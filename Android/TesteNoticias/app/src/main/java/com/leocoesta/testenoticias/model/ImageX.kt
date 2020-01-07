package com.leocoesta.testenoticias.model

data class ImageX(
    val cropOptions: CropOptions,
    val rightsHolder: String,
    val size: Size,
    val sizes: Sizes,
    val url: String
)