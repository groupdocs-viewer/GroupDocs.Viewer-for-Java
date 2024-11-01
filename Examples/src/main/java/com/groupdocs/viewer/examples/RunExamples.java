package com.groupdocs.viewer.examples;

import com.groupdocs.viewer.examples.advanced_usage.caching.UseCacheWhenProcessingDocuments;
import com.groupdocs.viewer.examples.advanced_usage.caching.UseCustomCacheImplementation;
import com.groupdocs.viewer.examples.advanced_usage.loading.*;
import com.groupdocs.viewer.examples.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromLocalDisk;
import com.groupdocs.viewer.examples.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromStream;
import com.groupdocs.viewer.examples.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromUrl;
import com.groupdocs.viewer.examples.advanced_usage.rendering.common_rendering_options.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages.AdjustPageSize;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages.DateTimeFormatAndTimeZoneOffset;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages.RenameEmailFields;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_image_files.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents.AdjustTimeUnit;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents.GetViewInfoForProjectDocument;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents.RenderProjectTimeInterval;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files.FilterMessages;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files.GetViewInfoForOutlookDataFile;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files.LimitCountOfItemsToRender;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files.RenderOutlookDataFileFolder;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_presentation_documents.RenderingFodp;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets.*;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_text_documents.RenderingTxt;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_web_documents.RenderingChmFiles;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_web_documents.RenderingHtmlWithUserDefinedMargins;
import com.groupdocs.viewer.examples.advanced_usage.rendering.rendering_options_by_document_type.rendering_word_processing_documents.RenderTrackedChanges;
import com.groupdocs.viewer.examples.basic_usage.CheckFileIsEncrypted;
import com.groupdocs.viewer.examples.basic_usage.GetSupportedFileFormats;
import com.groupdocs.viewer.examples.basic_usage.GetViewInfo;
import com.groupdocs.viewer.examples.basic_usage.extract_text.ExtractTextFromPdfFile;
import com.groupdocs.viewer.examples.basic_usage.processing_attachments.RenderDocumentAttachments;
import com.groupdocs.viewer.examples.basic_usage.processing_attachments.RetrieveAndPrintDocumentAttachments;
import com.groupdocs.viewer.examples.basic_usage.processing_attachments.RetrieveAndSaveDocumentAttachments;
import com.groupdocs.viewer.examples.basic_usage.render_document_to_html.*;
import com.groupdocs.viewer.examples.basic_usage.render_document_to_image.*;
import com.groupdocs.viewer.examples.basic_usage.render_document_to_pdf.AdjustQualityOfJpgImages;
import com.groupdocs.viewer.examples.basic_usage.render_document_to_pdf.GetPdfStream;
import com.groupdocs.viewer.examples.basic_usage.render_document_to_pdf.ProtectPdfDocument;
import com.groupdocs.viewer.examples.basic_usage.render_document_to_pdf.RenderToPdf;
import com.groupdocs.viewer.examples.howto.HowToDetermineFileType;
import com.groupdocs.viewer.examples.howto.HowToLogging;
import com.groupdocs.viewer.examples.quick_start.HelloWorld;
import com.groupdocs.viewer.examples.quick_start.SetLicenseFromUrl;

import java.io.IOException;
import java.util.Locale;

public class RunExamples {

