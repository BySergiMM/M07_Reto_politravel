package com.example.martisergi_politravel

import android.os.Bundle
import android.widget.EditText
import android.widget.GridView
import android.widget.RatingBar
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class PantallaModificar : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var paisEditText: EditText
    private lateinit var lugaresInteresantesEditText: EditText
    private lateinit var precioEditText: EditText
    private lateinit var descripcionEditText: EditText
    private lateinit var duracionEditText: EditText
    private lateinit var gridView: GridView
    private lateinit var puntuacionRatingBar: RatingBar
    private lateinit var transporte: Spinner
    private var inicioTourCoordenadasX: Double = 0.0
    private var inicioTourCoordenadasY: Double = 0.0
    private var finTourCoordenadasX: Double = 0.0
    private var finTourCoordenadasY: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_dar_de_alta)

    }
}
