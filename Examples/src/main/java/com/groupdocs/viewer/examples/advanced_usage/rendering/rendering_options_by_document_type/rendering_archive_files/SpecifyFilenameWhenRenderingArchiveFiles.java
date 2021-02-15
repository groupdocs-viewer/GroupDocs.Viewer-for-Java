package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.FileName;
import com.groupdocs.viewer.options.PdfViewOptions;
import com.groupdocs.viewer.utils.PathUtils;

import java.io.IOException;

/**
 * This example demonstrates how to specify filename when rendering archive files.
 */
public class SpecifyFilenameWhenRenderingArchiveFiles {
    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("SpecifyFilenameWhenRenderingArchiveFiles");
        String outputFilePath = PathUtils.combine(outputDirectory, "output.pdf");

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_ZIP)) {
            PdfViewOptions viewOptions = new PdfViewOptions(outputFilePath);
            viewOptions.getArchiveOptions().setFileName(new FileName("my filename"));

            viewer.view(viewOptions);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
