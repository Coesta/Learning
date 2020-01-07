package com.leocoesta.testenoticias.model

data class NavigationApi(
    val category: String,
    val created: String,
    val createdBy: String,
    val headerCSS: String,
    val headerHTML: String,
    val headerJS: String,
    val headerJSON: String,
    val id: String,
    val modified: String,
    val tenantId: String,
    val versionId: String
)