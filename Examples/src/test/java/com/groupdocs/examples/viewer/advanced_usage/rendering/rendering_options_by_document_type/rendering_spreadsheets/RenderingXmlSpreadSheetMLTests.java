package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render Excel 2003 SpreadSheetML XML document into HTML, JPG, PNG, PDF.
 */
public class RenderingXmlSpreadSheetMLTests {
    @Test
    public void run() {
        RenderingXmlSpreadSheetML.run(SampleFiles.SAMPLE_XML_SPREADSHEETML);
    }
}
