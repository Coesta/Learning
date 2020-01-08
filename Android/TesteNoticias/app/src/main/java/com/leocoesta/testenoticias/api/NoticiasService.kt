package com.leocoesta.testenoticias.api

import com.leocoesta.testenoticias.api.NoticiasService.Companion.URL_BASE
import com.leocoesta.testenoticias.model.Feed
import com.leocoesta.testenoticias.model.NoticiasResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface NoticiasService {

    companion object {
        const val URL_BASE = "https://native-leon.globo.com/feed/"
    }

    @GET(value = "g1")
    suspend fun obterFeedPrincipal(): NoticiasResponse

    @GET(value = "page/{product}/{id}/{page}")
    suspend fun obterFeedProximaPagina(
        @Path("product") product: String,
        @Path("id") id: String,
        @Path("page") page: String
    ): NoticiasResponse
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object NoticiasApi {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(URL_BASE)
        .build()

    val noticiasApi = retrofit.create(NoticiasService::class.java)
}
