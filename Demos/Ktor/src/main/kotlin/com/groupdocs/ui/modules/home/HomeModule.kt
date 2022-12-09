package com.groupdocs.ui.modules.home

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*


fun Route.homeModule() {
    route("") {
        get {
            call.respondHtmlTemplate(HomeTemplate()) {
                pageTitle {
                    +"GroupDocs.Viewer for Java Ktor"
                }
            }
        }
    }
}