package com.example.martisergi_politravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import java.io.File

class PantallaPaquetes : AppCompatActivity(), Adapter.OnItemClickListener, Adapter.OnItemLongClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var packages: MutableList<ClasePaquetes>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_paquetes)

        val gson = Gson()
        packages = gson.fromJson(
            File(this.filesDir, "infoViajes.json").readText(),
            Array<ClasePaquetes>::class.java
        ).toMutableList()

        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = Adapter(this, packages, this)
        adapter.setOnItemLongClickListener(this)
        recyclerView.adapter = adapter

        val floaticon: FloatingActionButton = findViewById(R.id.floaticon)
        floaticon.setOnClickListener {
            val intent = Intent(this, PantallaDarDeAlta::class.java)
            startActivity(intent)
        }
    }

    override fun onItemClick(item: ClasePaquetes) {
        val intent = Intent(this, PantallaDetalle::class.java)

        val id: Int = item.id
        val nombre: String = item.nombre
        val pais: String = item.pais
        val img: String = item.img
        val lugaresInteresantes: Array<String> = item.lugaresInteresantes
        val puntuacion: Double = item.puntuacion
        val precio: String = item.precio
        val descripcion: String = item.descripcion
        val duracion: Int = item.duracion
        val transporte: String = item.transporte
        val inicioTourNombre: String = item.inicioTourNombre
        val finTourNombre: String = item.finTourNombre

        intent.putExtra("id", id)
        intent.putExtra("nombre", nombre)
        intent.putExtra("pais", pais)
        intent.putExtra("img", img)
        intent.putExtra("lugaresInteresantes", lugaresInteresantes)
        intent.putExtra("puntuacion", puntuacion)
        intent.putExtra("precio", precio)
        intent.putExtra("descripcion", descripcion)
        intent.putExtra("duracion", duracion)
        intent.putExtra("transporte", transporte)
        intent.putExtra("inicioTourNombre", inicioTourNombre)
        intent.putExtra("finTourNombre", finTourNombre)

        val inicioTourCoordenadas: Array<Double> = item.inicioTourCoordenadas
        val finTourCoordenadas: Array<Double> = item.finTourCoordenadas

        intent.putExtra("inicioTourCoordenadas", inicioTourCoordenadas.map { it.toString() }.toTypedArray())
        intent.putExtra("finTourCoordenadas", finTourCoordenadas.map { it.toString() }.toTypedArray())

        this.startActivity(intent)
    }

    override fun onItemLongClick(position: Int): Boolean {
        // Remover el elemento de la lista
        packages.removeAt(position)

        // Actualizar el archivo JSON
        val gson = Gson()
        val json = gson.toJson(packages)
        File(this.filesDir, "infoViajes.json").writeText(json)

        // Notificar al adapter que el conjunto de datos ha cambiado
        recyclerView.adapter?.notifyDataSetChanged()

        return true
    }
}