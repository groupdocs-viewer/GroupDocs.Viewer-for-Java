package com.groupdocs.examples.viewer.quick_start;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

public class HelloWorldTests {

    /**
     * This example demonstrates how to render document into HTML.
     */
    @Test
    public void run() {
        HelloWorld.run(SampleFiles.SAMPLE_DOCX);
    }
}