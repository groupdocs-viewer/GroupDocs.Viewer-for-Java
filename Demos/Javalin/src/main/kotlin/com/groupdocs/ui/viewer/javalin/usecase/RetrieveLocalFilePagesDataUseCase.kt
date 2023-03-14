package com.groupdocs.ui.viewer.javalin.usecase

import com.groupdocs.ui.viewer.javalin.manager.PathManager
import com.groupdocs.ui.viewer.javalin.util.InternalServerException
import com.groupdocs.viewer.Viewer
import com.groupdocs.viewer.options.*
import java.io.*
import java.nio.file.Files
import java.nio.file.Path

class RetrieveLocalFilePagesDataUseCase(
    private val managerBeans: PathManager
) {
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

                val viewInfoOptions = ViewInfoOptions.fromHtmlViewOptions(viewOptions).apply {
                    spreadsheetOptions.textOverflowMode = TextOverflowMode.HIDE_TEXT
                    spreadsheetOptions.isSkipEmptyColumns = true
                    spreadsheetOptions.isSkipEmptyRows = true
                }

                val viewInfo = viewer.getViewInfo(viewInfoOptions)

                pages.forEach { (pageNumber, pagePath) ->
                    BufferedInputStream(FileInputStream(pagePath.toFile())).use { inputStream ->
                        val pageInfo = viewInfo.pages.firstOrNull { it.number == pageNumber }
                        if (pageInfo == null) {
                            System.err.println("Pages info has incorrect number of pages. Try to configure HtmlViewOptions")
                            return@forEach
                        } else {
                            processStream(pageNumber, pageInfo.width, pageInfo.height, inputStream)
                        }
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