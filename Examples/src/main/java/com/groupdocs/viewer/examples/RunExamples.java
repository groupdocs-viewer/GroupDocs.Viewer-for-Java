package com.groupdocs.viewer.examples;

import com.groupdocs.viewer.examples.quick_start.HelloWorld;

import java.io.IOException;

public class RunExamples {

    /**
     * The main method.
     */
    public static void main(String[] args) throws IOException {

        System.out.println("Uncomment the example(s) that you want to run in RunExamples.java file.");
        System.out.println("=======================================================================");

        Utils.cleanOutputDirectory();

        // region Quick Start

//        SetLicenseFromFile.run();
//        SetLicenseFromStream.run();
//        SetMeteredLicense.run();
        HelloWorld.run();

        // endregion

        // region Basic Usage

//        GetSupportedFileFormats.run();
//        GetViewInfo.run();
//        CheckFileIsEncrypted.run();

        // region Processing attachments

//        RetrieveAndPrintDocumentAttachments.run();
//        RetrieveAndSaveDocumentAttachments.run();
//        RenderDocumentAttachments.run();

        // endregion

        // region Render document to HTML

//        RenderToHtmlWithEmbeddedResources.run();
//        RenderToHtmlWithExternalResources.run();

//        ExcludingFontsFromOutputHtml.run();
//        MinifyHtmlDocument.run();
//        RenderToResponsiveHtml.run();

        // endregion

        // region Render document to Image

//        RenderToPng.run();
//        RenderToJpg.run();

//        GetTextCoordinates.run();
//        RenderForDisplayWithText.run();
//        AdjustQualityWhenRenderingToJpg.run();
//        AdjustImageSize.run();
//        RenderingWmzAndWmf.run();
//        RenderingEmzAndEmf.run();
//        RenderingCdr.run();
//        RenderingCmx.run();
//        RenderingAi.run();
//        RenderingTga.run();
//        RenderingApng.run();

        // endregion

        // region Render document to PDF

//        RenderToPdf.run();
//        GetPdfStream.run();

//        AdjustQualityOfJpgImages.run();
//        ProtectPdfDocument.run();

        // endregion

        // endregion

        // region Advanced Usage

        // region Common rendering options

//        AddWatermark.run();
//        RenderDocumentWithComments.run();
//        RenderDocumentWithNotes.run();
//        RenderHiddenPages.run();
//        RenderNConsecutivePages.run();
//        RenderSelectedPages.run();
//        ReplaceMissingFont.run();
//        ReorderPages.run();
//        FlipRotatePages.run();
//        RenderWithCustomFonts.run();
//        RenderingTxt.run();
//        SetImageSizeLimits.run();

        // endregion

        // region Rendering options by document type

        // region Rendering CAD Files

//        RenderingPc3Files.run();

        // endregion

        // region Rendering Archive Files

//        GetViewInfoForArchiveFile.run();
//        RenderArchiveFolder.run();
//        SpecifyFilenameWhenRenderingArchiveFiles.run();
//        RenderingRar.run();
//        RenderingArchivesToMultipleAndSinglePagesHtml.run();

        // endregion

        // region Rendering CAD Drawings

//        GetViewInfoForCadDrawing.run();
//        RenderAllLayouts.run();
//        RenderLayers.run();
//        RenderSingleLayout.run();
//        SplitDrawingIntoTiles.run();
//        AdjustOutputImageSize.run();
//        RenderingPlt.run();
//        RenderingObj.run();
//        RenderingCf2.run();
//        RenderingHpg.run();
//        SetImageBackgroundColor.run();
//        RenderingFodp.run();
//        RenderingIgs.run();
//        RenderingNotes.run();
//        RenderingFodgAndOdg.run();
//        RenderingPstAndOst.run();
        // endregion

        // region Rendering E-Mail Messages

//        AdjustPageSize.run();
//        RenameEmailFields.run();
//        DateTimeFormatAndTimeZoneOffset.run();

        // endregion

        // region Rendering Outlook Data Files

//        FilterMessages.run();
//        GetViewInfoForOutlookDataFile.run();
//        LimitCountOfItemsToRender.run();
//        RenderOutlookDataFileFolder.run();

        // endregion

        // region Rendering PDF Documents

//        DisableCharactersGrouping.run();
//        EnableFontHinting.run();
//        GetViewInfoForPdfDocument.run();
//        AdjustImageQuality.run();
//        EnableLayeredRendering.run();
//        RenderOriginalPageSize.run();
//        DisableTextSelection.run();
//        ExtractTextFromPdfFile.run();

        // endregion

        // region Rendering MS Project Documents

//        AdjustTimeUnit.run();
//        GetViewInfoForProjectDocument.run();
//        RenderProjectTimeInterval.run();

        // endregion

        // region Rendering Spreadsheets

//        AdjustTextOverflowInCells.run();
//        RenderGridLines.run();
//        RenderHiddenRowsAndColumns.run();
//        RenderPrintAreas.run();
//        SkipRenderingOfEmptyColumns.run();
//        SkipRenderingOfEmptyRows.run();
//        SplitWorksheetsIntoPages.splitByRows();
//        SplitWorksheetsIntoPages.splitByRowsAndColumns();
//        RenderRowAndColumnHeadings.run();
//        GetWorksheetsNames.run();
//        RenderingNumbers.run();
//        RenderingXmlSpreadSheetML.run();
//        RenderingByPageBreaks.run();

        // endregion

        // region Rendering Word Processing Documents

//        RenderTrackedChanges.run();

        // endregion

        // region Rendering Web documents

//        RenderingHtmlWithUserDefinedMargins.run();
//        RenderingChmFiles.run();

        // endregion

        // endregion

        // region Caching

//        UseCacheWhenProcessingDocuments.run();
//        UseCustomCacheImplementation.run();

        // endregion

        // region Loading

//        LoadPasswordProtectedDocument.run();
//        LoadDocumentsWithCharset.run();
//        LoadDocumentsWithEncoding.run();
//        SpecifyFileTypeWhenLoadingDocument.run();
//        SetResourceLoadingTimeout.run();

        // region Loading documents from different sources

//        LoadDocumentFromLocalDisk.run();
//        LoadDocumentFromStream.run();
//        LoadDocumentFromUrl.run();
//        LoadDocumentFromFtp.run();

        // endregion

        // endregion

        // endregion

        // region HowTo
//        HowToDetermineFileType.fromFileExtension();
//        HowToDetermineFileType.fromMediaType();
//        HowToDetermineFileType.fromStream();

//        HowToLogging.toConsole();
//        HowToLogging.toFile();

        // endregion

        System.out.println();
        System.out.println("All done.");
    }
}
