package com.iamageo.kt_shopping_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iamageo.kt_shopping_list.adapter.ProductAdapter
import com.iamageo.kt_shopping_list.utils.mutableListProduct
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //adapter
        val productAdapter = ProductAdapter(this)

        listview_products.adapter = productAdapter

        btn_insert.setOnClickListener{
           startActivity(Intent(this, AddProduct::class.java))
            finish()
        }

        listview_products.setOnItemClickListener { parent, view, position, id ->
                val item = productAdapter.getItem(position)
                productAdapter.remove(item)
        }

    }

    override fun onResume() {
        super.onResume()

        val adapter = listview_products.adapter as ProductAdapter

        adapter.clear()
        adapter.addAll(mutableListProduct)

        val sum = mutableListProduct.sumByDouble { it.value * it.qnt }

        total_product.text = sum.toString()
    }
}


