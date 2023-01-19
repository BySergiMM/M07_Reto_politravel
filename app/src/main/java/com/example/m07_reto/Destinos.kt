package com.example.m07_reto

import java.io.Serializable

class Destinos (val id: Int,
                val nombre: String,
                val imagen: String,
                val transporte: String,
                val inicio: String,
                val coordenadas_inicio:MutableList<coord>,
                val fin: String,
                val dias: Int,
                val itinerario: MutableList<Itinerari>) : Serializable