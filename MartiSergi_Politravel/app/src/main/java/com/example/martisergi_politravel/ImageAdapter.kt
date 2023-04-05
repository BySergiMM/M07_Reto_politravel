package com.example.martisergi_politravel

import android.content.Context
import android.graphics.BitmapFactory
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import java.io.File
class ImageAdapter(private val context: Context, private val imagePaths: List<String>) : BaseAdapter() {

    private var selectedPosition = -1

    override fun getCount(): Int {
        return imagePaths.size
    }

    override fun getItem(position: Int): Any {
        return imagePaths[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(context)
            imageView.layoutParams = AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 350)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(15, 15, 15, 15)
        } else {
            imageView = convertView as ImageView
        }

        // Cargar la imagen
        val imagePath = imagePaths[position]
        val file = File(context.filesDir, "img/$imagePath")
        if (file.exists()) {
            val bitmap = BitmapFactory.decodeFile(file.absolutePath)
            imageView.setImageBitmap(bitmap)
        }

        // Cambiar el estilo de la vista si está seleccionada
        if (selectedPosition == position) {
            imageView.setBackgroundResource(R.drawable.selector_imagen)
        } else {
            imageView.setBackgroundResource(android.R.color.transparent)
        }

        // Manejar el evento de click
        imageView.setOnClickListener {
            // Cambiar el estilo de la vista seleccionada
            if (selectedPosition != -1) {
                val lastSelectedView = parent?.getChildAt(selectedPosition) as ImageView?
                lastSelectedView?.setBackgroundResource(android.R.color.transparent)
            }
            selectedPosition = position
            imageView.setBackgroundResource(R.drawable.selector_imagen)
        }

        return imageView
    }
}
