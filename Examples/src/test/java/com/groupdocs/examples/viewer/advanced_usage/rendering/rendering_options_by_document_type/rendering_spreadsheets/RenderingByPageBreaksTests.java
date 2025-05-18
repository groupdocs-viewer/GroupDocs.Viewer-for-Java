package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to render spreadsheets by page breaks.
 * More details at https://docs.groupdocs.com/viewer/net/render-spreadsheets-by-page-breaks/
 */
public class RenderingByPageBreaksTests {
    @Test
    public void run() {
        RenderingByPageBreaks.run(SampleFiles.PAGE_BREAKS_XLSX);
    }
}
