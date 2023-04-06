package com.groupdocs.viewer.examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Utils {

    public static final String LICENSE_PATH = new File("resources/GroupDocs.Viewer.Java.lic").getAbsolutePath();
    public static final String SAMPLES_PATH = "resources/sample_files";
    public static final String FONTS_PATH = "resources/fonts";
    public static final String OUTPUT_PATH = "output";

    private Utils() {
    }

    public static void cleanOutputDirectory() throws IOException {
        final Path outputPath = Paths.get(OUTPUT_PATH);
        if (Files.exists(outputPath)) {
            deleteDirectoryWithContent(outputPath);
        }
    }

    public static Path getOutputDirectoryPath(String sampleName) {
        final Path sampleDirectory = Paths.get(OUTPUT_PATH, sampleName);
        try {
            return Files.createDirectories(sampleDirectory);
        } catch (IOException e) {
            throw new RuntimeException("Can't create sample directory: '" + sampleDirectory.toAbsolutePath() + "'", e);
        }
    }

    public static String combinePaths(String... pathParts) {
        StringBuilder relativePath = new StringBuilder();
        for (String pathPart : pathParts) {
            if (relativePath.length() > 0) {
                relativePath.append(File.separator);
            }
            relativePath.append(pathPart);
        }
        return relativePath.toString();
    }

    private static void deleteDirectoryWithContent(Path pathToBeDeleted) throws IOException {
        Files.walkFileTree(pathToBeDeleted, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult postVisitDirectory(
                    Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(
                    Path file, BasicFileAttributes attrs)
                    throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
