package com.groupdocs.ui.viewer.javalin.modules.home

import io.javalin.Javalin

fun Javalin.homeModule() {
    get("/viewer") { ctx ->
        ClassLoader.getSystemResourceAsStream("view/index.html")?.let {
            ctx.contentType("text/html")
            ctx.result(it)
        }
    }
}