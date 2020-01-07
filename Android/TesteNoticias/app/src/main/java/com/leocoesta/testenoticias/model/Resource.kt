package com.leocoesta.testenoticias.model

data class Resource(
    val bastianInstance: String,
    val brandedContent: Boolean,
    val brandedContentCampaign: String,
    val category: String,
    val contentType: String,
    val created: String,
    val createdBy: String,
    val description: String,
    val id: String,
    val issued: String,
    val modified: String,
    val scheduled: Boolean,
    val scheduler: Any,
    val status: StatusX,
    val tenantId: String,
    val title: String,
    val versionId: String
)