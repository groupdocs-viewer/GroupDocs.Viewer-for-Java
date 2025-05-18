package com.groupdocs.examples.viewer;


import com.groupdocs.examples.viewer.advanced_usage.caching.UseCacheWhenProcessingDocuments;
import com.groupdocs.examples.viewer.advanced_usage.caching.UseCustomCacheImplementation;
import com.groupdocs.examples.viewer.advanced_usage.loading.*;
import com.groupdocs.examples.viewer.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromFtp;
import com.groupdocs.examples.viewer.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromLocalDisk;
import com.groupdocs.examples.viewer.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromStream;
import com.groupdocs.examples.viewer.advanced_usage.loading.loading_documents_from_different_sources.LoadDocumentFromUrl;
import com.groupdocs.examples.viewer.advanced_usage.rendering.common_rendering_options.*;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_archive_files.*;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_cad_drawings.*;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages.AdjustPageSize;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages.DateTimeFormatAndTimeZoneOffset;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_email_messages.RenameEmailFields;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_image_files.*;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents.AdjustTimeUnit;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents.GetViewInfoForProjectDocument;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_ms_project_documents.RenderProjectTimeInterval;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files.FilterMessages;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files.GetViewInfoForOutlookDataFile;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files.LimitCountOfItemsToRender;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_outlook_data_files.RenderOutlookDataFileFolder;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_pdf_documents.*;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_presentation_documents.RenderingFodp;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_spreadsheets.*;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_text_documents.RenderingTxt;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_web_documents.RenderingChmFiles;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_web_documents.RenderingHtmlWithUserDefinedMargins;
import com.groupdocs.examples.viewer.advanced_usage.rendering.rendering_options_by_document_type.rendering_word_processing_documents.RenderTrackedChanges;
import com.groupdocs.examples.viewer.basic_usage.CheckFileIsEncrypted;
import com.groupdocs.examples.viewer.basic_usage.GetSupportedFileFormats;
import com.groupdocs.examples.viewer.basic_usage.GetViewInfo;
import com.groupdocs.examples.viewer.basic_usage.extract_text.ExtractTextFromPdfFile;
import com.groupdocs.examples.viewer.basic_usage.processing_attachments.RenderDocumentAttachments;
import com.groupdocs.examples.viewer.basic_usage.processing_attachments.RetrieveAndPrintDocumentAttachments;
import com.groupdocs.examples.viewer.basic_usage.processing_attachments.RetrieveAndSaveDocumentAttachments;
import com.groupdocs.examples.viewer.basic_usage.render_document_to_html.*;
import com.groupdocs.examples.viewer.basic_usage.render_document_to_image.*;
import com.groupdocs.examples.viewer.basic_usage.render_document_to_pdf.AdjustQualityOfJpgImages;
import com.groupdocs.examples.viewer.basic_usage.render_document_to_pdf.GetPdfStream;
import com.groupdocs.examples.viewer.basic_usage.render_document_to_pdf.ProtectPdfDocument;
import com.groupdocs.examples.viewer.basic_usage.render_document_to_pdf.RenderToPdf;
import com.groupdocs.examples.viewer.howto.HowToDetermineFileType;
import com.groupdocs.examples.viewer.howto.HowToLogging;
import com.groupdocs.examples.viewer.quick_start.*;
import com.groupdocs.examples.viewer.utils.FailureRegister;

public class Main {
    public static void main(String[] args) {
        System.out.println("Open `src/main/java/com/groupdocs/examples/viewer/Main.java` file. \nIn runExamples() method uncomment the example that you want to run.");
        System.out.println("=====================================================");

        runExamples();

        final boolean printFailedSamplesStacktrace = System.getenv("PRINT_FAILED_SAMPLES_STACKTRACE") != null;
        FailureRegister.getInstance().printFailedSamples(printFailedSamplesStacktrace);

        System.out.println("\nAll done.");
        System.exit(FailureRegister.getInstance().getFailedSamplesCount());
    }

