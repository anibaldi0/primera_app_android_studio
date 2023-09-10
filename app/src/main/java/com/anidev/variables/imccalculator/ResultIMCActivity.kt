package com.anidev.variables.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.anidev.variables.R
import com.anidev.variables.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var txtVwResult:TextView
    private  lateinit var txtVwIMC:TextView
    private lateinit var txtVwDescription:TextView
    private lateinit var btnReCalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponent()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUI(result: Double) {
        txtVwIMC.text = result.toString()
        when(result) {
            in 0.00..18.50 -> { //bajo peso
                txtVwResult.text = getString(R.string.title_bajo_peso)
                txtVwResult.setTextColor(ContextCompat.getColor(this, R.color.bajo_peso))
                txtVwDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99 -> { //peso normal
                txtVwResult.text = getString(R.string.title_peso_normal)
                txtVwResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                txtVwDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 -> { //sobrepeso
                txtVwResult.text = getString(R.string.title_sobrepeso)
                txtVwResult.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                txtVwDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.00 -> { //obesidad
                txtVwResult.text = getString(R.string.title_obeso)
                txtVwResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                txtVwDescription.text = getString(R.string.description_obeso)
            }
            else -> { //error
                txtVwIMC.text = getString(R.string.error)
                txtVwResult.text = getString(R.string.error)
                txtVwDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponent() {
        txtVwIMC = findViewById(R.id.txtVwIMC)
        txtVwResult = findViewById(R.id.txtVwResult)
        txtVwDescription = findViewById(R.id.txtVwDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }
}