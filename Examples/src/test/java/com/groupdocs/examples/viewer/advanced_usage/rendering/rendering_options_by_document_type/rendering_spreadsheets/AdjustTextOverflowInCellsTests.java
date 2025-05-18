package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class AdjustTextOverflowInCellsTests {

    /**
     * This example demonstrates how to hide text that overflows cells.
     */
    @Test
    public void run() {
        AdjustTextOverflowInCells.run(SampleFiles.SAMPLE_XLSX_WITH_TEXT_OVERFLOW);
    }
}