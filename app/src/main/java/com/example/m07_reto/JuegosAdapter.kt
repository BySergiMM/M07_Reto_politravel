package com.example.m07_reto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.size

class JuegosAdapter (private val context: Context,
                      private val pokemons: MutableList<Pokemon>) :
    RecyclerView.Adapter<JuegosAdapter.JuegosAdapterViewHolder>(),
    View.OnClickListener
{
    private val layout = R.layout.pokemon_item
    private var clickListener: View.OnClickListener? = null

    class JuegosAdapterViewHolder(val view: View):
        RecyclerView.ViewHolder(view)
    {
        var lblGameName: TextView
        var imgGameLogo: ImageView

        init{
            imgGameLogo = view.findViewById(R.id.ImgListPokemon)
            lblGameName = view.findViewById(R.id.LblListPokemonName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuegosAdapterViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        view.setOnClickListener(this)
        return JuegosAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: JuegosAdapterViewHolder, position: Int)
    {
        val pokemon = pokemons[position]
        bindPokemon(holder,pokemon)
    }

    fun bindPokemon (holder: JuegosAdapterViewHolder, pokemon: Pokemon)
    {
        holder.imgGameLogo?.setImageResource(pokemon.image)
        holder.lblGameName?.text = pokemon.nombre
    }

    override fun getItemCount(): Int {return pokemons.size}

    fun setOnClickListener(listener: View.OnClickListener)
    {
        clickListener = listener
    }

    override fun onClick(view: View?) {
        clickListener?.onClick(view)
    }
}