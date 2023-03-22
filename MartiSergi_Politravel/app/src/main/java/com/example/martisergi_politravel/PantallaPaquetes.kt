package com.example.martisergi_politravel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.File

class PantallaPaquetes : AppCompatActivity(), Adapter.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_paquetes)


        val gson = Gson()
        val packages = gson.fromJson(
            File(this.filesDir, "json/infoViajes.json").readText(),
            Array<TravelPackage>::class.java
        ).toList()
        val resources = this.resources
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = Adapter(packages, resources, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(item: TravelPackage) {
        val i = Intent(this, MainActivity::class.java)

        val id: Int = item.id
        val nombre: String = item.nombre
        val pais: String = item.pais
        val lugaresInteresantes: Array<String> = item.lugaresInteresantes
        val puntuacion: Double = item.puntuacion
        val precio: Int = item.precio
        val descripcion: String = item.descripcion
        val duración: Int = item.duración
        val transporte: String = item.transporte
        val inicioTourNombre: String = item.inicioTourNombre
        val finTourNombre: String = item.finTourNombre
        val inicioTourCoordenadas: Array<Double> = item.inicioTourCoordenadas
        val finTourCoordenadas: Array<Double> = item.finTourCoordenadas


        i.putExtra("id", id)
        i.putExtra("nombre", nombre)
        i.putExtra("pais", pais)
        i.putExtra("lugaresInteresantes", lugaresInteresantes)
        i.putExtra("puntuacion", puntuacion)
        i.putExtra("precio", precio)
        i.putExtra("descripcion", descripcion)
        i.putExtra("duración", duración)
        i.putExtra("transporte", transporte)
        i.putExtra("inicioTourNombre", inicioTourNombre)
        i.putExtra("finTourNombre", finTourNombre)
        i.putExtra("inicioTourCoordenadas", inicioTourCoordenadas)
        i.putExtra("finTourCoordenadas", finTourCoordenadas)

        this.startActivity(i)
    }

}