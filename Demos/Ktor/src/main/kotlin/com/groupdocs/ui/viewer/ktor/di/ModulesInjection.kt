package com.groupdocs.ui.viewer.ktor.di

import com.groupdocs.ui.viewer.ktor.cache.FilesCache
import com.groupdocs.ui.viewer.ktor.cache.MemoryFilesCacheImpl
import com.groupdocs.ui.viewer.ktor.manager.PathManager
import com.groupdocs.ui.viewer.ktor.manager.PathManagerImpl
import com.groupdocs.ui.viewer.ktor.modules.config.ConfigController
import com.groupdocs.ui.viewer.ktor.modules.config.ConfigControllerImpl
import com.groupdocs.ui.viewer.ktor.modules.description.DescriptionController
import com.groupdocs.ui.viewer.ktor.modules.description.DescriptionControllerImpl
import com.groupdocs.ui.viewer.ktor.modules.download.DownloadController
import com.groupdocs.ui.viewer.ktor.modules.download.DownloadControllerImpl
import com.groupdocs.ui.viewer.ktor.modules.print.PrintController
import com.groupdocs.ui.viewer.ktor.modules.print.PrintControllerImpl
import com.groupdocs.ui.viewer.ktor.modules.rotate.RotateController
import com.groupdocs.ui.viewer.ktor.modules.rotate.RotateControllerImpl
import com.groupdocs.ui.viewer.ktor.modules.tree.TreeController
import com.groupdocs.ui.viewer.ktor.modules.tree.TreeControllerImpl
import com.groupdocs.ui.viewer.ktor.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.viewer.ktor.usecase.GetLocalFilesUseCase
import com.groupdocs.ui.viewer.ktor.usecase.RetrieveLocalFilePagesStreamUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object ModulesInjection {
    val controllerBeans = module {
        singleOf(::ConfigControllerImpl) { bind<ConfigController>() }
        singleOf(::TreeControllerImpl) { bind<TreeController>() }
        singleOf(::DownloadControllerImpl) { bind<DownloadController>() }
        singleOf(::DescriptionControllerImpl) { bind<DescriptionController>() }
        singleOf(::PrintControllerImpl) { bind<PrintController>() }
        singleOf(::RotateControllerImpl) { bind<RotateController>() }

    }
    val usecaseBeans = module {
        singleOf(::GetLocalFilesUseCase)
        singleOf(::RetrieveLocalFilePagesStreamUseCase)
        singleOf(::AreFilesSupportedUseCase)
    }
    val managerBeans = module {
        singleOf(::PathManagerImpl) { bind<PathManager>() }
        singleOf(::MemoryFilesCacheImpl) { bind<FilesCache>() }
    }
}