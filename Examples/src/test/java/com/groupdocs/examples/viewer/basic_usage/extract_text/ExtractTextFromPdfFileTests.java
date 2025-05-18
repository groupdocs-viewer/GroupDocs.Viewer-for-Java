package com.groupdocs.examples.viewer.basic_usage.extract_text;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class ExtractTextFromPdfFileTests {

    @Test
    public void testRun() {
        ExtractTextFromPdfFile.run(SampleFiles.SAMPLE_PDF);
    }
}