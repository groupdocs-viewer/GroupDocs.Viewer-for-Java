package com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.PdfViewOptions;

import java.io.File;

public class ReorderPages {

    /**
     * This example demonstrates how to reorder pages in the output PDF document.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("ReorderPages");
        String outputFilePath = new File(outputDirectory, "output.pdf").getPath();

        PdfViewOptions viewOptions = new PdfViewOptions(outputFilePath);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX)) {
            // Pass page numbers in the order you want to render them
            viewer.view(viewOptions, 2, 1);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}