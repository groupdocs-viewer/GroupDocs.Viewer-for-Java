package com.groupdocs.ui

import com.groupdocs.ui.config.ApplicationConfig
import com.groupdocs.ui.di.ModulesInjection
import com.groupdocs.ui.model.ErrorResponse
import com.groupdocs.ui.modules.config.configModule
import com.groupdocs.ui.modules.description.descriptionModule
import com.groupdocs.ui.modules.download.downloadModule
import com.groupdocs.ui.modules.home.homeModule
import com.groupdocs.ui.modules.print.printModule
import com.groupdocs.ui.modules.rotate.rotateModule
import com.groupdocs.ui.modules.tree.treeModule
import com.groupdocs.viewer.License
import com.typesafe.config.ConfigFactory
import io.github.config4k.extract
import io.javalin.Javalin
import io.javalin.http.staticfiles.Location
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.context.startKoin
import org.koin.core.logger.PrintLogger
import org.koin.dsl.module
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.BufferedInputStream
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

val logger: Logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)

@ExperimentalSerializationApi
fun main(args: Array<String>) {
    val parsedConfig = ConfigFactory.parseResources("application.conf").resolve()
    val appConfig = parsedConfig.extract<ApplicationConfig>("application")

    setGroupdocsLicense(appConfig.licensePathOrDefault)

    startKoin {
        logger(PrintLogger())
        modules(module {
            single { appConfig }
        })
        modules(ModulesInjection.controllerBeans)
        modules(ModulesInjection.usecaseBeans)
        modules(ModulesInjection.managerBeans)
    }

    val app = Javalin.create { config ->
        config.enableDevLogging()
        config.addStaticFiles {
            it.directory = "/static"
            it.hostedPath = "/static"
            it.location = Location.CLASSPATH
        }
    }.start(appConfig.server.host, appConfig.server.port)

    app.apply {
        get("/") { it.redirect("/viewer") }

        homeModule()
        configModule()
        descriptionModule()
        printModule()
        downloadModule()
        rotateModule()
        treeModule()
    }
    app.exception(Exception::class.java) { e, ctx ->
        e.printStackTrace()
        ctx.json(
            ErrorResponse(
                message = if (e.message?.equals("File's types are different or are not supported") == true) {
                    "Document types are not supported in sample app, anyway, it is still supported by GroupDocs.Viewer itself. Other probable reason of the error - documents types are different."

                } else {
                    e.message ?: "Internal server error"
                }
            )
        ).status(500)
    }
}

fun setGroupdocsLicense(licensePath: String) {
    try {
        logger.debug("Setting Groupdocs license...")

        val licenseExtension = Defaults.DEFAULT_LICENSE_EXTENSION
        val license = License()
        if (licensePath.startsWith("http://") || licensePath.startsWith("https://")) {
            val url = URL(licensePath)
            BufferedInputStream(url.openStream()).use { inputStream -> license.setLicense(inputStream) }
        } else {
            val path = Paths.get(licensePath)
            if (Files.exists(path)) {
                if (Files.isRegularFile(path)) {
                    license.setLicense(licensePath)
                } else {
                    Files.list(path).use { pathStream ->
                        val first =
                            pathStream.filter { path ->
                                path.endsWith(licenseExtension)
                            }.findFirst()
                        first.ifPresent { licensePath: Path? ->
                            license.setLicense(licensePath)
                        }
                    }
                }
            }
        }
    } catch (e: Exception) {
        logger.warn("Can not verify Viewer license!", e)
    }
}
