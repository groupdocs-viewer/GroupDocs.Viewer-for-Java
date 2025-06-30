package com.groupdocs.viewer.examples.quick_start;

import com.groupdocs.viewer.License;
import com.groupdocs.viewer.examples.Constants;
import com.groupdocs.viewer.examples.Utils;

import java.io.File;

public class SetLicenseFromFile {

    /**
     * This example demonstrates how to set license from file.
     * <p>
     * The SetLicense method attempts to set a license from several locations
     * relative to the executable and GroupDocs.Viewer.dll. You can also use the
     * additional overload to load a license from a stream, this is useful for
     * instance when the License is stored as an embedded resource.
     */
    public static void run() {
        final String licensePath = Constants.LICENSE_PATH;
        if (licensePath != null) {
            if (licensePath.startsWith("http")) {
                System.err.println("License path was not provided, license url is found instead!");
                return;
            }

            License license = new License();
            license.setLicense(licensePath);
            System.out.println("License set successfully.");

        } else {
            System.out.println(
                    "\nWe do not ship any license with this example. "+
                            "\nVisit the GroupDocs site to obtain either a temporary or permanent license. "+
                            "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. "+
                            "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license."
            );
        }
    }
}