package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_visio_documents;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render Visio documents figures into HTML, JPG, PNG, PDF.
 */
public class RenderingVisioDocumentsFiguresTests {

    @Test
    public void run() {
        RenderingVisioDocumentsFigures.run(SampleFiles.SAMPLE_VISIO);
    }
}
