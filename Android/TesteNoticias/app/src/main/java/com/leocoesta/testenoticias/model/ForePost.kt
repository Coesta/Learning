package com.leocoesta.testenoticias.model

data class ForePost(
    val aggregatedPosts: List<Any>,
    val content: ContentXX,
    val created: String,
    val draft: Boolean,
    val feedId: String,
    val id: String,
    val isPinned: Boolean,
    val lastPublication: String,
    val modified: String,
    val pinned: Pinned,
    val postHash: String,
    val publication: String,
    val tenantId: String,
    val type: String,
    val versionId: String
)