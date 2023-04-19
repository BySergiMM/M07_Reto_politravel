package com.example.martisergi_politravel

import java.io.Serializable

data class ClasePaquetes(
    val id: Int,
    var nombre: String,
    var pais: String,
    val img: String,
    var lugaresInteresantes: Array<String>,
    var puntuacion: Double,
    var precio: String,
    var descripcion: String,
    var duracion: Int,
    var transporte: String,
    var inicioTourNombre: String,
    var finTourNombre: String,
    var inicioTourCoordenadas: Array<Double>,
    var finTourCoordenadas: Array<Double>) : Serializable
