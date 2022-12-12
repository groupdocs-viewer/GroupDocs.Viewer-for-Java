package com.groupdocs.ui.settings

import com.groupdocs.ui.common.Settings


data class SettingsState(
    val errorMessage: String? = null,
    val licensePath: String? = Settings.instance.licensePath,
    val maxWidth: Int = Settings.instance.maxWidth,
    val isRenderComments: Boolean = Settings.instance.isRenderComments,
)

