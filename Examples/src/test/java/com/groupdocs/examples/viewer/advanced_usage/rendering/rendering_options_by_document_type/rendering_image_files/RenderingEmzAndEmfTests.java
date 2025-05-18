package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_image_files;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render EMZ/EMF document into HTML, JPG, PNG, PDF.
 */
public class RenderingEmzAndEmfTests {
    @Test
    public void run() {
        RenderingEmzAndEmf.run(SampleFiles.SAMPLE_EMZ);
    }
}
