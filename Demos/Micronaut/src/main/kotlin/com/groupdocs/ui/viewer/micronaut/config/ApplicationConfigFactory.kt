package com.groupdocs.ui.viewer.micronaut.config

import com.typesafe.config.ConfigFactory
import io.github.config4k.extract
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class ApplicationConfigFactory {
    @Singleton
    fun config(): ApplicationConfig {

        val parsedConfig = ConfigFactory.parseResources("application.conf").resolve()
        return parsedConfig.extract("application")
    }
}