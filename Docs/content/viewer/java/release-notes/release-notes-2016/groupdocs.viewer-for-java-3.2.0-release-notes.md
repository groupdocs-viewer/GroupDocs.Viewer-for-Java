---
id: groupdocs-viewer-for-java-3-2-0-release-notes
url: viewer/java/groupdocs-viewer-for-java-3-2-0-release-notes
title: GroupDocs.Viewer for Java 3.2.0 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 3.2.0{{< /alert >}}

## Major Features

There are 36 improvements and fixes in this regular monthly release. The most notable are:

*   File detection from stream.
*   Introduced PdfFileOptions.
*   Introduced new conversion mechanism for multipage TIFF documents.
*   Introduced options to show/hide grid lines for excel documents.
*   Introduced jpeg image quality settings.
*   Introduced file description property which returns document type format.
*   Introduced method that returns supported document formats.
*   Introduced option that allows to set text document encoding.
*   Introduced Hide/Show the hidden sheets for Excel files option.
*   Custom localization engine to use custom locales from path.
*   Improved document processing fidelity and speed.
*   Improved quality of re-sized images.

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| WEB-2128 | New conversion mechanism for displaying multipage TIFF files | New Feature |
| VIEWERNET-542 | Implement option that allows to set text document encoding. | New Feature |
| VIEWERNET-495 | Implement method that returns supported document formats. | New Feature |
| VIEWERNET-494 | Implement file description property that returns document type format. | New Feature |
| VIEWERNET-484 | Provide jpeg image quality setting. | New Feature |
| VIEWERNET-469 | Implement configuration option that allows set cells sheet conversion mode when converting to pdf. | New Feature |
| VIEWERNET-434 | Add support for Portuguese locale | New Feature |
| VIEWERNET-415 | Add ability to show/hide grid lines for excel files | New Feature |
| VIEWERNET-393 | New conversion mechanism for displaying multipage TIFF files | New Feature |
| VIEWERNET-389 | Implement PdfFileOptions same as another Options classes. | New Feature |
| VIEWERNET-304 | Process files from stream without specifying fileName parameter | New Feature |
| VIEWERNET-525 | Implement storing cache files separately depends on use pdf option. | Improvement |
| VIEWERNET-515 | Improve quality of re-sized images. | Improvement |
| VIEWERNET-462 | Improve document processing fidelity and speed | Improvement |
| VIEWERNET-436 | User provided Excel Spreadsheet does not follow MS Excel behavior when rendered to PDF | Improvement |
| VIEWERNET-423 | Improve localization engine to use custom locales from path | Improvement |
| VIEWERNET-395 | Hide/Show the hidden sheets for Excel files | Improvement |
| WEB-2446 | DocuSign signed files not showing all content | Bug |
| WEB-2445 | Doc to Pdf save error | Bug |
| WEB-2441 | Empty html | Bug |
| WEB-2438 | Not all content of the pdf document rendered to html | Bug |
| WEB-2435 | High memory usage while converting to Pdf | Bug |
| WEB-2402 | Specific eml file can't be viewed in HTML mode | Bug |
| VIEWERNET-528 | Failed to rotate page if page number specified. | Bug |
| VIEWERNET-514 | Resolution is set incorrectly when converting pdf to image. | Bug |
| VIEWERNET-513 | Image re-sized incorrectly when re-sizing to larger dimensions. | Bug |
| VIEWERNET-493 | Css classes are overridden in multiple pages documents | Bug |
| VIEWERNET-486 | Shift\_JIS encoded characters are not showing in proper format | Bug |
| VIEWERNET-480 | PreloadPagesCount is not working in V3.0 | Bug |
| VIEWERNET-479 | Blurry document in Image Based rendering | Bug |
| VIEWERNET-472 | Invalid Parameter Exception on rendering PDF to HTML | Bug |
| VIEWERNET-455 | Underline for some words/sentences when saving to html/image | Bug |
| VIEWERNET-454 | Failed to convert .xlsx with fixed headers table to image. | Bug |
| VIEWERNET-453 | Conversion of .xlsx with fixed headers table to pdf never completes. | Bug |
| VIEWERNET-451 | Empty Value Exception on rendering PDF File | Bug |
| VIEWERNET-438 | Invalid Parameter Exception on rendering Excel Spreadsheet to HTML | Bug |
| VIEWERJAVA-1065 | Incorrect converting PPT file to HTML | Bug |
| VIEWERJAVA-1120 | The .pdf document doesn't rendered | Bug |

