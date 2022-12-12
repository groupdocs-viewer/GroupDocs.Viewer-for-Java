package com.groupdocs.ui.common

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.ResourceLoader
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.io.InputStream

@ExperimentalComposeUiApi
class LocalResourceLoader : ResourceLoader {
    override fun load(resourcePath: String): InputStream = BufferedInputStream(FileInputStream(resourcePath))
}