package com.leocoesta.sobremim

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.leocoesta.sobremim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        findViewById<Button>(R.id.enviar_button).setOnClickListener {
            definirApelido(it)
        }
    }

    private fun definirApelido(view: View) {
        val apelidoEdit = findViewById<EditText>(R.id.apelido_edit)
        val apelidoText = findViewById<TextView>(R.id.apelido_text)

        apelidoText.text = apelidoEdit.text
        apelidoEdit.visibility = View.GONE
        view.visibility = View.GONE
        apelidoText.visibility = View.VISIBLE

        esconderTeclado(view)
    }

    private fun esconderTeclado(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
