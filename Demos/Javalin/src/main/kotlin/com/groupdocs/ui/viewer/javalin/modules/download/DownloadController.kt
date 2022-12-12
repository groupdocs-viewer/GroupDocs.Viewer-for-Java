package com.groupdocs.ui.viewer.javalin.modules.download

import com.groupdocs.ui.viewer.javalin.manager.PathManager
import com.groupdocs.ui.viewer.javalin.modules.BaseController
import org.koin.core.component.KoinComponent
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.nio.file.Paths

class DownloadControllerImpl(
    private val pathManager: PathManager
) : BaseController(), DownloadController, KoinComponent {

    override suspend fun download(filePath: String): InputStream {
        val resultPath = pathManager.filesDirectory.resolve(filePath).toAbsolutePath().normalize().toString()
        val resultDocumentPath = pathManager.assertPathIsInsideFilesDirectory(resultPath)

        return BufferedInputStream(FileInputStream(resultDocumentPath.toFile()))
    }

}

interface DownloadController {
    suspend fun download(filePath: String): InputStream
}