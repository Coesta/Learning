package com.leocoesta.testenoticias

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.leocoesta.testenoticias.api.NoticiasService
import com.leocoesta.testenoticias.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoticiasFactory(
    private val api: NoticiasService
) : DataSource.Factory<String, Item>() {

    val sourceLiveData = MutableLiveData<NoticiasDataSource>()

    override fun create(): DataSource<String, Item> {
        val source = NoticiasDataSource(api)
        sourceLiveData.postValue(source)

        return source
    }

}