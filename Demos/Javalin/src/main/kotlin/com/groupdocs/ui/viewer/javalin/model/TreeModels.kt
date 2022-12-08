package com.groupdocs.ui.viewer.javalin.model

data class TreeRequest(
    val path: String
)

// --------------------------------

data class FileDescriptionEntity(
    val guid: String? = null,
    val name: String? = null,
    val isDirectory: Boolean? = null,
    val size: Long? = null
)