package com.groupdocs.viewer.examples.quick_start;

import com.groupdocs.viewer.License;
import com.groupdocs.viewer.examples.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SetLicenseFromStream {

    /**
     * This example demonstrates how to set license from stream.
     */

    public static void run() {
        File licenseFile = new File(Utils.LICENSE_PATH);

        if (licenseFile.exists()) {
            try (InputStream stream = new FileInputStream(Utils.LICENSE_PATH)) {
                License license = new License();
                license.setLicense(stream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.print("License set successfully.");
        } else {
            System.out.print("\nWe do not ship any license with this example. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLearn how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}