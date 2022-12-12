package com.groupdocs.ui.viewer.javalin.model

data class ErrorResponse(
    val message: String,
    val exception: Exception? = null
)
