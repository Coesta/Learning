package com.leocoesta.testenoticias

import androidx.lifecycle.ViewModel
import com.leocoesta.testenoticias.api.NoticiasApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        viewModelScope.launch {
            val noticias = NoticiasApi.noticiasApi.obterFeedPrincipal()
            println(noticias.feed.falkor.items.first().toString())
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}