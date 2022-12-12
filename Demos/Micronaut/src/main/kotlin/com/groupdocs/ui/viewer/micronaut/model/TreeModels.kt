package com.groupdocs.ui.viewer.micronaut.model

import com.fasterxml.jackson.annotation.JsonInclude

data class TreeRequest(
    val path: String
)

// --------------------------------

@JsonInclude(JsonInclude.Include.ALWAYS)
data class FileDescriptionEntity(
    val guid: String? = null,
    val name: String? = null,
    val isDirectory: Boolean? = null,
    val size: Long? = null
)