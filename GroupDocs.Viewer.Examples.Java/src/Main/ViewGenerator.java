package Main;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import com.groupdocs.viewer.config.ViewerConfig;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.converter.options.ImageOptions;
import com.groupdocs.viewer.domain.FileDescription;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.Transformation;
import com.groupdocs.viewer.domain.Watermark;
import com.groupdocs.viewer.domain.WatermarkPosition;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.containers.FileContainer;
import com.groupdocs.viewer.domain.containers.FileTreeContainer;
import com.groupdocs.viewer.domain.containers.PrintableHtmlContainer;
import com.groupdocs.viewer.domain.containers.RotatePageContainer;
import com.groupdocs.viewer.domain.html.HtmlResource;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.domain.image.PageImage;
import com.groupdocs.viewer.domain.options.DocumentInfoOptions;
import com.groupdocs.viewer.domain.options.FileTreeOptions;
import com.groupdocs.viewer.domain.options.PdfFileOptions;
import com.groupdocs.viewer.domain.options.PrintableHtmlOptions;
import com.groupdocs.viewer.domain.options.ReorderPageOptions;
import com.groupdocs.viewer.domain.options.RotatePageOptions;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;
import com.groupdocs.viewer.handler.ViewerImageHandler;
import com.groupdocs.viewer.handler.input.IInputDataHandler;

