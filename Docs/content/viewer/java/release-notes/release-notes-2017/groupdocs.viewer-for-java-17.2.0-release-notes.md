---
id: groupdocs-viewer-for-java-17-2-0-release-notes
url: viewer/java/groupdocs-viewer-for-java-17-2-0-release-notes
title: GroupDocs.Viewer for Java 17.2.0 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 17.2.0.{{< /alert >}}

## Major Features

There are new features, improvements, and fixes in this regular monthly release. The most notable are:

*   Improved rendering Slides documents by removing embedded audios
*   Improved extracting document information
*   MOBI file format viewing support
*   Fixed rendering of DWG documents which ware rendered into small image or into image with dots
*   Ability to set default font when rendering Email documents
*   OTP (OpenDocument Presentation Template) file format viewing support
*   Improved public API of ViewerConfig class and IInputDataHandler interface
*   When viewing two documents in one browser page CSS classes are not overriding
*   WebP (Image format) file format viewing support
*   OTS (OpenDocument Spreadsheet Template) file format viewing support
*   Current directory is used as storage path when storage path is not specified in ViewerConfig
*   Implemented responsive HTML ouput for Slides documents
*   Added possibility to configure ViewerConfig class via app.config or web.config files
*   Implemented partial rendering of large Excel sheets when rendering to Html
*   Improved rendering Email documents in Html mode
*   Improved rendering Pdf documents in Html mode
*   Rendering password-protected MPP(2003) files
*   LaTeX file format support
*   Add {resource-name} pattern to HtmlOptions.HtmlResourcePrefix
*   Implement setting which allows rendering PDF document layers separately

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERNET-888 | Mobi format support | New Feature |
| VIEWERNET-955 | Ability to set default font when rendering Email documents | New Feature |
| VIEWERNET-849 | Add OTP format support | New Feature |
| VIEWERNET-996 | OTS format support | New Feature |
| VIEWERNET-971 | WebP file format support | New Feature |
| VIEWERNET-1043 | Implement setting to prevent glyphs grouping when rendering pdf documents | New Feature |
| VIEWERNET-1036 | Partial rendering of large Excel sheets in HTML mode | New Feature |
| VIEWERNET-1034 | Implement parameterless ViewerHtmlHandler and ViewerImageHandler constructors | New Feature |
| VIEWERNET-308 | Add possibility to configurate ViewerConfig class via app.config or web.config file | New Feature |
| VIEWERNET-1022 | Rendering password-protected MPP(2003) files | New Feature |
| VIEWERNET-785 | LaTeX file format support | New Feature |
| VIEWERNET-913 | Remove embedded audios from presentation | Improvement |
| VIEWERNET-966 | Improve public API of ViewerConfig class | Improvement |
| VIEWERNET-963 | Improve rendering CAD (dwg, dxf) documents to Pdf | Improvement |
| VIEWERNET-957 | Improve public API of IInputDataHandler interface | Improvement |
| VIEWERNET-927 | Display HTML pages of two different documents in the same page in browser without overriding CSS classes | Improvement |
| VIEWERNET-1020 | Use current directory when storage path is not specified | Improvement |
| VIEWERNET-934 | Implement responsive HTML output for Slides documents | Improvement |
| VIEWERNET-1052 | Implement setting to configure content ordering in resultant HTML document | Improvement |
| VIEWERNET-1040 | Improve Email documents rendering | Improvement |
| VIEWERNET-1075 | Implement saving fonts and styles separately when converting Words to Html | Improvement |
| VIEWERNET-1071 | Add {resource-name} pattern to HtmlOptions.HtmlResourcePrefix | Improvement |
| VIEWERNET-1061 | Add CountPagesToRender and PageNumbersToRender properties to RenderOptions class | Improvement |
| VIEWERNET-1060 | Implement IDisposable for container classes | Improvement |
| VIEWERNET-1055 | Implement setting which allows rendering pdf document layers separately | Improvement |
| VIEWERNET-1021 | Add code examples to documentation comments | Improvement |
| VIEWERNET-942 | Invalid rendering of DWG file into Image or HTML | Bug |
| VIEWERNET-922 | GetDocumentInfo() method is throwing exception | Bug |
| VIEWERNET-918 | Failed to load XPS file in evaluation mode | Bug |
| VIEWERNET-910 | Dwg document is rendered into the small image | Bug |
| VIEWERNET-905 | Invalid rendering of DWG file into HTML and Image | Bug |
| VIEWERNET-798 | SheetRender.GetPageSize throws an exception when sheet is empty | Bug |
| VIEWERNET-417 | FormattedText does not return TextWidth for Japanese characters. | Bug |
| WEB-2447 | The background is missed for IE 11 | Bug |
| WEB-2109 | Special characters like accents, umlauts and circumflex are displayed incorrectly when saving specific PDF to HTML | Bug |
| WEB-1398 | A ligature is shown incorrectly in HTML produced from PDF | Bug |
| VIEWERNET-979 | Invalid characters while rendering Word document into HTML | Bug |
| VIEWERNET-958 | Throws unsupported file format exception when loading specific doc file | Bug |
| VIEWERNET-956 | Getting exception "File type 'doc' is not supported" | Bug |
| VIEWERNET-949 | Parameter is not valid exception when rendering xlsx to image | Bug |
| VIEWERNET-877 | Extra blank page created when converting DWG to PDF | Bug |
| VIEWERNET-848 | Failed to convert WMF file to image in ASP.NET application | Bug |
| VIEWERNET-847 | Incorrect Rendering of Radio Buttons, Checkboxes, and their Label into Html | Bug |
| VIEWERNET-775 | No text when converting Pdf to Html with FontAbsorber | Bug |
| VIEWERNET-1027 | Different exception messages for password encrypted Word document | Bug |
| VIEWERNET-993 | Failed to load SAI image | Bug |
| VIEWERNET-976 | Large scrollbars when viewing pdf converted to HTML with embedded resources in IE Edge | Bug |
| VIEWERNET-962 | IE Edge displays large scrollbars for generated HTML | Bug |
| VIEWERNET-953 | Failed to load Tex file from stream | Bug |
| VIEWERNET-947 | Failed to load XCF file | Bug |
| VIEWERNET-941 | Position of graph lines is not correct in output HTML or image file | Bug |
| WEB-2422 | Printing Radio Buttons from HTML page | Bug |
| WEB-1092 | Links are converted into plain text when converting PDF to HTML | Bug |
| VIEWERNET-1023 | Merged cells in XLSX are not displayed as merged in HTML | Bug |
| VIEWERNET-1004 | Alignment of radio button text and checkbox text is not proper | Bug |
| VIEWERNET-994 | Jumbling words when rendering PDF document to HTML | Bug |
| VIEWERNET-975 | Creates only one page in text(txt) document | Bug |
| VIEWERNET-974 | Radio buttons are not showing as 'selected' or 'checked' when converting to fixed HTML | Bug |
| VIEWERNET-972 | Radio buttons are not showing as 'selected' or 'checked' | Bug |
| VIEWERNET-581 | Missing characters, invalid formatting when saving to HTML | Bug |
| WEB-2377 | Incorrect conversion from DOCX to PDF | Bug |
| WEB-756 | Header-links in PDF files do not work | Bug |
| VIEWERNET-1035 | Input stream must be FileStream exception when loading Tex file from stream | Bug |
| VIEWERNET-688 | Getting GroupDocs.Foundation Dependency Exception in SharePoint 2013 | Bug |
| VIEWERNET-505 | Background image is missing when converting to image | Bug |
| VIEWERJAVA-976 | Text and text alignment is messed up in 01\_the\_manure\_tool\_baltic\_20131215\_incl\_logo.xlsx | Bug |
| VIEWERJAVA-1322 | A lot of temporary files with name ASPOSE\_24\_14xxx are created in temp folder | Bug |
| VIEWERJAVA-1358 | Fields are duplicated in fd.xml file | Bug |
| VIEWERJAVA-1326 | Exception is thrown by the API when an XLSX file is queried for info using com.groupdocs.viewer.handler.ViewerHandler.getDocumentInfo | Bug |
| VIEWERJAVA-1325 | Exception when getPages is accessed from multiple threads | Bug |
| VIEWERJAVA-1320 | PDF to HTML rendering generates an exception | Bug |
| VIEWERJAVA-1318 | Attachments present in MSG files are not rendering to HTML | Bug |
| VIEWERJAVA-1316 | EML and MSG files are not properly rendering to HTML and Images | Bug |
| VIEWERJAVA-1315 | ODS files/documents are not rendering to HTML and Images | Bug |
| VIEWERJAVA-1311 | FileData is not serializable | Bug |
| VIEWERJAVA-1080 | Doesn't viewed .doc file | Bug |
| VIEWERJAVA-903 | Text loss on to HTML conversion | Bug |
| VIEWERJAVA-766 | Appends null at the end of the path for resources HTML | Bug |
| VIEWERJAVA-651 | EPUB document loading issue | Bug |

