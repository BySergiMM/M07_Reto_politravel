package com.example.m07_reto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DestinosAdapter (private val context: Context, private val destinos: List<Destinos>)
    : RecyclerView.Adapter<DestinosAdapter.DestinosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_lista, parent, false)
        return DestinosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return destinos.size
    }

    override fun onBindViewHolder(holder: DestinosViewHolder, position: Int) {
        val destino = destinos[position]
        holder.bind(destino)
    }

    class DestinosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.nombre)
        private val transporteTextView: TextView = itemView.findViewById(R.id.transporte)
        private val imagenImageView: ImageView = itemView.findViewById(R.id.imagen)

        fun bind(destino: Destinos) {
            nombreTextView.text = destino.nombre
            transporteTextView.text = destino.transporte
            imagenImageView.setImageResource(destino.imagen)
        }
    }
}