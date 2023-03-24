package com.example.martisergi_politravel

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
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
        val precioI = intent.getIntExtra("precio", 0)
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


        val img = findViewById<ImageView>(R.id.image)
        val imagePath = "${filesDir.absolutePath}/img/"+imgI+".png"

        val file = File(imagePath)
        if (file.exists()) {
            val bitmap = BitmapFactory.decodeFile(file.absolutePath)
            img.setImageBitmap(bitmap)
        } else {
            Log.e("TAG", "La imagen no existe en la ruta: $imagePath")
        }



        val carta = findViewById<CardView>(R.id.carta)

        carta.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Al presionar la carta, no hace nada
                }
                MotionEvent.ACTION_UP -> {
                    // Al soltar la carta, la anima para moverla hacia arriba
                    val anim = ObjectAnimator.ofFloat(carta, "translationY", 0f, -500f)
                    anim.duration = 500
                    anim.start()
                }
            }
            true
        }
    }
}