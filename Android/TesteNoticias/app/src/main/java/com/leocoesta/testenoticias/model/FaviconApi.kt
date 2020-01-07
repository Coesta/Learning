package com.leocoesta.testenoticias.model

data class FaviconApi(
    val category: String,
    val created: String,
    val favicon: Favicon,
    val id: String,
    val modified: String,
    val tenantId: String,
    val versionId: String
)