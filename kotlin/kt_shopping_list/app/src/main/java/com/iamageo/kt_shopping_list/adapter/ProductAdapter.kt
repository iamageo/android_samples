package com.iamageo.kt_shopping_list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.iamageo.kt_shopping_list.model.Product
import com.iamageo.kt_shopping_list.R
import java.text.NumberFormat
import java.util.*

class ProductAdapter(context: Context) : ArrayAdapter<Product>(context, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v: View

        if(convertView != null) {
            v = convertView

        } else {
            v = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        }

        val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))

        val item = getItem(position)

        val product_name = v.findViewById<TextView>(R.id.list_item_name)

        val product_price = v.findViewById<TextView>(R.id.list_item_price)

        val product_qnt = v.findViewById<TextView>(R.id.list_item_qnt)

        val product_photo = v.findViewById<ImageView>(R.id.list_item_photo)

        product_name.text = item?.name
        product_price.text = item?.value.toString()
        product_qnt.text = item?.qnt.toString()

        if (item != null) {
            if( item.photo != null) {
                product_photo.setImageBitmap(item.photo)
            }
        }

       return v
    }


}