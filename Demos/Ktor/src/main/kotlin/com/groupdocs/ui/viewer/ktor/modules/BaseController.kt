package com.groupdocs.ui.viewer.ktor.modules

import com.groupdocs.ui.viewer.ktor.config.ViewerConfig
import org.koin.java.KoinJavaComponent.inject

open class BaseController {

    protected val appConfig by inject<ViewerConfig>(ViewerConfig::class.java)
}