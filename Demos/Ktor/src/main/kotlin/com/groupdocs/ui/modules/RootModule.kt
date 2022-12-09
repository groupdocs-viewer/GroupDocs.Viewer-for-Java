package com.groupdocs.ui.modules

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Routing.rootModule() {

    get("/") {
        call.respondRedirect("/viewer")
    }
}