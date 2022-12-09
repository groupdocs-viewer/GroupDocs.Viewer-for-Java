package com.groupdocs.ui.viewer.ktor.modules.download

import com.groupdocs.ui.viewer.ktor.manager.PathManager
import com.groupdocs.ui.viewer.ktor.modules.BaseController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.io.OutputStream
import java.nio.file.Files

class DownloadControllerImpl(
    private val pathManager: PathManager
) : BaseController(), DownloadController, KoinComponent {
    override suspend fun download(fileName: String,  outputStream: OutputStream) {
        val resultPath = pathManager.filesDirectory.resolve(fileName).toAbsolutePath().normalize().toString()
        val resultDocumentPath = pathManager.assertPathIsInsideFilesDirectory(resultPath)

        withContext(Dispatchers.IO) {
            Files.copy(resultDocumentPath, outputStream)
        }
    }

}

interface DownloadController {
    suspend fun download(fileName: String,  outputStream: OutputStream)
}