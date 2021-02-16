package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_word_processing_documents;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.HtmlViewOptions;

import java.io.File;

public class RenderTrackedChanges {

    /**
     * This example demonstrates how to render tracked changes.
     */

    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderTrackedChanges");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.html").getPath();

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
        viewOptions.getWordProcessingOptions().setRenderTrackedChanges(true);

        try (Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX_WITH_TRACKED_CHANGES)) {
            viewer.view(viewOptions);
        }

        System.out.println(
                "\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}