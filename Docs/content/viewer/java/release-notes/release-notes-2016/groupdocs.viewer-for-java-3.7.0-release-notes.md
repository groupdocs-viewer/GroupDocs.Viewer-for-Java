---
id: groupdocs-viewer-for-java-3-7-0-release-notes
url: viewer/java/groupdocs-viewer-for-java-3-7-0-release-notes
title: GroupDocs.Viewer for Java 3.7.0 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 3.7.0{{< /alert >}}

## Major Features

There are improvements and fixes in this regular monthly release. The most notable are:

*   Introduced option to specify custom fonts path.
*   Introduced new methods for working with email attachments.
*   Introduced new methods for getting info for remotely located document or document in the form of stream.
*   Introduced ability to clear cache.
*   Introduced options to set opacity setting for watermark in html mode.
*   Improved rendering performance.
*   Improved rendering performance.
*   Improved applying watermark performance.
*   Improved GetPdfFile method usability and performance.
*   Implemented saving Cells document sheet to multiple pages in image mode.
*   Ability to specify font for watermark.
*   Add support for Spanish locale.
*   Add support for Italian locale
*   Hide/Show the hidden pages for Visio files
*   Ability to set default font when rendering Cells and Words documents
*   Ability to set the encoding standard automatically
*   LaTeX file format viewing support
*   Save html resources to cache without saving them to local disc
*   Improve rendering Pdf Dynamic XFA Forms
*   Ability to set default font when rendering Diagram documents
*   EMF and DICOM file format viewing support
*   Fixed html watermak rendering

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERNET-631 | Add ability to specify custom fonts path | New Feature |
| VIEWERNET-475 | Opacity setting for Watermark | New Feature |
| VIEWERNET-416 | Get selected attachment from email documents | New Feature |
| VIEWERNET-414 | Render attachments from email documents | New Feature |
| VIEWERNET-478 | Pre-Render Information required of a remotely located document or document in the form of streams | New Feature |
| VIEWERNET-459 | Provide remove old cache utility feature in the next generation API | New Feature |
| VIEWERNET-733  | Implement saving Cells document sheet to multiple pages in image mode | New Feature |
| VIEWERNET-787 | Implement ability to specify font for watermark | New Feature |
| VIEWERNET-394 | Support for hyperlinks referencing a worksheet in the same document | New Feature |
| VIEWERNET-433 | Add support for Spanish locale | New Feature |
| VIEWERNET-435 | Add support for Italian locale | New Feature |
| VIEWERNET-639 | Hide/Show the hidden pages for Visio files | New Feature |
| VIEWERNET-801 | Ability to set default font when rendering Cells documents | New Feature |
| VIEWERNET-802 | Ability to set default font when rendering Words documents | New Feature |
| WEB-2073 | LaTeX file format viewing support | New Feature |
| WEB-1084 | The ability to show and hide PDF layers | New Feature |
| VIEWERNET-871 | Ability to set default font when rendering Diagram documents | New Feature |
| VIEWERNET-851 | Implement support of EMF file type. | New Feature |
| VIEWERNET-549 | DICOM format support | New Feature |
| VIEWERNET-582 | The GroupDocs.Viewer 3.x is slower than 2.19 in performance | Improvement |
| VIEWERNET-641  | Update DocumentInfoOptions Cells/Words/Email DocumentInfoOptions properties names and types | Improvement |
| VIEWERNET-640 | Remove duplicated document name header in Project document converted to html | Improvement |
| VIEWERNET-636 | Remove border in html that was converted from words document | Improvement |
| VIEWERNET-619 | Implement adding prefix to font-family property if it can be overriden | Improvement |
| VIEWERNET-614 | Implement transparent watermarking in html mode | Improvement |
| VIEWERNET-600 | Improve performance of extracting document information in image mode | Improvement |
| VIEWERNET-590 | Apply HtmlResourcePrefix to fonts mentioned in css files | Improvement |
| VIEWERNET-568 | Load document only when not cached | Improvement |
| VIEWERNET-557 | Improve temp files folder structure | Improvement |
| VIEWERNET-558 | Improve processing remote files by Uri | Improvement |
| VIEWERNET-628 | Implement RotatePage method that returns void | Improvement |
| VIEWERNET-663 | Improve library performance | Improvement |
| VIEWERNET-665 | Improve applying watermark performance | Improvement |
| VIEWERNET-670 | Improve get pdf file performance | Improvement |
| VIEWERNET-674 | Improve GetPdfFile method usability | Improvement |
| VIEWERNET-721 | Improve Words files to html rendering speed | Improvement |
| VIEWERNET-732 | Implement saving file data separately based on options | Improvement |
| VIEWERNET-748 | Implement releasing converters resources | Improvement |
| VIEWERNET-401 | Improve applying pdf document transformations | Improvement |
| VIEWERNET-803 | Ability to set the encoding standard automatically | Improvement |
| VIEWERNET-824 | Cleanup GetDocumentInfo method response | Improvement |
| VIEWERNET-826 | Remove XHTML xmlns attribute | Improvement |
| VIEWERNET-827 | Cleanup html markup for Cells documents | Improvement |
| VIEWERNET-899 | Convert Pdf Dynamic XFA Form to Standard AcroForm | Improvement |
| VIEWERNET-895 | Mark CachedPageDescription redundant constructor as Obsolete | Improvement |
| VIEWERNET-873 | Save html resources to cache without saving them to local disc. | Improvement |
| VIEWERNET-616 | Implement GetPdfFile from stream or remote file | Improvement |
| WEB-1734 | Hide the hidden sheets for .xls file | Improvement |
| WEB-1107 | Convert a document page to JPEG in about 0.1 second | Improvement |
| WEB-905 | Links for mail attachments | Improvement |
| VIEWERNET-642 | GetDocumentInfo Method Throws Exception in Evaluation Mode | Bug |
| VIEWERNET-632 | The HtmlResourcePrefix {page-number} is not set in DiagramToHtmlConverter | Bug |
| VIEWERNET-476 | Some characters are not showing in correct format when render as HTML | Bug |
| VIEWERNET-591 | 'System.OutOfMemoryException' thrown while rendering as image | Bug |
| VIEWERNET-605 | Only first frame or tiff document converted in image mode | Bug |
| VIEWERNET-606 | Only first frame or tiff document converted in image mode | Bug |
| VIEWERNET-550 | MSG file is not rendering properly | Bug |
| VIEWERNET-583 | Failed to get document information in image mode with text from epub document | Bug |
| VIEWERNET-570 | Failed to get document information in image mode with text in trial | Bug |
| VIEWERNET-551 | File description document type format is Unknown when extension is upper case | Bug |
| VIEWERNET-552 | File description document type format is Unknown when extension is upper case | Bug |
| VIEWERNET-652 | Small images are not visible in image mode | Bug |
| VIEWERNET-655 | Invalid parameter exception while converting mpt to image | Bug |
| VIEWERNET-659 | File is corrupted or damaged exception while converting mpt document to image | Bug |
| VIEWERNET-662 | Project reading exception in multithreading environment | Bug |
| VIEWERNET-681 | GetPdfFile returns all pages in trial mode | Bug |
| VIEWERNET-682 | JpegQuality is not applied for watermarked images | Bug |
| VIEWERNET-684 | Invalid Rendering of Excel File into Html and Image | Bug |
| VIEWERNET-689 | Incorrect Rendering of Excel File into Html and Image | Bug |
| VIEWERNET-690 | GetPages() for Email Attachment Throws Path Exception for Relative Storage Path | Bug |
| VIEWERNET-693 | Invalid Parameter Exception in Html Rendering | Bug |
| VIEWERNET-701 | GetPages() Throws Exception In Case of Stream Object | Bug |
| VIEWERNET-722 | Failed to load xps document in image mode with pdf | Bug |
| VIEWERNET-725 | API Renders First Sheet Twice in Excel Workbook | Bug |
| VIEWERNET-729 | Incorrect Spacing between Characters in Html Rendering | Bug |
| VIEWERNET-529 | Cannot add page to pdf document | Bug |
| VIEWERNET-564 | OutOfMemoryException raised when total readed file size reached upto 250MB | Bug |
| VIEWERNET-627 | The operation is not supported error raised when loading epub document | Bug |
| VIEWERNET-667 | IOException is raised when try to move a loaded document(into the viewer) to any other directory | Bug |
| VIEWERNET-691 | Cell shading is not applied uniformly while converting spreadsheet to HTML | Bug |
| VIEWERNET-717 | Ott file stream detects as ods file format | Bug |
| VIEWERNET-729 | GetDocumentInfo() Throws "Parameter is not valid" Exception | Bug |
| VIEWERNET-753 | Excel file is not properly rendering into HTML | Bug |
| VIEWERNET-776 | Header contents of Word document are not appearing in rendered html or images | Bug |
| VIEWERNET-779 | Exception generated while calling handler.getDocumentInfo(uuid) | Bug |
| VIEWERNET-780 | Exception when calling GetPdfFile/RotatePage/ReorderPage with guid without extension | Bug |
| VIEWERNET-784 | Incorrect watermark position and text in PDF file | Bug |
| VIEWERNET-786 | Out Of Memory Exception While Rendering Excel File into HTML | Bug |
| VIEWERNET-596 | The bookmark range is invalid for .docx | Bug |
| VIEWERNET-747 | Text document format detected as Unknown | Bug |
| VIEWERNET-805 | GetPages() Method Throws "Parameter is not valid" Exception | Bug |
| VIEWERNET-807 | Output html contains garbled characters and few characters are merged | Bug |
| VIEWERNET-820 | GetPages() throws exception for email attachments | Bug |
| VIEWERNET-821 | API throws exception in Mono | Bug |
| VIEWERNET-835 | User can't catch GroupDocsException | Bug |
| VIEWERNET-866 | Html watermark style block contains garbage characters. | Bug |
| VIEWERNET-865 | Html watermark style block contains garbage characters. | Bug |
| VIEWERNET-863 | Watermark is Rendered Incorrectly in Html Representation | Bug |
| VIEWERNET-838 | Wmf file dimmensions are different from dimmensions in the MS Paint. | Bug |
| VIEWERNET-834 | TeX to Html conversion error | Bug |
| VIEWERNET-829 | Incorrect Rendering of PDF Document into Image | Bug |
| VIEWERNET-811 | The output pdf file contains black pages instead of content when converting djvu to pdf. | Bug |
| VIEWERNET-810 | Slanting line does not appear in html rendering | Bug |
| VIEWERNET-794 | DefaultRegularFont setting doesn't work properly | Bug |
| VIEWERNET-566 | Specific pdf document can't be saved as HTML | Bug |
| VIEWERNET-496 | Exception when converting document to html after cleanup | Bug |
| VIEWERNET-437 | Some characters not displayed when render HTML or PNG | Bug |
| WEB-2372 | Different HTML generated for the same document | Bug |
| WEB-1531 | Outlines are rendered incorrectly in HTML | Bug |
| WEB-2320 | Some text extracted from document twice | Bug |
| WEB-1709 | Text is shifted and duplicated in a PDF produced from VSD | Bug |
| WEB-1813 | Diagram file rendering regression | Bug |
| WEB-2029 | Incorrect saving XLSX to HTML | Bug |
| WEB-2289 | Incomplete converting XLSX to HTML | Bug |
| WEB-2322 | Text coordinates are incorrect for a specific document | Bug |
| WEB-2433 | Not all content of the Visio file is stored when converting to the PDF | Bug |
| WEB-1869 | Each page of a Word document is converted to HTML too long | Bug |
| WEB-2000 | Incorrect saving PDF to HTML | Bug |
| WEB-2081 | There is no text in tables of a PDF after conversion to HTML | Bug |
| WEB-2349 | Text selection is unstable in Firefox on the HTML engine | Bug |
| WEB-2070 | Convert .docx to .pdf wrong symbol | Bug |
| WEB-2448 | Missing character in resultant html | Bug |
| WEB-2425 | Incomprehensible characters when view pdf | Bug |
| WEB-2038 | Text issues when saving document containig XFA form to HTML | Bug |
| VIEWERJAVA-853 | Supports the hyperlinks for the nested tabs for the .xls file | Bug |
| VIEWERJAVA-924 | Cache is generated in the HTML mode independently of the useCache setting | Bug |
| VIEWERJAVA-962 | Thumbnails are not displaying for some files | Bug |
| VIEWERJAVA-967 | PDF to PNG text issues | Bug |
| VIEWERJAVA-988 | HTML to PNG bad conversion | Bug |
| VIEWERJAVA-1002 | Exception throws when try to rotate VTX file | Bug |
| VIEWERJAVA-1015 | Pdf to Html text positioning issues | Bug |
| VIEWERJAVA-1078 | preloadPagesCount() parameter doesn't work | Bug |
| VIEWERJAVA-1079 | Quality parameter does not work | Bug |
| VIEWERJAVA-1108 | The background is missed for IE 11 | Bug |
| VIEWERJAVA-1186 | Exception when trying to get thumbnails from presentation file | Bug |
| VIEWERJAVA-1203 | Issues in rendering PDF document to HTML | Bug |
| VIEWERJAVA-1204 | Exception generated while calling handler.getDocumentInfo(uuid) | Bug |
| VIEWERJAVA-1206 | Excel files are not rendering to Images and HTML | Bug |
| VIEWERJAVA-1211 | Issue in generated PDF file | Bug |
| VIEWERJAVA-1212 | Excel files are not rendering to HTML or Images | Bug |
| VIEWERJAVA-1216 | Performance issue with .pdf document that has a lot of images. | Bug |
| VIEWERJAVA-1217 | Issue with showing Excel groups | Bug |
| VIEWERJAVA-1220 | Invalid rendering of DWG file into Image or HTML | Bug |
| VIEWERJAVA-1309 | Exception with chunk image data throws during retrieving all image pages including transformation without license | Bug |

