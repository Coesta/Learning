package com.leocoesta.testenoticias.model

data class NoticiasResponse(
    val content_type: ContentType,
    val data_layer: DataLayer,
    val feed: Feed,
    val header: Header,
//    val hierarchy: Hierarchy,
//    val macroareas: Macroareas,
    val resource: Resource
)