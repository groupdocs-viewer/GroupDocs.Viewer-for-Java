package com.groupdocs.viewer.examples.quick_start;

import com.groupdocs.viewer.License;
import com.groupdocs.viewer.examples.Constants;
import com.groupdocs.viewer.examples.Utils;

import java.io.InputStream;
import java.net.URL;

/**
 * This example demonstrates how to set license from url.
 * <p>
 * The SetLicense method attempts to set a license from several locations relative to the executable.
 * You can also use the additional overload to load a license from a stream, this is useful for instance when the
 * License is stored as an embedded resource.
 */
public class SetLicenseFromUrl {

    /**
     * This example demonstrates how to set license from url.
     * <p>
     * The setLicense method attempts to set a license from several locations
     * relative to the executable. You can also use the
     * additional overload to load a license from a stream, this is useful for
     * instance when the License is stored as an embedded resource.
     */
    public static void run() {
        final String licensePath = Constants.LICENSE_PATH;
        if (licensePath != null) {
            if (!licensePath.startsWith("http")) {
                System.err.println("License url was not provided!");
                return;
            }
            try {
                URL website = new URL(licensePath);
                License license = new License();
                try (final InputStream inputStream = website.openStream()) {
                    license.setLicense(inputStream);
                }
                System.out.println("\nLicense set without errors.");
            } catch (Exception e) {
                System.err.println("Can't load remote license from '" + licensePath + "'");
                e.printStackTrace();
            }
        } else {
            System.out.println("\nWe do not ship any license with this example. " +
                    "\nEnvironment variable GROUPDOCS_LIC_PATH is null. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}