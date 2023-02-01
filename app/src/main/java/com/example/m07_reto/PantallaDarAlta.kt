package com.example.m07_reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class PantallaDarAlta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_dar_alta)

        val spinner: Spinner = findViewById(R.id.aTransportePaquete)
        val listaSpinner = listOf("Coche", "Avion", "Tren", "Barco")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaSpinner)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ){
                val selectedItem = parent?.getItemAtPosition(position) as String
                val textView = spinner.getChildAt(0) as TextView
                textView.setTextSize(20f)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }
}