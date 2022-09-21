package com.example.b2synchronous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment

class HeadlinesFragment: Fragment(), AdapterView.OnItemClickListener {
    lateinit var headlinesListView: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater.inflate(R.layout.fragment_headlines,container,false)
        headlinesListView = view.findViewById(R.id.headlinesListview)
        headlinesListView.setOnItemClickListener(this)
        return view
    }

    override fun onItemClick(adapterview: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        var itemClicked : String = adapterview?.getItemAtPosition(position).toString()
        Toast.makeText(context,itemClicked,Toast.LENGTH_SHORT).show()
    }
}