    /**
     * The main method.
     */
    public static void main(String[] args) throws IOException {

        System.out.println("Uncomment the example(s) that you want to run in RunExamples.java file.");
        System.out.println("=======================================================================");

        Utils.cleanOutputDirectory();
        Locale.setDefault(Locale.US);

        // region Quick Start

//        SetLicenseFromFile.run();
//        SetLicenseFromStream.run();
        SetLicenseFromUrl.run();
//        SetMeteredLicense.run();
        HelloWorld.run();

        // endregion

        // region Basic Usage

        GetSupportedFileFormats.run();
        GetViewInfo.run();
        CheckFileIsEncrypted.run();

        // region Processing attachments

        RetrieveAndPrintDocumentAttachments.run();
        RetrieveAndSaveDocumentAttachments.run();
        RenderDocumentAttachments.run();

        // endregion

        // region Render document to HTML

        RenderToHtmlWithEmbeddedResources.run();
        RenderToHtmlWithExternalResources.run();

        ExcludingFontsFromOutputHtml.run();
        MinifyHtmlDocument.run();
        RenderToResponsiveHtml.run();

        // endregion

        // region Render document to Image

        RenderToPng.run();
        RenderToJpg.run();

        GetTextCoordinates.run();
        RenderForDisplayWithText.run();
        AdjustQualityWhenRenderingToJpg.run();
        AdjustImageSize.run();
        RenderingWmzAndWmf.run();
        RenderingEmzAndEmf.run();
        RenderingCdr.run();
        RenderingCmx.run();
        RenderingAi.run();
        RenderingTga.run();
        RenderingApng.run();

        // endregion

        // region Render document to PDF

        RenderToPdf.run();
        GetPdfStream.run();

        AdjustQualityOfJpgImages.run();
        ProtectPdfDocument.run();

        // endregion

        // endregion

        // region Advanced Usage

        // region Common rendering options

        AddWatermark.run();
        RenderDocumentWithComments.run();
        RenderDocumentWithNotes.run();
        RenderHiddenPages.run();
        RenderNConsecutivePages.run();
        RenderSelectedPages.run();
        ReplaceMissingFont.run();
        ReorderPages.run();
        FlipRotatePages.run();
        RenderWithCustomFonts.run();
        RenderingTxt.run();
        SetImageSizeLimits.run();

        // endregion

        // region Rendering options by document type

        // region Rendering CAD Files

        RenderingPc3Files.run();

        // endregion

        // region Rendering Archive Files

        GetViewInfoForArchiveFile.run();
        RenderArchiveFolder.run();
        SpecifyFilenameWhenRenderingArchiveFiles.run();
        RenderingRar.run();
        RenderingArchivesToMultipleAndSinglePagesHtml.run();

        // endregion

        // region Rendering CAD Drawings

        GetViewInfoForCadDrawing.run();
        RenderAllLayouts.run();
        RenderLayers.run();
        RenderSingleLayout.run();
        SplitDrawingIntoTiles.run();
        AdjustOutputImageSize.run();
        RenderingPlt.run();
        RenderingObj.run();
        RenderingCf2.run();
        RenderingHpg.run();
        SetImageBackgroundColor.run();
        RenderingFodp.run();
        RenderingIgs.run();
        RenderingNotes.run();
        RenderingFodgAndOdg.run();
        RenderingPstAndOst.run();
        // endregion

        // region Rendering E-Mail Messages

        AdjustPageSize.run();
        RenameEmailFields.run();
        DateTimeFormatAndTimeZoneOffset.run();

        // endregion

        // region Rendering Outlook Data Files

        FilterMessages.run();
        GetViewInfoForOutlookDataFile.run();
        LimitCountOfItemsToRender.run();
        RenderOutlookDataFileFolder.run();

        // endregion

        // region Rendering PDF Documents

        DisableCharactersGrouping.run();
        EnableFontHinting.run();
        GetViewInfoForPdfDocument.run();
        AdjustImageQuality.run();
        EnableLayeredRendering.run();
        RenderOriginalPageSize.run();
        DisableTextSelection.run();
        ExtractTextFromPdfFile.run();

        // endregion

        // region Rendering MS Project Documents

        AdjustTimeUnit.run();
        GetViewInfoForProjectDocument.run();
        RenderProjectTimeInterval.run();

        // endregion

        // region Rendering Spreadsheets

        AdjustTextOverflowInCells.run();
        RenderGridLines.run();
        RenderHiddenRowsAndColumns.run();
        RenderPrintAreas.run();
        SkipRenderingOfEmptyColumns.run();
        SkipRenderingOfEmptyRows.run();
        SplitWorksheetsIntoPages.splitByRows();
        SplitWorksheetsIntoPages.splitByRowsAndColumns();
        RenderRowAndColumnHeadings.run();
        GetWorksheetsNames.run();
        RenderingNumbers.run();
        RenderingXmlSpreadSheetML.run();
        RenderingByPageBreaks.run();

        // endregion

        // region Rendering Word Processing Documents

        RenderTrackedChanges.run();

        // endregion

        // region Rendering Web documents

        RenderingHtmlWithUserDefinedMargins.run();
        RenderingChmFiles.run();

        // endregion

        // endregion

        // region Caching

        UseCacheWhenProcessingDocuments.run();
        UseCustomCacheImplementation.run();

        // endregion

        // region Loading

        LoadPasswordProtectedDocument.run();
        LoadDocumentsWithCharset.run();
        LoadDocumentsWithEncoding.run();
        SpecifyFileTypeWhenLoadingDocument.run();
        SetResourceLoadingTimeout.run();

        // region Loading documents from different sources

        LoadDocumentFromLocalDisk.run();
        LoadDocumentFromStream.run();
        LoadDocumentFromUrl.run();
//        LoadDocumentFromFtp.run();

        // endregion

        // endregion

        // endregion

        // region HowTo
        HowToDetermineFileType.fromFileExtension();
        HowToDetermineFileType.fromMediaType();
        HowToDetermineFileType.fromStream();

        HowToLogging.toConsole();
        HowToLogging.toFile();

        // endregion

        System.out.println();
        System.out.println("All done.");
    }
}