##  Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Viewer for Java 17.2.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Viewer which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Rename classes which names start with AutoCad to Cad
    1.  Class *com.groupdocs.viewer.domain.DocumentTypeFormat* constant *AUTOCAD\_DRAWING\_FILE\_FORMAT* value changed to "CAD Drawing File Format"
    2.  Class *com.groupdocs.viewer.domain.DocumentTypeFormat* constant *AUTOCAD\_DRAWING\_FILE\_FORMAT* name changed to *CAD\_DRAWING\_FILE\_FORMAT*
2.   Mobi format support
    1.  Class *com.groupdocs.viewer.domain.DocumentTypeFormat* constant added *public static final String MOBIPOCKET = "Mobipocket"*
3.  Ability to set default font when rendering Email documents
4.  Add OTP format support
5.  Improve public API of ViewerConfig class Public API changes:
    1.  Class *com.groupdocs.viewer.сonfig.ViewerConfig* property *public String TempFolderName* marked as 'Deprecated'
    2.  Class *com.groupdocs.viewer.сonfig.ViewerConfig* property *public String TempPath* marked as 'Deprecated'
6.  Improve public API of IInputDataHandler interface Public API changes:
    1.  Class *ViewerImageHandler* and *ViewerHtmlHandler* method *FileListContainergetFileList()* added
    2.  Class *ViewerImageHandler* and *ViewerHtmlHandler* method *getFileList(FileListOptions fileListOptions)* added
    3.  Class *ViewerImageHandler* and *ViewerHtmlHandler* method *FileTreeContainer* *loadFileTree()* marked as 'Deprecated'
    4.  Class *ViewerImageHandler* and *ViewerHtmlHandler* method *FileTreeContainer loadFileTree(FileTreeOptions* *fileTreeOptions)* marked as 'Deprecated'
    5.  Class *com.groupdocs.viewer.domain.containers.FileTreeContainer* marked as 'Deprecated'
    6.  Class *com.groupdocs.viewer.domain.options.FileTreeOptions* marked as 'Deprecated'
    7.  Interface *com.groupdocs.viewer.handler.input.IInputDataHandler* method *saveDocument(CachedDocumentDescription* *cachedDocumentDescription, InputStream* *documentStream)* marked as 'Deprecated'
    8.  Interface *com.groupdocs.viewer.handler.input.IInputDataHandler* method *loadFileTree(FileTreeOptions* *fileTreeOptions)* marked as 'Deprecated'
    9.  Interface *com.groupdocs.viewer.handler.input.IInputDataHandler* method *void addFile(String guid, InputStream content)* added
    10.  Interface *com.groupdocs.viewer.handler.input.IInputDataHandler* method *List<FileDescription> getEntities(String path)* added

