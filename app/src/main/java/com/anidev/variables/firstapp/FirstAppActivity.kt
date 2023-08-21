package com.anidev.variables.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.anidev.variables.R


class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val ediTxtName = findViewById<AppCompatEditText>(R.id.ediTxtName)

        btnStart.setOnClickListener {
            val name = ediTxtName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("Extra_Name", name)
                startActivity(intent)
            }
        }
        //para que arranque la primer pantalla
    }

}