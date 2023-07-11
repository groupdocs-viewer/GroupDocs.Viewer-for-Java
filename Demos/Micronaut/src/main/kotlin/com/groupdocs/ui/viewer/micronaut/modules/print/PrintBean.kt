package com.groupdocs.ui.viewer.micronaut.modules.print

import com.groupdocs.ui.viewer.micronaut.manager.PathManager
import com.groupdocs.ui.viewer.micronaut.model.PrintRequest
import com.groupdocs.ui.viewer.micronaut.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.viewer.micronaut.util.InternalServerException
import com.groupdocs.viewer.Viewer
import com.groupdocs.viewer.options.LoadOptions
import com.groupdocs.viewer.options.PdfViewOptions
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.URLDecoder

interface PrintBean {
    suspend fun print(request: PrintRequest): InputStream
}

@Bean(typed = [PrintBean::class])
@Singleton
class PrintBeanImpl(
    @Inject private val checkAreFilesSupported: AreFilesSupportedUseCase,
    @Inject private val pathManager: PathManager,
) : PrintBean {
    override suspend fun print(request: PrintRequest): InputStream {
        val guid = request.guid
        val fileGuid = URLDecoder.decode(guid, "UTF-8")

        val filePath = pathManager.assertPathIsInsideFilesDirectory(fileGuid)

        if (!checkAreFilesSupported(filePath.fileName.toString())) {
            throw InternalServerException("Document types are not supported in sample app, anyway, it is still supported by GroupDocs.Comparison itself. Other probable reason of the error - documents types are different.") // TODO: Need another exception type
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