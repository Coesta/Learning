package com.leocoesta.appcomswipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var contador : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        qtd_atualizacoes_tv.text

        swipe.setOnRefreshListener {
            contador++
            qtd_atualizacoes_tv.text = "$contador : atualizacoes"
            swipe.isRefreshing = false
        }
    }
}
