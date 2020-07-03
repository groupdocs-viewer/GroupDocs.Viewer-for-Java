---
id: groupdocs-viewer-for-java-17-5-0-release-notes
url: viewer/java/groupdocs-viewer-for-java-17-5-0-release-notes
title: GroupDocs.Viewer for Java 17.5.0 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 17.5.0.{{< /alert >}}

## Major Features

This release includes new features, improvements, and fixes. The most notable are:

*   Added file formats support
    *   Microsoft Visio: VSTX, VSSX
    *   OneNote: ONE
    *   DjVu (multi-layer raster image)
*   Added option to hide tracked changes when converting Text documents
*   Added option to delete annotations when rendering PDF documents
*   Added option for adjusting the size when rendering CAD documents
*   Added option for specifying Layouts when rendering CAD documents
*   Added option that switches on more accurate rendering of complex PDF documents

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| WEB-2143 | Get print URl for document in JavaScript API | New Feature |
| VIEWERNET-739 | Add DJVU file format support | New Feature |
| VIEWERNET-797 | Hide tracked changes when converting Words documents | New Feature |
| VIEWERNET-1066 | Implement setting to delete annotations when rendering pdf documents | New Feature |
| VIEWERNET-1100 | Integrate Dynabic.Metered into GroupDocs.Viewer | New Feature |
| VIEWERNET-1106 | Implement settings for adjusting the size of CAD documents rendering | New Feature |
| VIEWERNET-1109 | Add VSSX file format support | New Feature |
| VIEWERNET-1110 | Add VSTX file format support | New Feature |
| VIEWERNET-1146 | Implement setting for specifying Layouts when rendering Cad documents | New Feature |
| VIEWERNET-474 | Render one or range of worksheets from large excel file. | Improvement |
| VIEWERNET-1076 | Remove obsolete CountPagesToConvert and PageNumbersToConvert RenderOptions properties | Improvement |
| VIEWERNET-1077 | Add code examples to PdfOptions class documentation comments | Improvement |
| VIEWERNET-1078 | Add code examples to CellsOptions class documentation comments | Improvement |
| VIEWERNET-1079 | Add code examples to DiagramOptions class documentation comments | Improvement |
| VIEWERNET-1080 | Add code examples to EmailOptions class documentation comments | Improvement |
| VIEWERNET-1084 | Remove members marked as obsolete in previous versions | Improvement |
| VIEWERNET-1161 | Implement a setting that switches on more accurate rendering of pdf documents | Improvement |
| VIEWERNET-1163 | Do not set resource prefix when HtmlResourcePrefix is empty string | Improvement |
| VIEWERNET-1164 | Improve look of comments in API reference documentation | Improvement |
| VIEWERNET-1167 | CellsOptions.ShowGridLines property does not work when rendering Cells to PDF | Improvement |
| VIEWERNET-1170 | Extend support for setting JpegQuality when rendering documents as pdf | Improvement |
| VIEWERNET-1190 | Throw GroupDocsViewerException when file type can't be determined for passed stream | Improvement |
| VIEWERNET-1194 | Create lower-case name when rendering document from stream | Improvement |
| VIEWERJAVA-1205 | CustomCacheHandler is written for S3 Bucket but still uses local disk for cache | Improvement |
| VIEWERJAVA-1363 | Pdf rendering to HTML taking a lot of time | Improvement |
| WEB-1152 | Color filling isn't displayed for some objects | Bug |
| VIEWERNET-756 | Incorrect Font Color in Rendering Excel to Html | Bug |
| VIEWERNET-793 | Email attachments are not found when setting UsePDF to true | Bug |
| VIEWERNET-874 | HTMLSaveOptions.DefaultFont setting doesn't work properly | Bug |
| VIEWERNET-938 | Save method requires System.Web reference | Bug |
| VIEWERNET-987 | Incomplete image when converting specific dwg | Bug |
| VIEWERNET-1025 | Character's size issue when rendering PDF document into HTML | Bug |
| VIEWERNET-1026 | API is rendering PDF document into blank HTML pages | Bug |
| VIEWERNET-1038 | Incorrect resource relative path when rendering to Html | Bug |
| VIEWERNET-1091 | Black background when rendering pps or ppt to image | Bug |
| VIEWERNET-1094 | Issue in HtmlResourcePrefix when Rendering .msg File | Bug |
| VIEWERNET-1095 | Issue with Underline Text when Rendering PDF into HTML | Bug |
| VIEWERNET-1099 | IgnoreResourcePrefixForCss is ignored when rendering Words documents | Bug |
| VIEWERNET-1133 | Overflow Text is Not Visible when Rendering Excel Sheet to HTML | Bug |
| VIEWERJAVA-647 | PDF to HTML fixed layout issue | Bug |
| VIEWERJAVA-817 | Lines are too thin when rendering PDF as HTML | Bug |
| VIEWERJAVA-818 | Pdf to Html space and positioning issues | Bug |
| VIEWERJAVA-990 | PDF to HTML images color issue | Bug |
| VIEWERJAVA-1312 | getLastModificationDate is not showing last modification date as expected | Bug |
| VIEWERJAVA-1314 | GroupDocs.Viewer for Java latest Jar file lacks few imports | Bug |
| VIEWERJAVA-1370 | Excel file with blank sheets not rendering to image | Bug |
| VIEWERJAVA-1391 | Excel files are not rendering to image | Bug |
| VIEWERJAVA-1392 | ImageOptions is not working as expected | Bug |
| VIEWERJAVA-1490 | PPTX/XLSX documents are not rendering to Images properly | Bug |
| VIEWERJAVA-1498 | Duplicate pages are generated in cache if API is used in trial mode | Bug |
| VIEWERJAVA-1513 | Image-based rendering issues | Bug |
| VIEWERJAVA-1503 | Style-sheet link is incorrect if HTML is generated with ResourcesEmbedded = false | Bug |

