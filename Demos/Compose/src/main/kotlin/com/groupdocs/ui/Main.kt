// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.groupdocs.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.groupdocs.ui.common.Screen
import com.groupdocs.ui.home.HomeScreen
import com.groupdocs.ui.result.ResultScreen
import com.groupdocs.ui.settings.SettingsScreen
import com.groupdocs.ui.theme.GroupDocsTheme
import java.awt.Dimension

@ExperimentalComposeUiApi
@Composable
@Preview
fun App() {
    val screen = remember {
        mutableStateOf<Screen>(
            Screen.Home
        )
    }

    GroupDocsTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (screen.value) {
                is Screen.Home -> {
                    HomeScreen(screen)
                }
                is Screen.Result -> {
                    ResultScreen(screen)
                }
                is Screen.Settings -> {
                    SettingsScreen(screen)
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "GroupDocs.Viewer example (Kotlin, Compose)",
        icon = painterResource("icon.png"),
        resizable = false
    ) {
        this.window.size = Dimension(860, 680)
        App()
    }
}
