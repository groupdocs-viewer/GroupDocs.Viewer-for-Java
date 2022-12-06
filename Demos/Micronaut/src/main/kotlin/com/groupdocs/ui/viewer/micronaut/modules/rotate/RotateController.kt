package com.groupdocs.ui.viewer.micronaut.modules.rotate

import com.groupdocs.ui.viewer.micronaut.model.RotateRequest
import com.groupdocs.ui.viewer.micronaut.model.RotateResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking

@Singleton
@Controller("/viewer")
class RotateController(
    @Inject private val rotateBean: RotateBean
) {
    @Post("/rotateDocumentPages")
    @Produces(MediaType.APPLICATION_JSON)
    fun rotate(request: RotateRequest): HttpResponse<RotateResponse> {
        val response = runBlocking { rotateBean.rotate(request) }

        return HttpResponse.ok<RotateResponse>().body(response)
    }
}