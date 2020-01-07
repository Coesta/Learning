package com.leocoesta.testenoticias.model

data class ContentType(
    val api: String,
    val `class`: String,
    val created: String,
    val createdBy: String,
    val customName: String,
    val id: String,
    val modified: String,
    val name: String,
    val schema: String,
    val tenantId: String,
    val urlType: String,
    val useCustomName: Boolean,
    val versionId: String
)