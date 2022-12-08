package com.groupdocs.ui.viewer.javalin.modules

import com.groupdocs.ui.viewer.javalin.config.ApplicationConfig
import org.koin.java.KoinJavaComponent

open class BaseController {
    protected val appConfig by KoinJavaComponent.inject<ApplicationConfig>(ApplicationConfig::class.java)
}
