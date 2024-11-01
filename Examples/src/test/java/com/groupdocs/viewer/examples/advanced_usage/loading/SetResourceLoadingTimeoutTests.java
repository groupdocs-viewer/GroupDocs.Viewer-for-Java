package com.groupdocs.viewer.examples.advanced_usage.loading;

import org.testng.annotations.Test;

/**
 * This example demonstrates how to set timeout for loading external resources contained by a document.
 */
public class SetResourceLoadingTimeoutTests {
    @Test(timeOut = 120_000)
    public void run() {
        SetResourceLoadingTimeout.run();
    }
}
