package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class SkipRenderingOfEmptyColumnsTests {

    /**
     * This example demonstrates how to skip rendering of empty columns.
     */
    @Test
    public void run() {
        SkipRenderingOfEmptyColumns.run(SampleFiles.SAMPLE_XLSX_WITH_EMPTY_COLUMN);
    }
}