public class ViewGenerator {
	/**
	 * Fetches complete information of the source document
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void renderDocumentInformation(String fileName) {
		// ExStart:GetDocumentInformation
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();

			// Create html handler
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);

			String documentName = fileName;
			// Get document information
			DocumentInfoOptions options = new DocumentInfoOptions(documentName);
			DocumentInfoContainer documentInfo = htmlHandler.getDocumentInfo(options);

			System.out.println("DateCreated: " + documentInfo.getDateCreated());
			System.out.println("DocumentType: " + documentInfo.getDocumentType());
			System.out.println("Extension: " + documentInfo.getExtension());
			System.out.println("FileType: " + documentInfo.getFileType());
			System.out.println("Guid: " + documentInfo.getGuid());
			System.out.println("LastModificationDate: " + documentInfo.getLastModificationDate());
			System.out.println("Name: " + documentInfo.getName());
			System.out.println("PageCount: " + documentInfo.getPages().size());
			System.out.println("Size: " + documentInfo.getSize());

			for (PageData pageData : documentInfo.getPages()) {
				System.out.println("Page number: " + pageData.getNumber());
				System.out.println("Page name: " + pageData.getName());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetDocumentInformation
	}

	/**
	 * Gets image representation of the document
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void renderDocumentAsImage(String fileName) {
		// ExStart:GetDocumentImageRepresentation
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			// Get pages
			List<PageImage> pages = imageHandler.getPages(guid);

			// Save pages
			for (PageImage page : pages) {
				Utilities.saveAsImage(page.getPageNumber() + "_" + fileName, "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetDocumentImageRepresentation
	}

	/**
	 * Gets image representation of the N consecutive documents
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param pageNumber
	 *            starting page number
	 * @param countPagesToConvert
	 *            total number of pages to convert
	 */
	public static void renderDocumentAsImage(String fileName, int pageNumber, int countPagesToConvert) {
		// ExStart:GetDocumentImageRepresentationOfNConsecutiveDocument
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			// Options to convert countPagesToConvert consecutive pages starting
			// from pageNumber
			ImageOptions options = new ImageOptions();
			options.setPageNumber(pageNumber);
			options.setCountPagesToConvert(countPagesToConvert);

			// Get pages
			List<PageImage> pages = imageHandler.getPages(guid, options);

			// Save pages
			for (PageImage page : pages) {
				Utilities.saveAsImage(page.getPageNumber() + "_" + fileName, "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetDocumentImageRepresentationOfNConsecutiveDocument
	}

	/**
	 * Gets image representation of provided page numbers
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param listPagesToConvert
	 *            list of pages to render
	 */
	public static void renderDocumentAsImage(String fileName, List<Integer> listPagesToConvert) {
		// ExStart:GetImageRepresentationForCustomPages
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			// Options to convert 1, 3, 5, 6, 8 page numbers
			ImageOptions options = new ImageOptions();
			options.setPageNumbersToConvert(listPagesToConvert);

			List<PageImage> pages = imageHandler.getPages(guid, options);

			for (PageImage page : pages) {
				Utilities.saveAsImage(page.getPageNumber() + "_" + fileName, "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetImageRepresentationForCustomPages
	}

	/**
	 * Gets image representation of the document with rotation of provided angle
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param rotationAngle
	 *            value of angle
	 */
	public static void renderDocumentAsImage(String fileName, int rotationAngle) {
		// ExStart:RotatePageToNintyDegreeInImageMode
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			// Set rotation angle for page number 3
			RotatePageOptions rotateOptions = new RotatePageOptions(guid, 3, rotationAngle);

			// Perform page rotation
			imageHandler.rotatePage(rotateOptions);

			// Set image options to include Rotate transformations
			ImageOptions imageOptions = new ImageOptions();
			imageOptions.setTransformations(Transformation.Rotate);

			List<PageImage> pages = imageHandler.getPages(guid, imageOptions);

			for (PageImage page : pages) {
				Utilities.saveAsImage(page.getPageNumber() + "_" + fileName, "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:RotatePageToNintyDegreeInImageMode
	}

	/**
	 * Renders document to image excluding transformation
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param excludeTransformation
	 *            excludeTransformation true or false
	 */
	public static void renderDocumentAsImage(String fileName, boolean excludeTransformation) {
		// ExStart:RetrieveAllImagesExcludingTransformation
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			// Set image options NOT to include ANY transformations
			ImageOptions noTransformationsOptions = new ImageOptions();
			// This is set by default
			noTransformationsOptions.setTransformations(Transformation.None);

			// Get image representation of all document pages, without
			// transformations
			List<PageImage> pagesWithoutTransformations = imageHandler.getPages(guid, noTransformationsOptions);

			// Get image representation of all document pages, without
			// transformations
			List<PageImage> pagesWithoutTransformations2 = imageHandler.getPages(guid);
			for (PageImage page : pagesWithoutTransformations) {
				Utilities.saveAsImage(page.getPageNumber() + "_" + fileName, "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:RetrieveAllImagesExcludingTransformation
	}

	/**
	 * Gets image representation of document with reorder
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param pageNumber
	 *            page number that needs to be reordered
	 * @param newPosition
	 *            reorder to a new position
	 * @param isTransformation
	 *            isTransformation is true of false
	 */
	public static void renderDocumentAsImage(String fileName, int pageNumber, int newPosition,
			boolean isTransformation) {
		// ExStart:ReorderFirstAndSecondPagesInImageMode
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			// Perform page reorder
			ReorderPageOptions options = new ReorderPageOptions(guid, pageNumber, newPosition);
			imageHandler.reorderPage(options);

			ImageOptions imageOptions = new ImageOptions();
			imageOptions.setTransformations(Transformation.Reorder);

			List<PageImage> pages = imageHandler.getPages(guid, imageOptions);
			int pageNumberCount = 1;
			for (PageImage page : pages) {
				Utilities.saveAsImage(pageNumberCount + "_" + fileName, "png", page.getStream());
				pageNumberCount++;
			}

		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:ReorderFirstAndSecondPagesInImageMode
	}

	/**
	 * Gets image representation of the document with watermark
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param watermarkText
	 *            text that will appear on the image as watermark
	 */
	public static void renderDocumentAsImage(String fileName, String watermarkText) {
		// ExStart:AddWatermarkToImagePageRepresentation
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();

			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			ImageOptions options = new ImageOptions();

			// Set watermark properties
			Watermark watermark = new Watermark(watermarkText);
			watermark.setColor(Color.blue);
			watermark.setPosition(WatermarkPosition.Diagonal);
			watermark.setWidth(100f);

			options.setWatermark(watermark);

			// Get document pages image representation with watermark
			List<PageImage> pages = imageHandler.getPages(guid, options);
			for (PageImage page : pages) {
				Utilities.saveAsImage(page.getPageNumber() + "_" + fileName, "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:AddWatermarkToImagePageRepresentation
	}

	/**
	 * Gets image representation of the document from relative path
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void renderDocumentAsImageFromRelativePath(String fileName) {
		// ExStart:GetDocumentRepresentationFromRelativePath
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			// Set relative path. So that full path will be
			String guid = fileName;

			// Get pages by absolute path
			List<PageImage> pages = imageHandler.getPages(guid);
			for (PageImage page : pages) {
				Utilities.saveAsImage(page.getPageNumber() + "_" + fileName, "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetDocumentRepresentationFromRelativePath
	}

	/**
	 * Gets image representation of the document from Uri
	 * 
	 * @param URL
	 *            url of the source document/file
	 */
	public static void renderDocumentAsImageFromUri(String URL) {
		// ExStart:GetDocumentRepresentationFromUri
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			URI uri = new URI(URL);

			// Get pages by absolute path
			List<PageImage> pages = imageHandler.getPages(uri);
			for (PageImage page : pages) {
				Utilities.saveAsImage(Integer.toString(page.getPageNumber()), "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetDocumentRepresentationFromUri
	}

	/**
	 * Gets image representation of the document from input stream
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void renderDocumentAsImageFromInputStream(String fileName) {
		// ExStart:GetDocumentRepresentationFromInputStream
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			// Get file stream
			FileInputStream fileStream = new FileInputStream("./Data/Storage/word.docx");

			// Get pages
			List<PageImage> pages = imageHandler.getPages(fileStream,
					"./Data/Storage/tempfile." + Utilities.getFileExtension(fileName));
			for (PageImage page : pages) {
				Utilities.saveAsImage(page.getPageNumber() + "_" + fileName, "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetDocumentRepresentationFromInputStream
	}

	/**
	 * Gets image representation of the document from absolute path
	 * 
	 * @param fileAbsolutePath
	 *            absolute path of the document
	 */
	public static void renderDocumentAsImageFromAbsolutePath(String fileAbsolutePath) {
		// ExStart:GetDocumentRepresentationFromAbsolutePath
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			// Set absolute path to file
			String guid = fileAbsolutePath;

			// Get pages by absolute path
			List<PageImage> pages = imageHandler.getPages(guid);
			for (PageImage page : pages) {
				Utilities.saveAsImage(Integer.toString(page.getPageNumber()), "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetDocumentRepresentationFromAbsolutePath
	}

	public static void renderDocumentAsImageMultipleTransformations(String fileName, int rotationAngle,
			int rotationPageNumber, int reorderPageNumber, int reorderNewPosition) {
		// ExStart:PerformMultipleTransformationsInImageMode
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			// Rotate page
			imageHandler.rotatePage(new RotatePageOptions(guid, rotationPageNumber, rotationAngle));

			// Rotate second page 180 degrees
			// imageHandler.rotatePage(new RotatePageOptions(guid, 2, 180));

			// Reorder pages
			imageHandler.reorderPage(new ReorderPageOptions(guid, reorderPageNumber, reorderNewPosition));

			// Set options to include rotate and reorder transformations
			ImageOptions options = new ImageOptions();
			options.setTransformations(
					Transformation.fromValue(Transformation.Rotate.value() | Transformation.Reorder.value()));

			// Set watermark properties
			Watermark watermark = new Watermark("This is watermark text");
			watermark.setColor(Color.BLUE);
			watermark.setPosition(WatermarkPosition.Diagonal);
			watermark.setWidth(100f);

			options.setWatermark(watermark);

			// Get document pages image representation with multiple
			// transformations
			List<PageImage> pages = imageHandler.getPages(guid, options);
			for (PageImage page : pages) {
				Utilities.saveAsImage(page.getPageNumber() + "_" + fileName, "png", page.getStream());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:PerformMultipleTransformationsInImageMode
	}

	// ============================================================================
	/**
	 * Gets html representation of the document with embedded resource
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void renderDocumentAsHtml(String fileName) {
		// ExStart:GetHtmlRepresentationWithEmbeddedRec
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create html handler
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
			String guid = fileName;

			HtmlOptions options = new HtmlOptions();
			options.setResourcesEmbedded(true);
			List<PageHtml> pages = htmlHandler.getPages(guid, options);

			for (PageHtml page : pages) {
				Utilities.saveAsHtml(page.getPageNumber() + "_" + fileName, page.getHtmlContent());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetHtmlRepresentationWithEmbeddedRec
	}

	/**
	 * Gets html representation of the N consecutive pages
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param pageNumber
	 *            starting page number
	 * @param countPagesToConvert
	 *            total number of pages to convert
	 */
	public static void renderDocumentAsHtml(String fileName, int pageNumber, int countPagesToConvert) {
		// ExStart:GetHtmlRepresentationOfNConsecutiveDocs
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create html handler
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
			String guid = fileName;

			// Options to convert countPagesToConvert consecutive pages starting
			// from pageNumber
			HtmlOptions options = new HtmlOptions();
			options.setPageNumber(pageNumber);
			options.setCountPagesToConvert(countPagesToConvert);
			List<PageHtml> pages = htmlHandler.getPages(guid, options);

			for (PageHtml page : pages) {
				Utilities.saveAsHtml(page.getPageNumber() + "_" + fileName, page.getHtmlContent());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetHtmlRepresentationOfNConsecutiveDocs
	}

	/**
	 * Gets html representation of custom page numbers
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param listPagesToConvert
	 *            list of pages to convert
	 */
	public static void renderDocumentAsHtml(String fileName, List<Integer> listPagesToConvert) {
		// ExStart:GetHtmlRepresentationForCustomPageNumberList
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create html handler
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
			String guid = fileName;

			// Options to convert 1, 3, 5, 6, 8 page numbers
			HtmlOptions options = new HtmlOptions();
			options.setPageNumbersToConvert(listPagesToConvert);

			List<PageHtml> pages = htmlHandler.getPages(guid, options);

			for (PageHtml page : pages) {
				Utilities.saveAsHtml(page.getPageNumber() + "_" + fileName, page.getHtmlContent());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetHtmlRepresentationForCustomPageNumberList
	}

	/**
	 * Gets html representation of the document with rotation
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param rotationAngle
	 *            value of angle
	 */
	public static void renderDocumentAsHtml(String fileName, int rotationAngle) {
		// ExStart:RotatePageToNintyDegreeInHtmlMode
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create html handler
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
			String guid = fileName;

			// Set rotation angle 90 for page number 1
			RotatePageOptions rotateOptions = new RotatePageOptions(guid, 3, rotationAngle);

			// Perform page rotation
			htmlHandler.rotatePage(rotateOptions);
			// Set html options to include rotate transformation
			HtmlOptions options = new HtmlOptions();
			options.setTransformations(Transformation.Rotate);

			// Get All pages
			List<PageHtml> pages = htmlHandler.getPages(guid, options);

			// Save pages
			for (PageHtml page : pages) {
				Utilities.saveAsHtml(page.getPageNumber() + "_" + fileName, page.getHtmlContent());
			}

		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:RotatePageToNintyDegreeInHtmlMode
	}

	/**
	 * Renders document as html with reorder
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param pageNumber
	 *            page number that needs to be reordered
	 * @param newPosition
	 *            reorder to a new position
	 * @param isTransformation
	 *            isTransformation can be true or false
	 */
	public static void renderDocumentAsHtml(String fileName, int pageNumber, int newPosition,
			boolean isTransformation) {
		// ExStart:ReorderFirstAndSecondPagesInHtmlMode
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();

			// Create html handler
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
			String guid = fileName;

			// Perform page reorder
			ReorderPageOptions options = new ReorderPageOptions(guid, pageNumber, newPosition);
			htmlHandler.reorderPage(options);

			// Set image options to include reorder transformations
			HtmlOptions htmlOptions = new HtmlOptions();
			htmlOptions.setTransformations(Transformation.Reorder);

			// Get html representation of all document pages, including rotate
			// transformations
			List<PageHtml> pages = htmlHandler.getPages(guid, htmlOptions);
			int pageNumberCount = 1;
			for (PageHtml page : pages) {
				Utilities.saveAsHtml(pageNumberCount + "_" + fileName, page.getHtmlContent());
				pageNumberCount++;
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:ReorderFirstAndSecondPagesInHtmlMode
	}

	/**
	 * Gets html representation of the document with watermark
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param watermarkText
	 *            text that will show on the image as watermark
	 */
	public static void renderDocumentAsHtml(String fileName, String watermarkText) {
		// ExStart:AddWatermarkToHtmlPageRepresentation
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create html handler
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
			String guid = fileName;

			HtmlOptions options = new HtmlOptions();

			// Set watermark properties
			Watermark watermark = new Watermark(watermarkText);
			watermark.setColor(Color.blue);
			watermark.setPosition(WatermarkPosition.Diagonal);
			watermark.setWidth(100f);

			options.setWatermark(watermark);

			// Get document pages html representation with watermark
			List<PageHtml> pages = htmlHandler.getPages(guid, options);
			for (PageHtml page : pages) {
				Utilities.saveAsHtml(page.getPageNumber() + "_" + fileName, page.getHtmlContent());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:AddWatermarkToHtmlPageRepresentation
	}

	/**
	 * Gets html representation of document excluding transformation
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param excludeTransformation
	 *            excludeTransformation true or false
	 */
	public static void renderDocumentAsHtml(String fileName, boolean excludeTransformation) {
		// ExStart:RetrieveAllHtmlPagesExludingTransformation
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create html handler
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
			String guid = fileName;

			// Set html options to include rotate transformation
			HtmlOptions noTransformationsOptions = new HtmlOptions();
			noTransformationsOptions.setTransformations(Transformation.None);

			// Get html representation of all document pages, without
			// transformations
			List<PageHtml> pagesWithoutTransformations = htmlHandler.getPages(guid, noTransformationsOptions);

			// Get html representation of all document pages, without
			// transformations
			List<PageHtml> pagesWithoutTransformations2 = htmlHandler.getPages(guid);
			for (PageHtml page : pagesWithoutTransformations) {
				Utilities.saveAsHtml(page.getPageNumber() + "_" + fileName, page.getHtmlContent());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:RetrieveAllHtmlPagesExludingTransformation
	}

	/**
	 * Gets printable html representation of the document
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void renderDocumentAsHtmlForPrint(String fileName) {
		// ExStart:GetDocumentHtmlForPrint
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			// Get document html for print
			PrintableHtmlOptions options = new PrintableHtmlOptions(guid);
			PrintableHtmlContainer container = imageHandler.getPrintableHtml(options);

			// Save as html
			Utilities.saveAsHtml(fileName, container.getHtmlContent());

		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetDocumentHtmlForPrint
	}

	/**
	 * Gets printable html representation of the document with watermark
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param watermarkText
	 *            text that will appear as watermark
	 */
	public static void renderDocumentAsHtmlForPrint(String fileName, String watermarkText) {
		// ExStart:GetDocumentHtmlForPrintWithWatermark
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			// Set watermark properties
			Watermark watermark = new Watermark(watermarkText);
			watermark.setColor(Color.BLUE);
			watermark.setPosition(WatermarkPosition.Diagonal);
			watermark.setWidth(100f);
			// Get document html for print with watermark
			PrintableHtmlOptions options = new PrintableHtmlOptions(guid, watermark);
			PrintableHtmlContainer container = imageHandler.getPrintableHtml(options);

			// Save as html
			Utilities.saveAsHtml(fileName, container.getHtmlContent());
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetDocumentHtmlForPrintWithWatermark
	}

	/**
	 * Gets printable html representation of the document with custom CSS
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void renderDocumentAsHtmlForPrintWithCustomCss(String fileName) {
		// ExStart:GetDocumentHtmlForPrintWithCustomCss
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();

			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);
			String guid = fileName;

			// Get document html for print with custom css
			String css = "a { color: hotpink; }"; // Some style
			PrintableHtmlOptions options = new PrintableHtmlOptions(guid, css);
			PrintableHtmlContainer container = imageHandler.getPrintableHtml(options);

			// Save as html
			Utilities.saveAsHtml(fileName, container.getHtmlContent());
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetDocumentHtmlForPrintWithCustomCss
	}

	public static void renderDocumentAsHtmlMultipleTransformations(String fileName, int rotationAngle,
			int rotationPageNumber, int reorderPageNumber, int reorderNewPosition) {
		// ExStart:PerformMultipleTransformationsInHtmlMode
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create html handler
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
			String guid = fileName;

			// Rotate page
			htmlHandler.rotatePage(new RotatePageOptions(guid, rotationPageNumber, rotationAngle));

			// Rotate second page 180 degrees
			htmlHandler.rotatePage(new RotatePageOptions(guid, 2, 180));

			// Reorder pages
			htmlHandler.reorderPage(new ReorderPageOptions(guid, reorderPageNumber, reorderNewPosition));

			// Set options to include rotate and reorder transformations
			HtmlOptions options = new HtmlOptions();
			options.setTransformations(
					Transformation.fromValue(Transformation.Rotate.value() | Transformation.Reorder.value()));

			// Set watermark properties
			Watermark watermark = new Watermark("This is watermark text");
			watermark.setColor(Color.BLUE);
			watermark.setPosition(WatermarkPosition.Diagonal);
			watermark.setWidth(100f);

			options.setWatermark(watermark);

			// Get document pages html representation with multiple
			// transformations
			List<PageHtml> pages = htmlHandler.getPages(guid, options);
			for (PageHtml page : pages) {
				Utilities.saveAsHtml(page.getPageNumber() + "_" + fileName, page.getHtmlContent());
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:PerformMultipleTransformationsInHtmlMode
	}

	/**
	 * Gets resource stream of html representation of the document
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void getDocumentHtmlResourceStream(String fileName) {
		// ExStart:GetHtmlResourceStream
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create html handler
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
			String guid = fileName;

			List<PageHtml> pages = htmlHandler.getPages(guid);

			for (PageHtml page : pages) {
				System.out.println("Page number: " + page.getPageNumber());
				System.out.println("Resources count: " + page.getHtmlResources().size());
				System.out.println("Html content: " + page.getHtmlContent());

				// Html resources descriptions
				for (HtmlResource resource : page.getHtmlResources()) {
					System.out.println(resource.getResourceName() + resource.getResourceType());

					// Get html page resource stream
					InputStream resourceStream = htmlHandler.getResource(guid, resource);
					System.out.println("Stream size: " + resourceStream.available());
				}
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetHtmlResourceStream
	}

	// ===================================================================================
	/**
	 * Saves original file
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void getOriginalFile(String fileName) {
		// ExStart:GetOriginalFile
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			String guid = fileName;

			// Get file in container
			FileContainer container = imageHandler.getFile(guid);

			// Save file
			Utilities.saveAsFile(fileName, container.getStream());

		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetOriginalFile
	}

	/**
	 * Gets original file as pdf without any transformation
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void getOriginalFileAsPdf(String fileName) {
		// ExStart:GetOriginalPdfDocWithoutTransformation
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			// Set PDF file options
			PdfFileOptions options = new PdfFileOptions();
			options.setGuid(fileName);

			// Get file as pdf
			FileContainer container = imageHandler.getPdfFile(options);

			// Save file
			Utilities.saveAsFile(fileName, container.getStream(), ".pdf");

		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetOriginalPdfDocWithoutTransformation
	}

	/**
	 * Gets original file as pdf along with watermark
	 * 
	 * @param fileName
	 *            name of the source document
	 * @param watermarkText
	 *            text that will appear on the document as watermark
	 */
	public static void getOriginalFileAsPdfWithWatermark(String fileName, String watermarkText) {
		// ExStart:GetOriginalPdfDocWithWatermark
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			// Set PDF file options
			PdfFileOptions options = new PdfFileOptions();
			options.setGuid(fileName);

			// Set watermark properties
			Watermark watermark = new Watermark(watermarkText);
			watermark.setColor(Color.BLUE);
			watermark.setPosition(WatermarkPosition.Diagonal);
			watermark.setWidth(100f);

			options.setWatermark(watermark);

			// Get file as pdf with watermaks
			FileContainer container = imageHandler.getPdfFile(options);

			// Save file
			Utilities.saveAsFile(fileName, container.getStream(), ".pdf");
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetOriginalPdfDocWithWatermark
	}

	/**
	 * Gets original file as pdf with print action
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void getOriginalFileAsPdfWithPrintAction(String fileName) {
		// ExStart:GetOriginalPdfDocWithPrintAction
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			PdfFileOptions options = new PdfFileOptions();
			options.setGuid(fileName);

			// Set add print action property
			options.setAddPrintAction(true);

			// Get file as pdf with print action
			FileContainer container = imageHandler.getPdfFile(options);
			Utilities.saveAsFile(fileName, container.getStream(), ".pdf");
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetOriginalPdfDocWithPrintAction
	}

	/**
	 * Gets original file as pdf with transformations
	 * 
	 * @param fileName
	 *            name of the source document
	 */
	public static void getOriginalFileAsPdfWithTransformation(String fileName) {
		// ExStart:GetOriginalPdfDocWithTransformation
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			PdfFileOptions options = new PdfFileOptions();
			options.setGuid(fileName);

			RotatePageOptions rotateOptions = new RotatePageOptions(fileName, 1, 90);

			imageHandler.rotatePage(rotateOptions);
			// Set apply rotate and reorder transformations
			options.setTransformations(Transformation.Rotate);

			Watermark watermark = new Watermark("Watermark text.");
			watermark.setColor(Color.blue);
			watermark.setPosition(WatermarkPosition.Diagonal);
			watermark.setWidth(100f);

			options.setWatermark(watermark);
			// Get file as pdf with transformations
			FileContainer container = imageHandler.getPdfFile(options);

			// Save file
			Utilities.saveAsFile(fileName, container.getStream(), ".pdf");
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:GetOriginalPdfDocWithTransformation
	}

	/**
	 * Loads file tree list for the storage path
	 * 
	 */
	public static void loadFileTreeList() {
		// ExStart:LoadFileTreeListForStoragePath
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			// Load file tree list for ViewerConfig.StoragePath
			FileTreeContainer container = imageHandler.loadFileTree();

			for (FileDescription node : container.getFileTree()) {
				if (node.isDirectory()) {
					System.out.println("Guid: " + node.getGuid() + " | Name: " + node.getName()
							+ " | LastModificationDate: " + node.getLastModificationDate());
				} else {
					System.out.println("Guid: " + node.getGuid() + " | Name: " + node.getName() + " | Document type: "
							+ node.getDocumentType() + " | File type: " + node.getFileType() + " | Extension: "
							+ node.getExtension() + " | Size: " + node.getSize() + " | LastModificationDate: "
							+ node.getLastModificationDate());
				}
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:LoadFileTreeListForStoragePath
	}

	/**
	 * Loads file tree list for the custom storage path
	 * 
	 * @param customPath
	 *            customPath of the storage
	 */
	public static void loadFileTreeList(String customPath) {
		// ExStart:LoadFileTreeListForCustomPath
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			// Load file tree list for custom path
			FileTreeOptions options = new FileTreeOptions(customPath);

			FileTreeContainer container = imageHandler.loadFileTree(options);

			for (FileDescription node : container.getFileTree()) {
				if (node.isDirectory()) {
					System.out.println("Guid: " + node.getGuid() + " | Name: " + node.getName()
							+ " | LastModificationDate: " + node.getLastModificationDate());
				} else {
					System.out.println("Guid: " + node.getGuid() + " | Name: " + node.getName() + " | Document type: "
							+ node.getDocumentType() + " | File type: " + node.getFileType() + " | Extension: "
							+ node.getExtension() + " | Size: " + node.getSize() + " | LastModificationDate: "
							+ node.getLastModificationDate());
				}
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:LoadFileTreeListForCustomPath
	}

	/**
	 * Loads ordered file tree list for the custom storage path with order
	 * 
	 * @param customPath
	 *            customPath of the storage
	 */
	public static void loadFileTreeListWithOrder(String customPath) {
		// ExStart:loadFileTreeListForCustomPathWithOrder
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();
			// Create image handler
			ViewerImageHandler imageHandler = new ViewerImageHandler(config);

			// Load file tree list ordered by Name field for custom path
			FileTreeOptions options = new FileTreeOptions(customPath, FileTreeOptions.FileTreeOrderBy.Name, true);

			FileTreeContainer container = imageHandler.loadFileTree(options);

			for (FileDescription node : container.getFileTree()) {
				if (node.isDirectory()) {
					System.out.println("Guid: " + node.getGuid() + " | Name: " + node.getName()
							+ " | LastModificationDate: " + node.getLastModificationDate());
				} else {
					System.out.println("Guid: " + node.getGuid() + " | Name: " + node.getName() + " | Document type: "
							+ node.getDocumentType() + " | File type: " + node.getFileType() + " | Extension: "
							+ node.getExtension() + " | Size: " + node.getSize() + " | LastModificationDate: "
							+ node.getLastModificationDate());
				}
			}
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd:LoadFileTreeListForCustomPathWithOrder
	}

	/**
	 * Renders document with CustomInputDataHandler
	 * 
	 * @param fileName
	 *            name of the document
	 */
	public static void renderDocumentWithCustomDataHandler(String fileName) {
		// ExStart: RenderDocumentWithCustomDataHandler
		try {
			// Setup GroupDocs.Viewer config
			ViewerConfig config = Utilities.getConfiguration();

			// File guid
			String guid = fileName;

			// Use custom IInputDataHandler implementation
			IInputDataHandler inputDataHandler = new AzureInputDataHandler("<Account_Name>", "<Account_Key>",
					"<Container_Name>");

			// Get file HTML representation
			ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config, inputDataHandler);

			List<PageHtml> pages = htmlHandler.getPages(guid);
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		// ExEnd: RenderDocumentWithCustomDataHandler
	}

}
