package com.groupdocs.ui.viewer.javalin.modules.print

import com.groupdocs.ui.viewer.javalin.manager.PathManager
import com.groupdocs.ui.viewer.javalin.model.PrintRequest
import com.groupdocs.ui.viewer.javalin.modules.BaseController
import com.groupdocs.ui.viewer.javalin.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.viewer.javalin.util.InternalServerException
import com.groupdocs.viewer.Viewer
import com.groupdocs.viewer.options.LoadOptions
import com.groupdocs.viewer.options.PdfViewOptions
import org.koin.core.component.KoinComponent
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.URLDecoder

interface PrintController {
    suspend fun print(request: PrintRequest): InputStream
}

class PrintControllerImpl(
    private val areFilesSupported: AreFilesSupportedUseCase,
    private val pathManager: PathManager
) : BaseController(), PrintController, KoinComponent {

    override suspend fun print(request: PrintRequest): InputStream {
        val guid = request.guid
        val fileGuid = URLDecoder.decode(guid, "UTF-8")

        val filePath = pathManager.assertPathIsInsideFilesDirectory(fileGuid)

        if (!areFilesSupported(filePath.fileName.toString())) {
            throw InternalServerException("Document types are not supported in sample app, anyway, it is still supported by GroupDocs.Viewer itself. Other probable reason of the error - documents types are different.") // TODO: Need another exception type
        }

        val filePassword = request.password

        ByteArrayOutputStream().use { byteOutputStream ->
            Viewer(filePath, LoadOptions().apply { password = filePassword }).use { viewer ->
                viewer.view(PdfViewOptions { byteOutputStream })
            }
            return ByteArrayInputStream(byteOutputStream.toByteArray())
        }
    }

}