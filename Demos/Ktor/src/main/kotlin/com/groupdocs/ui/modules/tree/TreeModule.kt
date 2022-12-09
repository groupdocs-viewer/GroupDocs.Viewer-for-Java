package com.groupdocs.ui.modules.tree

import com.groupdocs.ui.model.TreeRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.treeModule() {
    val treeController by inject<TreeController>()

    post("/loadFileTree") {
        val request = call.receive<TreeRequest>()
        val response = treeController.tree(request)
        call.respond(HttpStatusCode.OK, response)
    }
}