package com.example.m07_reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class lista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val Juegos = mutableListOf(
            Pokemon("Viaje a la luna", R.drawable.logo, "Dias: 5-7"),
            Pokemon("Viaje a la luna", R.drawable.logo, "Dias: 5-7"),
            Pokemon("Viaje a la luna", R.drawable.logo, "Dias: 5-7"),
            Pokemon("Viaje a la luna", R.drawable.logo, "Dias: 5-7"),
            Pokemon("Viaje a la luna", R.drawable.logo, "Dias: 5-7"),
            Pokemon("Viaje a la luna", R.drawable.logo, "Dias: 5-7"),
            Pokemon("Viaje a la luna", R.drawable.logo, "Dias: 5-7"),
            Pokemon("Viaje a la luna", R.drawable.logo, "Dias: 5-7"))

        val lstJuegos = findViewById<RecyclerView>(R.id.LstJuegos)

        val adaptador = JuegosAdapter(this, Juegos)
        lstJuegos.hasFixedSize()
        lstJuegos.layoutManager = LinearLayoutManager(this)
        lstJuegos.adapter = adaptador


    }
}