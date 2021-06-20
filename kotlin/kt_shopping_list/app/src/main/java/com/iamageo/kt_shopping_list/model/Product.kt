package com.iamageo.kt_shopping_list.model

import android.graphics.Bitmap

data class Product(val name: String, val qnt: Int, val value: Double, val photo: Bitmap? = null)