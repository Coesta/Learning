package com.leocoesta.sobremim

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.leocoesta.sobremim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val meuNome: MeuNome = MeuNome(meuNome = "Leonardo Costa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.enviarButton.setOnClickListener { definirApelido(it) }
        binding.meuNome = meuNome

    }

    private fun definirApelido(view: View) {
        binding.apply {
            meuNome?.meuApelido = apelidoEdit.text.toString()
            invalidateAll()
            apelidoEdit.visibility = View.GONE
            enviarButton.visibility = View.GONE
            apelidoText.visibility = View.VISIBLE
        }

        esconderTeclado(view)
    }

    private fun esconderTeclado(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
