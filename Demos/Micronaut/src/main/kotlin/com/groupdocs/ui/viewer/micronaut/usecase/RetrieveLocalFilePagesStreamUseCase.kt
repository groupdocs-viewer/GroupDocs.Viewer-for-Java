package com.groupdocs.ui.viewer.micronaut.usecase

import com.groupdocs.ui.viewer.micronaut.manager.PathManager
import com.groupdocs.ui.viewer.micronaut.util.InternalServerException
import com.groupdocs.viewer.Viewer
import com.groupdocs.viewer.options.HtmlViewOptions
import com.groupdocs.viewer.options.LoadOptions
import com.groupdocs.viewer.options.Rotation
import io.micronaut.context.annotation.Bean
import java.io.*
import java.nio.file.Files
import java.nio.file.Path

@Bean
class RetrieveLocalFilePagesStreamUseCase(
    private val managerBeans: PathManager
) {
    operator fun invoke(
        inputStream: InputStream,
        password: String? = null,
        previewWidth: Int,
        previewRatio: Float,
        pageRotations: Map<Int, Rotation>? = null,
        processStream: (pageNumber: Int, inputStream: InputStream) -> Unit
    ) {
        try {
            val loadOptions = LoadOptions()
            loadOptions.password = password

            Viewer(inputStream, loadOptions).use { viewer ->
                val pages = mutableMapOf<Int, Path>()

                val viewOptions = HtmlViewOptions.forEmbeddedResources({ pageNumber ->
                    val pathForTempFile = managerBeans.createPathForTempFile()
                    pages[pageNumber] = pathForTempFile
                    BufferedOutputStream(FileOutputStream(pathForTempFile.toFile()))
                }) { pageNumber, stream ->
                    try {
                        stream.close()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    pages[pageNumber]?.let { pagePath ->
                        BufferedInputStream(FileInputStream(pagePath.toFile())).use { inputStream ->
                            processStream(pageNumber, inputStream)
                        }
                        Files.deleteIfExists(pagePath)
                    }
                }.also { viewOptions ->
                    viewOptions.imageMaxWidth = previewWidth
                    viewOptions.imageMaxHeight = (previewWidth * previewRatio).toInt()
                    pageRotations?.forEach { (pageNumber, rotation) ->
                        viewOptions.pageRotations[pageNumber] = rotation
                    }
                }

                viewer.view(viewOptions)
            }
        } catch (e: Exception) {
            throw RetrieveLocalFilePagesStreamException("Can't retrieve local file description", e)
        }

    }
}

class RetrieveLocalFilePagesStreamException(message: String, e: Throwable? = null) : InternalServerException(message, e)