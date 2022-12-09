package com.groupdocs.ui.modules.print

import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.modules.BaseController
import com.groupdocs.ui.status.InternalServerException
import com.groupdocs.ui.usecase.AreFilesSupportedUseCase
import com.groupdocs.viewer.Viewer
import com.groupdocs.viewer.options.LoadOptions
import com.groupdocs.viewer.options.PdfViewOptions
import org.koin.core.component.KoinComponent
import java.io.OutputStream

class PrintControllerImpl(
    private val pathManager: PathManager,
    private val areFilesSupported: AreFilesSupportedUseCase
) : BaseController(), PrintController, KoinComponent {
    override suspend fun print(fileGuid: String, filePassword: String?, outputStream: OutputStream) {

        val filePath = pathManager.assertPathIsInsideFilesDirectory(fileGuid)

        if (!areFilesSupported(filePath.fileName.toString())) {
            throw InternalServerException("Document types are not supported in sample app, anyway, it is still supported by GroupDocs.Viewer itself. Other probable reason of the error - documents types are different.") // TODO: Need another exception type
        }

        Viewer(filePath, LoadOptions().apply { password = filePassword }).use { viewer ->
            viewer.view(PdfViewOptions { outputStream })
        }
    }
}

interface PrintController {
    suspend fun print(fileGuid: String, filePassword: String?, outputStream: OutputStream)
}