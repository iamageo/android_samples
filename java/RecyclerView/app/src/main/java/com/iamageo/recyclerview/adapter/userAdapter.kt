package com.iamageo.recyclerview.adapter

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.iamageo.recyclerview.adapter.userAdapter.MyViewHolder
import android.widget.TextView
import com.iamageo.recyclerview.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.CheckedTextView
import android.widget.Toast
import com.iamageo.recyclerview.MainActivity
import com.iamageo.recyclerview.model.User
import java.util.ArrayList

private val MAX_SELECTABLE = 3
var mMutableListSelected: MutableList<CheckBox> = ArrayList()

class userAdapter(
    // https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=pt-
        private val userList: ArrayList<User>) : RecyclerView.Adapter<MyViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val nameText: TextView
        val ck_opcao: CheckBox

        init {
            nameText = view.findViewById(R.id.user)
            ck_opcao = view.findViewById(R.id.ck_opcao)
        }
    }

    /**
     * Initialize the listview of the Adapter.
     * containing the data to populate views to be used
     * by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Get element from your listitens at this position and replace the
        // contents of the view with that element
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)
        return MyViewHolder(itemView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val name = userList[position].username
        val op = userList[position].checked

        holder.nameText.text = SpannableStringBuilder(name).apply{
            setSpan(StyleSpan(Typeface.BOLD), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        //click no item
        holder.ck_opcao.setOnClickListener{

            //opcao true
            if (!holder.ck_opcao.isChecked) {
                mMutableListSelected.remove(holder.ck_opcao)
                holder.ck_opcao.isChecked = false
                reloadCheckedTextView(mMutableListSelected as ArrayList<CheckBox>)
                holder.ck_opcao.setButtonDrawable(R.drawable.box)

            } else if (mMutableListSelected.size < MAX_SELECTABLE) {
                mMutableListSelected.add(holder.ck_opcao)
                holder.ck_opcao.isChecked = true
                reloadCheckedTextView(mMutableListSelected as ArrayList<CheckBox>)
            } else {    
                holder.ck_opcao.isChecked = false
                holder.ck_opcao.setButtonDrawable(R.drawable.box)
            }

        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return userList.size
    }

    fun reloadCheckedTextView(mSelected: ArrayList<CheckBox>) {
        for (i in mSelected.indices) {
            if (i == 0) {
                mSelected[i].setButtonDrawable(R.drawable.one)
            } else if (i == 1) {
                mSelected[i].setButtonDrawable(R.drawable.two)
            } else {
                mSelected[i].setButtonDrawable(R.drawable.three)
            }
        }
    }
}