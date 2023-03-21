package com.example.martisergi_politravel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.File

class PantallaPaquetes : AppCompatActivity(), Adapter.OnItemClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_paquetes)


        val gson = Gson()
        val packages = gson.fromJson(
            File(this.filesDir, "json/packages.json").readText(),
            Array<TravelPackage>::class.java
        ).toList()
        val resources = this.resources
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = Adapter(packages, resources, this)
        recyclerView.adapter = adapter


    }

    override fun onItemClick(item: TravelPackage) {
        val i = Intent(this, MainActivity::class.java)

        val id: Int = item.id
        val name: String = item.name
        val country: String = item.country
        val interestingPlaces: Array<String> = item.interestingPlaces
        val rating: Double = item.rating
        val price: Int = item.price
        val description: String = item.description
        val duration: Int = item.duration
        val conveyance: String = item.conveyance
        val tourStartName: String = item.tourStartName
        val tourEndName: String = item.tourEndName
        val tourStartCoord: Array<Double> = item.tourStartCoord
        val tourEndCoord: Array<Double> = item.tourEndCoord


        i.putExtra("id", id)
        i.putExtra("name", name)
        i.putExtra("country", country)
        i.putExtra("interestingPlaces", interestingPlaces)
        i.putExtra("rating", rating)
        i.putExtra("price", price)
        i.putExtra("description", description)
        i.putExtra("duration", duration)
        i.putExtra("conveyance", conveyance)
        i.putExtra("tourStartName", tourStartName)
        i.putExtra("tourEndName", tourEndName)
        i.putExtra("tourStartCoord", tourStartCoord)
        i.putExtra("tourEndCoord", tourEndCoord)

        this.startActivity(i)
    }

}