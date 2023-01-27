package com.example.m07_reto

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PantallaDetalle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val intent = getIntent()
        val objeto = intent.getSerializableExtra("objeto") as ClaseDestinos

        var Titulo = findViewById<TextView>(R.id.TituloVer)
        val Imagen = findViewById<ImageView>(R.id.ImagenVer)
        val Dias = findViewById<TextView>(R.id.DiasVer)
        val Transporte = findViewById<TextView>(R.id.TransporteVer)
        val Inicio = findViewById<TextView>(R.id.InicioVer)
        val Final = findViewById<TextView>(R.id.FinVer)
        val FtoTransporte = findViewById<ImageView>(R.id.transporte)

        val latitud = findViewById<TextView>(R.id.latitud)
        val longitud = findViewById<TextView>(R.id.longitud)


        val ruta = getFilesDir().toString() +"/img/"+ objeto.imagen
        val bitmap = BitmapFactory.decodeFile(ruta)

        Imagen?.setImageBitmap(bitmap)

        Titulo.text = objeto.nombre
        Dias.text = objeto.dias.toString()
        Transporte.text = objeto.transporte
        Inicio.text = objeto.inicio
        Final.text = objeto.fin

        latitud.text = objeto.Coordenadas.latitud
        longitud.text = objeto.Coordenadas.longitud

        var latitudMaps = objeto.Coordenadas.latitud.toDouble()
        var longitudMaps = objeto.Coordenadas.longitud.toDouble()

        if (Transporte.text == "Avion")
        {
            FtoTransporte.setImageResource(R.drawable.avion)
        } else if (Transporte.text == "Barco")
        {
            FtoTransporte.setImageResource(R.drawable.barco)
        } else if (Transporte.text == "Coche")
        {
            FtoTransporte.setImageResource(R.drawable.coche)
        }


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            //Posición inicial del mapa
            val latLng = LatLng(latitudMaps, longitudMaps)
            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 10f)
            googleMap.moveCamera(cameraUpdate)
            //Agregando marcador en la posicion
            googleMap.addMarker(MarkerOptions().position(latLng))
            //Habilitando los controles de zoom
            googleMap.uiSettings.isZoomControlsEnabled = true
        }


        val listaItinerario = findViewById<RecyclerView>(R.id.listaItinerario)

        val AdapterIti = ItinerariAdapter(this, objeto.itinerario)

        listaItinerario.layoutManager = LinearLayoutManager(this)
        listaItinerario.adapter = AdapterIti

        listaItinerario.isNestedScrollingEnabled = false

    }
}