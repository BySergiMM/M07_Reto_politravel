package com.example.martisergi_politravel


import android.annotation.SuppressLint

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Adapter(
    val itemList: List<TravelPackage>,
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

        val cityName: TextView = view.findViewById(R.id.cityName)
        var countryName: TextView = view.findViewById(R.id.countryName)
        val price: TextView = view.findViewById(R.id.price)
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
        holder.cityName.text = cardElement.name
        holder.price.text = cardElement.price.toString()
        holder.countryName.text = cardElement.country

        val country = cardElement.country.toLowerCase(Locale.ROOT).replace(" ", "")

        holder.itemView.setOnClickListener {

            listener.onItemClick(cardElement)

        }
    }
    override fun getItemCount() = itemList.size

}