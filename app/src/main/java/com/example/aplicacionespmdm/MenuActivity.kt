package com.example.aplicacionespmdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionespmdm.BoardGamesApp.BoardGamesActivity
import com.example.aplicacionespmdm.IMCapp.IMCactivity
import com.example.aplicacionespmdm.MessageApp.HelloActivity
import com.example.aplicacionespmdm.MessageApp.MainActivity
import com.example.aplicacionespmdm.SuperheroApp.SuperheroListActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        var btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        var btnBoardGamesApp = findViewById<Button>(R.id.btnBoardGamesApp)
        var btnSuperheroApp = findViewById<Button>(R.id.btnSuperheroApp)

        btnMessageApp.setOnClickListener{navigateToMessageApp()}
        btnHelloApp.setOnClickListener{navigateToHelloApp()}
        btnIMCApp.setOnClickListener{navigateToIMCApp()}
        btnBoardGamesApp.setOnClickListener{navigateToBoardGamesApp()}
        btnSuperheroApp.setOnClickListener{navigateToSuperheroApp()}



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun navigateToMessageApp(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHelloApp(){
        var intent = Intent(this, HelloActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp(){
        var intent = Intent(this, IMCactivity::class.java)
        startActivity(intent)
    }

    private fun navigateToBoardGamesApp(){
        var intent = Intent(this, BoardGamesActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperheroApp(){
        var intent = Intent(this, SuperheroListActivity::class.java)
        startActivity(intent)
    }
}