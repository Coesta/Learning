package com.leocoesta.testenoticias.model

data class BackstageStructure(
    val ancestors: List<Any>,
    val color_primary: String,
    val created: String,
    val createdBy: String,
    val disabled: Boolean,
    val header_css: String,
    val header_hrml: String,
    val header_js: String,
    val hierarchy_name: String,
    val hostname: String,
    val id: String,
    val modified: String,
    val name: String,
    val parent: String,
    val parentCategory: String,
    val parents: List<Any>,
    val path: String,
    val slug: String,
    val tenantId: String,
    val usingPath: String,
    val versionId: String
)