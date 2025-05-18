package com.groupdocs.examples.viewer.advanced_usage.loading;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to specify encoding.
 */
public class LoadDocumentsWithEncodingTests {
    @Test
    public void run() {
        LoadDocumentsWithEncoding.run(SampleFiles.SAMPLE_TXT_SHIFT_JS_ENCODED);
    }
}
