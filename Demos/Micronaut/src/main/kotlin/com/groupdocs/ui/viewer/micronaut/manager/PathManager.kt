package com.groupdocs.ui.viewer.micronaut.manager

import com.groupdocs.ui.viewer.micronaut.Defaults
import com.groupdocs.ui.viewer.micronaut.config.ApplicationConfig
import com.groupdocs.ui.viewer.micronaut.util.InternalServerException
import io.micronaut.context.annotation.Bean
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import java.util.regex.Pattern
import kotlin.math.min

/**
 * Manages path to temp, cache, files or result directory according to config
 * Does not create or check is any directory exist
 */
@Bean
class PathManagerImpl(
    private val appConfig: ApplicationConfig
) : PathManager {
    private val isLocalProvider: Boolean by lazy {
        appConfig.viewer.filesProviderTypeOrDefault == Defaults.Comparison.FilesProviderType.LOCAL
    }

    override val tempDirectory: Path by lazy {
        val absoluteOrRelativeTempDirectory = Paths.get(appConfig.viewer.tempDirectoryOrDefault)
        if (absoluteOrRelativeTempDirectory.isAbsolute) {
            absoluteOrRelativeTempDirectory
        } else if (isLocalProvider) {
            filesDirectory.resolve(absoluteOrRelativeTempDirectory)
        } else {
            absoluteOrRelativeTempDirectory.toAbsolutePath()
        }.normalize()
    }

    override val resultDirectory: Path by lazy {
        if (!isLocalProvider) {
            throw InternalServerException("Access to result directory is impossible, because local provider is not enabled")
        }
        val absoluteOrRelativeResultDirectory = appConfig.local.resultDirectoryOrDefault
        if (absoluteOrRelativeResultDirectory.isAbsolute) {
            absoluteOrRelativeResultDirectory
        } else {
            filesDirectory.resolve(absoluteOrRelativeResultDirectory).toAbsolutePath()
        }.normalize()
    }

    override val filesDirectory: Path by lazy {
        if (!isLocalProvider) {
            throw InternalServerException("Access to files directory is impossible, because local provider is not enabled")
        }
        val absoluteOrRelativeFilesDirectory = appConfig.local.filesDirectoryOrDefault
        absoluteOrRelativeFilesDirectory.toAbsolutePath().normalize()
    }

    override fun createPathForTempFile(): Path = tempDirectory.resolve("gd_${UUID.randomUUID()}.tmp")

    override fun createPathForResultFile(sourceName: String, targetName: String, extension: String): Path {
        sourceName.matches(FILENAME_PATTERN) || throw InternalServerException("Source file name contains forbidden characters")
        targetName.matches(FILENAME_PATTERN) || throw InternalServerException("Target file name contains forbidden characters")

        val sourceNameWithoutExtension = File(sourceName).nameWithoutExtension
        val targetNameWithoutExtension = File(targetName).nameWithoutExtension

        val resultFileName =
            if (sourceNameWithoutExtension.length + targetNameWithoutExtension.length > MAX_FILENAME_LENGTH) {
                val halfOfFileNameLength = MAX_FILENAME_LENGTH / 2
                val trimmedSourceFileName = sourceNameWithoutExtension
                    .substring(min(halfOfFileNameLength, sourceNameWithoutExtension.length))
                val trimmedTargetFileName = targetNameWithoutExtension
                    .substring(min(halfOfFileNameLength, targetNameWithoutExtension.length))
                "result-${trimmedSourceFileName}-${trimmedTargetFileName}_${System.currentTimeMillis()}.$extension"
            } else "result-${sourceNameWithoutExtension}-${targetNameWithoutExtension}.$extension"

        return resultDirectory.resolve(resultFileName)
    }

    override fun assertPathIsInsideFilesDirectory(pathToCheck: String): Path {
        val checkPath = Paths.get(pathToCheck)
        val path = if (!checkPath.isAbsolute) {
            filesDirectory.resolve(pathToCheck).toAbsolutePath().normalize()
        } else checkPath.normalize()

        if (!path.startsWith(filesDirectory)) {
            // Avoid accessing to any directory outside filesDirectory
            throw AccessDeniedException()
        }
        return path
    }

    private companion object {
        val FILENAME_PATTERN = Pattern.compile("^[^</*?\"\\\\>:|]+\$").toRegex()
        const val MAX_FILENAME_LENGTH = 255 - 55 // 55 for extension, prefix and so on
    }
}

interface PathManager {
    val tempDirectory: Path
    val resultDirectory: Path
    val filesDirectory: Path
    fun createPathForTempFile(): Path
    fun assertPathIsInsideFilesDirectory(pathToCheck: String): Path
    fun createPathForResultFile(sourceName: String, targetName: String, extension: String): Path
}

class AccessDeniedException(message: String = "Access denied!") : InternalServerException(message)