package com.example.martisergi_politravel

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.File

class PantallaDarDeAlta : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var paisEditText: EditText
    private lateinit var lugaresInteresantesEditText: EditText
    private lateinit var precioEditText: EditText
    private lateinit var descripcionEditText: EditText
    private lateinit var duracionEditText: EditText
    private lateinit var avionImageView: ImageView
    private lateinit var barcoImageView: ImageView
    private lateinit var cocheImageView: ImageView
    private lateinit var gridView: GridView
    private lateinit var puntuacionRatingBar: RatingBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_dar_de_alta)

        // Obtener referencias a las vistas
        nombreEditText = findViewById(R.id.nombre)
        paisEditText = findViewById(R.id.pais)
        lugaresInteresantesEditText = findViewById(R.id.lugaresInteresantes)
        precioEditText = findViewById(R.id.precio)
        descripcionEditText = findViewById(R.id.descripcion)
        duracionEditText = findViewById(R.id.duracion)
        avionImageView = findViewById(R.id.avion)
        barcoImageView = findViewById(R.id.barco)
        cocheImageView = findViewById(R.id.coche)
        gridView = findViewById(R.id.gridview)
        puntuacionRatingBar = findViewById(R.id.puntuacion)

        // Configurar el listener del botón Guardar
        val guardarButton: Button = findViewById(R.id.botonAgregarPaquete)
        guardarButton.setOnClickListener {
            guardarPaquete()
        }

        val imgDir = File(this.filesDir, "img")
        val imgFiles = imgDir.listFiles()?.filter { it.isFile }?.map { it.name }
        val gridView: GridView = findViewById(R.id.gridview)
        gridView.adapter = ImageAdapter(this, imgFiles!!)
    }
    fun guardarPaquete() {
        // Obtener los valores introducidos por el usuario
        val nombre = nombreEditText.text.toString().trim()
        val pais = paisEditText.text.toString().trim()
        val lugaresInteresantes = lugaresInteresantesEditText.text.toString().trim().split(",").toTypedArray()
        val precio = precioEditText.text.toString().trim()
        val descripcion = descripcionEditText.text.toString().trim()
        val duracion = duracionEditText.text.toString().trim().toInt()
        val transporte = when {
            avionImageView.isSelected -> "Avión"
            barcoImageView.isSelected -> "Barco"
            cocheImageView.isSelected -> "Coche"
            else -> "Avión"
        }
        val inicioTourNombre = "Inicio del tour"
        val finTourNombre = "Fin del tour"
        val inicioTourCoordenadas = arrayOf(0.0, 0.0)
        val finTourCoordenadas = arrayOf(0.0, 0.0)
        val puntuacion = puntuacionRatingBar.rating.toDouble()
        val imagen = if (gridView.selectedItem != null) {
            val imgName = gridView.selectedItem.toString()
            File(this.filesDir, "img/$imgName").name
        } else {
            ""
        }

        // Obtener el último id de los paquetes guardados
        val gson = Gson()
        val file = File(this.filesDir, "infoViajes.json")
        val paquetes = if (file.exists()) {
            gson.fromJson(file.readText(), Array<ClasePaquetes>::class.java).toList()
        } else {
            emptyList()
        }
        val lastPackage = paquetes.maxByOrNull { it.id }
        val lastId = lastPackage?.id ?: 0

        // Crear el objeto ClasePaquetes con el nuevo id
        val paquete = ClasePaquetes(
            lastId + 1,
            nombre,
            pais,
            imagen,
            lugaresInteresantes,
            puntuacion,
            precio,
            descripcion,
            duracion,
            transporte,
            inicioTourNombre,
            finTourNombre,
            inicioTourCoordenadas,
            finTourCoordenadas
        )

        // Agregar el paquete al archivo JSON
        val newPaquetes = paquetes.toMutableList()
        newPaquetes.add(paquete)
        file.writeText(gson.toJson(newPaquetes))

        // Mostrar un mensaje de éxito
        Toast.makeText(this, "El paquete se ha guardado correctamente", Toast.LENGTH_SHORT).show()
    }
}