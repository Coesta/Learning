package com.leocoesta.testenoticias

import androidx.paging.PageKeyedDataSource
import com.leocoesta.testenoticias.api.NoticiasService
import com.leocoesta.testenoticias.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoticiasDataSource(private val api: NoticiasService) : PageKeyedDataSource<String, Item>() {

    var ofertaCorrente: String = ""

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, Item>
    ) {
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {

            val feedInicial = api.obterFeedPrincipal().feed

            val nextPage = feedInicial.falkor.nextPage.toString()
            ofertaCorrente = feedInicial.oferta!!

            val items = api.obterFeedPrincipal().feed.falkor.items

            callback.onResult(items, null, nextPage)
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, Item>) {

    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, Item>) {}

}