package com.groupdocs.ui.viewer.micronaut.modules.tree

import com.groupdocs.ui.viewer.micronaut.model.ConfigResponse
import com.groupdocs.ui.viewer.micronaut.model.FileDescriptionEntity
import com.groupdocs.ui.viewer.micronaut.model.TreeRequest
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
class TreeController(
    @Inject private val treeBean: TreeBean
) {
    @Post("/loadFileTree")
    @Produces(MediaType.APPLICATION_JSON)
    fun tree(request: TreeRequest): HttpResponse<List<FileDescriptionEntity>> {
        val response = runBlocking { treeBean.tree(request) }

        return HttpResponse.ok<ConfigResponse>().body(response)
    }
}