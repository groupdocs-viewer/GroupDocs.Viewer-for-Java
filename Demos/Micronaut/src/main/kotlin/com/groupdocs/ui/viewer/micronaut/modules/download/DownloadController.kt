package com.groupdocs.ui.viewer.micronaut.modules.download

import com.groupdocs.ui.viewer.micronaut.model.ConfigResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking
import java.io.BufferedInputStream
import java.nio.file.Paths

@Singleton
@Controller("/viewer")
class DownloadController(
    @Inject private val downloadBean: DownloadBean
) {
    @Get("/downloadDocument")
    @Produces(MediaType.APPLICATION_JSON)
    fun download(@QueryValue path: String): HttpResponse<*> {
        val decodedGuid = java.net.URLDecoder.decode(path, "UTF-8")
        val guidAsPath = Paths.get(decodedGuid)

        val inputStream = runBlocking { downloadBean.download(fileName = decodedGuid) }

        return HttpResponse.ok<ConfigResponse>()
            .header("Content-disposition", "attachment; filename=${guidAsPath.fileName}")
            .header("Content-Description", "File Transfer")
            .header("Content-Transfer-Encoding", "binary")
            .header("Cache-Control", "must-revalidate")
            .header("Pragma", "public")
            .body(BufferedInputStream(inputStream))
    }
}