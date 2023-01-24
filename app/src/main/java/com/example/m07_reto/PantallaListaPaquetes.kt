package com.example.m07_reto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.FileReader

class PantallaListaPaquetes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_paquetes)

        fun getViajes(): MutableList<ClaseDestinos>
        {
            val jsonpathfile = getFilesDir().toString() + "/json/lista.json"
            val jsonFile = FileReader(jsonpathfile)
            val primeraLista = object: TypeToken<MutableList<ClaseDestinos>>() {}.type
            val preguntes: MutableList<ClaseDestinos> = Gson().fromJson(jsonFile, primeraLista)
            return preguntes
        }
        val transporte: TextView = findViewById(R.id.transporte)
        val imgdias: ImageView = findViewById(R.id.imagendias)
        val imgtrp: ImageView = findViewById(R.id.imagentransporte)


        if (transporte.text == "Avion")
        {
            imgtrp.setImageResource(R.drawable.avion)
        } else if (transporte.text == "Barco")
        {
            imgtrp.setImageResource(R.drawable.barco)
        } else if (transporte.text == "Coche")
        {
            imgtrp.setImageResource(R.drawable.coche)
        }

        val viajes = getViajes()
        val ListaViaje = findViewById<RecyclerView>(R.id.ListaViajes)

        val AdapterLista = DestinosAdapter(this, viajes)
        ListaViaje.hasFixedSize()
        ListaViaje.layoutManager = LinearLayoutManager(this)
        ListaViaje.adapter = AdapterLista

        AdapterLista.setOnClickListener(){
            val a = viajes[ListaViaje.getChildAdapterPosition(it)]
            val intent = Intent(this, PantallaDetalle::class.java)
            intent.putExtra("objeto", a)
            startActivity(intent)
        }
    }
}