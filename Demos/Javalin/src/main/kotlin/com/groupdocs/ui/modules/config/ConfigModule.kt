package com.groupdocs.ui.modules.config

import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject

fun Javalin.configModule() {
    val controller: ConfigController by inject(ConfigController::class.java)

    get("/viewer/loadConfig") { ctx ->
        runBlocking {
            val response = controller.config()
            ctx.json(response)
        }
    }
}