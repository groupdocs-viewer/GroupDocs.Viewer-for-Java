package com.groupdocs.ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public static String getProjectProperty(String name) {
        Properties p = new Properties();
        try (InputStream i = Utils.class.getResourceAsStream("/project.properties")) {
            p.load(i);
        } catch (IOException e) {
            // Ignore
        }
        return p.getProperty(name);
    }

}
