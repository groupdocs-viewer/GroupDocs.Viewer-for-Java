package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;

import com.groupdocs.viewer.config.ViewerConfig;

public class Utilities {

	// ExStart:CommonProperties
	public final static String storagePath = "./Data/Storage/";
	public final static String outputHtmlPath = "./Data/Output/Html/";
	public final static String outputImagePath = "./Data/Output/Images/";
	public final static String outputPath = "./Data/Output/";

	// ExEnd:CommonProperties

	// ExStart:ApplyLicenseFromFile
	/**
	 * This method applies product license from file
	 * 
	 */
	public static void ApplyLicenseFromFile(String filePath) {
		try {
			// Setup license
			com.groupdocs.viewer.licensing.License lic = new com.groupdocs.viewer.licensing.License();
			lic.setLicense(filePath);
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	// ExEnd:ApplyLicenseFromFile

	// ExStart:ExStart:ApplyLicenseFromStreamObj
	/**
	 * This method applies product license from stream
	 * 
	 */
	public static void ApplyLicenseFromStream(String filePath) {

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

	// ExEnd:ExStart:ApplyLicenseFromStreamObj

	// ExStart:SaveAsImage
	/**
	 * This method writes input stream to output image file
	 * 
	 * @param fileName
	 *            name of the output image file
	 * @param imageFormat
	 *            format of output image file
	 */
	public static void SaveAsImage(String fileName, String imageFormat, InputStream inputStream) {

		try {
			// Write input stream to output file
			ImageIO.write(ImageIO.read(inputStream), imageFormat,
					new File(outputImagePath + GetFileNameWithoutExtension(fileName) + "." + imageFormat));
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
	public static void SaveAsHtml(String outputFileName, String fileContent) {
		try {

			// Initialize PrintWriter for output file
			PrintWriter out = new PrintWriter(outputHtmlPath + GetFileNameWithoutExtension(outputFileName) + ".html");

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
	public static void SaveAsFile(String fileName, InputStream inputStream) {

		try {

			// Create stream for output file
			OutputStream outputStream = new FileOutputStream(outputPath + fileName);
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
	public static void SaveAsFile(String fileName, InputStream inputStream, String fileExtension) {

		try {

			// Create stream for output file
			OutputStream outputStream = new FileOutputStream(
					outputPath + GetFileNameWithoutExtension(fileName) + fileExtension);
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
	public static String GetFileExtension(String fileName) {
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
	public static String GetFileNameWithoutExtension(String fileName) {
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
	public static ViewerConfig GetConfiguration() {
		try {

			// Setup GroupDocs.Viewer config
			ViewerConfig config = new ViewerConfig();
			// Set storage path
			config.setStoragePath(storagePath);
			// Set cache to true for cache purpose
			config.setUseCache(false);
			return config;

		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
			return null;
		}
	}
	// ExEnd:GetConfiguration
}
