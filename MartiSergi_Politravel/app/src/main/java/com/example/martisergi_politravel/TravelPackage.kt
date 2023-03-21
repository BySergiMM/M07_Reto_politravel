package com.example.martisergi_politravel

import java.io.Serializable

data class TravelPackage(
    val id: Int,
    val name: String,
    val country: String,
    val interestingPlaces: Array<String>,
    val rating: Double,
    val price: Int,
    val description: String,
    val duration: Int,
    val conveyance: String,
    val tourStartName: String,
    val tourEndName: String,
    val tourStartCoord: Array<Double>,
    val tourEndCoord: Array<Double>) : Serializable