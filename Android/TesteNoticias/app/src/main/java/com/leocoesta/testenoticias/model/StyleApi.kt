package com.leocoesta.testenoticias.model

data class StyleApi(
    val category: String,
    val created: String,
    val createdBy: String,
//    val favicon: FaviconX,
    val id: String,
    val inherits: Boolean,
    val modified: String,
    val operation: String,
    val primaryColor: String,
    val productBrand: String,
    val tenantId: String,
    val title: String,
    val type: String,
    val versionId: String
)