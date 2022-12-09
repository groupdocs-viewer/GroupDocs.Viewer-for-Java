package com.groupdocs.ui.viewer.ktor

import com.groupdocs.ui.viewer.ktor.modules.config.configModule
import com.groupdocs.ui.viewer.ktor.modules.description.descriptionModule
import com.groupdocs.ui.viewer.ktor.modules.download.downloadModule
import com.groupdocs.ui.viewer.ktor.modules.home.homeModule
import com.groupdocs.ui.viewer.ktor.modules.print.printModule
import com.groupdocs.ui.viewer.ktor.modules.rootModule
import com.groupdocs.ui.viewer.ktor.modules.rotate.rotateModule
import com.groupdocs.ui.viewer.ktor.modules.tree.treeModule
import com.groupdocs.ui.viewer.ktor.status.generalStatusPages
import com.groupdocs.ui.viewer.ktor.status.internalStatusPages
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import org.slf4j.event.Level

fun Application.module() {
    install(CallLogging) {
        level = Level.DEBUG
        filter { call -> call.request.path().startsWith("/viewer") }
    }
    install(ContentNegotiation) {
        gson {
            serializeNulls()
        }
    }
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }
    install(StatusPages) {
        generalStatusPages()
        internalStatusPages()
    }

    install(Routing) {
        static("/static") {
            resources("static")
        }
        rootModule()
        route("/viewer") {
            homeModule()
            configModule()
            treeModule()
            descriptionModule()
            rotateModule()
            downloadModule()
            printModule()
        }
    }
}