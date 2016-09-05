package com.groupdocs.viewer.ui;

import com.groupdocs.viewer.licensing.License;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Utils {

    static {
        loadLicense();
    }

    public static void loadLicense() {
        Path p = Utils.getLicensePath();
        if (p != null) {
            License l = new License();
            l.setLicense(p.toString());
        }
    }

    public static Properties getProjectProperties() {
        Properties p = new Properties();

        try (InputStream i = Utils.class.getResourceAsStream("/project.properties")) {
            p.load(i);
        } catch (IOException x) {
            throw new RuntimeException(x);
        }

        return p;
    }

    public static Path getLicensePath() {
        String p = Utils.getProjectProperties().getProperty("com.groupdocs.viewer.ui.license.path");
        Path path = FileSystems.getDefault().getPath(p);
        if (Files.isReadable(path)) {
            return path;
        }

        return null;
    }

    public static Path getStoragePath() {
        String p = Utils.getProjectProperties().getProperty("com.groupdocs.viewer.ui.storage.path");
        Path path = FileSystems.getDefault().getPath(p);
        if (Files.isDirectory(path)) {
            return path;
        }

        return null;
    }

}
