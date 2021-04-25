package com.iamageo.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.iamageo.recyclerview.R

class Adapter(private var titles: List<String>, private var detail: List<String>, private var images: List<Int>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val itemTitle: TextView = itemview.findViewById(R.id.tv_title)
        val itemDescription: TextView = itemview.findViewById(R.id.tv_description)
        val images: ImageView = itemview.findViewById(R.id.iv_image)

        init {
            itemview.setOnClickListener { v: View ->
                run {
                    val position: Int = adapterPosition
                    Toast.makeText(
                        itemview.context,
                        "You clicked on item # ${position + 1}",
                        Toast.LENGTH_LONG
                    )
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val v: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDescription.text = detail[position]
        holder.images.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
       return titles.size
    }


}