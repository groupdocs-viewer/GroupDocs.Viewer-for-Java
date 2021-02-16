package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

/**
 * This example demonstrates how to render archives files into multiple/single pages HTML.
 */
public class RenderingArchivesToMultipleAndSinglePagesHtml {

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingArchivesToMultipleAndSinglePagesHtml");
        String pageFilePathFormat = Utils.combinePaths(outputDirectory, "RAR_result.html");

        // TO single page HTML
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            options.setRenderSinglePage(true);

            viewer.view(options);
        }

        // RAR_result_page_{0}.html - {0} is page number mask
        pageFilePathFormat = Utils.combinePaths(outputDirectory, "RAR_result_page_{0}.html");

        // TO multi pages HTML
        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_RAR_WITH_FOLDERS)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            /*
             * If options.RenderSinglePage is set to false (by default),
             * you can set the number of items per page (default is 16), this property is for rendering to HTML only
             */
            options.getArchiveOptions().setItemsPerPage(10);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
