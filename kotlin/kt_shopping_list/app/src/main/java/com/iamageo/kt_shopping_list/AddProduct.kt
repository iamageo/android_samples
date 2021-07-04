package com.iamageo.kt_shopping_list

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iamageo.kt_shopping_list.db.database
import com.iamageo.kt_shopping_list.utils.toByteArray
import org.jetbrains.anko.db.*
import org.jetbrains.anko.toast
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProduct : AppCompatActivity() {

    val COD_IMAGE = 100
    var imageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        new_product_add.setOnClickListener {

            val product_name = new_product_name.text.toString()

            val product_value = new_product_price.text.toString()

            val product_qnt = new_product_qnt.text.toString()


            if(product_name.isNotEmpty() && product_qnt.isNotEmpty() && product_value.isNotEmpty()) {

                database.use {

                    val idProduto = insert("products",
                            "name" to product_name,
                            "qtd" to product_qnt,
                            "value" to product_value,
                            "photo" to imageBitmap?.toByteArray()
                    )

                    if (idProduto != -1L) {

                        toast("Item inserido com sucesso")

                        new_product_name.text.clear()

                        new_product_price.text.clear()

                        new_product_qnt.text.clear()

                    } else {
                        toast("Erro ao inserir item no banco de dados")
                    }
                }

            } else {

                if(product_name.isEmpty()) {
                    new_product_name.error = "Product don't empty"
                }else {
                    new_product_name.error = null
                }

                if(product_value.isEmpty()) {
                    new_product_price.error = "Price don't empty"
                }else {
                    new_product_price.error = null
                }

                if(product_qnt.isEmpty()) {
                    new_product_qnt.error = "Qnt don't empty"
                }else {
                    new_product_qnt.error = null
                }




            }
        }

        new_product_img.setOnClickListener {
            openGallery()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == COD_IMAGE && resultCode == Activity.RESULT_OK) {
            if(data != null) {
                 val inputStream = data.data?.let { contentResolver.openInputStream(it) }

                var imageBitmap = BitmapFactory.decodeStream(inputStream)

                new_product_img.setImageBitmap(imageBitmap)

            }

        }
    }

    fun openGallery() {

        val intent = Intent(Intent.ACTION_GET_CONTENT)

        intent.type = "image/*"

        startActivityForResult(Intent.createChooser(intent, "Select image"), COD_IMAGE)

    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}