package com.groupdocs.ui.config

import com.groupdocs.ui.Defaults
import java.nio.file.Path

@kotlinx.serialization.Serializable
data class ViewerConfig(
    val common: Common = Common(),
    val viewer: Viewer = Viewer(),
    val local: Local = Local(),
    private val licensePath: String = ""
) {
    val licensePathOrDefault: String
        get() = licensePath.ifBlank { Defaults.DEFAULT_LICENSE_PATH }
}

@kotlinx.serialization.Serializable
data class Common(
    val pageSelector: Boolean = false,
    val download: Boolean = false,
    val upload: Boolean = false,
    val print: Boolean = false,
    val browse: Boolean = false,
    val rewrite: Boolean = false,
    val enableRightClick: Boolean = false
)

@kotlinx.serialization.Serializable
data class Viewer(
    private val filesProviderType: String = "",
    val preloadResultPageCount: Int = 0,
    private val previewPageWidth: Int = 0,
    private val previewPageRatio: Float = 0f,
    private val tempDirectory: String = "",
) {
    val filesProviderTypeOrDefault: Defaults.Viewer.FilesProviderType
        get() =
            when (filesProviderType.uppercase()) {
                in Defaults.Viewer.FilesProviderType.values()
                    .map { it.name.uppercase() } -> Defaults.Viewer.FilesProviderType.valueOf(filesProviderType.uppercase())
                else -> Defaults.Viewer.DEFAULT_FILES_PROVIDER_TYPE
            }
    val tempDirectoryOrDefault: String
        get() = tempDirectory.ifBlank { Defaults.Viewer.DEFAULT_TEMP_DIRECTORY }
            ?: throw IllegalStateException("Can't get temp directory!")
    val previewPageWidthOrDefault: Int
        get() = if (previewPageWidth == 0) Defaults.Viewer.DEFAULT_PREVIEW_PAGE_WIDTH else previewPageWidth
    val previewPageRatioOrDefault: Float
        get() = if (previewPageRatio == 0f) Defaults.Viewer.DEFAULT_PREVIEW_PAGE_RATIO else previewPageRatio
}

@kotlinx.serialization.Serializable
data class Local(
    private val filesDirectory: String = "",
    private val resultDirectory: String = "",
) {

    val filesDirectoryOrDefault: Path
        get() = Path.of(filesDirectory.ifBlank { Defaults.Local.DEFAULT_FILES_DIRECTORY })

    val resultDirectoryOrDefault: Path
        get() = Path.of(resultDirectory.ifBlank { Defaults.Local.DEFAULT_RESULT_DIRECTORY })
}