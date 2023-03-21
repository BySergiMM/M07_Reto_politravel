package com.example.sergimartio_politravel

import PaquetesAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.File


class PantallaPaquetes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_pantalla_paquetes)

        val gson = Gson()
        val packages = gson.fromJson(
            File(this.filesDir, "json/lista.json").readText(),
            Array<ClaseDestinos>::class.java
        ).toList()

        val adapter = PaquetesAdapter(packages)
        val recyclerView = findViewById<RecyclerView>(R.id.ListaPaquetes)
        recyclerView.adapter = adapter


    }



}
