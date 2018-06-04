package com.example.gregc.recyclerviewtest


import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.LinearLayout
import android.widget.TextView



var finalList = mutableListOf<String>()

class MainActivity : AppCompatActivity() {
    var getChoice: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val banknames = ArrayList<Item>()
        banknames.add(Header( "Chase" ))
        banknames.add(ListItem("Chase Account 1\nChase nickname 1"))
        banknames.add(ListItem("Chase Account 2\nChase nickname 2"))
        banknames.add(ListItem("Chase Account 3\nChase nickname 3"))
        banknames.add(Header( "Wells Fargo" ))
        banknames.add(ListItem("Wells Fargo Account 1\nWells Fargo nickname 1"))
        banknames.add(Header( "Bank of America" ))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))
        banknames.add(ListItem("Bank of America Account 1\nBank of America nickname 1"))



        getChoice = findViewById(R.id.getchoice)

        val adapter = TwoTextArrayAdapter(this , banknames)
        val list = findViewById<ListView>(R.id.list)

        list.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        list.adapter = adapter
        getChoice!!.setOnClickListener {
            var selected = ""
            var cntChoice = list.count
            var sparseBooleanArray = list.checkedItemPositions
            println(list.getItemAtPosition(1).toString())
            for (i in 0 until cntChoice)
            {
                if (sparseBooleanArray[i])
                {
                    selected += list.getItemAtPosition(i).toString() + "\n"
                }
            }
            Toast.makeText(this@MainActivity, finalList.toString(), Toast.LENGTH_LONG).show()
        }
    }





    interface Item {
        val viewType: Int
        fun getView(inflater: LayoutInflater, convertView: View?): View?
    }

    class TwoTextArrayAdapter(context: Activity, banks: List<Item>) : ArrayAdapter<Item>(context,  android.R.layout.simple_list_item_multiple_choice, banks) {
        var mInflater: LayoutInflater = LayoutInflater.from(context)

        enum class RowType {
            LIST_ITEM, HEADER_ITEM
        }


        override fun getViewTypeCount(): Int {
            return count
        }

        override fun getItemViewType(position: Int): Int {
            return position
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            return getItem(position).getView(mInflater, convertView)
        }


    }

    class Holder {
        lateinit var txtName: CheckedTextView
    }

    class ListItem(text1:String):Item {

        private val str1:String = text1
        override val viewType:Int
            get() {
                return TwoTextArrayAdapter.RowType.LIST_ITEM.ordinal
            }

        override fun getView(inflater: LayoutInflater, convertView: View?):View? {
            val holder :Holder
            var view: View? = convertView

            if (convertView == null)
            {
                holder = Holder()
                view = inflater.inflate(R.layout.movie_list_row, null) as View
                // Do some initialization
                holder.txtName = view.findViewById(R.id.Bank) as CheckedTextView
                view.tag = holder
            }
            else {
                view = convertView
                holder = convertView.tag as Holder
            }
            val text1 = view!!.findViewById(R.id.Bank) as CheckedTextView
            text1.setOnClickListener { v -> (v as CheckedTextView).toggle()
                text1.setCheckMarkDrawable(R.drawable.checkedwhitechecktesttest123killme)
                println("here "+ text1.isChecked)
                if(text1.isChecked)
                    finalList.add(text1.text.toString())
                else{
                    finalList.remove((text1.text.toString()))
                }
                println(text1.text)
                println(text1.verticalScrollbarPosition)

            }
            text1.text = str1
            return view
        }

    }
    class Header(name:String):Item {


        private val name:String = name
        override val viewType:Int
            get() {
                return TwoTextArrayAdapter.RowType.HEADER_ITEM.ordinal
            }

        override fun getView(inflater: LayoutInflater, convertView: View?):View {
            val view:View
            if (convertView == null)
            {
                view = inflater.inflate(R.layout.section_headers, null) as View
                // Do some initialization
            }
            else
            {
                view = convertView
            }
            val text = view.findViewById(R.id.ListHeader) as TextView
            text.text = name
            return view
        }
    }




}








