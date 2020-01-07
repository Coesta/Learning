package com.leocoesta.testenoticias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.leocoesta.testenoticias.api.NoticiasApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview.text = "Carregando"
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    }
}
