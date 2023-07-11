package com.groupdocs.ui.viewer.javalin.modules.print

import com.groupdocs.ui.viewer.javalin.model.PrintRequest
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject
import java.nio.file.Paths
import kotlin.io.path.nameWithoutExtension

fun Javalin.printModule() {
    val controller: PrintController by inject(PrintController::class.java)

    post("/viewer/printPdf") { ctx ->
        val request = ctx.bodyAsClass(PrintRequest::class.java)
        val decodedGuid = java.net.URLDecoder.decode(request.guid, "UTF-8")
        val guidAsPath = Paths.get(decodedGuid)

        ctx.header("Content-Type", "application/pdf")
        ctx.header("Content-disposition", "attachment; filename=${guidAsPath.nameWithoutExtension}.pdf")
        ctx.header("Content-Description", "File Transfer")
        ctx.header("Content-Transfer-Encoding", "binary")
        ctx.header("Cache-Control", "must-revalidate")
        ctx.header("Pragma", "public")
        runBlocking {
            val inputStream = controller.print(request)
            ctx.header("Content-Length", inputStream.available().toString())
            ctx.result(inputStream)
        }
    }
}