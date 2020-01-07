package com.leocoesta.testenoticias.model

data class Item(
//    val age: Int,
//    val aggregatedPosts: List<AggregatedPost>,
//    val config: ConfigX,
    val content: Content? = null,
//    val created: String,
//    val `data`: Data,
//    val draft: Boolean,
//    val externalData: ExternalData,
//    val feedId: String,
    val id: String,
//    val isPinned: Boolean,
//    val lastPublication: String,
    val metadata: String? = null,
//    val modified: String,
//    val pinned: PinnedXX,
//    val position: String,
//    val postHash: String,
//    val publication: String,
//    val tenantId: String,
    val type: String
//    val versionId: String
)