package com.groupdocs.examples.viewer;

import java.nio.file.Path;

import static com.groupdocs.examples.viewer.utils.FilesUtils.makeFilesPath;

public interface SampleFiles {

    // Archives
    Path SAMPLE_ZIP = makeFilesPath("sample.zip");
    Path SAMPLE_ZIP_WITH_FOLDERS = makeFilesPath("with_folders.zip");
    Path SAMPLE_RAR_WITH_FOLDERS = makeFilesPath("with_folders.rar");

    // CAD drawings
    Path SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS = makeFilesPath("with_layers_and_layouts.dwg");
    Path SAMPLE_PLT = makeFilesPath("sample.plt");
    Path SAMPLE_AI = makeFilesPath("sample.ai");
    Path SAMPLE_CF2 = makeFilesPath("sample.cf2");
    Path SAMPLE_IGS = makeFilesPath("sample.igs");
    Path SAMPLE_OBJ = makeFilesPath("sample.obj");
    Path SAMPLE_HPG = makeFilesPath("sample.hpg");
    Path SAMPLE_PC3_CONFIG = makeFilesPath("small_page.pc3");

    // Email messages
    Path SAMPLE_MSG = makeFilesPath("sample.msg");
    Path SAMPLE_MSG_WITH_ATTACHMENTS = makeFilesPath("with_attachments.msg");
    Path SAMPLE_OST = makeFilesPath("sample.ost");
    Path SAMPLE_PST = makeFilesPath("sample.pst");
    Path SAMPLE_OST_SUBFOLDERS = makeFilesPath("with_subfolders.ost");
    Path SAMPLE_NSF = makeFilesPath("sample.nsf");
    Path SAMPLE_EML = makeFilesPath("sample.eml");

    // PDFs
    Path SAMPLE_PDF = makeFilesPath("sample.pdf");
    Path HIEROGLYPHS_PDF = makeFilesPath("hieroglyphs.pdf");
    Path HIEROGLYPHS_1_PDF = makeFilesPath("hieroglyphs_1.pdf");
    Path ENCRYPTED = makeFilesPath("encrypted.pdf");
    Path ONE_PAGE_TEXT_PDF = makeFilesPath("one-page-text.pdf");

    // Presentations
    Path PPTX_WITH_NOTES = makeFilesPath("with_notes.pptx");
    Path SAMPLE_PPTX_HIDDEN_PAGE = makeFilesPath("with_hidden_page.pptx");
    Path MISSING_FONT_PPTX = makeFilesPath("with_missing_font.pptx");
    Path JPG_IMAGE_PPTX = makeFilesPath("with_jpg_image.pptx");
    Path SAMPLE_FODP = makeFilesPath("sample.fodp");

    // Project Management documents
    Path SAMPLE_MPP = makeFilesPath("sample.mpp");
    // Visio files
    Path SAMPLE_VISIO = makeFilesPath("sample.vssx");

    // Spreadsheets
    Path SAMPLE_XLSX = makeFilesPath("sample.xlsx");
    Path SAMPLE_XLSX_WITH_PRINT_AREAS = makeFilesPath("with_four_print_areas.xlsx");
    Path PAGE_BREAKS_XLSX = makeFilesPath("page-breaks.xlsx");
    Path SAMPLE_XLSX_WITH_EMPTY_COLUMN = makeFilesPath("with_empty_column.xlsx");
    Path SAMPLE_XLSX_WITH_EMPTY_ROW = makeFilesPath("with_empty_row.xlsx");
    Path SAMPLE_XLSX_WITH_HIDDEN_ROW_AND_COLUMN = makeFilesPath("with_hidden_row_and_column.xlsx");
    Path SAMPLE_XLSX_WITH_TEXT_OVERFLOW = makeFilesPath("with_overflowing_text.xlsx");
    Path THREE_SHEETS = makeFilesPath("three_sheets.xlsx");
    Path SAMPLE_NUMBERS = makeFilesPath("sample.numbers");
    Path SAMPLE_XML_SPREADSHEETML = makeFilesPath("excel-2003-xml.xml");
    Path TWO_PAGES_XLSX = makeFilesPath("two-pages.xlsx");
    Path FOUR_PAGES_XLSX = makeFilesPath("four-pages.xlsx");

    // Word Processing documents

    Path SAMPLE_DOCX = makeFilesPath("sample.docx");
    Path SAMPLE_DOCX_WITH_COMMENT = makeFilesPath("with_comment.docx");
    Path SAMPLE_DOCX_WITH_PASSWORD = makeFilesPath("password_protected.docx");
    Path SAMPLE_DOCX_WITH_TRACKED_CHANGES = makeFilesPath("with_tracked_changes.docx");
    Path SAMPLE_TXT_SHIFT_JS_ENCODED = makeFilesPath("shift_jis_encoded.txt");
    Path WITH_EXTERNAL_IMAGE_DOC = makeFilesPath("with_external_image.doc");
    Path SAMPLE_HTML = makeFilesPath("sample.html");

    // Text
    Path SAMPLE_TXT = makeFilesPath("sample.txt");

    Path SAMPLE_2_TXT = makeFilesPath("sample2.txt");

    // Graphics
    Path MISSING_FONT_ODG = makeFilesPath("with_missing_font.odg");
    Path SAMPLE_FODG = makeFilesPath("sample.fodg");
    Path SAMPLE_SVGZ = makeFilesPath("sample.svgz");
    Path SAMPLE_WMZ = makeFilesPath("sample.wmz");
    Path SAMPLE_EMZ = makeFilesPath("sample.emz");
    Path SAMPLE_CDR = makeFilesPath("sample.cdr");
    Path SAMPLE_CMX = makeFilesPath("sample.cmx");
    Path SAMPLE_TGA = makeFilesPath("sample.tga");
    Path SAMPLE_APNG = makeFilesPath("sample.apng");

    // Web
    Path SAMPLE_CHM = makeFilesPath("sample.chm");

    //Issues
    Path SAMPLE_ISSUE_3827 = makeFilesPath("issues/IssuesV2502/preview_test_pdf.pdf");
    Path SAMPLE_ISSUE_2863 = makeFilesPath("issues/IssuesV2502/short-archive.zip");
    Path SAMPLE_ISSUE_3288 = makeFilesPath("issues/IssuesV2502/long-archive.zip");
}
