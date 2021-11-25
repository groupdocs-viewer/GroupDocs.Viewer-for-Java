package com.groupdocs.viewer.examples;

import java.io.File;

public class TestFiles {

    // Archives
    public static final String SAMPLE_ZIP = getSampleFilePath("sample.zip");
    public static final String SAMPLE_ZIP_WITH_FOLDERS = getSampleFilePath("with_folders.zip");
    public static final String SAMPLE_RAR_WITH_FOLDERS = getSampleFilePath("with_folders.rar");

    // CAD drawings
    public static final String SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS = getSampleFilePath("with_layers_and_layouts.dwg");
    public static final String SAMPLE_PLT = getSampleFilePath("sample.plt");
    public static final String SAMPLE_AI = getSampleFilePath("sample.ai");
    public static final String SAMPLE_CF2 = getSampleFilePath("sample.cf2");
    public static final String SAMPLE_IGS = getSampleFilePath("sample.igs");
    public static final String SAMPLE_OBJ = getSampleFilePath("sample.obj");
    public static final String SAMPLE_HPG = getSampleFilePath("sample.hpg");
    public static final String SAMPLE_PC3_CONFIG = getSampleFilePath("small_page.pc3");

    // Email messages
    public static final String SAMPLE_MSG = getSampleFilePath("sample.msg");
    public static final String SAMPLE_MSG_WITH_ATTACHMENTS = getSampleFilePath("with_attachments.msg");
    public static final String SAMPLE_OST = getSampleFilePath("sample.ost");
    public static final String SAMPLE_PST = getSampleFilePath("sample.pst");
    public static final String SAMPLE_OST_SUBFOLDERS = getSampleFilePath("with_subfolders.ost");
    public static final String SAMPLE_NSF = getSampleFilePath("sample.nsf");
    public static final String SAMPLE_EML = getSampleFilePath("sample.eml");

    // PDFs
    public static final String SAMPLE_PDF = getSampleFilePath("sample.pdf");
    public static final String HIEROGLYPHS_PDF = getSampleFilePath("hieroglyphs.pdf");
    public static final String HIEROGLYPHS_1_PDF = getSampleFilePath("hieroglyphs_1.pdf");
    public static final String ENCRYPTED = getSampleFilePath("encrypted.pdf");
    public static final String ONE_PAGE_TEXT_PDF = getSampleFilePath("one-page-text.pdf");

    // Presentations
    public static final String PPTX_WITH_NOTES = getSampleFilePath("with_notes.pptx");
    public static final String SAMPLE_PPTX_HIDDEN_PAGE = getSampleFilePath("with_hidden_page.pptx");
    public static final String MISSING_FONT_PPTX = getSampleFilePath("with_missing_font.pptx");
    public static final String JPG_IMAGE_PPTX = getSampleFilePath("with_jpg_image.pptx");
    public static final String SAMPLE_FODP = getSampleFilePath("sample.fodp");

    // Project Management documents
    public static final String SAMPLE_MPP = getSampleFilePath("sample.mpp");
    // Visio files
    public static final String SAMPLE_VISIO = getSampleFilePath("sample.vssx");

    // Spreadsheets
    public static final String SAMPLE_XLSX = getSampleFilePath("sample.xlsx");
    public static final String SAMPLE_XLSX_WITH_PRINT_AREAS = getSampleFilePath("with_four_print_areas.xlsx");
    public static final String PAGE_BREAKS_XLSX = getSampleFilePath("page-breaks.xlsx");
    public static final String SAMPLE_XLSX_WITH_EMPTY_COLUMN = getSampleFilePath("with_empty_column.xlsx");
    public static final String SAMPLE_XLSX_WITH_EMPTY_ROW = getSampleFilePath("with_empty_row.xlsx");
    public static final String SAMPLE_XLSX_WITH_HIDDEN_ROW_AND_COLUMN = getSampleFilePath("with_hidden_row_and_column.xlsx");
    public static final String SAMPLE_XLSX_WITH_TEXT_OVERFLOW = getSampleFilePath("with_overflowing_text.xlsx");
    public static final String THREE_SHEETS = getSampleFilePath("three_sheets.xlsx");
    public static final String SAMPLE_NUMBERS = getSampleFilePath("sample.numbers");
    public static final String SAMPLE_XML_SPREADSHEETML = getSampleFilePath("excel-2003-xml.xml");
    public static final String TWO_PAGES_XLSX = getSampleFilePath("two-pages.xlsx");
    public static final String FOUR_PAGES_XLSX = getSampleFilePath("four-pages.xlsx");

    // Word Processing documents

    public static final String SAMPLE_DOCX = getSampleFilePath("sample.docx");
    public static final String SAMPLE_DOCX_WITH_COMMENT = getSampleFilePath("with_comment.docx");
    public static final String SAMPLE_DOCX_WITH_PASSWORD = getSampleFilePath("password_protected.docx");
    public static final String SAMPLE_DOCX_WITH_TRACKED_CHANGES = getSampleFilePath("with_tracked_changes.docx");
    public static final String SAMPLE_TXT_SHIFT_JS_ENCODED = getSampleFilePath("shift_jis_encoded.txt");
    public static final String WITH_EXTERNAL_IMAGE_DOC = getSampleFilePath("with_external_image.doc");
    public static final String SAMPLE_HTML = getSampleFilePath("sample.html");

    // Text
    public static final String SAMPLE_TXT = getSampleFilePath("sample.txt");

    public static final String SAMPLE_2_TXT = getSampleFilePath("sample2.txt");

    // Graphics
    public static final String MISSING_FONT_ODG = getSampleFilePath("with_missing_font.odg");
    public static final String SAMPLE_FODG = getSampleFilePath("sample.fodg");
    public static final String SAMPLE_SVGZ = getSampleFilePath("sample.svgz");
    public static final String SAMPLE_WMZ = getSampleFilePath("sample.wmz");
    public static final String SAMPLE_EMZ = getSampleFilePath("sample.emz");
    public static final String SAMPLE_CDR = getSampleFilePath("sample.cdr");
    public static final String SAMPLE_CMX = getSampleFilePath("sample.cmx");
    public static final String SAMPLE_TGA = getSampleFilePath("sample.tga");
    public static final String SAMPLE_APNG = getSampleFilePath("sample.apng");

    // Web
    public static final String SAMPLE_CHM = getSampleFilePath("sample.chm");

    private static String getSampleFilePath(String filePath) {
        return new File(Utils.SAMPLES_PATH, filePath).getPath();
    }
}
