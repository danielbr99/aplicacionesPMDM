package com.example.aplicacionespmdm.BoardGamesApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionespmdm.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BoardGamesActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter : GameAdapter
    private lateinit var fabAddGame: FloatingActionButton
    private val categories = listOf(
        GameCategory.Cooperative,
        GameCategory.Deckbuilding,
        GameCategory.Euro,
        GameCategory.LCG,
        GameCategory.Legacy
    )
    private val games = mutableListOf(
        Game("Frostpunk1", GameCategory.Cooperative),
        Game("Frostpunk2", GameCategory.Deckbuilding),
        Game("Frostpunk3", GameCategory.Euro),
        Game("Frostpunk4", GameCategory.LCG),
        Game("Frostpunk5", GameCategory.Legacy),
        Game("Frostpunk6", GameCategory.Cooperative),
        Game("Frostpunk7", GameCategory.Deckbuilding),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_board_games)
        initcomponents()
        initUI()
        initListeners()
    }

    private fun initcomponents() {
        rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvGames = findViewById<RecyclerView>(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) {position -> onCategorySelected(position)}
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter
        gamesAdapter = GameAdapter(games) {position -> onGameSelected(position)}
        rvGames.layoutManager =
            LinearLayoutManager(this)
        rvGames.adapter = gamesAdapter
    }

    private fun initListeners() { fabAddGame.setOnClickListener{ showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)

        val btnAddGame: Button = dialog.findViewById(R.id.btnAddGame)
        val etGame: EditText = dialog.findViewById(R.id.etGame)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if(currentGame.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: GameCategory = when(selectedRadioButton.text){
                    getString(R.string.dialog_cooperative_category) -> GameCategory.Cooperative
                    getString(R.string.dialog_deckbuilding_category) -> GameCategory.Deckbuilding
                    getString(R.string.dialog_euro_category) -> GameCategory.Euro
                    getString(R.string.dialog_lcg_category) -> GameCategory.LCG
                    else -> GameCategory.Legacy
                }
                games.add(Game(currentGame, currentCategory))
                updateGames()
                dialog.hide()

            }
        }
        dialog.show()
    }

    private fun updateGames(){
        val selectedCategories: List<GameCategory> = categories.filter { it.isSelected }
        val newGames = games.filter { selectedCategories.contains(it.category) }
        gamesAdapter.games = newGames.toMutableList()

        gamesAdapter.notifyDataSetChanged()
    }

    private fun onGameSelected(position:Int){
        games[position].isSelected = !games[position].isSelected
        updateGames()
    }

    private fun onCategorySelected(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateGames()
    }









}