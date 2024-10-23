package com.example.aplicacionespmdm.BoardGamesApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionespmdm.R

class GameAdapter (private val games: List<GameCategory>) :
    RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game_category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount() =  games.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(games[position])
    }

}