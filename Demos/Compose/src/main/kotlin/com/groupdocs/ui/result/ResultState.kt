package com.groupdocs.ui.result

import java.nio.file.Paths

data class ResultState(
    val isInProgress: Boolean = true,
    val errorMessage: String? = null,
    val infoMessage: String? = null,
    val sourcePath: String = "",
    val resultPath: String = "",
    val pagesCount: Int = 1,
    val pageList: List<String> = emptyList()
) {
    val sourceName: String get() = Paths.get(sourcePath).fileName.toString()
}

