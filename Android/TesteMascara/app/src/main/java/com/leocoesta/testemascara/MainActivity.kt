package com.leocoesta.testemascara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.sapereaude.maskedEditText.MaskedEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit = findViewById<MaskedEditText>(R.id.teste)
        val bt = findViewById<Button>(R.id.button)

        bt.setOnClickListener { println(edit.rawText) }

    }
}
