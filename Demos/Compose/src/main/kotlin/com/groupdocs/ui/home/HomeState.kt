package com.groupdocs.ui.home

import java.nio.file.Paths

data class HomeState(
    val isInProgress: Boolean = false,
    val sourceError: String? = null,
    val sourcePath: String? = null,
) {
    val isSourcePresent: Boolean = !sourcePath.isNullOrEmpty()

    val sourceFileName: String? get() = sourcePath?.let { Paths.get(it).fileName.toString() }
}

