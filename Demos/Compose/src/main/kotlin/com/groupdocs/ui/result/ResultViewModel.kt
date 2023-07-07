package com.groupdocs.ui.result

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.groupdocs.ui.common.NavigationException
import com.groupdocs.ui.common.Screen
import com.groupdocs.ui.common.Settings
import com.groupdocs.viewer.License
import com.groupdocs.viewer.Viewer
import com.groupdocs.viewer.options.PngViewOptions
import kotlinx.coroutines.*
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter
import kotlin.io.path.forEachDirectoryEntry
import kotlin.io.path.nameWithoutExtension


class ResultViewModel(private val screen: MutableState<Screen>) {
    private val _state: MutableState<ResultState> = mutableStateOf(ResultState())
    val state: State<ResultState> = _state
    private val tempDir: Path

    init {
        val sourcePath: String
        val sourceName: String
        tempDir = Paths.get(System.getProperty("java.io.tmpdir"))
        if (screen.value is Screen.Result) {
            sourcePath = (screen.value as Screen.Result).source
            sourceName = Paths.get(sourcePath).fileName.nameWithoutExtension
        } else throw NavigationException()
        //
        val licensePath = Settings.instance.licensePath
        if (licensePath == null || Files.exists(Paths.get(licensePath))) {
            CoroutineScope(Dispatchers.IO).launch {
                licensePath?.let { License().setLicense(it) }
//                println("License is ${if (License.isValidLicense()) "valid" else "invalid"}")
                val resultDirectory = tempDir.resolve(UUID.randomUUID().toString())
                Files.createDirectories(resultDirectory)

                Viewer(sourcePath).use { viewer ->
                    try {
                        val options = PngViewOptions { pageNumber ->
                            return@PngViewOptions FileOutputStream(resultDirectory.resolve("${sourceName}_$pageNumber.png").toFile())
                        }
                        options.isRenderComments = Settings.instance.isRenderComments
                        options.maxWidth = Settings.instance.maxWidth
                        viewer.view(options)
                    } catch (e: Exception) {
                        _state.value = _state.value.copy(
                            errorMessage = "Viewing error: ${e.message}",
                            isInProgress = false
                        )
                        return@use
                    }
                }
                _state.value = _state.value.copy(
                    sourcePath = sourcePath,
                    resultPath = resultDirectory.toString()
                )
                displayResult(resultDirectory)
            }
        } else {
            _state.value = _state.value.copy(
                errorMessage = "License not found: '$licensePath'",
                isInProgress = false
            )
        }

    }

    private fun displayResult(resultDirectory: Path) {
        println("Viewer result pages are saved to ${state.value.resultPath}")
        val pageList = mutableListOf<String>()
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                resultDirectory.forEachDirectoryEntry("*.png") { path ->
                    pageList.add(path.toString())
                }
            }
            _state.value = _state.value.copy(
                isInProgress = false,
                pageList = pageList,
                pagesCount = pageList.size
            )
        }
    }

    fun onDownload(pageNumber: Int) {
        val resultName = state.value.sourceName
        val extension =
            if (resultName.contains('.'))
                resultName.substring(resultName.lastIndexOf('.') + 1)
            else null
        val sourceFileName = Paths.get(state.value.sourcePath).fileName.nameWithoutExtension
        JFileChooser().apply {
            extension?.let {
                fileFilter = FileNameExtensionFilter("Png file", extension)
            }
            selectedFile = File("${sourceFileName}_page$pageNumber.png")
            if (showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                val resultPath = Paths.get(state.value.resultPath).resolve("${sourceFileName}_$pageNumber.png")

                val downloadPath = selectedFile.path
                CoroutineScope(Dispatchers.IO).launch {
                    FileUtils.copyFile(resultPath.toFile(), File(downloadPath))
                    withContext(Dispatchers.Main) {
                        _state.value = _state.value.copy(
                            infoMessage = "File was saved!"
                        )
                        delay(2500L)
                        _state.value = _state.value.copy(
                            infoMessage = null
                        )
                    }
                }
            }
        }
    }

    fun onDispose() {
        print("Deleting temporary files...")
        CoroutineScope(Dispatchers.IO).launch {
            state.value.pageList.toMutableList().apply {
                add(state.value.resultPath)
                forEach { path ->
                    try {
                        FileUtils.delete(File(path))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        println("Finished")
    }
}