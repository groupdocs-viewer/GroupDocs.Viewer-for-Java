package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.Constants;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.fonts.FolderFontSource;
import com.groupdocs.viewer.fonts.FontSettings;
import com.groupdocs.viewer.fonts.FontSource;
import com.groupdocs.viewer.fonts.SearchOption;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class RenderWithCustomFonts {

    /**
     * This example demonstrates how to add custom fonts to use when rendering
     * documents.
     */

    public static void run() {
        FontSource fontSource =
                new FolderFontSource(Constants.FONTS_PATH.toString(), SearchOption.TOP_FOLDER_ONLY);
        FontSettings.setFontSources(fontSource);

        Path outputDirectory = Utils.getOutputDirectoryPath("RenderWithCustomFonts");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (Viewer viewer = new Viewer(TestFiles.MISSING_FONT_PPTX)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}