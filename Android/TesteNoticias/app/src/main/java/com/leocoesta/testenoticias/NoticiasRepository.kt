package com.leocoesta.testenoticias

import androidx.paging.toLiveData
import com.leocoesta.testenoticias.api.NoticiasService
import java.util.concurrent.Executors

class NoticiasRepository (private val api: NoticiasService) {

    val sourceFactory = NoticiasFactory(api)

    val livePagedList = sourceFactory.toLiveData(
        pageSize = DATABASE_PAGE_SIZE,
        fetchExecutor = Executors.newFixedThreadPool(5)
    )

    companion object {
        private const val DATABASE_PAGE_SIZE = 20
    }
}