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
import com.groupdocs.viewer.examples.quick_start.SetLicenseFromFile;
import com.groupdocs.viewer.examples.quick_start.SetLicenseFromUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RunExamples {

    @FunctionalInterface
    private interface Example {
        void execute() throws Exception;
    }

    private static final List<String> FAILED_EXAMPLES = new ArrayList<>();

    /**
     * The main method.
     */
    public static void main(String[] args) {

        System.out.println("Uncomment the example(s) that you want to run in RunExamples.java file.");
        System.out.println("=======================================================================");

        try {
            Utils.cleanOutputDirectory();
        } catch (Exception e) {
            System.out.println("Failed to clean output directory: " + e);
        }
        Locale.setDefault(Locale.US);

        // region Quick Start
        run("SetLicenseFromFile", SetLicenseFromFile::run);
//        run("SetLicenseFromStream", SetLicenseFromStream::run);
//        run("SetLicenseFromUrl", SetLicenseFromUrl::run);
//        run("SetMeteredLicense", SetMeteredLicense::run);
        run("HelloWorld", HelloWorld::run);

        // endregion

        // region Basic Usage

        run("GetSupportedFileFormats", GetSupportedFileFormats::run);
        run("GetViewInfo", GetViewInfo::run);
        run("CheckFileIsEncrypted", CheckFileIsEncrypted::run);

        // region Processing attachments

       run("RetrieveAndPrintDocumentAttachments", RetrieveAndPrintDocumentAttachments::run);
       run("RetrieveAndSaveDocumentAttachments", RetrieveAndSaveDocumentAttachments::run);
       run("RenderDocumentAttachments", RenderDocumentAttachments::run);

        // endregion

        // region Render document to HTML

        run("RenderToHtmlWithEmbeddedResources", RenderToHtmlWithEmbeddedResources::run);
        run("RenderToHtmlWithExternalResources", RenderToHtmlWithExternalResources::run);

        run("ExcludingFontsFromOutputHtml", ExcludingFontsFromOutputHtml::run);
        run("MinifyHtmlDocument", MinifyHtmlDocument::run);
        run("RenderToResponsiveHtml", RenderToResponsiveHtml::run);

        // endregion

        // region Render document to Image

        run("RenderToPng", RenderToPng::run);
        run("RenderToJpg", RenderToJpg::run);

        run("GetTextCoordinates", GetTextCoordinates::run);
        run("RenderForDisplayWithText", RenderForDisplayWithText::run);
        run("AdjustQualityWhenRenderingToJpg", AdjustQualityWhenRenderingToJpg::run);
        run("AdjustImageSize", AdjustImageSize::run);
        run("RenderingWmzAndWmf", RenderingWmzAndWmf::run);
        run("RenderingEmzAndEmf", RenderingEmzAndEmf::run);
        run("RenderingCdr", RenderingCdr::run);
        run("RenderingCmx", RenderingCmx::run);
        run("RenderingAi", RenderingAi::run);
        run("RenderingTga", RenderingTga::run);
        run("RenderingApng", RenderingApng::run);

        // endregion

        // region Render document to PDF

        run("RenderToPdf", RenderToPdf::run);
        run("GetPdfStream", GetPdfStream::run);

        run("AdjustQualityOfJpgImages", AdjustQualityOfJpgImages::run);
        run("ProtectPdfDocument", ProtectPdfDocument::run);

        // endregion

        // endregion

        // region Advanced Usage

        // region Common rendering options

        run("AddWatermark", AddWatermark::run);
        run("RenderDocumentWithComments", RenderDocumentWithComments::run);
        run("RenderDocumentWithNotes", RenderDocumentWithNotes::run);
        run("RenderHiddenPages", RenderHiddenPages::run);
        run("RenderNConsecutivePages", RenderNConsecutivePages::run);
        run("RenderSelectedPages", RenderSelectedPages::run);
        run("ReplaceMissingFont", ReplaceMissingFont::run);
        run("ReorderPages", ReorderPages::run);
        run("FlipRotatePages", FlipRotatePages::run);
        run("RenderWithCustomFonts", RenderWithCustomFonts::run);
        run("RenderingTxt", RenderingTxt::run);
        run("SetImageSizeLimits", SetImageSizeLimits::run);
        run("CancelRenderWithCancellationToken", CancelRenderWithCancellationToken::run);

        // endregion

        // region Rendering options by document type

        // region Rendering CAD Files

        run("RenderingPc3Files", RenderingPc3Files::run);

        // endregion

        // region Rendering Archive Files

        run("GetViewInfoForArchiveFile", GetViewInfoForArchiveFile::run);
        run("RenderArchiveFolder", RenderArchiveFolder::run);
        run("SpecifyFilenameWhenRenderingArchiveFiles", SpecifyFilenameWhenRenderingArchiveFiles::run);
        run("RenderingRar", RenderingRar::run);
        run("RenderingArchivesToMultipleAndSinglePagesHtml", RenderingArchivesToMultipleAndSinglePagesHtml::run);

        // endregion

        // region Rendering CAD Drawings

        run("GetViewInfoForCadDrawing", GetViewInfoForCadDrawing::run);
        run("RenderAllLayouts", RenderAllLayouts::run);
        run("RenderLayers", RenderLayers::run);
        run("RenderSingleLayout", RenderSingleLayout::run);
        run("SplitDrawingIntoTiles", SplitDrawingIntoTiles::run);
        run("AdjustOutputImageSize", AdjustOutputImageSize::run);
        run("RenderingPlt", RenderingPlt::run);
        run("RenderingObj", RenderingObj::run);
        run("RenderingCf2", RenderingCf2::run);
        run("RenderingHpg", RenderingHpg::run);
        run("SetImageBackgroundColor", SetImageBackgroundColor::run);
        run("RenderingFodp", RenderingFodp::run);
        run("RenderingIgs", RenderingIgs::run);
        run("RenderingNotes", RenderingNotes::run);
        run("RenderingFodgAndOdg", RenderingFodgAndOdg::run);
        run("RenderingPstAndOst", RenderingPstAndOst::run);
        // endregion

        // region Rendering E-Mail Messages

        run("AdjustPageSize", AdjustPageSize::run);
        run("RenameEmailFields", RenameEmailFields::run);
        run("DateTimeFormatAndTimeZoneOffset", DateTimeFormatAndTimeZoneOffset::run);

        // endregion

        // region Rendering Outlook Data Files

        run("FilterMessages", FilterMessages::run);
        run("GetViewInfoForOutlookDataFile", GetViewInfoForOutlookDataFile::run);
        run("LimitCountOfItemsToRender", LimitCountOfItemsToRender::run);
        run("RenderOutlookDataFileFolder", RenderOutlookDataFileFolder::run);

        // endregion

        // region Rendering PDF Documents

        run("DisableCharactersGrouping", DisableCharactersGrouping::run);
        run("EnableFontHinting", EnableFontHinting::run);
        run("GetViewInfoForPdfDocument", GetViewInfoForPdfDocument::run);
        run("AdjustImageQuality", AdjustImageQuality::run);
        run("EnableLayeredRendering", EnableLayeredRendering::run);
        run("RenderOriginalPageSize", RenderOriginalPageSize::run);
        run("DisableTextSelection", DisableTextSelection::run);
        run("DisableFontLicenseVerifications", DisableFontLicenseVerifications::run);
        run("ExtractTextFromPdfFile", ExtractTextFromPdfFile::run);

        // endregion

        // region Rendering MS Project Documents

        run("AdjustTimeUnit", AdjustTimeUnit::run);
        run("GetViewInfoForProjectDocument", GetViewInfoForProjectDocument::run);
        run("RenderProjectTimeInterval", RenderProjectTimeInterval::run);

        // endregion

        // region Rendering Spreadsheets

        run("AdjustTextOverflowInCells", AdjustTextOverflowInCells::run);
        run("RenderGridLines", RenderGridLines::run);
        run("RenderHiddenRowsAndColumns", RenderHiddenRowsAndColumns::run);
        run("RenderPrintAreas", RenderPrintAreas::run);
        run("SkipRenderingOfEmptyColumns", SkipRenderingOfEmptyColumns::run);
        run("SkipRenderingOfEmptyRows", SkipRenderingOfEmptyRows::run);
        run("SplitWorksheetsIntoPages.splitByRows", SplitWorksheetsIntoPages::splitByRows);
        run("SplitWorksheetsIntoPages.splitByRowsAndColumns", SplitWorksheetsIntoPages::splitByRowsAndColumns);
        run("RenderRowAndColumnHeadings", RenderRowAndColumnHeadings::run);
        run("GetWorksheetsNames", GetWorksheetsNames::run);
        run("RenderingNumbers", RenderingNumbers::run);
        run("RenderingXmlSpreadSheetML", RenderingXmlSpreadSheetML::run);
        run("RenderingByPageBreaks", RenderingByPageBreaks::run);

        // endregion

        // region Rendering Word Processing Documents

        run("RenderTrackedChanges", RenderTrackedChanges::run);

        // endregion

        // region Rendering Web documents

        run("RenderingHtmlWithUserDefinedMargins", RenderingHtmlWithUserDefinedMargins::run);
        run("RenderingChmFiles", RenderingChmFiles::run);

        // endregion

        // endregion

        // region Caching

        run("UseCacheWhenProcessingDocuments", UseCacheWhenProcessingDocuments::run);
        run("UseCustomCacheImplementation", UseCustomCacheImplementation::run);

        // endregion

        // region Loading

        run("LoadPasswordProtectedDocument", LoadPasswordProtectedDocument::run);
        run("LoadDocumentsWithCharset", LoadDocumentsWithCharset::run);
        run("LoadDocumentsWithEncoding", LoadDocumentsWithEncoding::run);
        run("SpecifyFileTypeWhenLoadingDocument", SpecifyFileTypeWhenLoadingDocument::run);
        run("SetResourceLoadingTimeout", SetResourceLoadingTimeout::run);

        // region Loading documents from different sources

        run("LoadDocumentFromLocalDisk", LoadDocumentFromLocalDisk::run);
        run("LoadDocumentFromStream", LoadDocumentFromStream::run);
        run("LoadDocumentFromUrl", LoadDocumentFromUrl::run);
//        run("LoadDocumentFromFtp", LoadDocumentFromFtp::run);

        // endregion

        // endregion

        // endregion

        // region HowTo
        run("HowToDetermineFileType.fromFileExtension", HowToDetermineFileType::fromFileExtension);
        run("HowToDetermineFileType.fromMediaType", HowToDetermineFileType::fromMediaType);
        run("HowToDetermineFileType.fromStream", HowToDetermineFileType::fromStream);

        run("HowToLogging.toConsole", HowToLogging::toConsole);
        run("HowToLogging.toFile", HowToLogging::toFile);

        // endregion

        System.out.println();
        if (FAILED_EXAMPLES.isEmpty()) {
            System.out.println("All done. All examples passed.");
        } else {
            System.out.println("All done. Failed examples (" + FAILED_EXAMPLES.size() + "):");
            for (String failed : FAILED_EXAMPLES) {
                System.out.println("  - " + failed);
            }
        }
    }

    private static void run(String name, Example example) {
        try {
            example.execute();
        } catch (Throwable t) {
            FAILED_EXAMPLES.add(name);
            System.out.println();
            System.out.println("Example '" + name + "' failed with error:");
            System.out.println("  " + t.getClass().getName() + ": " + t.getMessage());
            if (t.getCause() != null) {
                System.out.println("  Caused by: " + t.getCause().getClass().getName() + ": " + t.getCause().getMessage());
            }
            System.out.println();
        }
    }
}
