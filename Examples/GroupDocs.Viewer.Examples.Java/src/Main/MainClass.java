package Main;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.groupdocs.viewer.config.ViewerConfig;
import com.groupdocs.viewer.converter.options.HtmlOptions;
import com.groupdocs.viewer.converter.options.ImageOptions;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.containers.DocumentFormatsContainer;
import com.groupdocs.viewer.domain.containers.DocumentInfoContainer;
import com.groupdocs.viewer.domain.containers.FileContainer;
import com.groupdocs.viewer.domain.html.PageHtml;
import com.groupdocs.viewer.domain.image.PageImage;
import com.groupdocs.viewer.domain.options.DocumentInfoOptions;
import com.groupdocs.viewer.domain.options.PdfFileOptions;
import com.groupdocs.viewer.handler.ViewerHandler;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;
import com.groupdocs.viewer.handler.ViewerImageHandler;

public class MainClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Set license.
		 * Uncomment following code if you have license file
		 */
		//Utilities.applyLicenseFromFile("D:\\GroupDocs.Viewer.Java.lic");

		//// Get document information
		//ViewGenerator.renderDocumentInformation("demo.docx");
		 
		//// Render document as image
		//ViewGenerator.renderDocumentAsImage("word.docx");
		 
		//// Render n consecutive pages as image
		//ViewGenerator.renderDocumentAsImage("word.docx", 1, 1);
		 
		//// Render custom page numbers as images
		//ArrayList<Integer> pagesToConvert = new ArrayList<Integer>();
		//Collections.addAll(pagesToConvert, 1, 3);
		//ViewGenerator.renderDocumentAsImage("word.docx", pagesToConvert);
		 
		//// Render as image with rotation
		//ViewGenerator.renderDocumentAsImage("word.docx", 90);
		 
		//// Render as image with watermark
		//ViewGenerator.renderDocumentAsImage("word.docx", "test watermark");
		 
		//// Render document as html
		//ViewGenerator.renderDocumentAsHtml("utf.docx");
		 
		//// Get html resource stream
		//ViewGenerator.getDocumentHtmlResourceStream("word.docx");
		 
		//// Render n consecutive pages as html
		//ViewGenerator.renderDocumentAsHtml("word.docx", 2, 1);
		 
		//// Render as html with custom page numbers
		//ArrayList<Integer> pagesToConvert2 = new ArrayList<Integer>();
		//Collections.addAll(pagesToConvert2, 2, 3);
		//ViewGenerator.renderDocumentAsHtml("word.docx", pagesToConvert);
		 
		//// Render as html with rotation
		//ViewGenerator.renderDocumentAsHtml("word.docx", 180);
		 
		//// Render as html with reorder
		//ViewGenerator.renderDocumentAsHtml("word.docx", 2, 3, true);
		 
		//// Render as html with watermark
		//ViewGenerator.renderDocumentAsHtml("word.docx", "test watermark");
		 
		//// Render as html excluding all html transformation
		//ViewGenerator.renderDocumentAsHtml("word.docx", true);
		 
		//// Render as image with multiple transformations
		//ViewGenerator.renderDocumentAsImageMultipleTransformations("word.docx",90, 1, 3, 4);
		 
		//// Render as html multiple transformation
		//ViewGenerator.renderDocumentAsHtmlMultipleTransformations("word.docx",90,1, 3, 4);
		 
		//// Save original file
		//ViewGenerator.getOriginalFile("word.docx");
		 
		//// Get original pdf file
		//ViewGenerator.getOriginalFileAsPdf("word.docx");
		 
		//// Get original pdf file with watermark
		//ViewGenerator.getOriginalFileAsPdfWithWatermark("word.docx", "test watermark");
		 
		//// Get original pdf file with print action
		//ViewGenerator.getOriginalFileAsPdfWithPrintAction("word.docx");
		 
		//// Get original pdf file with transformations
		//ViewGenerator.getOriginalFileAsPdfWithTransformation("word.docx");
		 
		//// Render as image from absolute path
		//ViewGenerator.renderDocumentAsImageFromAbsolutePath("D:/storage/word.docx");
		 
		//// Render as image from relative path
		//ViewGenerator.renderDocumentAsImageFromRelativePath("word.docx");
		 
		//// Render as image from uri
		//ViewGenerator.renderDocumentAsImageFromUri("http://serviceerette.ainigmadev.com/logo.png");
		 
		//// Render as image from input stream
		//ViewGenerator.renderDocumentAsImageFromInputStream("word.docx");
		 
		//// Render as image excluding transformation
		//ViewGenerator.renderDocumentAsImage("word.docx", true);
		 
		//// Render as image with reorder
		//ViewGenerator.renderDocumentAsImage("word.docx", 1, 3, false);
		 
		//// Load file tree list
		//ViewGenerator.loadFileTreeList();
		 
		//// Load file tree list for the custom path
		//ViewGenerator.loadFileTreeList("D:/storage/");
		 
		//// Load ordered file tree list for the custom path
		//ViewGenerator.loadFileTreeListWithOrder("D:/storage");
		 
		//// Render as printable html
		//ViewGenerator.renderDocumentAsHtmlForPrint("word.docx");
		 
		//// Render as html with watermark
		//ViewGenerator.renderDocumentAsHtmlForPrint("word.docx", "test");
		 
		//// Render as html with custom css
		//ViewGenerator.renderDocumentAsHtmlForPrintWithCustomCss("word.docx");
		 
		//// Render document as html
		//ViewGenerator.renderDocumentAsHtml("word.docx");
		 
		//// Render as html with page range
		//ViewGenerator.renderDocumentAsHtml("word.docx", 1, 3);
		 
		//// Render as html with custom input data handler
		//ViewGenerator.renderDocumentWithCustomDataHandler("word.docx");

		//// Render as image with grid lines
		//ViewGenerator.renderExcelAsImageWithGridLines("sample.xlsx");
		
		//// Render as html with custom input data handler
		//ViewGenerator.renderExcelAsHtmlWithGridLines("sample.xlsx") ;

		//// Render as html with multiple sheets per page
		//ViewGenerator.renderExcelAsHtmlWithMultiplePagesPerSheet("sample.xlsx") ;

		//// Get all supported formats 
		//ViewGenerator.getAllSupportedFormats() ;

		//// Render as image with hidden sheets
		//ViewGenerator.renderExcelAsImageWithHiddenSheets("sample.xlsx");

		//// Render as image with hidden sheet 2
		//ViewGenerator.renderExcelAsImageWithHiddenSheets2("sample.xlsx") ;

		//// Set locales path
		//ViewGenerator.setLocalesPath();

		//// Set documents encoding 
		//ViewGenerator.setDocumentEncoding();
	}
}
