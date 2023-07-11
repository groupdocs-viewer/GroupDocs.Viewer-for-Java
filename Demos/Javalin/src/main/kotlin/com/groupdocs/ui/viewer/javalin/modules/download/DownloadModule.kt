package com.groupdocs.ui.viewer.javalin.modules.download

import com.groupdocs.ui.viewer.javalin.util.InternalServerException
import io.javalin.Javalin
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject
import java.nio.file.Paths

fun Javalin.downloadModule() {
    val controller: DownloadController by inject(DownloadController::class.java)

    get("/viewer/downloadDocument") { ctx ->
        val guid = ctx.queryParam("path") ?: throw InternalServerException("Document guid is not provided!")
        val decodedGuid = java.net.URLDecoder.decode(guid, "UTF-8")
        val guidAsPath = Paths.get(decodedGuid)
        ctx.header("Content-disposition", "attachment; filename=${guidAsPath.fileName}")
        ctx.header("Content-Description", "File Transfer")
        ctx.header("Content-Transfer-Encoding", "binary")
        ctx.header("Cache-Control", "must-revalidate")
        ctx.header("Pragma", "public")
        runBlocking {
            val inputStream = controller.download(filePath = decodedGuid)
            ctx.result(inputStream)
        }
    }
}