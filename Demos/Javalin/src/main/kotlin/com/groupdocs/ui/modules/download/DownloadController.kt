package com.groupdocs.ui.modules.download

import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.modules.BaseController
import com.groupdocs.ui.usecase.GetLocalFilesUseCase
import org.koin.core.component.KoinComponent
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.io.InputStream

class DownloadControllerImpl(
    private val pathManager: PathManager
) : BaseController(), DownloadController, KoinComponent {

    override suspend fun download(fileName: String): InputStream {
        val resultPath = pathManager.filesDirectory.resolve(fileName).toAbsolutePath().normalize().toString()
        val resultDocumentPath = pathManager.assertPathIsInsideFilesDirectory(resultPath)

        return BufferedInputStream(FileInputStream(resultDocumentPath.toFile()))
    }

}

interface DownloadController {
    suspend fun download(fileName: String): InputStream
}