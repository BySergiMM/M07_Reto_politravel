package com.example.m07_reto

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

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

        val ruta = getFilesDir().toString() +"/img/"+ objeto.imagen
        val bitmap = BitmapFactory.decodeFile(ruta)

        Imagen?.setImageBitmap(bitmap)
        Imagen2?.setImageBitmap(bitmap)

        Titulo.text = objeto.nombre
        Dias.text = objeto.dias.toString()
        Transporte.text = objeto.transporte
    }
}