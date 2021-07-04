package com.iamageo.kt_shopping_list.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.iamageo.kt_shopping_list.model.Product
import java.io.ByteArrayOutputStream

val mutableListProduct = mutableListOf<Product>()

class Utils {

}

//function bitmap -> tobytearray
fun Bitmap.toByteArray() : ByteArray {
    val stream = ByteArrayOutputStream()

    //comprimindo a imagem
    this.compress(android.graphics.Bitmap.CompressFormat.PNG, 0, stream)

    //transformando em um array de caracteres
    return stream.toByteArray()
}

//function bytearray to bitmap
fun ByteArray.toBitmap() : Bitmap{
    return BitmapFactory.decodeByteArray(this, 0, this.size)
}


