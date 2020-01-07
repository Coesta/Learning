package com.leocoesta.testenoticias.model

data class MulticontentConfig(
    val category: String,
    val channels: Channels,
    val cloneMulticontent: Boolean,
    val configurationSidebar: ConfigurationSidebar,
    val created: String,
    val createdBy: String,
    val id: String,
    val modified: String,
    val seeMoreButton: Boolean,
    val seeMoreButtonLabel: String,
    val seeMoreButtonMinLimit: Int,
    val seeMoreButtonPosition: Int,
    val sharebar: Sharebar,
    val tenantId: String,
    val versionId: String
)