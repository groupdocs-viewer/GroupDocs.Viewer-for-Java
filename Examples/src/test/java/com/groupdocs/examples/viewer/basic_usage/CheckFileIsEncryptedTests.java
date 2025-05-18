package com.groupdocs.examples.viewer.basic_usage;

import com.groupdocs.examples.viewer.SampleFiles;
import org.testng.annotations.Test;

/**
 * This example demonstrates how to check if the file is encrypted.
 */
public class CheckFileIsEncryptedTests {
    @Test
    public void run() {
        CheckFileIsEncrypted.run(SampleFiles.ENCRYPTED);
    }
}
