package com.groupdocs.viewer.examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Utils {

    private Utils() {
    }

    public static void cleanOutputDirectory() throws IOException {
        if (Files.exists(Constants.OUTPUT_PATH)) {
            deleteDirectoryWithContent(Constants.OUTPUT_PATH);
        }
    }

    public static Path getOutputDirectoryPath(String sampleName) {
        final Path sampleDirectory = Constants.OUTPUT_PATH.resolve(sampleName);
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
