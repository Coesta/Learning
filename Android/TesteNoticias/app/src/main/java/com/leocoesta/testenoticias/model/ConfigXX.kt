package com.leocoesta.testenoticias.model

data class ConfigXX(
    val componentPosition: Int,
    val cutRange: Int,
    val editorialSlice: Int,
    val feedType: String,
    val forePosts: Int,
    val photoOverVideo: Boolean,
    val recommendation: RecommendationX
)