package com.example.aplicacionespmdm.BoardGamesApp

data class Game (val name:String, val category: GameCategory, var isSelected:Boolean = false)