package com.groupdocs.examples.viewer.quick_start;

import com.groupdocs.examples.viewer.utils.LicenseUtils;
import com.groupdocs.viewer.License;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SetLicenseFromStream {

    /**
     * This example demonstrates how to set license from stream.
     */

    public static void run() {

        try {
            final String licensePath = LicenseUtils.obtainLicensePath();
            if (licensePath == null) {
                System.err.println("LICENSE_PATH is not provided, setting license from stream is skipped!");
            } else if (new File(licensePath).isFile()) {
                final InputStream stream;
                if (licensePath.startsWith("http")) {
                    stream = new URL(licensePath).openStream();
                } else {
                    stream = Files.newInputStream(Paths.get(licensePath));
                }
                try {
                    License license = new License();
                    license.setLicense(stream);
                } finally {
                    if (stream != null) {
                        stream.close();
                    }
                }
                System.out.println("License set successfully.");
            } else {
                System.out.println(
                        "\nWe do not ship any license with this example. "
                                + "\nVisit the GroupDocs site to obtain either a temporary or permanent license. "
                                + "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. "
                                + "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license."
                );
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}