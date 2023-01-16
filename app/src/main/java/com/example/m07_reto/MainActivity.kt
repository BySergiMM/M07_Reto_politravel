package com.example.m07_reto

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        

        val pantalla = findViewById<View>(R.id.jueves)

        pantalla.setOnClickListener {
            val intent = Intent(this, lista::class.java)
            startActivity(intent)
        }
    }
}