Public API and Backward Incompatible Changes

##### Custom fonts path

**Set custom fonts directory path**

```java
    // Setup GroupDocs.Viewer config
    ViewerConfig config = new ViewerConfig();
    config.setStoragePath("C:\\storage");
    // Add custom fonts directories to FontDirectories list
    config.getFontDirectories().add("/usr/admin/Fonts");
    config.getFontDirectories().add("/home/admin/Fonts");
    // Init viewer handler with config
    ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
```

##### Working with email attachements

**Get email attachment original file**

```java
    // Setup GroupDocs.Viewer config
    ViewerConfig config = new ViewerConfig();
    config.setStoragePath("C:\\storage");
    // Create image handler
    ViewerImageHandler handler = new ViewerImageHandler(config);
    EmailAttachment attachment = new EmailAttachment("document-with-attachments.msg", "attachment-image.png");
    // Get attachment original file
    FileContainer container = imageHandler.getFile(attachment);
    System.out.println("Attach name: " + attachment.getName() + ", size: " + attachment.getFileType());
    System.out.println("Attach stream lenght: " + fileContainer.getStream().available());
```

**Get attachment document html representation**

```java
    // Setup GroupDocs.Viewer config
    ViewerConfig viewerConfig = new ViewerConfig();
    viewerConfig.setStoragePath("c:\\storage");
    viewerConfig.setUseCache(true);
    // Setup html conversion options
    HtmlOptions htmlOptions = new HtmlOptions();
    htmlOptions.setResourcesEmbedded(false);
    // Init viewer html handler
    ViewerHtmlHandler handler = new ViewerHtmlHandler(viewerConfig);
    DocumentInfoContainer info = handler.getDocumentInfo("document-with-attachments.msg");
    // Iterate over the attachments collection
    for (AttachmentBase attachment : info.getAttachments()) {
        System.out.println("Attach name: " + attachment.getName() + ", size: " + attachment.getFileType());
        // Get attachment document html representation
        List<PageHtml> pages = handler.getPages(attachment, htmlOptions);
        for (PageHtml page : pages) {
            System.out.println(" Page: " + page.getPageNumber() + ", size: " + page.getHtmlContent().length());
            for (HtmlResource htmlResource : page.getHtmlResources()) {
                InputStream resourceStream = handler.getResource(attachment, htmlResource);
                System.out.println(" Resource: " + htmlResource.getResourceName() + ", size: " + resourceStream.available());
            }
        }
    }
```

