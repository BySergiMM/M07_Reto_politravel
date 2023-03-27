package com.example.martisergi_politravel

import java.io.Serializable

data class ClasePaquetes(
    val id: Int,
    val nombre: String,
    val pais: String,
    val img: String,
    val lugaresInteresantes: Array<String>,
    val puntuacion: Double,
    val precio: String,
    val descripcion: String,
    val duracion: Int,
    val transporte: String,
    val inicioTourNombre: String,
    val finTourNombre: String,
    val inicioTourCoordenadas: Array<Double>,
    val finTourCoordenadas: Array<Double>) : Serializable
