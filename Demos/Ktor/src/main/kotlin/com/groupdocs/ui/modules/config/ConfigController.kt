package com.groupdocs.ui.modules.config

import com.groupdocs.ui.model.ConfigResponse
import com.groupdocs.ui.modules.BaseController
import org.koin.core.component.KoinComponent

class ConfigControllerImpl : BaseController(), ConfigController, KoinComponent {

    override suspend fun config(): ConfigResponse {
        return ConfigResponse(
            pageSelector = appConfig.common.pageSelector,
            download = appConfig.common.download,
            upload = appConfig.common.upload,
            print = appConfig.common.print,
            browse = appConfig.common.browse,
            rewrite = appConfig.common.rewrite,
            enableRightClick = appConfig.common.enableRightClick,
//            filesDirectory = appConfig.common.filesDirectory,
//            fontsDirectory = appConfig.common.fontsDirectory,
//            preloadPageCount = appConfig.common.preloadPageCount,
//            zoom = appConfig.common.zoom,
//            search = appConfig.common.search,
//            thumbnails = appConfig.common.thumbnails,
//            rotate = appConfig.common.rotate,
//            defaultDocument = appConfig.common.defaultDocument,
//            htmlMode = appConfig.common.htmlMode,
//            cache = appConfig.common.cache,
//            saveRotateState = appConfig.common.saveRotateState,
//            watermarkText = appConfig.common.watermarkText,
//            printAllowed = appConfig.common.printAllowed,
//            showGridLines = appConfig.common.showGridLines,
//            cacheFolderName = appConfig.common.cacheFolderName,
        )
    }
}

interface ConfigController {
    suspend fun config(): ConfigResponse
}