##  Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Viewer for Java 17.5.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Viewer which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### File format support

Support of following file formats has been added to GroupDocs.Viewer.

*   DJVU 
*   VSSX 
*   VSTX  
*   ONE

### Using Dynabic.Metered into GroupDocs.Viewer

You can also set Metered license as an alternative to license file. It is a new licensing mechanism that will be used along with existing licensing method. It is useful if you want to be billed based on the usage of the API features. For more details, please refer to [Metered Licensing FAQ](https://www.groupdocs.com/corporate/purchase/faqs/metered-faq) section.

```java
// Set metered key
Metered metered = new Metered();
metered.setMeteredKey("****", "****");
```

### Adjusting the size while rendering CAD documents

When CAD documents are rendered, the size of the render result is adjusted by API automatically depending on the size of the initial document. You may adjust the size of resulting document by setting CadOptions property as shown in the example.

**Setting result image size when rendering Cad documents**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create image handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "document.dwg";
 
// Set Cad options to render content with a specified size
ImageOptions options = new ImageOptions();
options.getCadOptions().setHeight(750);
options.getCadOptions().setWidth(450);
 
// Get pages
List<PageImage> pages = imageHandler.getPages(guid, options);
 
for (PageImage page : pages)
{
    System.out.println("Page number: " + page.getPageNumber());
    InputStream imageContent = page.getStream();
}
```

The following logic for sizing CAD document rendering is applied:

1.  If both CadOptions.Height and CadOptions.Width properties are set, the resulting image will have the same size in pixels
2.  If only one of CadOptions.Height and CadOptions.Width is set, the value of another side will be calculated from the ratio in the original document. If  CadOptions.Height is set as 600 and the ratio of the height to width in original CAD document is 6 to 5, then the width of the resulting image will be 500 px
3.  If not one of CadOptions.Height and CadOptions.Width is set or set as 0, the CadOptions.ScaleFactor will be used to form resulting image size. The data type of this property is float, values higher than 1 will enlarge resulting image and values between 0 and 1 will make the image smaller. If the render result image size is equal to 200 px to 200 px, when CadOptions.ScaleFactor is equal to 1, then setting this value to 0.1 will provide image with 20 px to 20 px dimension
4.  When CadOptions are not set size of resulting image is set  by API

The same logic is applied when rendering to HTML. When rendering to PDF, generally only height to width ratio matters

### Rendering pdf documents without annotations

When rendering PDF documents with annotations, by default annotations are represented in the resultant document. But sometimes you might want not to include annotations in resultant documents. In such cases set RenderOptions (ImageOptions or HtmlOptions)  PdfOptions.DeleteAnnotations property as true and pass it to GetPages method of corresponding ViewerHandler (ViewerImageHandler or ViewerHtmlHandler) as shown in the example below.

**How to render pdf documents and exclude annotations from rendering result**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create html handler
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
String guid = "DocumentWithAnnotations.pdf";
 
// Set pdf options to render content without annotations
HtmlOptions options = new HtmlOptions();
options.getPdfOptions().setDeleteAnnotations(true); // Default value is false
 
// Get pages
List<PageHtml> pages = htmlHandler.getPages(guid, options);
 
for (PageHtml page : pages) {
    System.out.println("Page number: " + page.getPageNumber());
    System.out.println("Html content: " + page.getHtmlContent());
}
```

In order to get original file without annotations, set PdfFileOptions PdfOptions.DeleteAnnotations property as true and pass it to GetPdfFile method of corresponding ViewerHandler (ViewerImageHandler or ViewerHtmlHandler) as shown in the example below.

**How to get original pdf document without annotations**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create image handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "DocumentWithAnnotations.pdf";
 
// Set pdf options to get original file without annotations
PdfFileOptions pdfFileOptions = new PdfFileOptions();
pdfFileOptions.getPdfOptions().setDeleteAnnotations(true); // Default value is false
 
// Get original pdf document without annotations
FileContainer fileContainer = imageHandler.getPdfFile(guid, pdfFileOptions);
// Access result pdf document using fileContainer.Stream property
```

### Rendering Words documents with tracked changes

Rendering Words document, by default will provide result without tracked changes. If you want to see tracked changes in your render result use WordsOptions.setShowTrackedChanges property of RenderOptions (ImageOptions or HtmlOptions) and pass it to corresponding ViewerHandler (ViewerImageHandler or ViewerHtmlHandler) as shown in sample code below.

**Rendering words documents with tracked changes**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create html handler
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
String guid = "document.docx";
 
// Set pdf options to render tracked changes 
HtmlOptions options = new HtmlOptions();
options.getWordsOptions().setShowTrackedChanges(true); // Default value is false
 
// Get pages 
List<PageHtml> pages = htmlHandler.getPages(guid, options);
 
for (PageHtml page : pages) {
    System.out.println("Page number: " + page.getPageNumber());
    System.out.println("Html content: " + page.getHtmlContent());
}
```

To get PDF representation of tracked changes from Words document, set PdfFileOptions WordsOptions.setShowTrackedChanges property as true and pass it to GetPdfFile method of the corresponding ViewerHandler (ViewerImageHandler or ViewerHtmlHandler) as shown in the example below.

**Get PDF representation of Words document with tracked changes**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create image handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "DocumentWithAnnotations.pdf";
 
// Set pdf options to get pdf file with tracked changes
PdfFileOptions pdfFileOptions = new PdfFileOptions();
pdfFileOptions.getWordsOptions().setShowTrackedChanges(true); // Default value is false
 
// Get pdf document with tracked changes
FileContainer fileContainer = imageHandler.getPdfFile(guid, pdfFileOptions);
// Access result pdf document using fileContainer.Stream property
```

### How to set output quality when rendering documents into PDF

When documents are rendered as PDF, sometimes we might be unhappy with a very big size of the resulting pdf, or we might intentionally want to reduce the quality of render result. For this purpose, you can use pdfFileOptions.setJpegQuality property as shown in the example below. Valid values for this option are in the range between 1 and 100, where 100 stands for the best quality and biggest size and 1 stands for the lowest quality and lowest size of resulting pdf document. The default value is 90. Since the version 17.5.0 support for additional document types has been added. Please refer to the table below to see which document types are affected.

**How to adjust the quality and size when rendering DjVu into pdf**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create html handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "document.djvu";
 
// Set pdf options JpegQuality in a range between 1 and 100
PdfFileOptions pdfFileOptions = new PdfFileOptions();
pdfFileOptions.setJpegQuality(5);
 
// Get file as pdf
FileContainer container = imageHandler.getPdfFile(guid, pdfFileOptions);
 
System.out.println("Name: " + container.getStream().available());
```

##### List of formats affected by PdfFileOptions.JpegQuality property when rendered as pdf

| Format Name | Description |
| --- | --- |
| Microsoft Word | Affects JPEG images contained in Microsoft Word documents |
| Microsoft PowerPoint | Affects JPEG images contained in Microsoft PowerPoint documents |
| Microsoft Outlook | Affects JPEG images set as a background in email documents msg and eml formats |
| OpenDocument Formats | Affects JPEG images contained in OpenDocument presentation (odp) andOpenDocument text (odt) formats |
| Image files | Affects rendering from PSD, TIFF, multi-page TIFF, WebP, SVG and DjVu formats |
| Metafile | Affects rendering from WMF and EMF formats |
| Microsoft Visio | Affects JPEG images contained inside Microsoft Visio documents |

### Rendering layouts from CAD documents

#### How to render Model together with Layouts from CAD documents

When CAD documents are rendered, by default we get only Model representation. In order to render Model and all non-empty Layouts within CAD document, in version 17.5.0 a new property cadOptions.setRenderLayouts of an ImageOptions and HtmlOptions has been introduced.

**Rendering Model and all non empty Layouts from CAD document**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create html handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "document.dwg";
 
// Set CAD options to render Model and all non empty Layouts
ImageOptions options = new ImageOptions();
options.getCadOptions().setRenderLayouts(true);
 
// Get pages
List<PageImage> pages = imageHandler.getPages(guid, options);
 
for (PageImage page : pages)
{
    System.out.println("Page number: " + page.getPageNumber());
    InputStream imageContent = page.getStream();
}
```

#### How to render specific Layout from CAD documents

Since the version 17.5.0, in order to render specific Layout, please use cadOptions.setLayoutName property of an ImageOptions and HtmlOptions. When this property is set, cadOptions.setRenderLayouts property will be ignored.

**Rendering specific Layout from Cad document**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create html handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "document.dwg";
 
// Set CAD options to render specific Layout
ImageOptions options = new ImageOptions();
options.getCadOptions().setLayoutName("MyFirstLayout");
 
// Get pages
List<PageImage> pages = imageHandler.getPages(guid, options);
 
for (PageImage page : pages)
{
    System.out.println("Page number: " + page.getPageNumber());
    InputStream imageContent = page.getStream();
}
```

#### How to obtain the list of Layouts contained in CAD document

To get the list of Layouts contained in CAD document, use getDocumentInfo of corresponding ViewerHandler as shown in the example:

**How to get the list of Layouts from CAD document**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create html handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "document.dwg";
 
// Set CAD options to get the full list of Layouts
DocumentInfoOptions documentInfoOptions = new DocumentInfoOptions();
documentInfoOptions.getCadOptions().setRenderLayouts(true);
 
// Get DocumentInfoContainer and iterate through pages
DocumentInfoContainer documentInfoContainer = imageHandler.getDocumentInfo(guid, documentInfoOptions);
 
System.out.println("Name: " + documentInfoContainer.getName());
System.out.println("Name: " + documentInfoContainer.getPages());
```

### Managing text overflow when rendering Cells documents to HTML

When cells documents are rendered into HTML, overflowed text inside the cell overlays subsequent cells until it meets nonempty cell. Since the version 17.5.0, there is a setting to configure the mode which will be used for rendering overflowed text:

1.  To set the overflowed text to be hidden, set CellsOptions.TextOverflowMode of HtmlOption to TextOverflowMode.HideText as shown in the example below.
2.  To set the overflowed text to overlay subsequent cells untill it meets non empty cell, set CellsOptions.TextOverflowMode of HtmlOption to TextOverflowMode.OverlayIfNextIsEmpty. This is a default value of the CellsOptions.TextOverflowMode.
3.  To set the overflowed text to overlay subsequent cells even they are not empty, set CellsOptions.TextOverflowMode of HtmlOption to TextOverflowMode.Overlay.

**Setting overflowed text to be hidden when rendering Cells documents**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create html handler
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
String guid = "document.xlsx";
 
// Set Cells options to hide overflowing text
HtmlOptions options = new HtmlOptions();
options.getCellsOptions().setTextOverflowMode(TextOverflowMode.HideText);
 
// Get pages
List<PageHtml> pages = htmlHandler.getPages(guid, options);
 
for (PageHtml page : pages) {
    System.out.println("Page number: " + page.getPageNumber());
    final String htmlContent = page.getHtmlContent();
    System.out.println("Html content: " + htmlContent);
}
```

### Enabling precise mode when rendering pdf documents

{{< alert style="info" >}}Since the version 17.5.0 PreventGlyphsGrouping property of PdfOptions class is set deprecated, use this feature instead. {{< /alert >}}

When pdf documents are rendered, we get similar representation in image and HTML formats, but sometimes result of rendering may contain shifted characters, symbols or document objects.To improve render result in such cases please use pdfOptions.setEnablePreciseRendering as shown in the example below. This option includes technics for more accurate representation of documents both in HTML and image formats.

**How to render pdf document in a precise mode.**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create html handler
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
String guid = "document.pdf";
 
// Set pdf options to render content in a precise mode
HtmlOptions options = new HtmlOptions();
options.getPdfOptions().setEnablePreciseRendering(true); // Default value is false
 
// Get pages
List<PageHtml> pages = htmlHandler.getPages(guid, options);
 
for (PageHtml page : pages) {
    System.out.println("Page number: " + page.getPageNumber());
    System.out.println("Html content: " + page.getHtmlContent());
}
```

### Rendering documents with comments

Some document types like Microsoft Word, Excel, OpenOffice Text and Spreadsheet may contain comments. By default comments are not rendered. Since the version 17.5.0 there is a new option - **setRenderComments** property of RenderOptions (ImageOptions or HtmlOptions) that enables comments rendering. Currently, this option works for Microsoft Word, Excel, OpenOffice Text and Spreadsheet document types. We are planning to extend support for this option to work with other document types in nearest coming API versions. See example below on how to use this option.

**Rendering Microsoft Word document with comments**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create html handler
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
String guid = "document.docx";
 
// Set words options to render content with comments
HtmlOptions options = new HtmlOptions();
options.setRenderComments(true); // Default value is false
 
 
// Get pages
List<PageHtml> pages = htmlHandler.getPages(guid, options);
 
for (PageHtml page : pages) {
    System.out.println("Page number: " + page.getPageNumber());
    final String htmlContent = page.getHtmlContent();
    System.out.println("Html content: " + htmlContent);
}
```

To get PDF representation with comments, set pdfFileOptions.setRenderComments property as true and pass it to getPdfFile method of the corresponding ViewerHandler (ViewerImageHandler or ViewerHtmlHandler) as shown in example below.

**Get PDF representation of Microsoft Word document with comments**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
 
// Create html handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);
String guid = "document.docx";
 
// Set pdf options to get pdf file with comments
PdfFileOptions pdfFileOptions = new PdfFileOptions();
pdfFileOptions.setRenderComments(true); // Default value is false
 
// Get pdf document with comments
FileContainer container = imageHandler.getPdfFile(guid, pdfFileOptions);
 
System.out.println("Name: " + container.getStream().available());
assertTrue(container.getStream().available() > 0);
```

### Rendering document from stream 

1.  Throw GroupDocsViewerException when file type can't be determined for passed stream - GroupDocs.Viewer will throw GroupDocsViewerException instead of EndOfStreamException when GroupDocs.Viewer can't determine file type
2.  Create lower-case name when rendering document from the stream - GroupDocs.Viewer will create a lower-case name for the document. Name consists of 32 digits separated by hyphens: 00000000-0000-0000-0000-000000000000 (GUID) and extension e.g. 00000000-0000-0000-0000-000000000000.docx
