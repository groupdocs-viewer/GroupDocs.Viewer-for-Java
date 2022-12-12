package com.groupdocs.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.groupdocs.ui.common.Screen
import com.groupdocs.ui.openInBrowser
import java.net.URI
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter


class HomeViewModel(private val screen: MutableState<Screen>) {
    private val _state: MutableState<HomeState> = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    fun runConverting() {
        if (!_state.value.isSourcePresent) {
            _state.value = _state.value.copy(
                sourceError = "Select source file"
            )
            return
        }
        screen.value = Screen.Result(
            source = state.value.sourcePath!!
        )
    }

    fun onAddSource() {
        chooseFile(
            filePath = {
                _state.value = _state.value.copy(
                    sourcePath = it,
                    sourceError = null
                )
            })
    }

    private fun chooseFile(extensions: (Pair<String, List<String>>)? = null, filePath: (String) -> Unit) {
        JFileChooser().apply {
            if (extensions != null) {
                fileFilter = FileNameExtensionFilter(extensions.first, *extensions.second.toTypedArray())
            }
            if (showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                filePath(selectedFile.path)
            }
        }
    }

    fun openGroupDocsSite() {
        try {
            openInBrowser(URI("http://groupdocs.com"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openTermsPage() {
        try {
            openInBrowser(URI("https://about.groupdocs.app/legal/tos"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openPolicy() {
        try {
            openInBrowser(URI("https://about.groupdocs.app/legal/privacy-policy"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    // Drag and drop
    // https://twitter.com/tkuenneth/status/1331993022955917312?s=20
    // https://dev.to/tkuenneth/from-swing-to-jetpack-compose-desktop-2-4a4h
    // https://github.com/JetBrains/compose-jb/issues/222
}