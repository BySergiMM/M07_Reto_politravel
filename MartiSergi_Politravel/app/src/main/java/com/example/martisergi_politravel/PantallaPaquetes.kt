package com.example.martisergi_politravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.File

class PantallaPaquetes : AppCompatActivity(), Adapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_paquetes)

        // Obtener la lista de paquetes desde un archivo JSON
        val gson = Gson()
        val packages = gson.fromJson(
            File(this.filesDir, "infoViajes.json").readText(),
            Array<ClasePaquetes>::class.java
        ).toList()

        // Configurar el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Crear el adaptador y asignarlo al RecyclerView
        val adapter = Adapter(this, packages, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(item: ClasePaquetes) {
        // Manejar el evento de clic en un elemento del RecyclerView
        // Por ejemplo, mostrar detalles del paquete en otra pantalla
        val intent = Intent(this, PantallaDetalle::class.java)
        intent.putExtra("packageId", item.id)
        startActivity(intent)
    }


}