## Public API and Backward Incompatible Changes

##### How to show grid lines for Excel files

**Show grid lines for Excel files in image representation**



```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath("C:\\storage");

// Create image handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "document.xlsx";

// Set image options to show grid lines
ImageOptions options = new ImageOptions();
options.getCellsOptions().setShowGridLines(true);

List<PageImage> pages = imageHandler.getPages(guid, options);

for (PageImage page : pages)
{
    System.out.printf("Page number: " + page.getPageNumber());

    // Page image stream
    final InputStream imageContent = page.getStream();
}


```

**Show grid lines for Excel files in html representation**



```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath("C:\\storage");

// Create html handler
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
String guid = "document.xlsx";

// Set html options to show grid lines
HtmlOptions options = new HtmlOptions();
options.getCellsOptions().setShowGridLines(true);
List<PageHtml> pages = htmlHandler.getPages(guid, options);

for (PageHtml page : pages) {
    System.out.println("Page number: " + page.getPageNumber());
    System.out.println("Html content: " + page.getHtmlContent());
}


```

##### How to deny showing multiple pages per sheet for Excel files

**Multiple pages per sheet**



```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath("C:\\storage");

// Create image or html handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "document.xlsx";

// Set pdf file one page per sheet option to false, default value of this option is true
PdfFileOptions pdfFileOptions = new PdfFileOptions();
pdfFileOptions.setGuid(guid);
pdfFileOptions.getCellsOptions().setOnePagePerSheet(false);

//Get pdf file
FileContainer fileContainer = imageHandler.getPdfFile(pdfFileOptions);

//The pdf file stream
final InputStream pdfStream = fileContainer.getStream();


```

##### How to get all supported formats

**Get all supported document formats**



```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath("C:\\storage");

// Create image or html handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);

// Get supported document formats
DocumentFormatsContainer documentFormatsContainer = imageHandler.getSupportedDocumentFormats();
Map<String, String> supportedDocumentFormats = documentFormatsContainer.getSupportedDocumentFormats();

for (Map.Entry<String, String> supportedDocumentFormat : supportedDocumentFormats.entrySet()) {
    System.out.println(String.format("Extension: '%s'; Document format: '%s'", supportedDocumentFormat.getKey(), supportedDocumentFormat.getValue()));
}


```

##### Show hidden sheets for Excel files

**Show hidden sheets for Excel files in image representation**



```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath("C:\\storage");

// Create image handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "document.xlsx";

// Set image options to show grid lines
ImageOptions options = new ImageOptions();
options.getCellsOptions().setShowGridLines(true);

List<PageImage> pages = imageHandler.getPages(guid, options);

for (PageImage page : pages)
{
    System.out.printf("Page number: " + page.getPageNumber());

    // Page image stream
    final InputStream imageContent = page.getStream();
}


```

**Show hidden sheets for Excel files in image representation**



```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath("C:\\storage");

// Create image or html handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "document.xlsx";

// Set image options to show grid lines
ImageOptions options = new ImageOptions();
options.getCellsOptions().setShowHiddenSheets(true);

DocumentInfoContainer container = imageHandler.getDocumentInfo(new DocumentInfoOptions(guid));

for (PageData page : container.getPages())
 System.out.println(String.format("Page number: %d, Page Name: %s, IsVisible: %s", page.getNumber(), page.getName(), page.isVisible()));

List<PageImage> pages = imageHandler.getPages(guid, options);

for (PageImage page : pages) {
 System.out.println("Page number: " + page.getPageNumber());

 // Page image stream
 final InputStream imageContent = page.getStream();
}


```

##### Localization

**How to create and use file with localized strings**

1\. Create xml file with localized strings

**XML**

