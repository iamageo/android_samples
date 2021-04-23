package com.iamageo.kt_random_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

    }

    fun sortNumber(view: View) {
        var text = findViewById<TextView>(R.id.result)
        var sortNumber = Random().nextInt(11)
        text.text = "The number sorted is: " + sortNumber

    }

}