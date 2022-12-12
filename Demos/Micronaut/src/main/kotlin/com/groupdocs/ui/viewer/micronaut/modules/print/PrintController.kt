package com.groupdocs.ui.viewer.micronaut.modules.print

import com.groupdocs.ui.viewer.micronaut.model.ConfigResponse
import com.groupdocs.ui.viewer.micronaut.model.PrintRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking
import java.io.BufferedInputStream
import java.nio.charset.StandardCharsets
import java.nio.file.Paths
import kotlin.io.path.nameWithoutExtension

@Singleton
@Controller("/viewer")
class PrintController(
    @Inject private val printBean: PrintBean
) {
    @Post("/printPdf")
    @Produces(MediaType.APPLICATION_JSON)
    fun print(request: PrintRequest): HttpResponse<*> {
        val inputStream = runBlocking { printBean.print(request = request) }
        val decodedGuid = java.net.URLDecoder.decode(request.guid, StandardCharsets.UTF_8.name())
        val guidAsPath = Paths.get(decodedGuid)

        return HttpResponse.ok<ConfigResponse>()
            .header("Content-Type", "application/pdf")
            .header("Content-Length", inputStream.available().toString())
            .header("Content-disposition", "attachment; filename=${guidAsPath.nameWithoutExtension}.pdf")
            .header("Content-Description", "File Transfer")
            .header("Content-Transfer-Encoding", "binary")
            .header("Cache-Control", "must-revalidate")
            .header("Pragma", "public")
            .body(BufferedInputStream(inputStream))
    }
}