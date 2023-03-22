package com.example.martisergi_politravel


import android.annotation.SuppressLint
import android.content.Context

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Adapter(val itemList: List<TravelPackage>,
    private val resources: Resources,
    val listener: OnItemClickListener
) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: TravelPackage)
    }

    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        val nombre: TextView = view.findViewById(R.id.nombre)
        var pais: TextView = view.findViewById(R.id.pais)
        val precio: TextView = view.findViewById(R.id.precio)
        val img: ImageView = view.findViewById(R.id.imagenCarta)
        override fun onClick(p0: View?) {
            listener.onItemClick(itemList[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cardElement = itemList[position]
        holder.nombre.text = cardElement.nombre
        holder.precio.text = cardElement.precio.toString()
        holder.pais.text = cardElement.pais

        holder.itemView.setOnClickListener {

            listener.onItemClick(cardElement)

        }
    }
    override fun getItemCount() = itemList.size

}