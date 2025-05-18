package com.groupdocs.examples.viewer.advanced_usage.loading;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to set timeout for loading external resources contained by a document.
 */
public class SetResourceLoadingTimeoutTests {
    @Test(timeOut = 120_000)
    public void run() {
        SetResourceLoadingTimeout.run(SampleFiles.WITH_EXTERNAL_IMAGE_DOC);
    }
}
