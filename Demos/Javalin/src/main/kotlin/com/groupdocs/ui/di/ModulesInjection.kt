package com.groupdocs.ui.di

import com.groupdocs.ui.cache.FilesCache
import com.groupdocs.ui.cache.MemoryFilesCacheImpl
import com.groupdocs.ui.manager.PathManager
import com.groupdocs.ui.manager.PathManagerImpl
import com.groupdocs.ui.modules.config.ConfigController
import com.groupdocs.ui.modules.config.ConfigControllerImpl
import com.groupdocs.ui.modules.description.DescriptionController
import com.groupdocs.ui.modules.description.DescriptionControllerImpl
import com.groupdocs.ui.modules.download.DownloadController
import com.groupdocs.ui.modules.download.DownloadControllerImpl
import com.groupdocs.ui.modules.print.PrintController
import com.groupdocs.ui.modules.print.PrintControllerImpl
import com.groupdocs.ui.modules.rotate.RotateController
import com.groupdocs.ui.modules.rotate.RotateControllerImpl
import com.groupdocs.ui.modules.tree.TreeController
import com.groupdocs.ui.modules.tree.TreeControllerImpl
import com.groupdocs.ui.usecase.AreFilesSupportedUseCase
import com.groupdocs.ui.usecase.GetLocalFilesUseCase
import com.groupdocs.ui.usecase.RetrieveLocalFilePagesDataUseCase
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