package com.groupdocs.ui.viewer.micronaut.modules.home

import com.groupdocs.ui.viewer.micronaut.config.ApplicationConfig
import com.groupdocs.ui.viewer.micronaut.util.setGroupdocsLicense
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.views.View
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.net.URI

@Singleton
@Controller("/")
class HomeController(
    @Inject private val appConfig: ApplicationConfig
) {
    private var isLicenseSet: Boolean = false

    @Get("/")
    fun home(): HttpResponse<String> {
        return HttpResponse.redirect(URI("/viewer"))
    }

    @View("viewer")
    @Get("/viewer")
    fun viewer() {
        if (!isLicenseSet) {
            val licensePath = appConfig.licensePathOrDefault
            setGroupdocsLicense(licensePath)
            isLicenseSet = true
        }
    }
}