**Get attachment document image representation**


```java
    // Setup GroupDocs.Viewer config
    ViewerConfig viewerConfig = new ViewerConfig();
    viewerConfig.setStoragePath("c:\\storage");
    viewerConfig.setUseCache(true);
    // Init viewer image handler
    ViewerImageHandler handler = new ViewerImageHandler(viewerConfig);
    DocumentInfoContainer info = handler.getDocumentInfo("document-with-attachments.msg");
    // Iterate over the attachments collection
    for (AttachmentBase attachment : info.getAttachments()) {
        System.out.println("Attach name: " + attachment.getName() + ", size: " + attachment.getFileType());
        // Get attachment document image representation
        List<PageImage> pages = handler.getPages(attachment, htmlOptions);
        for (PageImage page : pages) {
            System.out.println(" Page: " + page.getPageNumber() + ", size: " + page.getStream().available());
        }
    }
```

**Get document information**
**Get document information by guid**

```java
    // Setup GroupDocs.Viewer config
    ViewerConfig config = new ViewerConfig();
    config.setStoragePath("C:\\storage");
    // Create html handler
    ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
    String guid = "word.doc";
    // Get document information
    DocumentInfoOptions options = new DocumentInfoOptions();
    DocumentInfoContainer documentInfo = htmlHandler.getDocumentInfo(guid, options);
    System.out.println("DateCreated: " + documentInfo.getDateCreated());
    System.out.println("DocumentType: " + documentInfo.getDocumentType());
    System.out.println("DocumentTypeFormat: " + documentInfo.getDocumentTypeFormat());
    System.out.println("Extension: " + documentInfo.getExtension());
    System.out.println("FileType: " + documentInfo.getFileType());
    System.out.println("Guid: " + documentInfo.getGuid());
    System.out.println("LastModificationDate: " + documentInfo.getLastModificationDate());
    System.out.println("Name: " + documentInfo.getName());
    System.out.println("PageCount: " + documentInfo.getPages().size());
    System.out.println("Size: " + documentInfo.getSize());
    for (PageData pageData : documentInfo.getPages()) {
        System.out.println("Page number: " + pageData.getNumber());
        System.out.println("Page name: ", pageData.getName());
    }
```

