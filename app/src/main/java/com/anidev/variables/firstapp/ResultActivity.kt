package com.anidev.variables.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.anidev.variables.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val txtVwResult = findViewById<TextView>(R.id.txtVwResult)
        val name: String = intent.extras?.getString("Extra_Name").orEmpty()
        txtVwResult.text = "Hola $name"
    }
}