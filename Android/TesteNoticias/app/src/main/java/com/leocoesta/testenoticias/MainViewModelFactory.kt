package com.leocoesta.testenoticias

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leocoesta.testenoticias.api.NoticiasService
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val repository: NoticiasRepository,
                           private val api: NoticiasService) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository, api) as T
        }

        throw IllegalArgumentException("Classe viewmodel desconhecida!")
    }

}