**Get document information by stream**

```java
    // Setup GroupDocs.Viewer config
    ViewerConfig config = new ViewerConfig();
    config.setStoragePath("C:\\storage");
    // Create html handler
    ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
    // Get document stream
    InputStream stream = getDocumentStream();
    // Get document information
    DocumentInfoOptions options = new DocumentInfoOptions();
    DocumentInfoContainer documentInfo = htmlHandler.getDocumentInfo(stream, options);
    System.out.println("DateCreated: " + documentInfo.getDateCreated());
    System.out.println("DocumentType: " + documentInfo.getDocumentType());
    System.out.println("DocumentTypeFormat: " + documentInfo.getDocumentTypeFormat());
    System.out.println("Extension: " + documentInfo.getExtension());
    System.out.println("FileType: " + documentInfo.getFileType());
    System.out.println("Guid: " + documentInfo.getGuid());
    System.out.println("LastModificationDate: " + documentInfo.getLastModificationDate());
    System.out.println("Name: " + documentInfo.getName());
    System.out.println("PageCount: " + documentInfo.getPages().size());
    System.out.println("Size: " + documentInfo.getSize());
    for (PageData pageData : documentInfo.getPages()) {
        System.out.println("Page number: " + pageData.getNumber());
        System.out.println("Page name: ", pageData.getName());
    }
```

