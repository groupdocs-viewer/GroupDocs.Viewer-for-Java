package com.groupdocs.ui.model

data class ConfigResponse(
    val pageSelector: Boolean = true,
    val download: Boolean = true,
    val upload: Boolean = true,
    val print: Boolean = true,
    val browse: Boolean = true,
    val rewrite: Boolean = true,
    val enableRightClick: Boolean = true,
    val filesDirectory: String = "",
    val fontsDirectory: String = "",
    val preloadPageCount: Int = 0,
    val zoom: Boolean = true,
    val search: Boolean = true,
    val thumbnails: Boolean = true,
    val rotate: Boolean = true,
    val defaultDocument: String = "",
    val htmlMode: Boolean = true,
    val cache: Boolean = true,
    val saveRotateState: Boolean = true,
    val watermarkText: String = "",
    val printAllowed: Boolean = true,
    val showGridLines: Boolean = true,
    val cacheFolderName: String = ""
)