```java
<?xml version="1.0" encoding="utf-8" ?>
<root>
  <data name="EXC_TMPL_CORRUPTED_OR_DAMAGED_FILE">
    <value>Could not load file '{0}', file is corrupted or damaged.</value>
  </data>
  <data name="EXC_TMPL_FILE_TYPE_NOT_SUPPORTED">
    <value>File type '{0}' is not supported.</value>
  </data>
  <data name="EXC_TMPL_INVALID_PASSWORD">
    <value>Unable to decrypt file '{0}'. Password is invalid.</value>
  </data>
  <data name="EXC_TMPL_PASSWORD_PROTECTED_FILE">
    <value>Unable to open encrypted file '{0}'. Please provide password.</value>
  </data>
  <data name="EXC_TMPL_STORAGE_PATH_NOT_SPECIFIED">
    <value>The storage path is not specified. Please provide storage path.</value>
  </data>
  <data name="EXC_TMPL_CACHE_FILE_NOT_FOUND">
    <value>Could not find cached file '{0}'.</value>
  </data>
  <data name="EXC_TMPL_GUID_NOT_SPECIFIED">
    <value>The file GUID is not specified. Please provide file GUID.</value>
  </data>
  <data name="EXC_TMPL_TRANSFORMATION_FAILED_PAGE_NOT_EXIST">
    <value>Unable to transform file '{0}'. Page number '{1}' does not exist.</value>
  </data>
</root>


```

2\. Save file to disc e.g. "c://locales" with following name "LocalizedStrings-{Language Culture Name}.xml" where {Language Culture Name} is your culture name e.g. "fr-FR". So path is "c://locales//LocalizedStrings-fr-FR.xml"

3\. Setup ViewerConfig to use file with localized strings created above



```java
// Setup GroupDocs.Viewer config
ViewerConfig viewerConfig = new ViewerConfig();
viewerConfig.setStoragePath("c:\\storage");
viewerConfig.setLocalesPath("c:\\locales");

// Create html handler
ViewerHandler.CultureInfo cultureInfo = new ViewerHandler.CultureInfo("fr-FR");
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(viewerConfig, cultureInfo);


```

##### How to set Words, Cells and Email document encoding

**How to set Words, Cells and Email document encoding**



```java
//Initialize viewer config
ViewerConfig viewerConfig = new ViewerConfig();
viewerConfig.setStoragePath("c:\\storage");

//Initialize viewer handler
ViewerImageHandler viewerImageHandler = new ViewerImageHandler(viewerConfig);

//Set encoding
Charset encoding = Charset.forName("shift-jis");

//Set image options
ImageOptions imageOptions = new ImageOptions();
imageOptions.getWordsOptions().setEncoding(encoding);
imageOptions.getCellsOptions().setEncoding(encoding);
imageOptions.getEmailOptions().setEncoding(encoding);

//Get words document pages with encoding
String wordsDocumentGuid = "document.txt";
List<PageImage> wordsDocumentPages = viewerImageHandler.getPages(wordsDocumentGuid, imageOptions);

//Get cells document pages with encoding
String cellsDocumentGuid = "document.csv";
List<PageImage> cellsDocumentPages = viewerImageHandler.getPages(cellsDocumentGuid, imageOptions);

//Get email document pages with encoding
String emailDocumentGuid = "document.msg";
List<PageImage> emailDocumentPages = viewerImageHandler.getPages(emailDocumentGuid, imageOptions);

//Get words document info with encoding
DocumentInfoOptions wordsDocumentInfoOptions = new DocumentInfoOptions(wordsDocumentGuid);
wordsDocumentInfoOptions.getWordsDocumentInfoOptions().setEncoding(encoding);
DocumentInfoContainer wordsDocumentInfoContainer = viewerImageHandler.getDocumentInfo(wordsDocumentInfoOptions);

//Get cells document info with encoding
DocumentInfoOptions cellsDocumentInfoOptions = new DocumentInfoOptions(cellsDocumentGuid);
cellsDocumentInfoOptions.getCellsDocumentInfoOptions().setEncoding(encoding);
DocumentInfoContainer cellsDocumentInfoContainer = viewerImageHandler.getDocumentInfo(cellsDocumentInfoOptions);

//Get email document info with encoding
DocumentInfoOptions emailDocumentInfoOptions = new DocumentInfoOptions(emailDocumentGuid);
emailDocumentInfoOptions.getEmailDocumentInfoOptions().setEncoding(encoding);
DocumentInfoContainer emailDocumentInfoContainer = viewerImageHandler.getDocumentInfo(emailDocumentInfoOptions);


```
