package com.groupdocs.ui.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DefaultDirectories {
    public static final String LIC = ".lic";
    public static final String LICENSES = "Licenses";
    public static final String DOCUMENT_SAMPLES = "DocumentSamples";
    private static final Logger logger = LoggerFactory.getLogger(DefaultDirectories.class);

    public static String defaultLicenseDirectory() {
        Path defaultLicFolder = FileSystems.getDefault().getPath(LICENSES).toAbsolutePath();
        File licFolder = defaultLicFolder.toFile();
        if (licFolder.exists()) {
            Path defaultLicFile = getDefaultLicFile(licFolder);
            if (defaultLicFile != null) {
                return defaultLicFile.toString();
            }
        }
        licFolder.mkdirs();
        logger.info("License file path is incorrect, application launched in trial mode");
        return "";
    }

    public static String defaultViewerDirectory() {
        return getDefaultFilesDir("");
    }

    public static String getDefaultFilesDir(String folder) {
        String dir = DOCUMENT_SAMPLES + File.separator + folder;
        Path path = FileSystems.getDefault().getPath(dir).toAbsolutePath();
        makeDirs(path);
        return path.toString();
    }

    private static void makeDirs(Path path) {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            logger.error("Exception occurred while creating directories");
        }
    }

    public static String relativePathToAbsolute(String path) {
        if (StringUtils.isEmpty(path)) {
            return FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        }

        if (isAbsolutePath(path)) {
            makeDirs(Paths.get(path));
            return path;
        }

        Path absolutePath = FileSystems.getDefault().getPath(path).toAbsolutePath();
        makeDirs(absolutePath);
        return absolutePath.toString();
    }

    public static boolean isAbsolutePath(String path) {
        if (StringUtils.isEmpty(path)) {
            return false;
        }

        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path root : rootDirectories) {
            if (path.startsWith(root.toString())) {
                return true;
            }
        }
        return false;
    }

    public static Path getDefaultLicFile(File licFolder) {
        for (File file : licFolder.listFiles()) {
            if (file.getName().endsWith(LIC)) {
                return FileSystems.getDefault().getPath(LICENSES + File.separator + file.getName()).toAbsolutePath();
            }
        }
        return null;
    }
}
