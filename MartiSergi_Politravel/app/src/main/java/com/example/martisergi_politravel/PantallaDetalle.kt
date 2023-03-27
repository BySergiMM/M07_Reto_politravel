package com.example.martisergi_politravel

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.io.File

class PantallaDetalle : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_detalle)

        val id = intent.getIntExtra("id", 0)
        val nombreI = intent.getStringExtra("nombre") ?: ""
        val paisI = intent.getStringExtra("pais") ?: ""
        val imgI = intent.getStringExtra("img") ?: ""
        val lugaresInteresantesI = intent.getStringArrayExtra("lugaresInteresantes") ?: emptyArray()
        val puntuacionI = intent.getDoubleExtra("puntuacion", 0.0)
        val precioI = intent.getStringExtra("precio") ?: ""
        val descripcionI = intent.getStringExtra("descripcion") ?: ""
        val duracionI = intent.getIntExtra("duracion", 0)
        val transporteI = intent.getStringExtra("transporte") ?: ""
        val inicioTourNombreI = intent.getStringExtra("inicioTourNombre") ?: ""
        val finTourNombreI = intent.getStringExtra("finTourNombre") ?: ""
        val inicioTourCoordenadasI = intent.getDoubleArrayExtra("inicioTourCoordenadas") ?: doubleArrayOf()
        val finTourCoordenadasI = intent.getDoubleArrayExtra("finTourCoordenadas") ?: doubleArrayOf()

        val nombre = findViewById<TextView>(R.id.nombre)
        nombre.text = nombreI

        val pais = findViewById<TextView>(R.id.pais)
        pais.text = paisI

        val puntuacion = findViewById<TextView>(R.id.puntuacion)
        puntuacion.text = puntuacionI.toString()

        val precio = findViewById<TextView>(R.id.precio)
        precio.text = precioI

        val duracion = findViewById<TextView>(R.id.duracion)
        duracion.text = duracionI.toString()

        val transporte = findViewById<TextView>(R.id.transporte)
        transporte.text = transporteI

        val imgTransporte = findViewById<ImageView>(R.id.imgTransporte)

        if (transporteI.equals("avión")){
            imgTransporte.setImageResource(R.drawable.avion)
        }else if (transporteI.equals("barco")){
            imgTransporte.setImageResource(R.drawable.barco)
        }else if (transporteI.equals("coche")){
            imgTransporte.setImageResource(R.drawable.coche)
        }


        val img = findViewById<ImageView>(R.id.image)
        val imagePath = "${filesDir.absolutePath}/img/"+imgI+".png"

        val file = File(imagePath)
        if (file.exists()) {
            val bitmap = BitmapFactory.decodeFile(file.absolutePath)
            img.setImageBitmap(bitmap)
        } else {
            Log.e("TAG", "La imagen no existe en la ruta: $imagePath")
        }
    }
}