package com.example.gregc.recyclerviewtest


import android.app.Activity
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView;
import java.nio.file.Files.size



class CustomList(private val context: Activity, private val banks: Array<String>, private val nickname: Array<String>) : ArrayAdapter<String>(context, R.layout.movie_list_row, banks) {
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.movie_list_row, null, true)
        val txtTitle = rowView.findViewById(R.id.Bank) as TextView

        val txtNickName = rowView.findViewById(R.id.Nickname) as TextView
        txtTitle.text = banks[position]

        txtNickName.text = nickname[position]
        return rowView
    }
}