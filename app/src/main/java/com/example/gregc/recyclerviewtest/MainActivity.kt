package com.example.gregc.recyclerviewtest


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import android.widget.ArrayAdapter






class MainActivity : AppCompatActivity() {
    var myList: ListView? = null
    var getChoice: Button? = null
    var banks = arrayOf("Chase Account 1 ",
            "Chase Account 2",
            "Chase Account 3" ,
            "Chase Account 4",
            "test", "test2",
            "test3", "test4",
            "test5")
    var nicknames = arrayOf("Chase Account nickname 1 ",
            "Chase Account nickname 2",
            "Chase Account nickname 3" ,
            "Chase Account nickname 4",
            "test", "test2",
            "test3", "test4",
            "test5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myList = findViewById(R.id.list)
        getChoice = findViewById(R.id.getchoice)
        val adapter = CustomList(this , banks , nicknames)
        myList!!.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        myList!!.adapter = adapter

        getChoice!!.setOnClickListener {
                var selected = ""
                var cntChoice = myList!!.count
                var sparseBooleanArray = myList!!.checkedItemPositions
                for (i in 0 until cntChoice)
                {
                    if (sparseBooleanArray.get(i))
                    {
                        selected += myList!!.getItemAtPosition(i).toString() + "\n"
                    }
                }
                Toast.makeText(this@MainActivity, selected, Toast.LENGTH_LONG).show()
            }
        }

    }






