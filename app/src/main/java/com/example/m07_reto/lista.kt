package com.example.m07_reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.FileReader

class lista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)


        fun getViajes(): MutableList<Destinos>
        {
            val jsonpathfile = getFilesDir().toString() + "/json/lista.json"
            val jsonFile = FileReader(jsonpathfile)
            val primeraLista = object: TypeToken<MutableList<Destinos>>() {}.type
            val preguntes: MutableList<Destinos> = Gson().fromJson(jsonFile, primeraLista)

            return preguntes
        }

        val primeraLista = findViewById<RecyclerView>(R.id.ListaViajes)


        val a = getViajes()
        val adaptador = DestinosAdapter(this, a)
        primeraLista.hasFixedSize()
        primeraLista.layoutManager = LinearLayoutManager(this)
        primeraLista.adapter = adaptador

    }
}