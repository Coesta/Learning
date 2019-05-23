package com.leocoesta.rolardados

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var imagemDado : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagemDado = findViewById(R.id.dado_image)

        val rolarDadosBt : Button = findViewById(R.id.rolar_dados_bt)
        rolarDadosBt.setOnClickListener {
            rolarDados()
        }
    }

    private fun rolarDados() {

        val randomNumber = Random.nextInt(6) + 1
        val resourceDrawable = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        imagemDado.setImageResource(resourceDrawable)

    }
}
