package com.groupdocs.ui.modules.description

import com.groupdocs.ui.model.DescriptionRequest
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject

fun Javalin.descriptionModule() {
    val controller: DescriptionController by inject(DescriptionController::class.java)

    post("/viewer/loadDocumentDescription") { ctx ->
        val request = ctx.bodyAsClass(DescriptionRequest::class.java)
        runBlocking {
            val response = controller.description(request)
            ctx.json(response)
        }
    }
}