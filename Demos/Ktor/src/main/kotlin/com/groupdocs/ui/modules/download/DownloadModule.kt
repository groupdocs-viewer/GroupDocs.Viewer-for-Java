package com.groupdocs.ui.modules.download

import com.groupdocs.ui.status.InternalServerException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*
import org.koin.ktor.ext.inject
import java.nio.charset.StandardCharsets
import java.nio.file.Paths

fun Route.downloadModule() {
    val downloadController by inject<DownloadController>()

    get("/downloadDocument/") {
        call.parameters["path"]?.let { guid ->
            val decodedGuid = java.net.URLDecoder.decode(guid, StandardCharsets.UTF_8.name())
            val guidAsPath = Paths.get(decodedGuid)
            call.response.headers.apply {
                append("Content-disposition", "attachment; filename=${guidAsPath.fileName}")
                append("Content-Description", "File Transfer")
                append("Content-Transfer-Encoding", "binary")
                append("Cache-Control", "must-revalidate")
                append("Pragma", "public")
            }

            call.respondOutputStream(
                status = HttpStatusCode.OK,
                contentType = ContentType.Application.OctetStream,
                producer = {
                    downloadController.download(
                        fileName = decodedGuid,
                        outputStream = this
                    )
                }
            )
        } ?: throw InternalServerException("Document guid is not provided!")
    }
}