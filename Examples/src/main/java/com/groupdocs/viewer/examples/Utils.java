package com.groupdocs.viewer.examples;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Utils {

	public static final String LICENSE_PATH = "resources/GroupDocs.Viewer.Java.lic";
	public static final String SAMPLES_PATH = "resources/sample_files";
	public static final String FONTS_PATH = "resources/fonts";
	public static final String OUTPUT_PATH = "output";

	public static String getOutputDirectoryPath(String outputDirName) throws IOException {
		File outputDirectory = new File(OUTPUT_PATH, outputDirName).getCanonicalFile();
		if (outputDirectory.exists() && !deleteDirectory(outputDirectory)) {
			outputDirectory.deleteOnExit();
			throw new IOException("Can't delete output directory '" + outputDirectory.getAbsolutePath() + "'");
		}
		if (!outputDirectory.mkdirs()) {
			throw new IOException("Can't create output directory '" + outputDirectory.getAbsolutePath() + "'");
		}
		return outputDirectory.getAbsolutePath();
	}

	private static boolean deleteDirectory(File dir) {
		if (dir.isDirectory()) {
			File[] children = dir.listFiles();
			for (File child : Objects.requireNonNull(children)) {
				boolean success = deleteDirectory(child);
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}
}
