package com.example.m07_reto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m07_reto.ItinerariAdapter.*

class ItinerariAdapter(
    private val context: Context,
    private val itinerario: List<Itinerari>
    ) : RecyclerView.Adapter<ListaViewHolder>(), View.OnClickListener {
    private val layout = R.layout.activity_ver_info
    private var clickListener: View.OnClickListener? = null


    class ListaViewHolder(val view: View) :
        RecyclerView.ViewHolder(view) {

        var dia: TextView
        var infoDia: TextView

        init {
            dia = view.findViewById(R.id.DiaItinerario)
            infoDia = view.findViewById(R.id.InfoItinerario)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        view.setOnClickListener(this)
        return ListaViewHolder(view)
    }

    override fun getItemCount() = itinerario.size

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val dias = itinerario[position]
        bindCoordenada(holder, dias)
    }

    fun bindCoordenada(holder: ListaViewHolder, itinerario: Itinerari) {

        holder.dia?.text = "Dia " + itinerario.dia.toString() + ":"
        holder.infoDia?.text = itinerario.actividad

    }


    override fun onClick(view: View?) {
        clickListener?.onClick(view)
    }

    fun setOnClickListener(listener: View.OnClickListener) {
        clickListener = listener
    }
}