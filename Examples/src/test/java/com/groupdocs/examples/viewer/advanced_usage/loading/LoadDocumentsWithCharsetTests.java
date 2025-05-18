package com.groupdocs.examples.viewer.advanced_usage.loading;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class LoadDocumentsWithCharsetTests {

    /**
     * This example demonstrates how to specify charset.
     */
    @Test
    public void run() {
        LoadDocumentsWithCharset.run(SampleFiles.SAMPLE_TXT_SHIFT_JS_ENCODED);
    }
}