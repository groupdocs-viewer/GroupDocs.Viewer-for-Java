package com.groupdocs.viewer.examples.quick_start;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.groupdocs.viewer.License;
import com.groupdocs.viewer.examples.Utils;

public class SetLicenseFromStream {

    /**
     * This example demonstrates how to set license from stream.
     */

    public static void run() throws IOException {
        File licenseFile = new File(Utils.LICENSE_PATH);
        
        if (licenseFile.exists()) {
            InputStream stream = new FileInputStream(Utils.LICENSE_PATH);
            License license = new License();
            license.setLicense(stream);
            stream.close();
            
            System.out.print("License set successfully.");
        } else {
            System.out.print("\nWe do not ship any license with this example. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}