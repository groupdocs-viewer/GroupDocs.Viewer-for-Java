package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_web_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render CHM document into HTML, JPG, PNG, PDF.
 */
public class RenderingChmFilesTests {
    @Test
    public void run() {
        RenderingChmFiles.run(SampleFiles.SAMPLE_CHM);
    }
}
