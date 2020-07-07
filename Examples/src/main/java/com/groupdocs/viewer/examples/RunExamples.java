package com.groupdocs.viewer.examples;

import com.groupdocs.viewer.examples.advanced_usage.caching.*;
import com.groupdocs.viewer.examples.advanced_usage.loading.*;
import com.groupdocs.viewer.examples.advanced_usage.loading.loading_documents_from_different_sources.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_word_processing_documents.*;
import com.groupdocs.viewer.examples.basic_usage.*;
import com.groupdocs.viewer.examples.basic_usage.processing_attachments.*;
import com.groupdocs.viewer.examples.basic_usage.render_document_to_html.*;
import com.groupdocs.viewer.examples.basic_usage.render_document_to_image.*;
import com.groupdocs.viewer.examples.basic_usage.render_document_to_pdf.*;
import com.groupdocs.viewer.examples.quick_start.*;

import java.io.IOException;

public class RunExamples {

    /**
     * The main method.
     */

    public static void main(String[] args) throws IOException {

        System.out.println("Uncomment the example(s) that you want to run in RunExamples.java file.");
        System.out.println("=======================================================================");

        // Quick Start
        SetLicenseFromFile.run();
        //SetLicenseFromStream.run();
        //SetMeteredLicense.run();
        HelloWorld.run();

        // Basic Usage
        //GetSupportedFileFormats.run();
        //HowToDetermineFileType.fromFileExtension();
        //GetViewInfo.run();

        // Processing attachments
        //RetrieveAndPrintDocumentAttachments.run(); 
        //RetrieveAndSaveDocumentAttachments.run(); 
        //RenderDocumentAttachments.run(); 

        // Render document to HTML
        //RenderToHtmlWithEmbeddedResources.run(); 
        //RenderToHtmlWithExternalResources.run(); 
        //ExcludingFontsFromOutputHtml.run(); 
        //MinifyHtmlDocument.run(); 
        //RenderToResponsiveHtml.run(); 

        // Render document to Image
        //RenderToPng.run(); 
        //RenderToJpg.run(); 
        //GetTextCoordinates.run(); 
        //RenderForDisplayWithText.run(); 
        //AdjustQualityWhenRenderingToJpg.run(); 
        //AdjustImageSize.run();

        // Render document to PDF
        //RenderToPdf.run(); 
        //AdjustQualityOfJpgImages.run(); 
        //ProtectPdfDocument.run(); 

        // Advanced Usage
        // Common rendering options
        //AddWatermark.run(); 
        //RenderDocumentWithComments.run(); 
        //RenderDocumentWithNotes.run(); 
        //RenderHiddenPages.run();
        //RenderNConsecutivePages.run(); 
        //RenderSelectedPages.run(); 
        //ReplaceMissingFont.run(); 
        //ReorderPages.run(); 
        //RenderWithCustomFonts.run(); 
        //RotatePages.run(); 

        // Rendering options by document type
        // Rendering Archive Files
        //GetViewInfoForArchiveFile.run(); 
        //RenderArchiveFolder.run(); 

        // Rendering CAD Drawings
        //GetViewInfoForCadDrawing.run(); 
        //RenderAllLayouts.run(); 
        //RenderLayers.run(); 
        //RenderSingleLayout.run(); 
        //SplitDrawingIntoTiles.run(); 
        //AdjustOutputImageSize.run(); 

        // Rendering E-Mail Messages
        //AdjustPageSize.run(); 
        //RenameEmailFields.run(); 

        // Rendering Outlook Data Files
        //FilterMessages.run(); 
        //GetViewInfoForOutlookDataFile.run(); 
        //LimitCountOfItemsToRender.run(); 
        //RenderOutlookDataFileFolder.run(); 

        // Rendering PDF Documents
        //AdjustImageQuality.run(); 
        //DisableCharactersGrouping.run(); 
        //EnableFontHinting.run(); 
        //EnableLayeredRendering.run(); 
        //GetViewInfoForPdfDocument.run(); 

        // Rendering MS Project Documents
        //AdjustTimeUnit.run(); 
        //GetViewInfoForProjectDocument.run(); 
        //RenderProjectTimeInterval.run(); 

        // Rendering Spreadsheets
        //AdjustTextOverflowInCells.run(); 
        //RenderGridLines.run(); 
        //RenderHiddenRowsAndColumns.run(); 
        //RenderPrintAreas.run(); 
        //SkipRenderingOfEmptyColumns.run(); 
        //SkipRenderingOfEmptyRows.run(); 
        //SplitWorksheetsIntoPages.run(); 

        // Rendering Word Processing Documents
        //RenderTrackedChanges.run(); 

        // Caching
        //UseCacheWhenProcessingDocuments.run(); 

        // Loading
        //LoadPasswordProtectedDocument.run(); 
        //LoadDocumentsWithCharset.run(); 
        //SpecifyFileTypeWhenLoadingDocument.run(); 

        // Loading documents from different sources
        //LoadDocumentFromLocalDisk.run(); 
        //LoadDocumentFromStream.run(); 
        //LoadDocumentFromUrl.run(); 
//        LoadDocumentFromFtp.run();

        System.out.println();
        System.out.println("All done.");
    }
}
