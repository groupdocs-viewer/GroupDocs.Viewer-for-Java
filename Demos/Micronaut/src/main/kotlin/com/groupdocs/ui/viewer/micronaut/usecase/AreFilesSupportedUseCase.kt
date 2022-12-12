package com.groupdocs.ui.viewer.micronaut.usecase

import com.groupdocs.ui.viewer.micronaut.util.InternalServerException
import io.micronaut.context.annotation.Bean
import java.nio.file.Paths
import kotlin.io.path.extension

@Bean
class AreFilesSupportedUseCase {
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