package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.examples.viewer.SampleFiles;
import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.JpgViewOptions;

import java.nio.file.Path;

public class RenderingPc3Files {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingPc3Files");
        Path pageFilePathFormat = outputDirectory.resolve("pc3_result.jpg");

        // TO JPG with PC3 config
        try (Viewer viewer = new Viewer(inputFile)) {
            JpgViewOptions options = new JpgViewOptions(pageFilePathFormat);

            // With PC3 file is 274x198
            options.getCadOptions().setPc3File(SampleFiles.SAMPLE_PC3_CONFIG.toString());
            // Without PC3 file size is 2000x1769 pixels

            viewer.view(options);
        }
    }
}