    public static void runExamples() {
        // TODO: Comment examples which you don't want to run

        { // Licensing
        //SetLicenseFromFile.run();
        //SetLicenseFromStream.run();
            SetLicenseFromUrl.run();
        //SetMeteredLicense.run();
        }
        { // Quick start
            HelloWorld.run(SampleFiles.SAMPLE_DOCX);
        }
        { // Basic usage
            GetSupportedFileFormats.run();
            GetViewInfo.run(SampleFiles.SAMPLE_PDF);
            CheckFileIsEncrypted.run(SampleFiles.ENCRYPTED);

            { // Processing attachments
                RetrieveAndPrintDocumentAttachments.run(SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS);
                RetrieveAndSaveDocumentAttachments.run(SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS);
                RenderDocumentAttachments.run(SampleFiles.SAMPLE_MSG_WITH_ATTACHMENTS);
            }
            { // Render document to HTML
                RenderToHtmlWithEmbeddedResources.run(SampleFiles.SAMPLE_DOCX);
                RenderToHtmlWithExternalResources.run(SampleFiles.SAMPLE_DOCX);

                ExcludingFontsFromOutputHtml.run(SampleFiles.SAMPLE_DOCX);
                MinifyHtmlDocument.run(SampleFiles.SAMPLE_DOCX);
                RenderToResponsiveHtml.run(SampleFiles.SAMPLE_DOCX);
            }
            { // Render document to Image
                RenderToPng.run(SampleFiles.SAMPLE_DOCX);
                RenderToJpg.run(SampleFiles.SAMPLE_DOCX);

                GetTextCoordinates.run(SampleFiles.SAMPLE_DOCX);
                RenderForDisplayWithText.run(SampleFiles.SAMPLE_DOCX);
                AdjustQualityWhenRenderingToJpg.run(SampleFiles.SAMPLE_DOCX);
                AdjustImageSize.run(SampleFiles.SAMPLE_DOCX);
                RenderingWmzAndWmf.run(SampleFiles.SAMPLE_WMZ);
                RenderingEmzAndEmf.run(SampleFiles.SAMPLE_EMZ);
                RenderingCdr.run(SampleFiles.SAMPLE_CDR);
                RenderingCmx.run(SampleFiles.SAMPLE_CMX);
                RenderingAi.run(SampleFiles.SAMPLE_AI);
                RenderingTga.run(SampleFiles.SAMPLE_TGA);
                RenderingApng.run(SampleFiles.SAMPLE_APNG);
            }
            { // Render document to PDF
                RenderToPdf.run(SampleFiles.SAMPLE_DOCX);
                GetPdfStream.run(SampleFiles.SAMPLE_DOCX);

                AdjustQualityOfJpgImages.run(SampleFiles.JPG_IMAGE_PPTX);
                ProtectPdfDocument.run(SampleFiles.SAMPLE_DOCX);
            }
        }
        { // Advanced usage
            { // Common rendering options
                AddWatermark.run(SampleFiles.SAMPLE_DOCX);
                RenderDocumentWithComments.run(SampleFiles.SAMPLE_DOCX_WITH_COMMENT);
                RenderDocumentWithNotes.run(SampleFiles.PPTX_WITH_NOTES);
                RenderHiddenPages.run(SampleFiles.SAMPLE_PPTX_HIDDEN_PAGE);
                RenderNConsecutivePages.run(SampleFiles.SAMPLE_DOCX);
                RenderingSvgAndSvgz.run(SampleFiles.SAMPLE_SVGZ);
                RenderSelectedPages.run(SampleFiles.SAMPLE_DOCX);
                ReplaceMissingFont.run(SampleFiles.MISSING_FONT_PPTX);
                ReorderPages.run(SampleFiles.SAMPLE_DOCX);
                FlipRotatePages.run(SampleFiles.SAMPLE_DOCX);
                RotatePages.run(SampleFiles.SAMPLE_PDF);
                RenderWithCustomFonts.run(SampleFiles.MISSING_FONT_PPTX);
                RenderingTxt.run(SampleFiles.SAMPLE_TXT);
                SetImageSizeLimits.run(SampleFiles.SAMPLE_CF2);
            }
            { // Rendering options by document type
                { // Rendering CAD Files
                    RenderingPc3Files.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
                }
                { // Rendering Archive Files
                    GetViewInfoForArchiveFile.run(SampleFiles.SAMPLE_ZIP_WITH_FOLDERS);
                    RenderArchiveFolder.run(SampleFiles.SAMPLE_ZIP_WITH_FOLDERS);
                    SpecifyFilenameWhenRenderingArchiveFiles.run(SampleFiles.SAMPLE_ZIP);
                    RenderingRar.run(SampleFiles.SAMPLE_RAR_WITH_FOLDERS);
                    RenderArchivesToHtmlPages.run(SampleFiles.SAMPLE_RAR_WITH_FOLDERS);
                }
                { // Rendering CAD Drawings
                    GetViewInfoForCadDrawing.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
                    RenderAllLayouts.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
                    RenderLayers.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
                    RenderSingleLayout.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
                    SplitDrawingIntoTiles.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
                    AdjustOutputImageSize.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
                    RenderingPlt.run(SampleFiles.SAMPLE_PLT);
                    RenderingObj.run(SampleFiles.SAMPLE_OBJ);
                    RenderingCf2.run(SampleFiles.SAMPLE_CF2);
                    RenderingHpg.run(SampleFiles.SAMPLE_HPG);
                    SetImageBackgroundColor.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
                    RenderingFodp.run(SampleFiles.SAMPLE_FODP);
                    RenderingIgs.run(SampleFiles.SAMPLE_IGS);
                    RenderingNotes.run(SampleFiles.SAMPLE_MPP);
                    RenderingFodgAndOdg.run(SampleFiles.SAMPLE_FODG);
                    RenderingPstAndOst.run(SampleFiles.SAMPLE_PST);
                }
                { // Rendering E-Mail Messages
                    AdjustPageSize.run(SampleFiles.SAMPLE_MSG);
                    RenameEmailFields.run(SampleFiles.SAMPLE_MSG);
                    DateTimeFormatAndTimeZoneOffset.run(SampleFiles.SAMPLE_EML);
                }
                { // Rendering Outlook Data Files
                    FilterMessages.run(SampleFiles.SAMPLE_OST_SUBFOLDERS);
                    GetViewInfoForOutlookDataFile.run(SampleFiles.SAMPLE_OST_SUBFOLDERS);
                    LimitCountOfItemsToRender.run(SampleFiles.SAMPLE_OST);
                    RenderOutlookDataFileFolder.run(SampleFiles.SAMPLE_OST_SUBFOLDERS);
                }
                { // Rendering PDF Documents
                    DisableCharactersGrouping.run(SampleFiles.HIEROGLYPHS_PDF);
                    EnableFontHinting.run(SampleFiles.HIEROGLYPHS_1_PDF);
                    GetViewInfoForPdfDocument.run(SampleFiles.SAMPLE_PDF);
                    AdjustImageQuality.run(SampleFiles.SAMPLE_PDF);
                    EnableLayeredRendering.run(SampleFiles.SAMPLE_PDF);
                    RenderOriginalPageSize.run(SampleFiles.SAMPLE_PDF);
                    DisableTextSelection.run(SampleFiles.ONE_PAGE_TEXT_PDF);
                    ExtractTextFromPdfFile.run(SampleFiles.SAMPLE_PDF);
                }
                { // Rendering MS Project Documents
                    AdjustTimeUnit.run(SampleFiles.SAMPLE_MPP);
                    GetViewInfoForProjectDocument.run(SampleFiles.SAMPLE_MPP);
                    RenderProjectTimeInterval.run(SampleFiles.SAMPLE_MPP);
                }
                { // Rendering Spreadsheets
                    AdjustTextOverflowInCells.run(SampleFiles.SAMPLE_XLSX_WITH_TEXT_OVERFLOW);
                    RenderGridLines.run(SampleFiles.SAMPLE_XLSX);
                    RenderHiddenRowsAndColumns.run(SampleFiles.SAMPLE_XLSX_WITH_HIDDEN_ROW_AND_COLUMN);
                    RenderPrintAreas.run(SampleFiles.SAMPLE_XLSX_WITH_PRINT_AREAS);
                    SkipRenderingOfEmptyColumns.run(SampleFiles.SAMPLE_XLSX_WITH_EMPTY_COLUMN);
                    SkipRenderingOfEmptyRows.run(SampleFiles.SAMPLE_XLSX_WITH_EMPTY_ROW);
                    SplitWorksheetsIntoPages.splitByRows(SampleFiles.TWO_PAGES_XLSX);
                    SplitWorksheetsIntoPages.splitByRowsAndColumns(SampleFiles.FOUR_PAGES_XLSX);
                    RenderRowAndColumnHeadings.run(SampleFiles.SAMPLE_XLSX);
                    GetWorksheetsNames.run(SampleFiles.THREE_SHEETS);
                    RenderingNumbers.run(SampleFiles.SAMPLE_NUMBERS);
                    RenderingXmlSpreadSheetML.run(SampleFiles.SAMPLE_XML_SPREADSHEETML);
                    RenderingByPageBreaks.run(SampleFiles.PAGE_BREAKS_XLSX);
                }
                { // Rendering Word Processing Documents
                    RenderTrackedChanges.run(SampleFiles.SAMPLE_DOCX_WITH_TRACKED_CHANGES);
                }
                { // Rendering Web documents
                    RenderingHtmlWithUserDefinedMargins.run(SampleFiles.SAMPLE_HTML);
                    RenderingChmFiles.run(SampleFiles.SAMPLE_CHM);
                }

            }
            { // Caching
                UseCacheWhenProcessingDocuments.run(SampleFiles.SAMPLE_DOCX);
                UseCustomCacheImplementation.run(SampleFiles.SAMPLE_DOCX);
            }
            { // Loading
                LoadPasswordProtectedDocument.run(SampleFiles.SAMPLE_DOCX_WITH_PASSWORD);
                LoadDocumentsWithCharset.run(SampleFiles.SAMPLE_TXT_SHIFT_JS_ENCODED);
                LoadDocumentsWithEncoding.run(SampleFiles.SAMPLE_TXT_SHIFT_JS_ENCODED);
                SpecifyFileTypeWhenLoadingDocument.run(SampleFiles.SAMPLE_DOCX);
                SetResourceLoadingTimeout.run(SampleFiles.WITH_EXTERNAL_IMAGE_DOC);

                { // Loading documents from different sources
                    LoadDocumentFromLocalDisk.run(SampleFiles.SAMPLE_DOCX);
                    LoadDocumentFromStream.run(SampleFiles.SAMPLE_DOCX);
                    LoadDocumentFromUrl.run();
                    LoadDocumentFromFtp.run();
                }
            }
            { // HowTo
                HowToDetermineFileType.fromFileExtension();
                HowToDetermineFileType.fromMediaType();
                HowToDetermineFileType.fromStream();

                HowToLogging.toConsole();
                HowToLogging.toFile();
            }
        }
    }
}
