package com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets;

import com.groupdocs.examples.viewer.utils.FilesUtils;
import com.groupdocs.viewer.FileType;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.*;

import java.nio.file.Path;

/**
 * This example demonstrates how to render Excel 2003 SpreadSheetML XML document into HTML, JPG, PNG, PDF.
 */
public class RenderingXmlSpreadSheetML {
    public static void run(Path inputFile) {
        Path outputDirectory = FilesUtils.makeOutputPath("RenderingXmlSpreadSheetML");
        Path pageFileFullPath = outputDirectory.resolve("Excel_2003_Xml_result.html");

        /* Because the XML extension is associated with both an XML text document and Excel 2003 XML SpreadSheetML,
         * please specify the Excel2003XML fileType explicitly to render it as Excel 2003 XML SpreadSheetML.
         */

        LoadOptions loadOptions = new LoadOptions(FileType.EXCEL_2003_XML);

        // TO MULTI PAGES HTML
        try (Viewer viewer = new Viewer(inputFile, loadOptions)) {
            HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFileFullPath);

            viewer.view(options);
        }

        // TO JPG
        pageFileFullPath = outputDirectory.resolve("Excel_2003_Xml_result.jpg");

        try (Viewer viewer = new Viewer(inputFile, loadOptions)) {
            JpgViewOptions options = new JpgViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        // TO PNG
        pageFileFullPath = outputDirectory.resolve("Excel_2003_Xml_result.png");

        try (Viewer viewer = new Viewer(inputFile, loadOptions)) {
            PngViewOptions options = new PngViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        // TO PDF
        pageFileFullPath = outputDirectory.resolve("Excel_2003_Xml_result.pdf");

        try (Viewer viewer = new Viewer(inputFile, loadOptions)) {
            PdfViewOptions options = new PdfViewOptions(pageFileFullPath);

            viewer.view(options);
        }

        System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory);
    }
}
