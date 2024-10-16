package com.example.aplicacionespmdm.IMCapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.aplicacionespmdm.MessageApp.MainActivity
import com.example.aplicacionespmdm.R
import com.google.android.material.slider.RangeSlider
import java.lang.Math.pow
import java.text.DecimalFormat

class IMCactivity : AppCompatActivity() {


    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var tvAge: TextView
    private lateinit var btnSubstractWeight: CardView
    private lateinit var btnAddWeight: CardView
    private lateinit var btnSubstractAge: CardView
    private lateinit var btnAddAge: CardView
    private lateinit var btnCalculate: CardView
    private var currentWeight: Int = 70
    private var currentAge: Int = 18
    private var currentHeight: Int = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        initComponents()
        initListeners()
        setWeight()
        setAge()

    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        btnSubstractAge = findViewById(R.id.btnSubstractAge)
        btnAddAge = findViewById(R.id.btnAddAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }


    private fun initListeners() {
        viewMale.setOnClickListener { setComponentColorFemale() }
        viewFemale.setOnClickListener { setComponentColorMale() }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnSubstractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubstractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            Log.i("IMC", "El IMC es $result")
            navigateToResult(result)

        }

    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun calculateIMC(): Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / pow(currentHeight.toDouble() / 100, 2.0)

        return df.format(imc).toDouble()
    }

    private fun navigateToResult(result : Double) {
        var intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }

    private fun setComponentColorMale() {
        if (!isMaleSelected) {
            viewMale.setCardBackgroundColor(getColor(R.color.black))
            viewFemale.setCardBackgroundColor(getColor(R.color.gray))
            isMaleSelected = true
            isFemaleSelected = false
        }
    }

    private fun setComponentColorFemale() {
        if (!isFemaleSelected) {
            viewMale.setCardBackgroundColor(getColor(R.color.gray))
            viewFemale.setCardBackgroundColor(getColor(R.color.black))
            isMaleSelected = false
            isFemaleSelected = true
        }
    }


}
