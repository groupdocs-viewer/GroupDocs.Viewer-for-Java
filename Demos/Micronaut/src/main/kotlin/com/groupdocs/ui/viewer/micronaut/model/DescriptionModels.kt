package com.groupdocs.ui.viewer.micronaut.model

import com.fasterxml.jackson.annotation.JsonInclude

data class DescriptionRequest(
    val guid: String,
    val password: String?
)

// --------------------------------

@JsonInclude(JsonInclude.Include.ALWAYS)
data class DescriptionEntity(
    /**
     * Document Guid
     */
    val guid: String,

    /**
     * list of pages
     */
    val pages: MutableList<PageDescriptionEntity> = mutableListOf(),

    /**
     * Restriction for printing pdf files in viewer
     */
    val printAllowed: Boolean = true,

    val showGridLines: Boolean = true
)

/**
 * PageDescriptionEntity
 *
 * @author Aspose Pty Ltd
 */
data class PageDescriptionEntity(
    val data: String? = null,
    val angle: Int = 0,
    val width: Int = 0,
    val height: Int = 0,
    val number: Int = 0,
)