Documentation articles:

1.  1.  Load file tree
    2.  Get file list
2.  OTS format support
3.  WebP file format support
4.  Investigate EMLX format support Public API changes:
    1.  class *com.groupdocs.viewer.**domain**.DocumentTypeFormat* new constant added *public static final String APPLE\_MAIL = "Apple Mail";*
5.  Implement setting to prevent glyphs grouping when rendering pdf documents
6.  Partial rendering of large Excel sheets in HTML mode
7.  Partial rendering of large Excel sheets in Image mode
8.  Implement parameterless ViewerHtmlHandler and ViewerImageHandler constructors, after setting StoragePath and UseCache in configuration files following can be implemented as below:    
    **Example of rendering document using parameterless constructor and configurations**    
```java
 // Create html handler
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler();
String guid = "word.doc";
    
HtmlOptions options = new HtmlOptions();
options.setResourcesEmbedded(false);
List<PageHtml> pages = htmlHandler.getPages(guid, options);
```    
9.  Implement setting to configure content ordering in resultant html document
10.  LaTeX file format support
11.  Add {resource-name} pattern to HtmlOptions.HtmlResourcePrefix    
    **HtmlResourcePrefix setting supports replacement patterns: {page-number} and {resource-name}.**    
```java
HtmlOptions htmlOptions = new HtmlOptions();
htmlOptions.setResourcesEmbedded(false);
htmlOptions.setHtmlResourcePrefix("http://example.com/api/pages/{page-number}/resources/{resource-name}");
//The {page-number} and {resource-name} patterns will be replaced with current processing page number and resource name accordingly. 
```    
12.  Add CountPagesToRender and PageNumbersToRender properties to RenderOptions class
13.  Implement setting which allows render pdf document layers separately
