package com.groupdocs.ui.viewer.ktor.usecase

import com.groupdocs.ui.viewer.ktor.status.InternalServerException
import org.koin.core.component.KoinComponent
import java.nio.file.Paths
import kotlin.io.path.extension

class AreFilesSupportedUseCase : KoinComponent {
    operator fun invoke(vararg fileNames: String): Boolean {
        fileNames.forEach {
            it.ifBlank {
                throw AreFilesSupportedException("Source file name can't be blank")
            }
        }

        val extensions = fileNames.map { Paths.get(it).extension }
        val firstExtension = extensions.firstOrNull()
        return extensions.count { it != firstExtension || !SUPPORTED_EXTENSIONS.contains(it) } == 0
    }

    companion object {
        val SUPPORTED_EXTENSIONS = listOf(
            "doc",
            "docx",
            "xls",
            "xlsx",
            "ppt",
            "pptx",
            "pdf",
            "png",
            "txt",
            "html",
            "htm",
            "jpg",
            "jpeg"
        )
    }
}

class AreFilesSupportedException(message: String, e: Throwable? = null) : InternalServerException(message, e)