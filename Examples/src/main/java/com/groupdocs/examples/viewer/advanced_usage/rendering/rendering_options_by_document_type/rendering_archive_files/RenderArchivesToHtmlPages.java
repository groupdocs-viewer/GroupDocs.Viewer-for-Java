package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.*;


import java.nio.file.Path;
public class RenderArchivesToHtmlPages {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingArchivesToMultipleAndSinglePagesHtml");
        Path pageFilePathFormat = outputDirectory.resolve("RAR_result.html");

        // TO single page HTML
        try (Viewer viewer = new Viewer(inputFile)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);

            options.setRenderToSinglePage(true);

            viewer.view(options);
        }

        // RAR_result_page_{0}.html - {0} is page number mask
        pageFilePathFormat = outputDirectory.resolve("RAR_result_page_{0}.html");

        // TO multi pages HTML
        try (Viewer viewer = new Viewer(inputFile)) {
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
