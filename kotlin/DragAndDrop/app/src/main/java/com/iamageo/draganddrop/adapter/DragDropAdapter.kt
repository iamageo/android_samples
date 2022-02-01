package com.iamageo.draganddrop.adapter

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter
import com.iamageo.draganddrop.R

class DragDropAdapter(dataSet: MutableList<String>) :
    DragDropSwipeAdapter<String, DragDropAdapter.ViewHolder>(dataSet)  {

    private var list: MutableList<String> = this.dataSet as MutableList<String>

    inner class ViewHolder(itemView: View) : DragDropSwipeAdapter.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.item_text)
        val dragIcon: ImageView = itemView.findViewById(R.id.drag_icon)

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Log.d("DragDropAdapter", list[position])

                Toast.makeText(itemView.context, dataSet[position], Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getViewHolder(itemView: View) = ViewHolder(itemView)

    override fun onBindViewHolder(item: String, viewHolder: ViewHolder, position: Int) {
        // Here we update the contents of the view holder's views to reflect the item's data
        viewHolder.itemText.text = dataSet[position]
    }

    override fun getViewToTouchToStartDraggingItem(
        item: String,
        viewHolder: ViewHolder,
        position: Int
    ): View? {
        // We return the view holder's view on which the user has to touch to drag the item
        return viewHolder.dragIcon
    }

    override fun onDragFinished(item: String, viewHolder: ViewHolder) {
        super.onDragFinished(item, viewHolder)
        Log.d("DragDropAdapter", "$dataSet")}

}