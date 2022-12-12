package com.groupdocs.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

// https://material.io/design/color/the-color-system.html#color-theme-creation

private val LightColorPalette = lightColors(
    primary = Green,
    primaryVariant = GreenLight,
    onPrimary = BlackDark,
    secondary = WhiteLight,
    secondaryVariant = WhiteDark,
    onSecondary = BlueLight,
    error = RedDark,
    onError = WhiteLight,
    background = Blue,
    onBackground = WhiteLight,
    surface = BlackDark,
    onSurface = WhiteLight,
)

@Composable
fun GroupDocsTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalSpaces provides Spaces()) {
        MaterialTheme(
            colors = LightColorPalette,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}