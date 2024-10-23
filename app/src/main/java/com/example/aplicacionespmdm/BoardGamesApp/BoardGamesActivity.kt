package com.example.aplicacionespmdm.BoardGamesApp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionespmdm.R


class BoardGamesActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private val categories = listOf(
        GameCategory.Cooperative,
        GameCategory.Deckbuilding,
        GameCategory.Euro,
        GameCategory.LCG,
        GameCategory.Legacy
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_board_games)
        initcomponents()
        initUI()
    }

    private fun initcomponents() {
        rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvGames = findViewById<RecyclerView>(R.id.rvGames)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter
        //gamesAdapter = GamesAdapter(games)
    }


}