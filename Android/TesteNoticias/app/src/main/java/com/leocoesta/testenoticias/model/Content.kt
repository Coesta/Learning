package com.leocoesta.testenoticias.model

data class Content(
    val chapeu: Chapeu,
    val section: String,
    val summary: String,
    val title: String,
    val url: String
)