package com.example.aplicacionespmdm.BoardGamesApp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionespmdm.R

class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val cbGame: CheckBox = view.findViewById(R.id.cbGame)
    private val tvGame: TextView = view.findViewById(R.id.tvGame)

    fun render(game: Game) {
        if (game.isSelected) {
            tvGame.paintFlags = tvGame.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvGame.paintFlags = tvGame.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        val color = when (game.category) {
            GameCategory.Cooperative -> {
                tvGame.text = game.name
                R.color.bgapp_cooperative_category
            }

            GameCategory.Deckbuilding -> {
                tvGame.text = game.name
                R.color.bgapp_deckbuilding_category
            }

            GameCategory.Euro -> {
                tvGame.text = game.name
                R.color.bgapp_euro_category
            }

            GameCategory.LCG -> {
                tvGame.text = game.name
                R.color.bgapp_lcg_category
            }

            GameCategory.Legacy -> {
                tvGame.text = game.name
                R.color.bgapp_legacy_category
            }
        }
        cbGame.buttonTintList =
            ColorStateList.valueOf(ContextCompat.getColor(cbGame.context, color))
    }
}