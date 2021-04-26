package com.iamageo.recyclerview

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iamageo.recyclerview.adapter.Adapter


class MainActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    private var recyclerViewUser: RecyclerView? = null
    private var userAdapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      recyclerViewUser = findViewById(R.id.rv_recyclerView)

        postToList()
        setAdapter()

    }

    private fun setAdapter() {
        userAdapter = Adapter(titlesList, descList, imagesList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewUser!!.layoutManager = layoutManager
        recyclerViewUser!!.itemAnimator = DefaultItemAnimator()
        recyclerViewUser!!.adapter = userAdapter
    }

    private fun addToList(title: String, description: String, image: Int) {
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList() {
        for (i: Int in 1..25) {
            addToList("Title $i", "description $i", R.mipmap.ic_launcher_round)
        }
    }

}