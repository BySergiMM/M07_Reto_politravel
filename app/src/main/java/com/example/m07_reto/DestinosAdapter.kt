package com.example.m07_reto

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class DestinosAdapter (private val context: Context, private val destinos: List<Destinos>)
    : RecyclerView.Adapter<DestinosAdapter.DestinosViewHolder>(), View.OnClickListener{

    private val layout = R.layout.item_lista
    private var clickListener: View.OnClickListener? = null

    class DestinosViewHolder(val view: View): RecyclerView.ViewHolder(view){

        var nombre : TextView
        var imagen : ImageView
        var transporte : TextView

        init {
            nombre = view.findViewById(R.id.nombre)
            imagen = view.findViewById(R.id.imagen)
            transporte = view.findViewById(R.id.transporte)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        view.setOnClickListener(this)
        return DestinosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return destinos.size
    }

    override fun onBindViewHolder(holder: DestinosViewHolder, position: Int) {
        val destino = destinos[position]
        bind(holder, destino)
    }

    fun bind(holder: DestinosViewHolder, destinos: Destinos) {
        holder.nombre?.text = destinos.nombre
        holder.transporte?.text = destinos.transporte

        val ruta = context.getFilesDir().toString() +"/img/"+ destinos.imagen
        val bitmap = BitmapFactory.decodeFile(ruta)
        holder.imagen?.setImageBitmap(bitmap)
    }

    override fun onClick(view: View?){
        clickListener?.onClick(view)
    }
    fun setOnClickListener(listener: View.OnClickListener){
        clickListener = listener
    }

}