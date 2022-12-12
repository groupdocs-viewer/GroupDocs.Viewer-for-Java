package com.groupdocs.ui.viewer.micronaut.modules.tree

import com.groupdocs.ui.viewer.micronaut.manager.PathManager
import com.groupdocs.ui.viewer.micronaut.model.FileDescriptionEntity
import com.groupdocs.ui.viewer.micronaut.model.TreeRequest
import com.groupdocs.ui.viewer.micronaut.usecase.GetLocalFilesUseCase
import com.groupdocs.ui.viewer.micronaut.usecase.LocalStorageEntry
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

interface TreeBean {
    suspend fun tree(request: TreeRequest): List<FileDescriptionEntity>
}

@Bean(typed = [TreeBean::class])
@Singleton
class TreeBeanImpl(
    @Inject private val getLocalFiles: GetLocalFilesUseCase,
    @Inject private val pathManager: PathManager,
) : TreeBean {
    override suspend fun tree(request: TreeRequest): List<FileDescriptionEntity> {
        val path = pathManager.assertPathIsInsideFilesDirectory(URLDecoder.decode(request.path, StandardCharsets.UTF_8))

        val localFiles = getLocalFiles(path)
        return localFiles.sortedBy {
            it is LocalStorageEntry.File
        }.map {
            val isDirectory = it is LocalStorageEntry.Directory
            val size = if (it is LocalStorageEntry.File) it.size else 0

            val filesDirectory = pathManager.filesDirectory
            val fileFullPath = it.fullPath
            val guid = filesDirectory.relativize(fileFullPath).toString()
            FileDescriptionEntity(
                guid = URLEncoder.encode(guid, StandardCharsets.UTF_8),
                name = it.name,
                isDirectory = isDirectory,
                size = size
            )
        }
    }
}