package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.nio.file.Path;

public class RenderArchiveFolder {

    /**
     * This example demonstrates how to render folder of archive file.
     */

    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderArchiveFolder");
        Path pageFilePathFormat = outputDirectory.resolve("page_{0}.html");

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getArchiveOptions().setFolder("ThirdFolderWithItems");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_ZIP_WITH_FOLDERS)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}