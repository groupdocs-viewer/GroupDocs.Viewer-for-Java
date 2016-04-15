package Main;

import java.util.ArrayList;
import java.util.Collections;

public class MainClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Set license Uncomment following code if you have license file
		 */
		Utilities.ApplyLicenseFromFile("D:\\GroupDocs.Viewer.Java.lic");

//		// Get document information
//		ViewGenerator.RenderDocumentInformation("word.docx");
//
//		// Render document as image
//		ViewGenerator.RenderDocumentAsImage("word.docx");
//
//		// Render n consecutive pages as image
//		ViewGenerator.RenderDocumentAsImage("word.docx", 1, 1);
//
//		// Render custom page numbers as images
//		ArrayList<Integer> pagesToConvert = new ArrayList<Integer>();
//		Collections.addAll(pagesToConvert, 1, 3);
//		ViewGenerator.RenderDocumentAsImage("word.docx", pagesToConvert);
//
//		// Render as image with rotation
//		ViewGenerator.RenderDocumentAsImage("word.docx", 90);
//
//		// Render as image with watermark
	//	ViewGenerator.RenderDocumentAsImage("word.docx", "test watermark");
//
//		// Render document as html
//		ViewGenerator.RenderDocumentAsHtml("word.docx");
//
//		// Get html resource stream
		//ViewGenerator.GetDocumentHtmlResourceStream("word.docx");
//
//		// Render n consecutive pages as html
//		ViewGenerator.RenderDocumentAsHtml("word.docx", 2, 1);
//
//		// Render as html with custom page numbers
//		ArrayList<Integer> pagesToConvert2 = new ArrayList<Integer>();
//		Collections.addAll(pagesToConvert2, 2, 3);
//		ViewGenerator.RenderDocumentAsHtml("word.docx", pagesToConvert);
//
//		// Render as html with rotation
//		ViewGenerator.RenderDocumentAsHtml("word.docx", 180);
//
//		// Render as html with reorder
//		ViewGenerator.RenderDocumentAsHtml("word.docx", 2, 3, true);
//
//		// Render as html with watermark
//		ViewGenerator.RenderDocumentAsHtml("word.docx", "test watermark");
//
//		// Render as html excluding all html transformation
//		ViewGenerator.RenderDocumentAsHtml("word.docx", true);
//
//		// Render as image with multiple transformations
//		ViewGenerator.RenderDocumentAsImageMultipleTransformations("word.docx", 90, 1, 3, 4);
//
//		// Render as html multiple transformation
//		ViewGenerator.RenderDocumentAsHtmlMultipleTransformations("word.docx", 90, 1, 3, 4);
//
//		// Save original file
	//	ViewGenerator.GetOriginalFile("word.docx");
//
//		// Get original pdf file
	//	ViewGenerator.GetOriginalFileAsPdf("word.docx");
//
//		// Get original pdf file with watermark
//		ViewGenerator.GetOriginalFileAsPdfWithWatermark("word.docx", "test watermark");
//
//		// Get original pdf file with print action
	//	ViewGenerator.GetOriginalFileAsPdfWithPrintAction("word.docx");
//
//		// Get original pdf file with transformations
		ViewGenerator.GetOriginalFileAsPdfWithTransformation("word.docx");
//
//		// Render as image from absolute path
//		ViewGenerator.RenderDocumentAsImageFromAbsolutePath("D:/storage/word.docx");
//
//		// Render as image from relative path
//		ViewGenerator.RenderDocumentAsImageFromRelativePath("word.docx");
//
//		// Render as image from uri
//		ViewGenerator.RenderDocumentAsImageFromUri("http://serviceerette.ainigmadev.com/logo.png");
//
//		// Render as image from input stream
//		ViewGenerator.RenderDocumentAsImageFromInputStream("word.docx");
//
//		// Render as image excluding transformation
//		ViewGenerator.RenderDocumentAsImage("word.docx", true);
//
//		// Render as image with reorder
//		ViewGenerator.RenderDocumentAsImage("word.docx", 1, 3, false);
//
//		// Load file tree list
	//ViewGenerator.LoadFileTreeList();
//
//		// Load file tree list for the custom path
//		ViewGenerator.LoadFileTreeList("D:/storage/");
//
//		// Load ordered file tree list for the custom path
//		ViewGenerator.LoadFileTreeListWithOrder("D:/storage");
//
//		// Render as printable html
//		ViewGenerator.RenderDocumentAsHtmlForPrint("word.docx");
//
//		// Render as html with watermark
//		ViewGenerator.RenderDocumentAsHtmlForPrint("word.docx", "test");
//
//		// Render as html with custom css
//		ViewGenerator.RenderDocumentAsHtmlForPrintWithCustomCss("word.docx");
//
//		// Render document as html
//		ViewGenerator.RenderDocumentAsHtml("word.docx");
//
//		// Render as html with page range
//		ViewGenerator.RenderDocumentAsHtml("word.docx", 1, 3);
//
//		// Render as html with custom input data handler
//		ViewGenerator.RenderDocumentWithCustomDataHandler("word.docx");

	}
}
