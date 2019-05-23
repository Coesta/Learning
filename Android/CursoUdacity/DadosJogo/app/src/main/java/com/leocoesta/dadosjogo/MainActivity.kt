package com.leocoesta.dadosjogo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rolarBotao : Button = findViewById(R.id.rolar_bt)
        rolarBotao.text = "Jogar Dados"

        rolarBotao.setOnClickListener {
            Toast.makeText(this, "Dados jogados", Toast.LENGTH_SHORT).show()
        }
    }
}
