package com.groupdocs.viewer.examples;

import java.io.File;

public class SampleFiles {

	// Archives
	public static String SAMPLE_ZIP_WITH_FOLDERS = getSampleFilePath("with_folders.zip");

	// Diagrams
	public static String SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS = getSampleFilePath("with_layers_and_layouts.dwg");

	// Email messages
	public static String SAMPLE_MSG = getSampleFilePath("sample.msg");
	public static String SAMPLE_MSG_WITH_ATTACHMENTS = getSampleFilePath("with_attachments.msg");
	public static String SAMPLE_OST = getSampleFilePath("sample.ost");
	public static String SAMPLE_OST_SUBFOLDERS = getSampleFilePath("with_subfolders.ost");

	// PDFs
	public static String SAMPLE_PDF = getSampleFilePath("sample.pdf");
	public static String HIEROGLYPHS_PDF = getSampleFilePath("hieroglyphs.pdf");
	public static String HIEROGLYPHS_1_PDF = getSampleFilePath("hieroglyphs_1.pdf");

	// Presentations
	public static String PPTX_WITH_NOTES = getSampleFilePath("with_notes.pptx");
	public static String SAMPLE_PPTX_HIDDEN_PAGE = getSampleFilePath("with_hidden_page.pptx");
	public static String MISSING_FONT_PPTX = getSampleFilePath("with_missing_font.pptx");
	public static String JPG_IMAGE_PPTX = getSampleFilePath("with_jpg_image.pptx");

	// Project Management documents
	public static String SAMPLE_MPP = getSampleFilePath("sample.mpp");

	// Spreadsheets
	public static String SAMPLE_XLSX = getSampleFilePath("sample.xlsx");
	public static String SAMPLE_XLSX_WITH_PRINT_AREAS = getSampleFilePath("with_four_print_areas.xlsx");
	public static String SAMPLE_XLSX_WITH_EMPTY_COLUMN = getSampleFilePath("with_empty_column.xlsx");
	public static String SAMPLE_XLSX_WITH_EMPTY_ROW = getSampleFilePath("with_empty_row.xlsx");
	public static String SAMPLE_XLSX_WITH_HIDDEN_ROW_AND_COLUMN = getSampleFilePath("with_hidden_row_and_column.xlsx");
	public static String SAMPLE_XLSX_WITH_TEXT_OVERFLOW = getSampleFilePath("with_overflowing_text.xlsx");

	// Word Processing documents

	public static String SAMPLE_DOCX = getSampleFilePath("sample.docx");
	public static String SAMPLE_DOCX_WITH_COMMENT = getSampleFilePath("with_comment.docx");
	public static String SAMPLE_DOCX_WITH_PASSWORD = getSampleFilePath("password_protected.docx");
	public static String SAMPLE_DOCX_WITH_TRACKED_CHANGES = getSampleFilePath("with_tracked_changes.docx");
	public static String SAMPLE_TXT_SHIFT_JS_ENCODED = getSampleFilePath("shift_jis_encoded.txt");

	private static String getSampleFilePath(String filePath) {
		return new File(Utils.SAMPLES_PATH, filePath).getPath();
	}
}
