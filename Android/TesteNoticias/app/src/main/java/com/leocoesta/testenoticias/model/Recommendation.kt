package com.leocoesta.testenoticias.model

data class Recommendation(
    val active: Boolean,
    val contentId: String,
    val start: Int
)