package com.groupdocs.ui.modules

import com.groupdocs.ui.config.ViewerConfig
import org.koin.java.KoinJavaComponent.inject

open class BaseController {

    protected val appConfig by inject<ViewerConfig>(ViewerConfig::class.java)
}