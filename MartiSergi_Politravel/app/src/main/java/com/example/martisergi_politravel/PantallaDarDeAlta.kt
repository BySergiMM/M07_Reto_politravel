package com.example.martisergi_politravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.gson.Gson

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
            // Verificar que los valores sean válidos
            if (nombre.isEmpty() || pais.isEmpty() || lugaresInteresantes.isEmpty() || precio.isEmpty() || descripcion.isEmpty() || duracion.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Guardar los valores
                guardarPaquete()
            }
        }

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
            else -> ""
        }
        val inicioTourNombre = "Inicio del tour"
        val finTourNombre = "Fin del tour"
        val inicioTourCoordenadas = arrayOf(0.0, 0.0)
        val finTourCoordenadas = arrayOf(0.0, 0.0)
        val puntuacion = puntuacionRatingBar.rating.toDouble()

        // Crear el objeto ClasePaquetes
        val paquete = ClasePaquetes(
            0,
            nombre,
            pais,
            "",
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

        // Convertir el objeto en una cadena JSON
        val gson = Gson()
        val paqueteJson = gson.toJson(paquete)

        // Guardar la cadena JSON en un archivo, por ejemplo
        // ...

        // Mostrar un mensaje de éxito
        Toast.makeText(this, "El paquete se ha guardado correctamente", Toast.LENGTH_SHORT).show()
    }








}