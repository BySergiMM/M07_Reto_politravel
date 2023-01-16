package com.example.m07_reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val handler = Handler()

// Establece el progreso inicial en 0
        progressBar.progress = 0

// Ejecuta el código para actualizar el progreso después de 10 segundos
        handler.postDelayed({
            progressBar.progress = 100
            progressBar.progress = 100
        }, 10000)

        val intent = Intent(this, pantalla_listado::class.java)
        startActivity(intent)


    }
}