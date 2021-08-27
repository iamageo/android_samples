package com.iamageo.recyclerviewitemanimation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.iamageo.recyclerviewitemanimation.R
import com.iamageo.recyclerviewitemanimation.model.Contact

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {

    private var itemsList = mutableListOf<Contact>();

    fun setContacts(contactList: List<Contact>){
        this.itemsList = contactList.toMutableList()
    }

    class MyViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        val container = itemView.findViewById<MaterialCardView>(R.id.container_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_contact_item,parent,false);
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position];
        holder.container.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.rotate)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}