package com.example.aplicacionespmdm.MessageApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicacionespmdm.R


class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_activity)

        var textoHola = findViewById<TextView>(R.id.hello)
        var nombre: String = intent.extras?.getString("extra_name").orEmpty()
        textoHola.text = "$nombre"

        var btnSend = findViewById<Button>(R.id.buttonSend)
        var userText = findViewById<EditText>(R.id.etName)

        btnSend.setOnClickListener{
            var name = userText.text.toString()
            if (name.isNotEmpty()){
                var textIntent = Intent(this, MainActivity::class.java)
                textIntent.putExtra("extra_name",name)
                startActivity(textIntent)
            }

        }
    }
}
