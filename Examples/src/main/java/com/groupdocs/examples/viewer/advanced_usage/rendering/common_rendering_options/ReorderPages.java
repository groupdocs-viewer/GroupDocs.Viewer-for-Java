package com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.nio.file.Path;

public class ReorderPages {

    /**
     * This example demonstrates how to reorder pages in the output PDF document.
     */

    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("ReorderPages");
        Path outputFilePath = outputDirectory.resolve("output.pdf");

        PdfViewOptions viewOptions = new PdfViewOptions(outputFilePath);

        try (Viewer viewer = new Viewer(inputFile)) {
            // Pass page numbers in the order you want to render them
            viewer.view(viewOptions, 2, 1);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}