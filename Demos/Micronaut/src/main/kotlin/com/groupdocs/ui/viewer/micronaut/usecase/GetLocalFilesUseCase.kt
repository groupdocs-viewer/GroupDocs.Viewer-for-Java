package com.groupdocs.ui.viewer.micronaut.usecase

import com.groupdocs.ui.viewer.micronaut.util.InternalServerException
import io.micronaut.context.annotation.Bean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.nio.file.Files
import java.nio.file.Path

@Bean
class GetLocalFilesUseCase {
    suspend operator fun invoke(directory: Path): List<LocalStorageEntry> = withContext(Dispatchers.IO) {
        if (Files.notExists(directory)) {
            throw GetLocalFilesException("Directory does not exist: ${directory.fileName}")
        }
        try {
            val entries = mutableListOf<LocalStorageEntry>()
            Files.newDirectoryStream(directory).use { directoryStream ->
                directoryStream.forEach { path ->
                    val entry: LocalStorageEntry = when (Files.isDirectory(path)) {
                        true -> {
                            LocalStorageEntry.Directory(
                                name = path.fileName.toString(),
                                parentPath = directory
                            )
                        }

                        else -> {
                            LocalStorageEntry.File(
                                name = path.fileName.toString(),
                                parentPath = directory,
                                size = Files.size(path)
                            )
                        }
                    }
                    entries.add(entry)
                }
            }
            entries
        } catch (e: Exception) {
            throw GetLocalFilesException("can't get content of $directory", e)
        }
    }
}

sealed class LocalStorageEntry(val name: String, val parentPath: Path) {
    class File(name: String, val size: Long, parentPath: Path) : LocalStorageEntry(name, parentPath)
    class Directory(name: String, parentPath: Path) : LocalStorageEntry(name, parentPath)

    val fullPath get() = parentPath.resolve(name)
}

class GetLocalFilesException(message: String, e: Throwable? = null) : InternalServerException(message, e)