**Get document information by Uri**
```java
    // Setup GroupDocs.Viewer config
    ViewerConfig config = new ViewerConfig();
    config.setStoragePath("C:\\storage");
    // Create html handler
    ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);
    URI uri = new URI("http://example.com/words.doc");
    // Get document information
    DocumentInfoOptions options = new DocumentInfoOptions();
    DocumentInfoContainer documentInfo = htmlHandler.getDocumentInfo(uri, options);
    System.out.println("DateCreated: " + documentInfo.getDateCreated());
    System.out.println("DocumentType: " + documentInfo.getDocumentType());
    System.out.println("DocumentTypeFormat: " + documentInfo.getDocumentTypeFormat());
    System.out.println("Extension: " + documentInfo.getExtension());
    System.out.println("FileType: " + documentInfo.getFileType());
    System.out.println("Guid: " + documentInfo.getGuid());
    System.out.println("LastModificationDate: " + documentInfo.getLastModificationDate());
    System.out.println("Name: " + documentInfo.getName());
    System.out.println("PageCount: " + documentInfo.getPages().size());
    System.out.println("Size: " + documentInfo.getSize());
    for (PageData pageData : documentInfo.getPages()) {
        System.out.println("Page number: " + pageData.getNumber());
        System.out.println("Page name: ", pageData.getName());
    }
```

