package com.leocoesta.testenoticias.model

data class PinnedX(
    val cascade: Boolean,
    val isForePost: Boolean,
    val position: Int,
    val time: String
)