package com.example.m07_reto

import java.io.Serializable

class ClaseDestinos (val id: Int,
                     val nombre: String,
                     val imagen: String,
                     val transporte: String,
                     val inicio: String,
                     val Coordenadas:Coordenadas,
                     val fin: String,
                     val dias: Int,
                     val itinerario: MutableList<ClaseItinerari>) : Serializable