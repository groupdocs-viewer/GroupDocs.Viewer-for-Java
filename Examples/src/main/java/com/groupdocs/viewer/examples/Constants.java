package com.groupdocs.viewer.examples;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Constants {
    public static final Path PROJECT_ROOT_PATH;
    public static final Path FILES_PATH;
    public static final Path FONTS_PATH;
    public static final Path OUTPUT_PATH;
    public static final String LICENSE_PATH;

    static {
        final URL resource = Constants.class.getClassLoader().getResource(".");
        final URI uri;
        try {
            uri = Objects.requireNonNull(resource).toURI();
            Path basePath = Paths.get(uri);
            while (basePath != null && Files.notExists(basePath.resolve("Resources"))) {
                basePath = basePath.getParent();
            }
            if (basePath == null) {
                throw new IllegalStateException("Data directory was not found!");
            }

            PROJECT_ROOT_PATH = basePath;

            FILES_PATH = PROJECT_ROOT_PATH.resolve("Resources/SampleFiles/viewer");
            FONTS_PATH = PROJECT_ROOT_PATH.resolve("Resources/SampleFiles/viewer/fonts");
            OUTPUT_PATH = PROJECT_ROOT_PATH.resolve("Resources/Output/viewer");

            if (Files.notExists(FILES_PATH)) {
                throw new IllegalStateException("Directory with sample files was not found: '" + FILES_PATH + "'");
            }
            if (Files.notExists(OUTPUT_PATH) || !Files.isDirectory(OUTPUT_PATH)) {
                try {
                    Files.createDirectories(OUTPUT_PATH);
                } catch (IOException e) {
                    System.err.println("Output directory does not exist and it was not created: '" + OUTPUT_PATH + "'");
                    throw new RuntimeException(e);
                }
            }

            final Path licenseFile = basePath.resolve("Resources/LicenseFiles/GroupDocs.Viewer.Java.lic");
            if (Files.exists(licenseFile)) {
                LICENSE_PATH = licenseFile.toString();
            } else {
                final String conholdateLicPath = System.getenv("CONHOLDATE_LIC_PATH");
                if (conholdateLicPath != null && Files.exists(Paths.get(conholdateLicPath))) {
                    LICENSE_PATH = conholdateLicPath;
                } else {
                    final String groupdocsLicPath = System.getenv("GROUPDOCS_LIC_PATH");
                    if (groupdocsLicPath != null && Files.exists(Paths.get(groupdocsLicPath))) {
                        LICENSE_PATH = groupdocsLicPath;
                    } else {
                        LICENSE_PATH = null;
                        System.out.println(
                                "\nWe do not ship any license with this example. " +
                                        "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                                        "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                                        "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license."
                        );
                    }
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
