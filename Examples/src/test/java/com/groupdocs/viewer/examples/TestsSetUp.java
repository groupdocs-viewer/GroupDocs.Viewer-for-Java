package com.groupdocs.viewer.examples;

import com.groupdocs.viewer.logging.ConsoleLogger;
import com.groupdocs.viewer.logging.ViewerLogger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestsSetUp {
    @BeforeSuite(alwaysRun = true)
    public final void beforeSuite() {
//        ViewerLogger.setLogger(new ConsoleLogger(false, true, true, true));

        final String viewerLicense = System.getenv("GROUPDOCS_LIC_PATH");
        if (viewerLicense == null) {
            System.err.println("Variable %GROUPDOCS_LIC_PATH% is not set! Running tests without license");
        } else {
            if (!viewerLicense.startsWith("http") && Files.exists(Paths.get(viewerLicense))) {
                System.out.println("Using license: " + viewerLicense);
                new com.groupdocs.viewer.License().setLicense(viewerLicense);
            } else if (viewerLicense.startsWith("http")) {
                System.out.println("Using remote license: " + viewerLicense);
                try {
                    URL website = new URL(viewerLicense);
                    final URLConnection urlConnection = website.openConnection();
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(3000);
                    try (final InputStream inputStream = urlConnection.getInputStream()) {
                        new com.groupdocs.viewer.License().setLicense(inputStream);
                    }
                } catch (Exception e) {
                    System.err.println("Can't load remote license from '" + viewerLicense + "' (Do you need to activate vpn?)");
                    throw new IllegalStateException("Can't load license. Is VPN enabling required?");
                }
            } else {
                System.err.println("License was not set. Running tests without license.");
            }
//            System.out.println("License is valid: " + License.isLicensed());
        }
    }

    @AfterSuite(alwaysRun = true)
    public final void afterSuite() {
        System.out.println("============================================");
        System.out.println("Test report path " + Paths.get("target/surefire-reports/index.html").toAbsolutePath());
        System.out.println("============================================");
    }
}