package com.leocoesta.testenoticias

import androidx.paging.LivePagedListBuilder
import com.leocoesta.testenoticias.api.NoticiasService

class NoticiasRepository (private val api: NoticiasService {

    val sourceFactory = NoticiasFactory(api)

    val pagedList = LivePagedListBuilder(sourceFactory, DATABASE_PAGE_SIZE)

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }
}