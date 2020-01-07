package com.leocoesta.testenoticias.model

data class Config(
    val componentPosition: Int,
    val cutRange: Int,
    val disableDateTime: Boolean,
    val editorialSlice: Int,
    val elastic: Elastic,
    val feedType: String,
    val forePosts: Int,
    val headlineVariation: Any,
    val maxAge: Int,
    val photoOverVideo: Boolean,
    val recommendation: Recommendation
)