package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.JpgViewOptions;

import java.nio.file.Path;

public class RenderingPc3Files {
    public static void run() {
        Path outputDirectory = Utils.getOutputDirectoryPath("RenderingPc3Files");
        Path pageFilePathFormat = outputDirectory.resolve("pc3_result.jpg");

        // TO JPG with PC3 config
        try (Viewer viewer = new Viewer(TestFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            // With PC3 file is 274x198
            options.getCadOptions().setPc3File(TestFiles.SAMPLE_PC3_CONFIG);
            // Without PC3 file size is 2000x1769 pixels

            viewer.view(options);
        }
    }
}
