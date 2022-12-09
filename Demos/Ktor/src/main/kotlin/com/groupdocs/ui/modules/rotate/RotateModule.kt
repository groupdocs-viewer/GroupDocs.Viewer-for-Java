package com.groupdocs.ui.modules.rotate

import com.groupdocs.ui.model.RotateRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.rotateModule() {
    val rotateController by inject<RotateController>()

    post("/rotateDocumentPages") {
        val request = call.receive<RotateRequest>()
        val response = rotateController.rotate(request)
        call.respond(HttpStatusCode.OK, response)
    }
}