**Working with cache files**
**How to clear all cache files.**
```java
    //Init viewer config
    ViewerConfig viewerConfig = new ViewerConfig();
    viewerConfig.setStoragePath("c:\\storage");
    // Init viewer image or html handler
    ViewerImageHandler viewerImageHandler = new ViewerImageHandler(viewerConfig);
    //Clear all cache files 
    viewerImageHandler.clearCache();
```

**How to clear files from cache older than specified time interval.**
```java
    //Init viewer config
    ViewerConfig viewerConfig = new ViewerConfig();
    viewerConfig.setStoragePath("c:\\storage"); 
    // Init viewer image or html handler
    ViewerImageHandler viewerImageHandler = new ViewerImageHandler(viewerConfig);
    //Clear files from cache older than specified time interval
    viewerImageHandler.clearCache(24 * 60 * 60 * 1000);
```

1.  The PdfFileOptions addPrintAction property is depricated, please use PdfFileOptions Transformations property and Transformation.addPringAction enumeration.
2.  Implemented getPdfFile from stream or remote file public methods.  
    Public api changes:  
    1.  ViewerHandler.getPdfFile(PdfFileOptions) marked as deprecated
    2.  PdfFileOptions class all constructors except parameterles are marked as deprecated
    3.  Added new ViewerHandler methods: 
        
        *   FileContainer getPdfFile(String guid);
        *   FileContainer getPdfFile(String guid, PdfFileOptions pdfFileOptions);
        *   FileContainer getPdfFile(InputStream fileStream);
        *   FileContainer getPdfFile(InputStream fileStream, PdfFileOptions pdfFileOptions);
        *   FileContainer getPdfFile(InputStream fileStream, String fileName);
        *   FileContainer getPdfFile(InputStream fileStream, String fileName, PdfFileOptions pdfFileOptions);
        *   FileContainer getPdfFile(URL uri);
        *   FileContainer getPdfFile(URL uri, PdfFileOptions pdfFileOptions);
        *   FileContainer getPdfFile(URL uri, WindowsAuthenticationCredential credential, PdfFileOptions pdfFileOptions);
        
3.  Implemented saving Cells document sheet to multiple pages in image mode.  
    1.  Public API changes: Option CellsOptions.setOnePagePerSheet() now supported by ImageHandler. 
4.  Implemented setting 'FontName' which allows users to specify font name for watermark text.  
    Public API changes:  
    1.  Class: com.groupdocs.viewer.domain.Watermark
    2.  Added field: getFontName() and setFontName()
    3.  getPages method watermarking with font name
    4.  getPdfFile method watermarking with font name
5.  Cleanup GetDocumentInfo method response.  
    1.  Class com.groupdocs.viewer.domain.containers.DocumentInfoContainer field setContentControls() marked as deprecated
    2.  Class com.groupdocs.viewer.domain.ContentControl marked as deprecated
    3.  Class com.groupdocs.viewer.domain.WordsFileData field setContentControls() marked as deprecated
