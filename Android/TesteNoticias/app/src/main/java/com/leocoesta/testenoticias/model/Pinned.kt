package com.leocoesta.testenoticias.model

data class Pinned(
    val cascade: Boolean,
    val isForePost: Boolean,
    val position: Int,
    val time: String
)