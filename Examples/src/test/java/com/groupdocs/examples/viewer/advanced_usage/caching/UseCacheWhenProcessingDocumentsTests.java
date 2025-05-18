package com.groupdocs.examples.viewer.advanced_usage.caching;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class UseCacheWhenProcessingDocumentsTests {

    /**
     * This example demonstrates how to enable cache when render document.
     */
    @Test
    public void runTest() {
        UseCacheWhenProcessingDocuments.run(SampleFiles.SAMPLE_DOCX);
    }
}