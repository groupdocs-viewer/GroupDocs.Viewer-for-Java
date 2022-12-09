package com.groupdocs.ui.usecase

import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.status.InternalServerException
import com.groupdocs.viewer.Viewer
import com.groupdocs.viewer.options.HtmlViewOptions
import com.groupdocs.viewer.options.LoadOptions
import com.groupdocs.viewer.options.Rotation
import com.groupdocs.viewer.options.ViewInfoOptions
import org.koin.core.component.KoinComponent
import java.io.*
import java.nio.file.Files
import java.nio.file.Path

class RetrieveLocalFilePagesStreamUseCase(
    private val managerBeans: PathManager
) : KoinComponent {
    operator fun invoke(
        inputStream: InputStream,
        password: String? = null,
        previewWidth: Int,
        previewRatio: Float,
        pageRotations: Map<Int, Rotation>? = null,
        processStream: (pageNumber: Int, width: Int, height: Int, inputStream: InputStream) -> Unit
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
                }) { _, stream ->
                    try {
                        stream.close()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }.also { viewOptions ->
                    viewOptions.imageMaxWidth = previewWidth
                    viewOptions.imageMaxHeight = (previewWidth * previewRatio).toInt()
                    pageRotations?.forEach { (pageNumber, rotation) ->
                        viewOptions.pageRotations[pageNumber] = rotation
                    }
                }

                viewer.view(viewOptions)

                val viewInfo = viewer.getViewInfo(ViewInfoOptions.fromHtmlViewOptions(viewOptions))

                pages.forEach { (pageNumber, pagePath) ->
                    BufferedInputStream(FileInputStream(pagePath.toFile())).use { inputStream ->
                        val pageInfo = viewInfo.pages.first { it.number == pageNumber }
                        processStream(pageNumber, pageInfo.width, pageInfo.height, inputStream)
                    }
                    Files.deleteIfExists(pagePath)
                }
            }
        } catch (e: Exception) {
            throw RetrieveLocalFilePagesStreamException("Can't retrieve local file description", e)
        }
    }
}

class RetrieveLocalFilePagesStreamException(message: String, e: Throwable? = null) : InternalServerException(message, e)