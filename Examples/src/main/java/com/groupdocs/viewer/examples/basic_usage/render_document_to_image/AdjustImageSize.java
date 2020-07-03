package com.groupdocs.viewer.examples.basic_usage.render_document_to_image;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.SampleFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.JpgViewOptions;

import java.io.File;
import java.io.IOException;

public class AdjustImageSize {

    /**
     * This example demonstrates how to adjust size width and height of the output
     * images.
     */

    public static void run() throws IOException {
        String outputDirectory = Utils.getOutputDirectoryPath("AdjustImageSize");
        String pageFilePathFormat = new File(outputDirectory, "page_{0}.jpg").getPath();

        JpgViewOptions viewOptions = new JpgViewOptions(pageFilePathFormat);
        viewOptions.setWidth(600);
        viewOptions.setHeight(800);

        Viewer viewer = new Viewer(SampleFiles.SAMPLE_DOCX);
        viewer.view(viewOptions);
        viewer.close();

        System.out.println(
                String.format("\nSource document rendered successfully.\nCheck output in '%s'.", outputDirectory));
    }
}