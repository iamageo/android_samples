package com.iamageo.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iamageo.recyclerview.adapter.userAdapter
import com.iamageo.recyclerview.model.User
import java.util.*

class MainActivity : AppCompatActivity() {

    private var userArrayList: ArrayList<User>? = null
    private var userAdapter: userAdapter? = null
    private var recyclerViewUser: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewUser = findViewById(R.id.usersRecyclerView)
        userArrayList = ArrayList()
        setUserInfo()
        setAdapter()
    }

    private fun setAdapter() {

        userAdapter = userAdapter(userArrayList!!)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)

        recyclerViewUser!!.layoutManager = layoutManager

        recyclerViewUser!!.itemAnimator = DefaultItemAnimator()

        recyclerViewUser!!.adapter = userAdapter

    }

    private fun setUserInfo() {
        userArrayList!!.add(User("Jhon", false))
        userArrayList!!.add(User("Paulo", false))
        userArrayList!!.add(User("Ricardo", false))
        userArrayList!!.add(User("Rebeca", false))
        userArrayList!!.add(User("Herald", false))
    }
}