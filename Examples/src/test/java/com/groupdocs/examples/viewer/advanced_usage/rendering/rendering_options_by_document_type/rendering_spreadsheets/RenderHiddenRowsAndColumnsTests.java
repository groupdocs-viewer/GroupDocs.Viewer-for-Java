package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class RenderHiddenRowsAndColumnsTests {

    /**
     * This example demonstrates how to render hidden rows and columns.
     */
    @Test
    public void run() {
        RenderHiddenRowsAndColumns.run(SampleFiles.SAMPLE_XLSX_WITH_HIDDEN_ROW_AND_COLUMN);
    }
}