package com.leocoesta.testenoticias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.leocoesta.testenoticias.api.NoticiasApi
import com.leocoesta.testenoticias.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.listaNoticiasRv.adapter = NoticiasAdapter()
    }
}