6.  User can't catch GroupDocsException  
    1.  New public class com.groupdocs.viewer.exception.GroupDocsViewerException
    2.  All exceptions from com.groupdocs.viewer.exception package are derived classes of GroupDocsViewerException.
7.  How to specify resource prefix  
    HtmlResourcePrefix setting is necessary when every resource name in html document should be prefixed with some string. This may be useful when resources for document are obtained via some REST API method. Please note that css files will also be processed - html resource prefix value will be added to font names in css file.


    ```java
        HtmlOptions htmlOptions = new HtmlOptions();
        htmlOptions.setHtmlResourcePrefix("http://contoso.com/api/getResource?name=");
    ```
    
    If css files should not be processed then IgnoreResourcePrefixForCss setting should be set to true.


    ```java
    HtmlOptions htmlOptions = new HtmlOptions();
    htmlOptions.setHtmlResourcePrefix("http://contoso.com/api/getResource?name=");
    htmlOptions.setIgnoreResourcePrefixForCss(true);
    ```
    
8.  [How to set default font name]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/replace-missing-font.md" >}})
9.  [Show hidden pages for Visio files]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/show-hidden-pages.md" >}})
10.  How to specify internal hyperlink prefix for Excel files
11.  Mark CachedPageDescription redundant constructor as Obsolete  
    1.  Class com.groupdocs.viewer.domain.CachedPageDescription constructor public CachedPageDescription(String guid, CacheFileType cacheFileType) marked as deprecated
12.  Improve CAD files rendering   
    1.  Class com.groupdocs.viewer.domain.DocumentTypeName constant public final String Autocad = "Autocad"; changed to public final String CAD = "CAD"
13.  Update public classes fields access modifiers.  
    1.  Class com.groupdocs.viewer.localization.LocalizedStringKeys new contant EXC\_TMPL\_CORRUPTED\_OR\_DAMAGED\_FILE
    2.  Class com.groupdocs.viewer.localization.LocalizedStringKeys new contant EXC\_TMPL\_FILE\_TYPE\_NOT\_SUPPORTED
    3.  Class com.groupdocs.viewer.localization.LocalizedStringKeys new contant EXC\_TMPL\_INVALID\_PASSWORD
    4.  Class com.groupdocs.viewer.localization.LocalizedStringKeys new contant EXC\_TMPL\_PASSWORD\_PROTECTED\_FILE
    5.  Class com.groupdocs.viewer.localization.LocalizedStringKeys new contant EXC\_TMPL\_STORAGE\_PATH\_NOT\_SPECIFIED
    6.  Class com.groupdocs.viewer.localization.LocalizedStringKeys new contant EXC\_TMPL\_CACHE\_FILE\_NOT\_FOUND
    7.  Class com.groupdocs.viewer.localization.LocalizedStringKeys new contant EXC\_TMPL\_GUID\_NOT\_SPECIFIED
    8.  Class com.groupdocs.viewer.localization.LocalizedStringKeys new contant EXC\_TMPL\_TRANSFORMATION\_FAILED\_PAGE\_NOT\_EXIST
14.  [Ability to set default font when rendering Diagram documents]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/replace-missing-font.md" >}})
15.  The ability to show and hide PDF layers
16.  Starting from version 3.7.0 GroupDocs.Viewer the rendering Pdf documents into html representation was improved. It is possible to work with layers in html representation of Pdf document (e.g. show\\hide) with help of javascript. Each layer is separated into <div> tag which has Html data tag "data-pdflayer" and its value contains layer name. For example Pdf document has layer with name "Backgroung" so output html will contain tag
17.    
    ```html
    `<div data-pdflayer="Backgroung"> .... </div>`
    ```
    
    This layer can be easily accessed with javascript, see example how to access and hide layer with help of JQuery
        
    ```javascript
    // get layer
    var layer = $("[data-pdflayer='Backgroung']");
    // hide layer
    layer.hide();
    // show layer
    layer.show();
    // get all layers
    var allLayers = $("[data-pdflayer]");
    // go throught all layers and print layer name
    allLayers.each(function(index) {
        console.log(index + ": " + $(this).data("pdflayer"));
    });
    ```
