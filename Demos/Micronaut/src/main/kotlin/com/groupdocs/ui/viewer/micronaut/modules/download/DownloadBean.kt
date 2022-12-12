package com.groupdocs.ui.viewer.micronaut.modules.download

import com.groupdocs.ui.viewer.micronaut.manager.PathManager
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.io.InputStream

interface DownloadBean {
    suspend fun download(fileName: String): InputStream
}

@Bean(typed = [DownloadBean::class])
@Singleton
class DownloadBeanImpl(
    @Inject private val pathManager: PathManager
) : DownloadBean {
    override suspend fun download(fileName: String): InputStream {
        val resultPath = pathManager.filesDirectory.resolve(fileName).toAbsolutePath().normalize().toString()
        val resultDocumentPath = pathManager.assertPathIsInsideFilesDirectory(resultPath)

        return BufferedInputStream(FileInputStream(resultDocumentPath.toFile()))
    }
}