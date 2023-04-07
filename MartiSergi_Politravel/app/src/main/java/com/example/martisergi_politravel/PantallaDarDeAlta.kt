package com.example.martisergi_politravel

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.File

class PantallaDarDeAlta : AppCompatActivity() {

    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_dar_de_alta)

        gridView = findViewById(R.id.gridview)

        val adapter = ImageAdapter(this, readImagesFromDirectory())
        gridView.adapter = adapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            view.setBackgroundResource(R.drawable.image_selected)

            val selectedImageName = adapter.getItem(position)

            adapter.selectedImageName = selectedImageName
        }

        val botonGuardar = findViewById<Button>(R.id.botonGuardar)
        botonGuardar.setOnClickListener {
            val selectedImageName = adapter.selectedImageName

            val gson = Gson()
            val objetoPrueba = ClasePrueba(selectedImageName)
            val jsonString = gson.toJson(objetoPrueba)

            val file = File(filesDir, "prueba.json")
            if (file.exists()) {
                val jsonArray = gson.fromJson(file.readText(), Array<ClasePrueba>::class.java).toMutableList()
                jsonArray.add(objetoPrueba)
                file.writeText(gson.toJson(jsonArray))
            } else {
                file.writeText(gson.toJson(arrayOf(objetoPrueba)))
            }

            this.finish()
        }
    }

    private fun readImagesFromDirectory(): List<String> {
        val imagesDirectory = File(filesDir, "img")
        return imagesDirectory.listFiles()?.filter { it.isFile }?.map { it.name } ?: emptyList()
    }

    private class ImageAdapter(private val context: Context, private val imageNames: List<String>) : BaseAdapter() {
        var selectedImageName: String? = null

        override fun getCount() = imageNames.size

        override fun getItem(position: Int) = imageNames[position]

        override fun getItemId(position: Int) = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val imageView = ImageView(context)
            imageView.layoutParams = AbsListView.LayoutParams(300, 300)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(0, 10, 0, 10)

            val imageName = imageNames[position]
            imageView.setImageURI(Uri.fromFile(File(context.filesDir, "img/$imageName")))

            if (imageName == selectedImageName) {
                imageView.setBackgroundResource(R.drawable.selector_imagen)
            } else {
                imageView.setBackgroundResource(0)
            }

            return imageView
        }
    }
}
