package com.groupdocs.ui.viewer.micronaut.model

data class CompareRequest(
    val guids: List<CompareDocument> = emptyList()
)

data class CompareDocument(
    val guid: String,
    val password: String? = null
)

// --------------------------------

data class CompareResponse(
    /**
     * List of change information
     */
    val changes: List<DocumentChange>,

    /**
     * Extension of compared files, for saving total results
     */
    val extension: String? = null,

    /**
     * Unique key of results
     */
    val guid: String,

    /**
     * List of images of pages with marked changes
     */
    val pages: List<ComparePage>,
)

/**
 * PageDescriptionEntity
 *
 * @author Aspose Pty Ltd
 */
data class ComparePage(
    val angle: Int = 0,
    val data: String? = null,
    val height: Int = 0,
    val number: Int = 0,
    val width: Int = 0,
)

data class DocumentChange(
    val authors: List<String>,
    val box: ChangeBox,
    val comparisonAction: Int,
    val componentType: String,
    val id: Int,
    val pageInfo: PageInfo,
    val sourceText: String?,
    val styleChanges: List<StyleChange>,
    val targetText: String?,
    val text: String,
    val type: Int,
)

data class ChangeBox(
    val x: Double,
    val y: Double,
    val height: Double,
    val width: Double
)

data class PageInfo(
    val height: Int,
    val pageNumber: Int,
    val width: Int
)

data class StyleChange(
    val newValue: Any,
    val oldValue: Any,
    val propertyName: String
)