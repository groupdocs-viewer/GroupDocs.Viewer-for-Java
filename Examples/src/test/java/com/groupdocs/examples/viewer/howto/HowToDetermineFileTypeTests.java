package com.groupdocs.examples.viewer.howto;

import org.testng.annotations.Test;

import java.io.IOException;

/**
 * This example demonstrates how to determine file type when you have file extension, media-type or stream.
 */
public class HowToDetermineFileTypeTests {
    @Test
    public static void fromFileExtension() {
        HowToDetermineFileType.fromFileExtension();
    }

    @Test
    public static void fromMediaType() {
        HowToDetermineFileType.fromMediaType();
    }

    @Test
    public static void fromStream() throws IOException {
        HowToDetermineFileType.fromStream();
    }
}
