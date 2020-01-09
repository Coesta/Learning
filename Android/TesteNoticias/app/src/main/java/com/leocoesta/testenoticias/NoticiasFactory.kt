package com.leocoesta.testenoticias

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.leocoesta.testenoticias.api.NoticiasService
import com.leocoesta.testenoticias.model.Item

class NoticiasFactory(private val api: NoticiasService) : DataSource.Factory<String, Item>() {

    val sourceLiveData = MutableLiveData<NoticiasDataSource>()

    override fun create(): DataSource<String, Item> {
        val source = NoticiasDataSource(api)
        sourceLiveData.value = source
        return source
    }

}