package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render Apple Numbers document into HTML, JPG, PNG, PDF.
 */
public class RenderingNumbersTests {
    @Test
    public void run() {
        RenderingNumbers.run(SampleFiles.SAMPLE_NUMBERS);
    }
}
