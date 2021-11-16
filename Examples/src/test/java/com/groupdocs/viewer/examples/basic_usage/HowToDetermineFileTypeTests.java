package com.groupdocs.viewer.examples.basic_usage;

import com.groupdocs.viewer.examples.howto.HowToDetermineFileType;
import org.testng.annotations.Test;

import java.io.IOException;

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
