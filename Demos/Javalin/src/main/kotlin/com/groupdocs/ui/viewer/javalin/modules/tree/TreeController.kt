package com.groupdocs.ui.viewer.javalin.modules.tree

import com.groupdocs.ui.viewer.javalin.manager.PathManager
import com.groupdocs.ui.viewer.javalin.model.FileDescriptionEntity
import com.groupdocs.ui.viewer.javalin.model.TreeRequest
import com.groupdocs.ui.viewer.javalin.modules.BaseController
import com.groupdocs.ui.viewer.javalin.usecase.GetLocalFilesUseCase
import com.groupdocs.ui.viewer.javalin.usecase.LocalStorageEntry
import org.koin.core.component.KoinComponent
import java.net.URLDecoder
import java.net.URLEncoder

class TreeControllerImpl(
    private val getLocalFiles: GetLocalFilesUseCase,
    private val pathManager: PathManager
) : BaseController(), TreeController, KoinComponent {

    override suspend fun tree(request: TreeRequest): List<FileDescriptionEntity> {
        val path = pathManager.assertPathIsInsideFilesDirectory(URLDecoder.decode(request.path, "UTF-8"))

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
                guid = URLEncoder.encode(guid, "UTF-8"),
                name = it.name,
                isDirectory = isDirectory,
                size = size
            )
        }
    }

}

interface TreeController {
    suspend fun tree(request: TreeRequest): List<FileDescriptionEntity>
}