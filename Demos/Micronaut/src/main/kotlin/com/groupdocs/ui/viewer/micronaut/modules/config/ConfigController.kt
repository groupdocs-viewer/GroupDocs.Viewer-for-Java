package com.groupdocs.ui.viewer.micronaut.modules.config

import com.groupdocs.ui.viewer.micronaut.model.ConfigResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking

@Singleton
@Controller("/viewer")
class ConfigController(
    @Inject val configBean: ConfigBean
) {
    @Get("/loadConfig")
    @Produces(MediaType.APPLICATION_JSON)
    fun config(): HttpResponse<*> {
        val response = runBlocking { configBean.config() }

        return HttpResponse.ok<ConfigResponse>().body(response)
    }
}