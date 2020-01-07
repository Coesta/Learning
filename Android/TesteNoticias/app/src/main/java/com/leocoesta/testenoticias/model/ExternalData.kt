package com.leocoesta.testenoticias.model

data class ExternalData(
    val config: ConfigXX,
    val forePosts: List<ForePost>,
    val id: String,
    val items: List<ItemX>,
    val limit: Int,
    val nextPage: Int,
    val source: String
)