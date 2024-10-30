package com.example.aplicacionespmdm.BoardGamesApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionespmdm.R

class GameAdapter (var games: MutableList<Game>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<GameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GameViewHolder(view)
    }

    override fun getItemCount() =  games.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.render(games[position])
        holder.itemView.setOnClickListener{ onItemSelected(position) }
    }

}