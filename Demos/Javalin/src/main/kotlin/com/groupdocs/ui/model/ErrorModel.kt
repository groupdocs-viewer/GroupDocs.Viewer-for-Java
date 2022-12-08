package com.groupdocs.ui.model

data class ErrorResponse(
    val message: String,
    val exception: Exception? = null
)
