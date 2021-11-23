package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_lotus_notes_data_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.*;
import com.groupdocs.viewer.utils.PathUtils;

/**
 * This example demonstrates how to render NSF document into HTML, JPG, PNG, PDF.
 */
public class RenderingNsf {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingNsf");
        String pageFilePathFormat = Utils.combinePaths(outputDirectory, "NSF_result.html");

        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setResourceLoadingTimeout(100);

        // TO HTML
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_NSF, loadOptions)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            viewer.view(options);
        }

        // TO JPG
        pageFilePathFormat = PathUtils.combine(outputDirectory, "NSF_result_{0}.jpg");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_NSF, loadOptions)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PNG
        pageFilePathFormat = PathUtils.combine(outputDirectory, "NSF_result_{0}.png");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_NSF, loadOptions)) {
            PngViewOptions options = new PngViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        // TO PDF
        pageFilePathFormat = PathUtils.combine(outputDirectory, "NSF_result.pdf");

        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_NSF, loadOptions)) {
            PdfViewOptions options = new PdfViewOptions(pageFilePathFormat);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
