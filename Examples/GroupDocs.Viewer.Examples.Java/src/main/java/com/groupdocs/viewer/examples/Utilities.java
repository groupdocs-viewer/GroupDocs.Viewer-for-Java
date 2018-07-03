package com.groupdocs.viewer.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import com.groupdocs.viewer.config.ViewerConfig;
import com.groupdocs.viewer.domain.image.PageImage;
import com.groupdocs.viewer.handler.ViewerImageHandler;
import com.groupdocs.viewer.metered.Metered;

public class Utilities {

	// ExStart:CommonProperties
	public static final String TEST_BUCKET = "usman-aziz-test-bucket";
	public static final String ACCESS_KEY = "xxxxxxxxxxxxxxx";
	public static final String SECRET_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	
	public static final Path STORAGE_PATH = getProjectBaseDir().resolve("Data/Storage");
	public static final Path TEMP_PATH = getProjectBaseDir().resolve("Data/temp");
	public static final Path LICENSE_PATH = getProjectBaseDir().resolve("GroupDocs.Total.Java.lic");
	public static final List<String> customFontDirs = Arrays
			.asList(getProjectBaseDir().resolve("Data/Fonts").toString());
	// Generated html files will be saved in Html folder with name starting with output_
	public static final Path OUTPUT_HTML_PATH = getProjectBaseDir().resolve("Data/Output/Html/output_");
	// Generated image files will be saved in Images folder with name starting with output_
	public static final Path OUTPUT_IMAGE_PATH = getProjectBaseDir().resolve("Data/Output/Images/output_");
	// Generated files will be saved in Output folder with name starting with output_
	public static final Path OUTPUT_PATH = getProjectBaseDir().resolve("Data/Output/output_");

	// ExEnd:CommonProperties

