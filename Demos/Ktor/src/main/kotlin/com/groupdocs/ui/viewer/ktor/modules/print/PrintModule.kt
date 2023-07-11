package com.groupdocs.ui.viewer.ktor.modules.print

import com.groupdocs.ui.viewer.ktor.model.PrintRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.nio.file.Paths
import kotlin.io.path.nameWithoutExtension

fun Route.printModule() {
    val printController by inject<PrintController>()

    post("/printPdf") {
        val request = call.receive<PrintRequest>()
        val decodedGuid = java.net.URLDecoder.decode(request.guid, "UTF-8")
        val guidAsPath = Paths.get(decodedGuid)
        call.response.headers.apply {
            append("Content-disposition", "attachment; filename=${guidAsPath.nameWithoutExtension}")
            append("Content-Description", "File Transfer")
            append("Content-Transfer-Encoding", "binary")
            append("Cache-Control", "must-revalidate")
            append("Pragma", "public")
        }

        call.respondOutputStream(
            status = HttpStatusCode.OK,
            contentType = ContentType.Application.Pdf,
            producer = {
                printController.print(
                    fileGuid = decodedGuid,
                    filePassword = request.password,
                    outputStream = this
                )
            }
        )
    }
}