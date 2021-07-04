package com.iamageo.kt_shopping_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iamageo.kt_shopping_list.adapter.ProductAdapter
import com.iamageo.kt_shopping_list.db.database
import com.iamageo.kt_shopping_list.model.Product
import com.iamageo.kt_shopping_list.utils.mutableListProduct
import com.iamageo.kt_shopping_list.utils.toBitmap
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.rowParser
import org.jetbrains.anko.db.select

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

        database.use {

            select("products").exec {

                val parser = rowParser {
                    id: Int,
                            name: String,
                            qtd: Int,
                            value: Double,
                            photo: ByteArray? ->

                    Product(id, name, qtd, value, photo?.toBitmap())
                }

                var productsList = parseList(parser)

                adapter.clear()
                adapter.addAll(productsList)

                val sum = productsList.sumByDouble { it.value * it.qnt }

                total_product.text = sum.toString()
            }



        }

    }
}


