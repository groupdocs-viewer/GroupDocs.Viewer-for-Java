package com.groupdocs.examples.viewer;


import com.groupdocs.examples.viewer.utils.FailureRegister;
import com.groupdocs.examples.viewer.utils.LicenseUtils;
import com.groupdocs.viewer.License;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class TestsSetUp {
    @BeforeSuite
    public final void setUp() throws IOException {
//        ViewerLogger.setLogger(new ConsoleLogger(false, true, true, true));
        FailureRegister.getInstance().setThrowExceptionsImmediately(true);

        try (final InputStream licenseStream = LicenseUtils.createLicenseStream()) {
            if (licenseStream == null) {
                throw new RuntimeException("License was NOT set!");
            }
            final License license = new License();
            license.setLicense(licenseStream);
            System.out.println("License was set successfully!");
        }
    }

    @AfterSuite(alwaysRun = true)
    public final void afterSuite() {
        System.out.println("============================================");
        System.out.println("Test report path " + Paths.get("target/surefire-reports/index.html").toAbsolutePath());
        System.out.println("============================================");
    }
}