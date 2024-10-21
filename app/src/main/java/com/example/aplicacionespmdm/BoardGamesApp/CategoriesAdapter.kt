package com.example.aplicacionespmdm.BoardGamesApp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(private val categories: List<GameCategory>) :
    RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
    }
    override fun getItemCount() =  categories.size
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
    }
}
