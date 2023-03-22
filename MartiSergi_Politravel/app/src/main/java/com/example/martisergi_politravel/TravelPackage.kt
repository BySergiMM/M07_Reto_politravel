package com.example.martisergi_politravel

import java.io.Serializable

data class TravelPackage(
    val id: Int,
    val nombre: String,
    val pais: String,
    val img: String,
    val lugaresInteresantes: Array<String>,
    val puntuacion: Double,
    val precio: Int,
    val descripcion: String,
    val duración: Int,
    val transporte: String,
    val inicioTourNombre: String,
    val finTourNombre: String,
    val inicioTourCoordenadas: Array<Double>,
    val finTourCoordenadas: Array<Double>) : Serializable