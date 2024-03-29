package com.leocoesta.testefullscreendialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<MaterialButton>(R.id.dialog_button)

        button.setOnClickListener {
            val dialogo = DialogoFragment()
            dialogo.exibir(supportFragmentManager)
        }
    }
}
