package com.groupdocs.ui.viewer.javalin.di

import com.groupdocs.ui.viewer.javalin.cache.FilesCache
import com.groupdocs.ui.viewer.javalin.cache.MemoryFilesCacheImpl
import com.groupdocs.ui.viewer.javalin.manager.PathManager
import com.groupdocs.ui.viewer.javalin.manager.PathManagerImpl
import com.groupdocs.ui.viewer.javalin.modules.config.ConfigController
import com.groupdocs.ui.viewer.javalin.modules.config.ConfigControllerImpl
import com.groupdocs.ui.viewer.javalin.modules.description.DescriptionController
import com.groupdocs.ui.viewer.javalin.modules.description.DescriptionControllerImpl
import com.groupdocs.ui.viewer.javalin.modules.download.DownloadController
import com.groupdocs.ui.viewer.javalin.modules.download.DownloadControllerImpl
import com.groupdocs.ui.viewer.javalin.modules.print.PrintController
import com.groupdocs.ui.viewer.javalin.modules.print.PrintControllerImpl
import com.groupdocs.ui.viewer.javalin.modules.rotate.RotateController
import com.groupdocs.ui.viewer.javalin.modules.rotate.RotateControllerImpl
import com.groupdocs.ui.viewer.javalin.modules.tree.TreeController
import com.groupdocs.ui.viewer.javalin.modules.tree.TreeControllerImpl
import com.groupdocs.ui.viewer.javalin.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.viewer.javalin.usecase.GetLocalFilesUseCase
import com.groupdocs.ui.viewer.javalin.usecase.RetrieveLocalFilePagesDataUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object ModulesInjection {
    val controllerBeans = module {
        singleOf(::ConfigControllerImpl) { bind<ConfigController>() }
        singleOf(::TreeControllerImpl) { bind<TreeController>() }
        singleOf(::DescriptionControllerImpl) { bind<DescriptionController>() }
        singleOf(::PrintControllerImpl) { bind<PrintController>() }
        singleOf(::DownloadControllerImpl) { bind<DownloadController>() }
        singleOf(::RotateControllerImpl) { bind<RotateController>() }
    }
    val usecaseBeans = module {
        singleOf(::GetLocalFilesUseCase)
        singleOf(::RetrieveLocalFilePagesDataUseCase)
        singleOf(::AreFilesSupportedUseCase)
    }
    val managerBeans = module {
        singleOf(::PathManagerImpl) { bind<PathManager>() }
        singleOf(::MemoryFilesCacheImpl) { bind<FilesCache>() }
    }
}