package com.groupdocs.ui.modules

import com.groupdocs.ui.config.ApplicationConfig
import org.koin.java.KoinJavaComponent

open class BaseController {
    protected val appConfig by KoinJavaComponent.inject<ApplicationConfig>(ApplicationConfig::class.java)
}
