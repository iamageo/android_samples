package com.iamageo.recyclerviewitemanimation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.iamageo.recyclerviewitemanimation.R
import com.iamageo.recyclerviewitemanimation.adapter.ContactAdapter
import com.iamageo.recyclerviewitemanimation.model.Contact

class MainActivity : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    lateinit var movieAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        setAdapterInRecyclerView()
        movieAdapter.setContacts(fakeContacts())

    }

    private fun setAdapterInRecyclerView() {
        movieAdapter = ContactAdapter()
        recyclerview.adapter = movieAdapter
    }

    private fun initComponents() {
        recyclerview = findViewById(R.id.rv_contact)
    }

    private fun fakeContacts(): MutableList<Contact> {
        val contactList = mutableListOf<Contact>()
        for (i in 0..25) { contactList.add(Contact("Contact $i", "(00) $i 0000-0000")) }
        return contactList
    }
}