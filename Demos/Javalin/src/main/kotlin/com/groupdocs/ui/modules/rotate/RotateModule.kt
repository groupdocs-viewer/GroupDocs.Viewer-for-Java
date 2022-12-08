package com.groupdocs.ui.modules.rotate

import com.groupdocs.ui.model.RotateRequest
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject

fun Javalin.rotateModule() {
    val controller: RotateController by inject(RotateController::class.java)

    post("/viewer/loadDocumentRotate") { ctx ->
        val request = ctx.bodyAsClass(RotateRequest::class.java)
        runBlocking {
            val response = controller.rotate(request)
            ctx.json(response)
        }
    }
}