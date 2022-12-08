package com.groupdocs.ui.viewer.javalin.modules.rotate

import com.groupdocs.ui.viewer.javalin.cache.FilesCache
import com.groupdocs.ui.viewer.javalin.cache.MemoryFilesCacheEntry
import com.groupdocs.ui.viewer.javalin.cache.MemoryFilesCachePage
import com.groupdocs.ui.viewer.javalin.manager.PathManager
import com.groupdocs.ui.viewer.javalin.model.RotateRequest
import com.groupdocs.ui.viewer.javalin.model.RotateResponse
import com.groupdocs.ui.viewer.javalin.modules.BaseController
import com.groupdocs.ui.viewer.javalin.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.viewer.javalin.usecase.RetrieveLocalFilePagesDataUseCase
import com.groupdocs.ui.viewer.javalin.util.InternalServerException
import com.groupdocs.ui.viewer.javalin.util.angleToRotation
import com.groupdocs.ui.viewer.javalin.util.rotationToAngle
import com.groupdocs.viewer.options.Rotation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

class RotateControllerImpl(
    private val retrieveLocalFilePagesStream: RetrieveLocalFilePagesDataUseCase,
    private val areFilesSupported: AreFilesSupportedUseCase,
    private val pathManager: PathManager,
    private val filesCache: FilesCache
) : BaseController(), RotateController, KoinComponent {

    override suspend fun rotate(request: RotateRequest): RotateResponse {
        val password = request.password
        val pageNumber = request.pages.firstOrNull() ?: throw IllegalStateException("Incorrect request data!")
        val angle = request.angle
        val guid = URLDecoder.decode(request.guid, StandardCharsets.UTF_8)

        val filePath = pathManager.assertPathIsInsideFilesDirectory(guid)

        if (!areFilesSupported(filePath.fileName.toString())) {
            throw InternalServerException("Document types are not supported in sample app, anyway, it is still supported by GroupDocs.Viewer itself. Other probable reason of the error - documents types are different.") // TODO: Need another exception type
        }

        val previewPageWidth = appConfig.viewer.previewPageWidthOrDefault
        val previewPageRatio = appConfig.viewer.previewPageRatioOrDefault

        val pageRotations: Map<Int, Rotation>? = if (filesCache.isEntryExist(guid = guid)) {
            val entry = filesCache.readEntry(guid = guid)

            val entryPage = entry.pages.first { it.pageNumber == pageNumber }

            (angle + entryPage.angle).angleToRotation()?.let { rotation ->
                mapOf(Pair(pageNumber, rotation))
            }
        } else {
            angle.angleToRotation()?.let { rotation ->
                mapOf(Pair(pageNumber, rotation))
            }
        }

        return withContext(Dispatchers.IO) {
            BufferedInputStream(FileInputStream(filePath.toFile())).use { inputStream ->
                var response: RotateResponse? = null
                retrieveLocalFilePagesStream(
                    inputStream = inputStream,
                    password = password,
                    pageRotations = pageRotations,
                    previewWidth = previewPageWidth,
                    previewRatio = previewPageRatio,
                ) { pageNumber, width, height, pageInputStream ->
                    response = RotateResponse(
                        data = String(pageInputStream.readAllBytes()),
                        angle = 0,
                        number = pageNumber,
                        width = width,
                        height = height,
                    )
                }
                if (filesCache.isEntryExist(guid = guid)) {
                    val entry = filesCache.readEntry(guid = guid)
                    filesCache.createEntry(guid = guid, entry = entry.copy(
                        pages = entry.pages.map {
                            if (it.pageNumber == pageNumber) {
                                it.copy(
                                    angle = pageRotations?.get(pageNumber)?.rotationToAngle() ?: 0,
                                    data = response?.data
                                )
                            } else it
                        }
                    ))
                } else {
                    val entry = MemoryFilesCacheEntry(
                        lastAccess = System.currentTimeMillis(),
                        pages = listOf(
                            MemoryFilesCachePage(
                                pageNumber = pageNumber,
                                angle = pageRotations?.get(pageNumber)?.rotationToAngle() ?: 0,
                                width = response?.width ?: previewPageWidth,
                                height = response?.height ?: (previewPageWidth * previewPageRatio).toInt(),
                                data = response?.data
                            )
                        )
                    )
                    filesCache.createEntry(guid = guid, entry)
                }
                response ?: throw IllegalStateException("Response must not be null")
            }
        }
    }
}

interface RotateController {
    suspend fun rotate(request: RotateRequest): RotateResponse
}