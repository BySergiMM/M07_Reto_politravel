package com.example.martisergi_politravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader

class PantallaPaquetes : AppCompatActivity(), Adapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_paquetes)

        // Obtener la lista de paquetes desde un archivo JSON
        val gson = Gson()
        val packages = gson.fromJson(
            File(this.filesDir, "infoViajes.json").readText(),
            Array<ClasePaquetes>::class.java
        ).toList()

        // Configurar el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Crear el adaptador y asignarlo al RecyclerView
        val adapter = Adapter(this, packages, this)
        recyclerView.adapter = adapter
    }


    override fun onItemClick(item: ClasePaquetes) {
        val intent = Intent(this, PantallaDetalle::class.java)

        val id: Int = item.id
        val nombre: String = item.nombre
        val pais: String = item.pais
        val img: String = item.img
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


        intent.putExtra("id", id)
        intent.putExtra("nombre", nombre)
        intent.putExtra("pais", pais)
        intent.putExtra("img", img)
        intent.putExtra("lugaresInteresantes", lugaresInteresantes)
        intent.putExtra("puntuacion", puntuacion)
        intent.putExtra("precio", precio)
        intent.putExtra("descripcion", descripcion)
        intent.putExtra("duración", duración)
        intent.putExtra("transporte", transporte)
        intent.putExtra("inicioTourNombre", inicioTourNombre)
        intent.putExtra("finTourNombre", finTourNombre)
        intent.putExtra("inicioTourCoordenadas", inicioTourCoordenadas)
        intent.putExtra("finTourCoordenadas", finTourCoordenadas)

        this.startActivity(intent)
    }

}