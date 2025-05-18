package com.groupdocs.examples.viewer.advanced_usage.caching;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class UseCustomCacheImplementationTests {

    /**
     * This example demonstrates how to create custom cache and how to use it.
     */
    @Test
    public void runTest() {
        UseCustomCacheImplementation.run(SampleFiles.SAMPLE_DOCX);
    }
}
