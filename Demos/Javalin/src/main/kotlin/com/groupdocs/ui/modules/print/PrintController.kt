package com.groupdocs.ui.modules.print

import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.model.PrintRequest
import com.groupdocs.ui.modules.BaseController
import com.groupdocs.ui.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.util.InternalServerException
import com.groupdocs.viewer.Viewer
import com.groupdocs.viewer.options.LoadOptions
import com.groupdocs.viewer.options.PdfViewOptions
import org.koin.core.component.KoinComponent
import java.io.*
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import java.util.*

interface PrintController {
    suspend fun print(request: PrintRequest): InputStream
}

class PrintControllerImpl(
    private val areFilesSupported: AreFilesSupportedUseCase,
    private val pathManager: PathManager
) : BaseController(), PrintController, KoinComponent {

    override suspend fun print(request: PrintRequest): InputStream {
        val guid = request.guid
        val fileGuid = URLDecoder.decode(guid, StandardCharsets.UTF_8)

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