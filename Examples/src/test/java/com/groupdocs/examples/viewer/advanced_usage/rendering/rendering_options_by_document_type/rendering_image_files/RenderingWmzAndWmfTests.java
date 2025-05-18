package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_image_files;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render WMZ/WMF document into HTML, JPG, PNG, PDF.
 */
public class RenderingWmzAndWmfTests {
    @Test
    public void run() {
        RenderingWmzAndWmf.run(SampleFiles.SAMPLE_WMZ);
    }
}
