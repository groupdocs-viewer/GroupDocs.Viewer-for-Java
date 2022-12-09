package com.groupdocs.ui.viewer.ktor.modules.description

import com.groupdocs.ui.viewer.ktor.model.DescriptionRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.descriptionModule() {
    val descriptionController by inject<DescriptionController>()

    post("/loadDocumentDescription") {
        val request = call.receive<DescriptionRequest>()
        val response = descriptionController.description(request)
        call.respond(HttpStatusCode.OK, response)
    }
}