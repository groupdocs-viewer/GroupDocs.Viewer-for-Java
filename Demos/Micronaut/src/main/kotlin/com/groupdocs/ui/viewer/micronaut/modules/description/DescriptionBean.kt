package com.groupdocs.ui.viewer.micronaut.modules.description

import com.groupdocs.ui.viewer.micronaut.cache.FilesCache
import com.groupdocs.ui.viewer.micronaut.cache.MemoryFilesCacheEntry
import com.groupdocs.ui.viewer.micronaut.cache.MemoryFilesCachePage
import com.groupdocs.ui.viewer.micronaut.config.ApplicationConfig
import com.groupdocs.ui.viewer.micronaut.manager.PathManager
import com.groupdocs.ui.viewer.micronaut.model.DescriptionEntity
import com.groupdocs.ui.viewer.micronaut.model.DescriptionRequest
import com.groupdocs.ui.viewer.micronaut.model.PageDescriptionEntity
import com.groupdocs.ui.viewer.micronaut.usecase.RetrieveLocalFilePagesDataUseCase
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.net.URLDecoder
import java.net.URLEncoder

interface DescriptionBean {
    suspend fun description(request: DescriptionRequest): DescriptionEntity
}

@Bean(typed = [DescriptionBean::class])
@Singleton
class DescriptionBeanImpl(
    @Inject private val retrieveLocalFilePagesStream: RetrieveLocalFilePagesDataUseCase,
    @Inject private val pathManager: PathManager,
    @Inject private val appConfig: ApplicationConfig,
    @Inject private val filesCache: FilesCache
) : DescriptionBean {
    override suspend fun description(request: DescriptionRequest): DescriptionEntity {
        val guid = URLDecoder.decode(request.guid, "UTF-8")
        val path = pathManager.assertPathIsInsideFilesDirectory(guid)
        val password = request.password
        val previewPageWidth = appConfig.viewer.previewPageWidthOrDefault
        val previewPageRatio = appConfig.viewer.previewPageRatioOrDefault

        val entity = DescriptionEntity(
            guid = URLEncoder.encode(guid, "UTF-8"),
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
                        val data = String(pageInputStream.readBytes())
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