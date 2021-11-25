package com.groupdocs.viewer.examples.howto;

//import com.groupdocs.foundation.logging.ConsoleLogger;

import org.testng.annotations.Test;

/**
 * This example demonstrates how to log to file or console.
 */
public class HowToLoggingTests {
    /**
     * Logging to console.
     */
    @Test
    public static void toConsole() {
        HowToLogging.toConsole();
    }

    /**
     * Logging to file.
     */
    @Test
    public static void toFile() {
        HowToLogging.toFile();
    }
}
