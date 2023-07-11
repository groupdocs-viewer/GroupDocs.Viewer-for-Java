package com.groupdocs.ui.common

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

class SettingsException(message: String) : RuntimeException(message)

class Settings private constructor(val path: Path) {
    private val properties: Properties = Properties()

    init {
        BufferedInputStream(FileInputStream(path.toFile())).use {
            properties.load(it)
        }
    }

    var licensePath: String?
        get() = properties.getProperty("licensePath")?.ifBlank { null }
        set(value) {
            properties.setProperty("licensePath", if (value.isNullOrBlank()) "" else value)
        }

    var maxWidth: Int
        get() =
            properties.getProperty("maxWidth", "400").toIntOrNull() ?: 400
        set(value) {
            properties.setProperty("maxWidth", value.toString())
        }

    var isRenderComments: Boolean
        get() =
            properties.getProperty("isRenderComments", "false") == "true"
        set(value) {
            properties.setProperty("isRenderComments", value.toString())
        }


    fun save() {
        BufferedOutputStream(FileOutputStream(path.toFile())).use {
            properties.store(it, "Application settings")
        }
    }

    companion object {

        private val settingsPath: Path =
            Paths.get(System.getProperty("user.home")).resolve("groupdocs-viewer-compose.properties")
        private var _instance: Settings? = null

        val instance: Settings
            get() {
                if (_instance == null) {
                    println("Settings path: $settingsPath")
                    if (Files.notExists(settingsPath)) {
                        try {
                            Files.createFile(settingsPath)
                        } catch (e: Exception) {
                            throw SettingsException("Error: can't create file '${e.message}'")
                        }
                    }
                    if (Files.exists(settingsPath)) {
                        _instance = Settings(settingsPath)
                    }
                }
                return _instance!!
            }
    }
}