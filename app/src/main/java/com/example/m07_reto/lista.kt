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
            Pokemon("Pokemon Y", R.drawable.logo, 1000000001),
            Pokemon("Pokemon Go", R.drawable.logo, 1000000002),
            Pokemon("Pokemon Rojo", R.drawable.logo, 1000000003),
            Pokemon("Pokemon Rubi", R.drawable.logo, 1000000004),
            Pokemon("Pokemon Negro", R.drawable.logo, 1000000005),
            Pokemon("Pokemon Oro", R.drawable.logo, 1000000006),
            Pokemon("Pokemon Espada", R.drawable.logo, 1000000007),
            Pokemon("Pokemon Rubi Omega", R.drawable.logo, 1000000008))

        val lstJuegos = findViewById<RecyclerView>(R.id.LstJuegos)

        val adaptador = JuegosAdapter(this, Juegos)
        lstJuegos.hasFixedSize()
        lstJuegos.layoutManager = LinearLayoutManager(this)
        lstJuegos.adapter = adaptador


    }
}