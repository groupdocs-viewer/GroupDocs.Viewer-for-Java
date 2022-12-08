package com.groupdocs.ui.modules.description

import com.groupdocs.ui.cache.FilesCache
import com.groupdocs.ui.cache.MemoryFilesCacheEntry
import com.groupdocs.ui.cache.MemoryFilesCachePage
import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.model.DescriptionEntity
import com.groupdocs.ui.model.DescriptionRequest
import com.groupdocs.ui.model.PageDescriptionEntity
import com.groupdocs.ui.modules.BaseController
import com.groupdocs.ui.usecase.RetrieveLocalFilePagesDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class DescriptionControllerImpl(
    private val retrieveLocalFilePagesStream: RetrieveLocalFilePagesDataUseCase,
    private val pathManager: PathManager,
    private val filesCache: FilesCache
) : BaseController(), DescriptionController, KoinComponent {

    override suspend fun description(request: DescriptionRequest): DescriptionEntity {
        val guid = URLDecoder.decode(request.guid, StandardCharsets.UTF_8)
        val path = pathManager.assertPathIsInsideFilesDirectory(guid)
        val password = request.password
        val previewPageWidth = appConfig.viewer.previewPageWidthOrDefault
        val previewPageRatio = appConfig.viewer.previewPageRatioOrDefault

        val entity = DescriptionEntity(
            guid = URLEncoder.encode(guid, StandardCharsets.UTF_8),
            printAllowed = appConfig.common.print
        )
        if (filesCache.isEntryExist(guid = guid)) {
            val memoryFilesCacheEntry = filesCache.readEntry(guid = guid)
            entity.pages.addAll(memoryFilesCacheEntry.pages.map { mapEntry ->
                PageDescriptionEntity(
                    number = mapEntry.pageNumber,
                    width = previewPageWidth,
                    height = (previewPageWidth * previewPageRatio).toInt(),
                    data = mapEntry.data
                )
            })
            return entity
        } else {
            return withContext(Dispatchers.IO) {
                BufferedInputStream(FileInputStream(path.toFile())).use { inputStream ->
                    retrieveLocalFilePagesStream(
                        inputStream = inputStream,
                        password = password,
                        previewWidth = previewPageWidth,
                        previewRatio = previewPageRatio,
                    ) { pageNumber, width, height, pageInputStream ->
                        val data = String(pageInputStream.readAllBytes())
                        entity.pages.add(
                            PageDescriptionEntity(
                                number = pageNumber,
                                width = width,
                                height = height,
                                data = data
                            )
                        )
                    }
                    filesCache.createEntry(guid = guid, entry = MemoryFilesCacheEntry(
                        pages = entity.pages.map { page ->
                            MemoryFilesCachePage(
                                pageNumber = page.number,
                                angle = page.angle,
                                width = page.width,
                                height = page.height,
                                data = page.data
                            )
                        }
                    ))
                    entity
                }
            }
        }
    }
}

interface DescriptionController {
    suspend fun description(request: DescriptionRequest): DescriptionEntity
}