	// ExStart:ApplyLicenseFromFile
	/**
	 * This method applies product license from file
	 * 
	 */
	public static void applyLicenseFromFile() {
		try {
			// Setup license
			com.groupdocs.viewer.licensing.License lic = new com.groupdocs.viewer.licensing.License();
			lic.setLicense(LICENSE_PATH.toString());
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	// ExStart:ApplyLicenseFromStreamObj
	/**
	 * This method applies product license from stream
	 * 
	 */
	public static void applyLicenseFromStream(String filePath) {

		try {
			// Obtain license stream
			FileInputStream licenseStream = new FileInputStream(filePath);

			// Setup license
			com.groupdocs.viewer.licensing.License lic = new com.groupdocs.viewer.licensing.License();
			lic.setLicense(licenseStream);
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	// ExEnd:ApplyLicenseFromStreamObj
	public static Path getProjectBaseDir() {
		Properties props = new Properties();
		try {
			InputStream i = Utilities.class.getResourceAsStream("/project.properties");
			props.load(i);
		} catch (IOException x) {
			throw new RuntimeException(x);
		}
		return FileSystems.getDefault().getPath(props.getProperty("project.basedir"));
	}

	// ExEnd:ApplyLicenseFromFile

	// ExStart:UseMeteredLicense
		/**
		 * This method uses Metered license
		 * 
		 */
		public static void applyMeteredLicense() {

			try {
				// Set metered key
				Metered metered = new Metered();
				metered.setMeteredKey("public_key","private_key");
				
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
				exp.printStackTrace();
			}
		}
		
	// ExStart:SaveAsImage
	/**
	 * This method writes input stream to output image file
	 * 
	 * @param fileName
	 *            name of the output image file
	 * @param imageFormat
	 *            format of output image file
	 */
	public static void saveAsImage(String fileName, String imageFormat, InputStream inputStream) {

		try {
			// Write input stream to output file
			ImageIO.write(ImageIO.read(inputStream), imageFormat,
					new File(OUTPUT_IMAGE_PATH + getFileNameWithoutExtension(fileName) + "." + imageFormat));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}

	}

	// ExEnd:SaveAsImage

	// ExStart:SaveAsHtml
	/**
	 * This method writes string to output html file
	 * 
	 * @param outputFileName
	 *            name of the output html file
	 * @param fileContent
	 *            content to be written in output html file
	 */
	public static void saveAsHtml(String outputFileName, String fileContent) {
		try {

			// Initialize PrintWriter for output file
			PrintWriter out = new PrintWriter(
					OUTPUT_HTML_PATH.toString() + getFileNameWithoutExtension(outputFileName) + ".html", "UTF-8");

			// Write file content in
			out.println(fileContent);
			out.flush();
			out.close();
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}

	}

	// ExEnd:SaveAsHtml

	// ExStart:SaveAsFile
	/**
	 * This method writes input stream to output file
	 * 
	 * @param fileName
	 *            name of the output file
	 * @param inputStream
	 *            input stream to be written in output file
	 */
	public static void saveAsFile(String fileName, InputStream inputStream) {

		try {

			// Create stream for output file
			OutputStream outputStream = new FileOutputStream(OUTPUT_PATH + fileName);
			int read = 0;
			byte[] bytes = new byte[1024];

			// Write bytes into output stream
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.close();
			outputStream.flush();
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	// ExEnd:SaveAsFile

	// ExStart:SaveAsFileWithFileExtension
	/**
	 * This method writes input stream to output file
	 * 
	 * @param fileName
	 *            name of the output file
	 * @param inputStream
	 *            input stream to be written in output file
	 * @param fileExtension
	 *            extension of output file
	 */
	public static void saveAsFile(String fileName, InputStream inputStream, String fileExtension) {

		try {

			// Create stream for output file
			OutputStream outputStream = new FileOutputStream(
					OUTPUT_PATH + getFileNameWithoutExtension(fileName) + fileExtension);
			int read = 0;
			byte[] bytes = new byte[1024];

			// Write bytes into output stream
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.close();
			outputStream.flush();
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	// ExEnd:SaveAsFileWithFileExtension

	// ExStart:GetFileExtension
	/**
	 * This method gets extension of file
	 * 
	 * @param fileName
	 *            name of the file
	 * @return String file extension
	 */
	public static String getFileExtension(String fileName) {
		try {

			// Get file name tokens
			String[] tokens = fileName.split("\\.(?=[^\\.]+$)");

			// Return file extension
			return tokens[tokens.length - 1];
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
			return null;
		}
	}

	// ExEnd:GetFileExtension
	// ExStart:GetFileNameWithoutExtension
	/**
	 * This method gets extension of file
	 * 
	 * @param fileName
	 *            name of the file
	 */
	public static String getFileNameWithoutExtension(String fileName) {
		try {

			return fileName.replaceFirst("[.][^.]+$", "");

		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
			return null;
		}

	}

	// ExEnd:GetFileNameWithoutExtension

	// ExStart:GetConfiguration
	/**
	 * This method sets the storage path and Use Cache option
	 * 
	 * @param fileName
	 *            name of the output image file
	 * @param imageFormat
	 *            format of output image file
	 * @return ViewerConfig object
	 */
	public static ViewerConfig getConfiguration() {
		try {

			// Setup GroupDocs.Viewer config
			ViewerConfig config = new ViewerConfig();
			// Set storage path
			config.setStoragePath(STORAGE_PATH.toString()); 
			// Set cache to true for cache purpose
			config.setCachePath(TEMP_PATH.toString());
			// Add custom fonts directories to FontDirectories list
			config.setFontDirectories(customFontDirs);
			config.setUseCache(false);
			// Set default Font Name
			config.setDefaultFontName("Calibri");
			return config;

		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
			return null;
		}
	}
    // ExEnd:GetConfiguration
	
	/**
	 * Cleans up temp files
	 */
	public static void cleanupTempFiles() {
		try {
			// ExStart:cleanupTempFiles
			// Setup GroupDocs.Viewer config
			ViewerConfig config = new ViewerConfig();
			config.setStoragePath(STORAGE_PATH.toString());
			   
			// Create image or HTML handler
			ViewerImageHandler handler = new ViewerImageHandler(config);
			  
			// Cleanup temporary files
			handler.clearTempFiles();
			// ExEnd:cleanupTempFiles

		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace(); 
		}
	}
}
