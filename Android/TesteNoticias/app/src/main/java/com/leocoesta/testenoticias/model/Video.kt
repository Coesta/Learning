package com.leocoesta.testenoticias.model

data class Video(
    val duration: Int,
    val id: Int,
    val kind: String,
    val previewUrl: String,
    val programTitle: String,
    val trademark: String,
    val trademarkRaster: String,
    val url: String
)