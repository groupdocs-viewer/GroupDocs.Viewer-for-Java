package com.groupdocs.ui.model

data class RotateRequest(
    val angle: Int,
    val pages: List<Int>,
    val guid: String,
    val password: String?
)

// --------------------------------

data class RotateResponse(
    val data: String,
    val angle: Int,
    val width: Int,
    val height: Int,
    val number: Int
)