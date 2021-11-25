package com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings;

import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.examples.TestFiles;
import com.groupdocs.viewer.examples.Utils;
import com.groupdocs.viewer.options.JpgViewOptions;
import com.groupdocs.viewer.utils.PathUtils;

public class RenderingPc3Files {
    public static void run() {
        String outputDirectory = Utils.getOutputDirectoryPath("RenderingPc3Files");
        String pageFilePathFormat = PathUtils.combine(outputDirectory, "pc3_result.jpg");

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
