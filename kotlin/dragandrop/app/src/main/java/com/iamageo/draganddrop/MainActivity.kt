package com.iamageo.draganddrop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeRecyclerView
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemSwipeListener
import com.iamageo.draganddrop.adapter.DragDropAdapter

class MainActivity : AppCompatActivity() {
private lateinit var dragDropAdapter: DragDropAdapter
private var itemsList = mutableListOf<String>()

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    createFakeItems()
    setUpRecycler()
}

private fun createFakeItems() {
    for (i in 0..9) {
        itemsList.add("item $i")
    }
}

private fun setUpRecycler() {
    dragDropAdapter = DragDropAdapter(itemsList)
    val mList: DragDropSwipeRecyclerView = findViewById(R.id.list)
    mList.layoutManager = LinearLayoutManager(this)
    mList.adapter = dragDropAdapter

    mList.orientation = DragDropSwipeRecyclerView.ListOrientation.VERTICAL_LIST_WITH_VERTICAL_DRAGGING
    mList.reduceItemAlphaOnSwiping = true

}

}