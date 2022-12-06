package com.groupdocs.ui.viewer.micronaut.modules.description

import com.groupdocs.ui.viewer.micronaut.model.DescriptionEntity
import com.groupdocs.ui.viewer.micronaut.model.DescriptionRequest
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
class DescriptionController(
    @Inject private val descriptionBean: DescriptionBean
) {
    @Post("/loadDocumentDescription")
    @Produces(MediaType.APPLICATION_JSON)
    fun description(request: DescriptionRequest): HttpResponse<*> {
        val response = runBlocking { descriptionBean.description(request) }

        return HttpResponse.ok<DescriptionEntity>().body(response)
    }
}