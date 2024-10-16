package com.example.aplicacionespmdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionespmdm.IMCapp.IMCactivity
import com.example.aplicacionespmdm.MessageApp.HelloActivity
import com.example.aplicacionespmdm.MessageApp.MainActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        var btnIMCApp = findViewById<Button>(R.id.btnIMCApp)

        btnMessageApp.setOnClickListener{navigateToMessageApp()}
        btnHelloApp.setOnClickListener{navigateToHelloApp()}
        btnIMCApp.setOnClickListener{navigateToIMCApp()}



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
}