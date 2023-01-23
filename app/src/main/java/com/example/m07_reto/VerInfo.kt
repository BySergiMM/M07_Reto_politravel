package com.example.m07_reto

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VerInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_info)

        val intent = getIntent()
        val objeto = intent.getSerializableExtra("objeto") as Destinos

        var Titulo = findViewById<TextView>(R.id.TituloVer)
        val Imagen = findViewById<ImageView>(R.id.ImagenVer)
        val Imagen2 = findViewById<ImageView>(R.id.ImagenVera)
        val Dias = findViewById<TextView>(R.id.DiasVer)
        val Transporte = findViewById<TextView>(R.id.TransporteVer)
        val Inicio = findViewById<TextView>(R.id.InicioVer)
        val Final = findViewById<TextView>(R.id.FinVer)


        val ruta = getFilesDir().toString() +"/img/"+ objeto.imagen
        val bitmap = BitmapFactory.decodeFile(ruta)

        Imagen?.setImageBitmap(bitmap)
        Imagen2?.setImageBitmap(bitmap)

        Titulo.text = objeto.nombre
        Dias.text = objeto.dias.toString()
        Transporte.text = objeto.transporte
        Inicio.text = objeto.inicio
        Final.text = objeto.fin

        val listaItinerario = findViewById<RecyclerView>(R.id.listaItinerario)

        val AdapterIti = ItinerariAdapter(this, objeto.itinerario)
        listaItinerario.hasFixedSize()
        listaItinerario.layoutManager = LinearLayoutManager(this)
        listaItinerario.adapter = AdapterIti



    }
}