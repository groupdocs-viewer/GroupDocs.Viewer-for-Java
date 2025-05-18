package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.SampleFiles;
import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;

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

    public static void run(Path inputFile) {
        FontSource fontSource =
                new FolderFontSource(FilesUtils.makeFontPath("terminal-grotesque_open.otf").toString(), SearchOption.TOP_FOLDER_ONLY);
        FontSettings.setFontSources(fontSource);

        Path outputDirectory = FilesUtils.makeOutputPath("RenderWithCustomFonts");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

        try (Viewer viewer = new Viewer(inputFile)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}