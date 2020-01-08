package com.leocoesta.testenoticias

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.leocoesta.testenoticias.api.NoticiasApi
import com.leocoesta.testenoticias.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _noticiasTipoBasico = MutableLiveData<List<Item>>()
    val noticiasTipoBasico: LiveData<List<Item>>
        get() = _noticiasTipoBasico

    init {
        viewModelScope.launch {

            val noticias = NoticiasApi.noticiasApi.obterFeedPrincipal()
//            _noticiasTipoBasico.value = noticias.feed.falkor.items.filter { it.type == "basico"}
//
//            println("Total Itens: ${noticias.feed.falkor.items.size}")
//            println("Total Itens Filtrados: ${noticias.feed.falkor.items.filter { it.type == "basico" }.size}")
//            println(noticias.feed.falkor.items.first().toString())
//            println(noticialTipoBasico.va.first().toString())

            println("Total Itens PRINCIPAL: ${noticias.feed.falkor.items.size}")
            println("Total Itens Filtrados PRINCIPAL: ${noticias.feed.falkor.items.filter { it.type == "basico" }.size}")
            println("Prox. Page: ${noticias.feed.falkor.nextPage}")


            val nextPageNoticia = NoticiasApi.noticiasApi.obterFeedProximaPagina(
                product = "g1",
                id = noticias.feed.oferta!!,
                page = noticias.feed.falkor.nextPage.toString()
            )

            println("Total Itens PAGINA: ${nextPageNoticia.feed.falkor.items.size}")
            println("Total Itens PAGINA: ${nextPageNoticia.feed.falkor.items.filter { it.type == "basico" }.size}")
            println("PAGINA Prox. Page: ${nextPageNoticia.feed.falkor.nextPage}")

        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}