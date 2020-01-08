package com.leocoesta.testenoticias

import androidx.paging.ItemKeyedDataSource
import com.leocoesta.testenoticias.api.NoticiasService
import com.leocoesta.testenoticias.model.Item
import com.leocoesta.testenoticias.model.NoticiasResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoticiasDataSource(
    private val api: NoticiasService,
    private val nextPage: String
) : ItemKeyedDataSource<String, Item>() {



    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<Item>
    ) {
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
            val feedInicial = api.obterFeedPrincipal().feed.falkor.items

            callback.onResult(feedInicial)
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKey(item: Item): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<Item>) {}

}