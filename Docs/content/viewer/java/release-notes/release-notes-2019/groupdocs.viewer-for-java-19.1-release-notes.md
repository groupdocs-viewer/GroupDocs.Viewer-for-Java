---
id: groupdocs-viewer-for-java-19-1-release-notes
url: viewer/java/groupdocs-viewer-for-java-19-1-release-notes
title: GroupDocs.Viewer for Java 19.1 Release Notes
weight: 6
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 19.1.{{< /alert >}}

## Major Features

This release includes new features, improvements, and fixes. The most notable are:

*   Added following file-formats support
    *   CAD Formats:
        *   Stereolithography File (\*.stl)
        *   Industry Foundation Classes File (\*.ifc)
        *   MicroStation Drawing format V7 (\*.dgn)
        *   AutoDesk Design Web format (\*.dwf)
    *   Presentations
        *   Microsoft PowerPoint Open XML format (\*.potx, \*.pptm, \*.potm  and \*.ppsm)
    *   Spreadsheets
        *   Microsoft Excel Open XML format (\*.xltm and \*.xltx)
    *   Documents
        *   OpenDocument Text format (\*.odt and \*.ott)
        *   Microsoft Visio format (\*.vstm, \*.vssm and \*.vsdm)
        *   Microsoft Outlook format (\*.pst and \*.ost)
    *   Images
        *   Digital Negative Image File (\*.dng)
        *   JPEG 2000 File Format (\*.jp2, \*.j2c, \*.j2k, \*.jpf, \*.jpx and \*.jpm)
        *   Computer Graphics Metafile (\*.cgm)
        *   Scalable Vector Graphics File (\*.svg)
        *   PostScript (\*.ps and \*.eps)
*   Added support of rendering PDF Portfolio files
*   Added support of rendering into responsive HTML
*   Added support of CSS and HTML minification
*   Added setting for specifying Layers when rendering CAD documents
*   Added option to set page size when rendering Email messages
*   Added support of rendering colored CAD drawings

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERNET-63 | Rendering only Print Area in Excel documents | Feature |
| VIEWERNET-64 | Settings to include/exclude hidden content in Excel documents | Feature |
| VIEWERNET-78 | Specify image quality when rendering PDF documents as HTML | Feature |
| VIEWERNET-93 | Implement simple file storage interface | Feature |
| VIEWERNET-101 | Feature for setting column width and row height when rendering Spredsheet documents | Feature |
| VIEWERNET-102 | Feature for AutoFitting column width depending on content for rendering into HTML | Feature |
| VIEWERNET-121 | Changing language for header of emails | Feature |
| VIEWERNET-143 | Setting page size when rendering Email documents as PDF and image | Feature |
| VIEWERNET-155 | Add new option which allows checking password each time document processed | Feature |
| VIEWERNET-227 | Support rendering password-protected sheets in spreadsheet documents | Feature |
| VIEWERNET-235 | Obtaining start and end dates from MS Porject document | Feature |
| VIEWERNET-236 | Add support for rendering OST file format | Feature |
| VIEWERNET-237 | Add support for rendering PST file format | Feature |
| VIEWERNET-238 | Option for setting list of fonts that should be excluded from HTML | Feature |
| VIEWERNET-274 | Add CGM (Computer Graphics Metafile) file format support | Feature |
| VIEWERNET-279 | Support for PSD file format | Feature |
| VIEWERNET-693 | Add EPS (Encapsulated PostScript) file format support | Feature |
| VIEWERNET-1077 | Add PS (PostScript) file format support | Feature |
| VIEWERNET-1125 | Render CAD documents by specifying coordinates | Feature |
| VIEWERNET-1180 | Support of IFC file format | Feature |
| VIEWERNET-1398 | Implement setting for specifying Layers when rendering CAD documents | Feature |
| VIEWERNET-1427 | Support rendering PDF documents with attachments | Feature |
| VIEWERNET-1436 | Show comments when rendering Presentation documents | Feature |
| VIEWERNET-1463 | Add DWF file format support | Feature |
| VIEWERNET-1468 | Support rendering notes for Presentation documents | Feature |
| VIEWERNET-1469 | Add SVG format support | Feature |
| VIEWERNET-1507 | Add VSDM file format support | Feature |
| VIEWERNET-1508 | Add VSSM file format support | Feature |
| VIEWERNET-1510 | Add VSTM file format support | Feature |
| VIEWERNET-1513 | Implement a setting for excluding fonts while rendering into HTML | Feature |
| VIEWERNET-1544 | Add DNG image file format support | Feature |
| VIEWERNET-1558 | Ignore empty rows when rendering Spreadsheet documents | Feature |
| VIEWERNET-1560 | Show comments when rendering Spreadsheet documents as HTML | Feature |
| VIEWERNET-1569 | Implement a setting for ignoring HTML Resource Prefix in resources | Feature |
| VIEWERNET-1571 | Add STL file format support | Feature |
| VIEWERNET-1577 | Export styles that make page responsive when resources are not embedded | Feature |
| VIEWERNET-1600 | GIF images are displayed without animation | Feature |
| VIEWERNET-1607 | Implement a setting to show/hide hidden pages | Feature |
| VIEWERNET-1609 | Implement an option to split MS Project documents by time intervals | Feature |
| VIEWERNET-1610 | Implement a setting for minifying CSS resources and HTML content | Feature |
| VIEWERNET-1707 | Add JPEG2000 file format support | Feature |
| VIEWERNET-1710 | Improve rendering Jpeg images into HTML | Feature |
| VIEWERNET-1723 | Removing cache files of a specific document | Feature |
| VIEWERNET-1731 | Add XLTX file format support | Feature |
| VIEWERNET-1732 | Add XLTM file format support | Feature |
| VIEWERNET-1735 | Add ODG (OpenDocument Graphics) file format support | Feature |
| VIEWERNET-1757 | Add ISFF-based DGN (V7) file format support | Feature |
| VIEWERNET-1758 | Add PPTM file format support | Feature |
| VIEWERNET-1759 | Add PPSM file format support | Feature |
| VIEWERNET-1760 | Add POTX file format support | Feature |
| VIEWERNET-1761 | Add POTM file format support | Feature |
| VIEWERNET-25 | Set output page height and width (for image and HTML) depending on the rendered DWF document page sizes | Improvement |
| VIEWERNET-40 | Exporting contained images when rendering SVG to HTML | Improvement |
| VIEWERNET-46 | Minify CSS content when rendering into HTML with EnableMinification is true | Improvement |
| VIEWERNET-56 | Improve rendering MS OneNote documents into HTML by providing pure HTML and SVG | Improvement |
| VIEWERNET-58 | Extend support of HtmlOptions.ExcludeFonts option for Text documents | Improvement |
| VIEWERNET-85 | Add prefix for CSS classes when rendering Email messages | Improvement |
| VIEWERNET-98 | Extend support for DefaultFontName setting to PDF documents when rendering into HTML | Improvement |
| VIEWERNET-112 | Extend support for DefaultFontName option for MS Project documents when rendering into PDF | Improvement |
| VIEWERNET-115 | Eliminate the gap between list of tasks and footer when rendering MS Project documents | Improvement |
| VIEWERNET-118 | Improve compression for rendering into HTML with EnableMinification setting | Improvement |
| VIEWERNET-123 | Support JpegQuality option when rendering OneNote documents into PDF | Improvement |
| VIEWERNET-131 | Add support for rendering password protected ODT and OTT formats | Improvement |
| VIEWERNET-136 | Support empty string for ViewerConfig.CacheFolderName property | Improvement |
| VIEWERNET-137 | Support empty string for ViewerConfig.PageNamePrefix property | Improvement |
| VIEWERNET-138 | Add new property EnableCaching which will replace UseCache property in ViewerConfig class | Improvement |
| VIEWERNET-139 | Add new property EmbedResources which will replace IsResourcesEmbedded property in HtmlOptions class | Improvement |
| VIEWERNET-146 | Extend support for rendering comments from ODP document format | Improvement |
| VIEWERNET-177 | Extend support for DefaultFontName setting to PDF documents when rendering into PDF | Improvement |
| VIEWERNET-194 | Improve output content for printable HTML | Improvement |
| VIEWERNET-210 | Extend DefaultFontName setting support for ODG, SVG and MetaFile Images | Improvement |
| VIEWERNET-217 | Add ForcePasswordValidation configuration via configs | Improvement |
| VIEWERNET-224 | Extend support for DefaultFontName option for MS Project documents rendering to image and HTML | Improvement |
| VIEWERNET-229 | Reduce count of calls to storage methods | Improvement |
| VIEWERNET-231 | Retrieve list of resources only when loading page from cache | Improvement |
| VIEWERNET-234 | Improve output for printable HTML | Improvement |
| VIEWERNET-239 | Improve setting PageSize and TimeScale for MS Project documents by default | Improvement |
| VIEWERNET-240 | Prevent setting malicious values for HtmlResourcePrefix | Improvement |
| VIEWERNET-247 | Rendering comments from Presentation documents into images when ExtractText option is enabled | Improvement |
| VIEWERNET-261 | Security improvements | Improvement |
| VIEWERNET-270 | Implement rendering color CAD drawings | Improvement |
| VIEWERNET-271 | Include Photoshop file format (PSD) into list of supported file formats | Improvement |
| VIEWERNET-276 | Cleanup FileDescription and DocumentInfoContainer classes | Improvement |
| VIEWERNET-296 | Extend support for HtmlOptions.ExcludeFonts setting when rendering MS Project documents as HTML | Improvement |
| VIEWERNET-306 | GetDocumentInfo method page number depending on the type of ViewerHandler | Improvement |
| VIEWERNET-311 | Release internal resources for methods which accepts URL | Improvement |
| VIEWERNET-678 | Responsive html output required in the case of html representation | Improvement |
| VIEWERNET-731 | DWG+DFX (2007,2010) support is required. | Improvement |
| VIEWERNET-1223 | Do not show items beyond Start and End date options when rendering MS Project documents | Improvement |
| VIEWERNET-1321 | Add code examples to WordsOptions class documentation comments | Improvement |
| VIEWERNET-1322 | Remove obsolete ViewerConfig properties and fields | Improvement |
| VIEWERNET-1323 | Determine resource type based on resource name | Improvement |
| VIEWERNET-1399 | Extend support for DefaultFontName option for CAD documents | Improvement |
| VIEWERNET-1417 | Rendering djvu documents with maximum JpegQuality renders contained images with low quality | Improvement |
| VIEWERNET-1442 | Extend support of HtmlOptions.IsResourceEmbedded option for Presentation documents | Improvement |
| VIEWERNET-1445 | Extend support of HtmlOptions.IsResourceEmbedded option for Microsoft Project documents | Improvement |
| VIEWERNET-1455 | Replace backslashes in resource URL's with forward slashes | Improvement |
| VIEWERNET-1458 | Move the setting that enables text extraction to ImageOptions class | Improvement |
| VIEWERNET-1490 | Improve exporting and embedding HTML resources when rendering Presentation documents | Improvement |
| VIEWERNET-1499 | Improve rendering Microsoft Visio document as HTML | Improvement |
| VIEWERNET-1511 | Improve rendering into HTML for rotated documents | Improvement |
| VIEWERNET-1525 | Extend support for setting font directories to Presentation documents | Improvement |
| VIEWERNET-1535 | Improve rendering metafile images into HTML | Improvement |
| VIEWERNET-1548 | Implement responsive output for rendering into HTML | Improvement |
| VIEWERNET-1559 | Use ICacheDataHandler instead of IFileDataStore | Improvement |
| VIEWERNET-1565 | Extend support for HtmlOptions.EnableResponsiveRendering to Text documents | Improvement |
| VIEWERNET-1568 | Use single naming convention for HTML resources | Improvement |
| VIEWERNET-1576 | Improve setting prefix for fonts when rendering Text document as HTML | Improvement |
| VIEWERNET-1578 | Implement responsive output for rendering MS Visio documents and SVG images into HTML | Improvement |
| VIEWERNET-1592 | Show local time when rendering Email messages | Improvement |
| VIEWERNET-1604 | Watermark is not over the content when rendering into HTML | Improvement |
| VIEWERNET-1605 | Rendering documents into HTML from stream does not create external resources | Improvement |
| VIEWERNET-1608 | Improve styles generation when rendering into HTML with embedded resources | Improvement |
| VIEWERNET-1619 | Load custom fonts on demand | Improvement |
| VIEWERNET-1620 | Add code examples for CAD rendering options | Improvement |
| VIEWERNET-1621 | Add code examples for Slides rendering options | Improvement |
| VIEWERNET-1668 | Extend support of CountRowsPerPage option when rendering Spreadsheet documents as PDF and as image with enabled text extraction | Improvement |
| VIEWERNET-1670 | Drop support of caching based on render options | Improvement |
| VIEWERNET-1683 | Improve MHT documents rendering performance | Improvement |
| VIEWERNET-1690 | New overload for RotatePage and ReorderPage methods with ability to specify RenderOptions | Improvement |
| VIEWERNET-1694 | Support JpegQuality option when rendering Microsoft Project documents | Improvement |
| VIEWERNET-1738 | Improve exporting and embedding HTML resources when rendering SVG documents | Improvement |
| VIEWERNET-1763 | Extend support for ShowHiddenSlides option to Open Document Presentation | Improvement |
| VIEWERNET-1764 | Improve rendering comments from Presentation documents | Improvement |
| VIEWERNET-1766 | Create single styles resource when rendering Text documents as HTML | Improvement |
| VIEWERNET-36 | Access to the path "/Path/to/file/fd.xml" is denied | Bug |
| VIEWERNET-37 | Incorrect rendering of the content in header and footer of Word document | Bug |
| VIEWERNET-41 | Issues when printing printable Html or saving as PDF | Bug |
| VIEWERNET-42 | Content minification prevents styles loading | Bug |
| VIEWERNET-45 | Printable Html gets messy when adding watermark | Bug |
| VIEWERNET-52 | Exception when rendering tiff image as Html | Bug |
| VIEWERNET-53 | Blur output when rendering PDF as Html | Bug |
| VIEWERNET-57 | DefaultFontName setting is not working for rendering Text documents into PDF and image | Bug |
| VIEWERNET-65 | Missing content when rendering PDF to HTML | Bug |
| VIEWERNET-73 | Invalid PDF when rendering Excel document with multiple pages per sheet | Bug |
| VIEWERNET-74 | Issues when rendering Excel document with vertical Japanese writing | Bug |
| VIEWERNET-75 | Converting DNG image into JPG provides output with light spots | Bug |
| VIEWERNET-80 | Text's shadow appears in the output HTML | Bug |
| VIEWERNET-91 | Invalid styles when rendering presentation documents into HTML | Bug |
| VIEWERNET-92 | Unable to render Presentation documents, after ViewerConfig.FontDirectories are added | Bug |
| VIEWERNET-94 | Content of the cell is hidden when rendering Excel to HTML | Bug |
| VIEWERNET-103 | Text color is incorrect when rendering PDF | Bug |
| VIEWERNET-108 | Black image when rendering PDF document | Bug |
| VIEWERNET-109 | Images and diagrams are missing when rendering OTS file | Bug |
| VIEWERNET-145 | Evaluation limitations applied for valid licence | Bug |
| VIEWERNET-147 | The voluminous email is not fully rendered into image | Bug |
| VIEWERNET-151 | The output image is cropped when rendering HTML as image | Bug |
| VIEWERNET-163 | Comments are missing when rendering PPTX file | Bug |
| VIEWERNET-167 | Incorrect exception | Bug |
| VIEWERNET-168 | Some STL file are not supported | Bug |
| VIEWERNET-169 | GetFileList throws "Guid for file should contain extension" when file has no extension | Bug |
| VIEWERNET-170 | Incorrect rendering of items with background color in Visio document | Bug |
| VIEWERNET-172 | Can't set different default fonts when rendering PDF document | Bug |
| VIEWERNET-182 | Access to the path 'c:\\windows\\system32\\inetsrv\\vs.bin' is denied. | Bug |
| VIEWERNET-198 | Issue when rendering email message having attachments with same name | Bug |
| VIEWERNET-204 | API generates 5 pages with repeated content when rendering single page email message | Bug |
| VIEWERNET-206 | First page filled with black color when rendering PDF document | Bug |
| VIEWERNET-207 | Exception when rendering PDF document as HTML | Bug |
| VIEWERNET-216 | DOCX to HTML pages - all HTML pages use CSS class names from first page | Bug |
| VIEWERNET-218 | Duplicate link tag when rendering Text documents with external resources | Bug |
| VIEWERNET-222 | Incorrect rendering of PDF document into HTML | Bug |
| VIEWERNET-244 | Exception when file name contains curly braces | Bug |
| VIEWERNET-246 | Relative and absolute resource paths in the same HTML page | Bug |
| VIEWERNET-249 | An exception raises while retrieving HTML pages from the source document | Bug |
| VIEWERNET-260 | Deadlock when rendering documents in multiple processes | Bug |
| VIEWERNET-268 | GetDocumentInfo throws exception when Aspose.Words is also referenced | Bug |
| VIEWERNET-281 | Exception: CAD document rendering failed | Bug |
| VIEWERNET-304 | OutlookOptions.MaxItemsInFolder option not working properly for rendering into image and PDF | Bug |
| VIEWERNET-310 | Specified watermark font not found exception when calling GetPdfFile method | Bug |
| VIEWERNET-449 | Exception "Save to stream error: Value cannot be null" when rendering VSD as HTML | Bug |
| VIEWERNET-1127 | Aspose.CAD 1.1.0: Failed to load DGN file | Bug |
| VIEWERNET-1147 | Incorrect character position in HTML mode in Safari for iOS | Bug |
| VIEWERNET-1243 | Alignment of radio button text and checkbox text is not proper | Bug |
| VIEWERNET-1256 | Link with external URL in PDF document is not rendered as hyperlink | Bug |
| VIEWERNET-1257 | Aspose.Pdf 16.11.0: Check boxes in PDF document are not rendered correctly | Bug |
| VIEWERNET-1305 | Aspose.Tasks 16.11.0: Rendering MS Project document stops responding. | Bug |
| VIEWERNET-1374 | Incorrect Positioning of Characters When Rendering PDF to HTML | Bug |
| VIEWERNET-1378 | Misplaced Characters when Viewing HTML in Safari for iOS | Bug |
| VIEWERNET-1381 | Exception when rendering CAD file into image | Bug |
| VIEWERNET-1386 | Aspose.Email 17.3.0: Some characters are being replaced with a ? placeholder while rendering. | Bug |
| VIEWERNET-1389 | Unable to render PDF document in HTML/Image mode | Bug |
| VIEWERNET-1393 | Aspose.Pdf 17.4.0: Incorrect Characters after rendering PDF in HTML/Image mode | Bug |
| VIEWERNET-1396 | Incorrect rendering of bullets in HTML mode | Bug |
| VIEWERNET-1401 | Blank output HTML page when rendering PDF document | Bug |
| VIEWERNET-1422 | Out Of Memory Exception when Rendering PDF into Image | Bug |
| VIEWERNET-1433 | Unable to render Word document having AD RMS template | Bug |
| VIEWERNET-1446 | Incorrect position of parenthesis in output HTML | Bug |
| VIEWERNET-1447 | Conflict when using GroupDocs.Viewer and Aspose APIs in same project | Bug |
| VIEWERNET-1457 | File added to storage when GetDocumentInfo called for stream | Bug |
| VIEWERNET-1466 | ViewerConfig.DefaultFontName setting does not replace missing fonts for Spreadsheet documents | Bug |
| VIEWERNET-1477 | Image export failed exception when passed CAD layout name is not exist. | Bug |
| VIEWERNET-1489 | "Index was out of range" exception when rendering PDF to Html | Bug |
| VIEWERNET-1491 | Incorrect rendering of PDF document into HTML | Bug |
| VIEWERNET-1500 | Multipage Microsoft Visio document shows page count as one | Bug |
| VIEWERNET-1501 | Watermark not displayed when rendering Microsoft Visio document as HTML | Bug |
| VIEWERNET-1505 | Content is missing when rendering PDF document into HTML | Bug |
| VIEWERNET-1506 | File extension field does not include period | Bug |
| VIEWERNET-1512 | Resource prefix not applied when rendering Presentation documents to HTML | Bug |
| VIEWERNET-1556 | Exception when rendering Excel document into HTML and image | Bug |
| VIEWERNET-1567 | All pages are same when rendering Microsoft Project document into an image | Bug |
| VIEWERNET-1591 | Issue with recipient and sent date when rendering from eml message to image | Bug |
| VIEWERNET-1599 | CAD document layouts with the size different than model are not rendered correctly | Bug |
| VIEWERNET-1624 | The output image gets cut when rendering PowerPoint presentation | Bug |
| VIEWERNET-1629 | Parameter is not valid exception when rendering xlsx to image | Bug |
| VIEWERNET-1630 | Some rows/records are missing when rendering Excel document to HTML | Bug |
| VIEWERNET-1650 | Missing words and characters when rendering PDF to HTML | Bug |
| VIEWERNET-1662 | The parameter 'address' cannot be an empty string exception when rendering MSG document | Bug |
| VIEWERNET-1667 | Empty space between text is lost when rendering Email documents | Bug |
| VIEWERNET-1680 | Columns are missing when rendering Excel document to PDF and HTML | Bug |
| VIEWERNET-1681 | Blank output when rendering PDF document as HTML | Bug |
| VIEWERNET-1684 | Content is missing when rendering interactive PDF document | Bug |
| VIEWERNET-1687 | Images are missing when rendering PDF document into HTML or Image | Bug |
| VIEWERNET-1689 | Index out of range exception when rendering CAD document | Bug |
| VIEWERNET-1691 | Exception when rendering Excel document into HTML and image | Bug |
| VIEWERNET-1711 | ViewerConfig.FontDirectories property not working for Text documents | Bug |
| VIEWERNET-1712 | ViewerConfig.FontDirectories property not working for Presentation documents | Bug |
| VIEWERNET-1725 | Time interval option for rendering MS Project documents | Bug |
| VIEWERNET-1733 | Index was out of range exception when rendering XLSX as PDF | Bug |
| VIEWERNET-1744 | Incorrect font when rendering PPTX as HTML | Bug |
| VIEWERNET-1746 | Text overlaps when viewing HTML in Mozilla Firefox | Bug |
| VIEWERNET-1747 | Legend is shifted and incorrect formatting when rendering PPTX as HTML | Bug |
| VIEWERNET-1752 | Wrong number of layouts in DXF | Bug |
| VIEWERNET-1756 | API is not creating cache files in CachePath when rendering document from network path | Bug |
| VIEWERNET-1765 | Header contains error message when rendering Word document as PDF | Bug |
| VIEWERJAVA-242 | Render large sized dwg document by specifying coordinates | Feature |
| VIEWERJAVA-597 | Add PostScript file format support | Feature |
| VIEWERJAVA-1802 | Prompt for a password again if the file was cached | Feature |
| VIEWERJAVA-594 | Incorrect rendering of PPTX document as HTML | Bug |
| VIEWERJAVA-598 | Content of the cell is hidden when rendering Excel to HTML | Bug |
| VIEWERJAVA-599 | OpenDocument spreadsheet documents incorrect rendering | Bug |
| VIEWERJAVA-600 | NullPointerException for LaTeX document | Bug |
| VIEWERJAVA-603 | Incorrect exception type | Bug |
| VIEWERJAVA-605 | Font 'Segoe UI' does not support style 'Regular' | Bug |
| VIEWERJAVA-608 | Guid for file should contain extension | Bug |
| VIEWERJAVA-1801 | Exception occurred while opening a file with password | Bug |
| VIEWERJAVA-1803 | Omitting trailing slash in ViewerConfig.setStoragePath() cause failing create cache folder | Bug |

##  Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Viewer for Java 19.1. In the version, following public class members were added, marked as deprecated, removed or replaced.{{< /alert >}}

### com.groupdocs.viewer.config.ViewerConfig

The following methods are added in the namespace.

```java
ViewerConfig.getEnableCaching ( )  :  boolean 
ViewerConfig.getFontDirectories ( )  :  List<String> 
ViewerConfig.getForcePasswordValidation ( )  :  boolean 
ViewerConfig.setEnableCaching ( boolean p1 )  :  void 
ViewerConfig.setFontDirectories ( List<String> p1 )  :  void 
ViewerConfig.setForcePasswordValidation ( boolean p1 )  :  void 
```

### com.groupdocs.viewer.converter.options.CadOptions

The following methods are added in the namespace.

```java
CadOptions.getLayers ( )  :  List<String> 
CadOptions.getTiles ( )  :  List<Tile> 
CadOptions.setLayers ( List<String> p1 )  :  void 
CadOptions.setTiles ( List<Tile> p1 )  :  void 
```

### com.groupdocs.viewer.converter.options.CellsOptions

The following methods are added in the namespace.

```java
CellsOptions.getIgnoreEmptyRows ( )  :  boolean 
CellsOptions.getRenderPrintAreaOnly ( )  :  boolean 
CellsOptions.getShowHiddenColumns ( )  :  boolean 
CellsOptions.getShowHiddenRows ( )  :  boolean 
CellsOptions.setIgnoreEmptyRows ( boolean p1 )  :  void 
CellsOptions.setRenderPrintAreaOnly ( boolean p1 )  :  void 
CellsOptions.setShowHiddenColumns ( boolean p1 )  :  void 
CellsOptions.setShowHiddenRows ( boolean p1 )  :  void  
```

The following methods are removed in the namespace.

```java
CellsOptions.getFlags ( )  :  int 
CellsOptions.getShowHiddenSheets ( )  :  boolean 
CellsOptions.setShowHiddenSheets ( boolean p1 )  :  void
```

### com.groupdocs.viewer.converter.options.DiagramOptions

The following methods are removed in the namespace.

```java
DiagramOptions.DiagramOptions ( ) 
DiagramOptions.getFlags ( )  :  int 
DiagramOptions.getShowHiddenPages ( )  :  boolean 
DiagramOptions.setShowHiddenPages ( boolean p1 )  :  void 
```

### com.groupdocs.viewer.converter.options.EmailField

The following method is added in the class.

```java
EmailField.EmailField ( ) 
```

### com.groupdocs.viewer.converter.options.EmailOptions

The following methods are added in the class.

```java
EmailOptions.getFieldLabels ( )  :  Map<String,String> 
EmailOptions.getPageSize ( )  :  int 
EmailOptions.setFieldLabels ( Map<String,String> p1 )  :  void 
EmailOptions.setPageSize ( int p1 )  :  void 
```

### com.groupdocs.viewer.converter.options.FileDataOptions

The following methods are removed from the class.

```java
FileDataOptions.FileDataOptions ( ) 
FileDataOptions.getCadOptions ( )  :  CadOptions 
FileDataOptions.getCellsOptions ( )  :  CellsOptions 
FileDataOptions.getDiagramOptions ( )  :  DiagramOptions 
FileDataOptions.getEmailOptions ( )  :  EmailOptions 
FileDataOptions.getPassword ( )  :  String 
FileDataOptions.getPdfOptions ( )  :  PdfOptions 
FileDataOptions.getRenderComments ( )  :  boolean 
FileDataOptions.getUseCache ( )  :  boolean 
FileDataOptions.getUsePdf ( )  :  boolean 
FileDataOptions.getWordsOptions ( )  :  WordsOptions 
FileDataOptions.setCadOptions ( CadOptions p1 )  :  void 
FileDataOptions.setCellsOptions ( CellsOptions p1 )  :  void 
FileDataOptions.setDiagramOptions ( DiagramOptions p1 )  :  void 
FileDataOptions.setEmailOptions ( EmailOptions p1 )  :  void 
FileDataOptions.setPassword ( String p1 )  :  void 
FileDataOptions.setPdfOptions ( PdfOptions p1 )  :  void 
FileDataOptions.setRenderComments ( boolean p1 )  :  void 
FileDataOptions.setUseCache ( boolean p1 )  :  void 
FileDataOptions.setUsePdf ( boolean p1 )  :  void 
FileDataOptions.setWordsOptions ( WordsOptions p1 )  :  void 
```

### com.groupdocs.viewer.converter.options.HtmlOptions

The following methods are added in the class.

```java
HtmlOptions.getEmbedResources ( )  :  boolean 
HtmlOptions.getEnableMinification ( )  :  boolean 
HtmlOptions.getEnableResponsiveRendering ( )  :  boolean 
HtmlOptions.getExcludeFonts ( )  :  boolean 
HtmlOptions.getExcludeFontsList ( )  :  List<String> 
HtmlOptions.getIgnorePrefixInResources ( )  :  boolean 
HtmlOptions.setEmbedResources ( boolean p1 )  :  void 
HtmlOptions.setEnableMinification ( boolean p1 )  :  void 
HtmlOptions.setEnableResponsiveRendering ( boolean p1 )  :  void 
HtmlOptions.setExcludeFonts ( boolean p1 )  :  void 
HtmlOptions.setExcludeFontsList ( List<String> p1 )  :  void 
HtmlOptions.setIgnorePrefixInResources ( boolean p1 )  :  void  
```

The following methods are removed from the class.

```java
HtmlOptions.getIgnoreResourcePrefixForCss ( )  :  boolean 
HtmlOptions.isResourcesEmbedded ( )  :  boolean 
HtmlOptions.setIgnoreResourcePrefixForCss ( boolean p1 )  :  void 
HtmlOptions.setResourcesEmbedded ( boolean p1 )  :  void 
```

### com.groupdocs.viewer.converter.options.ImageOptions

The following methods are added in the class.

```java
ImageOptions.getExtractText ( )  :  boolean 
ImageOptions.setExtractText ( boolean p1 )  :  void 
```

### com.groupdocs.viewer.converter.options.OutlookOptions

The following methods are added in the class.

```java
OutlookOptions.getMaxItemsInFolder ( )  :  int 
OutlookOptions.OutlookOptions ( ) 
OutlookOptions.setMaxItemsInFolder ( int p1 )  :  void
```

### com.groupdocs.viewer.converter.options.PdfOptions

The following methods are added in the class.

```java
PdfOptions.getImageQuality ( )  :  int 
PdfOptions.setImageQuality ( int p1 )  :  void 
```

The following methods are deprecated in the class.

```java
PdfOptions.getPreventGlyphsGrouping ( )  :  boolean //DEPRECATED 
PdfOptions.setPreventGlyphsGrouping ( boolean p1 )  :  void //DEPRECATED
```

The following methods are removed from the class.

```java
PdfOptions.getDeleteAnnotations ( )  :  boolean 
PdfOptions.getFlags ( )  :  int 
PdfOptions.setDeleteAnnotations ( boolean p1 )  :  void
```

### com.groupdocs.viewer.converter.options.ProjectOptions

The following methods are added in the class.

```java
ProjectOptions.getEndDate ( )  :  Date 
ProjectOptions.getPageSize ( )  :  int 
ProjectOptions.getStartDate ( )  :  Date 
ProjectOptions.getTimeUnit ( )  :  int 
ProjectOptions.ProjectOptions ( ) 
ProjectOptions.setEndDate ( Date p1 )  :  void 
ProjectOptions.setPageSize ( int p1 )  :  void 
ProjectOptions.setStartDate ( Date p1 )  :  void 
ProjectOptions.setTimeUnit ( int p1 )  :  void 
```

### com.groupdocs.viewer.converter.options.RenderOptions

The following methods are added in the class.

```java
RenderOptions.getDefaultFontName ( )  :  String 
RenderOptions.getOutlookOptions ( )  :  OutlookOptions 
RenderOptions.getProjectOptions ( )  :  ProjectOptions 
RenderOptions.getShowHiddenPages ( )  :  boolean 
RenderOptions.getSlidesOptions ( )  :  SlidesOptions 
RenderOptions.setDefaultFontName ( String p1 )  :  void 
RenderOptions.setOutlookOptions ( OutlookOptions p1 )  :  void 
RenderOptions.setProjectOptions ( ProjectOptions p1 )  :  void 
RenderOptions.setShowHiddenPages ( boolean p1 )  :  void 
RenderOptions.setSlidesOptions ( SlidesOptions p1 )  :  void 
```

The following methods are removed from the class.

```java
RenderOptions.getDiagramOptions ( )  :  DiagramOptions 
RenderOptions.setDiagramOptions ( DiagramOptions p1 )  :  void
```

### com.groupdocs.viewer.converter.options.SlidesOptions

The following methods are added in the class.

```java
SlidesOptions.getRenderNotes ( )  :  boolean 
SlidesOptions.setRenderNotes ( boolean p1 )  :  void 
SlidesOptions.SlidesOptions ( ) 
```

### com.groupdocs.viewer.converter.options.Tile

The following methods are added in the class.

```java
Tile.getEndPointX ( )  :  int 
Tile.getEndPointY ( )  :  int 
Tile.getHeight ( )  :  int 
Tile.getStartPointX ( )  :  int 
Tile.getStartPointY ( )  :  int 
Tile.getWidth ( )  :  int 
Tile.setHeight ( int p1 )  :  void 
Tile.setWidth ( int p1 )  :  void 
Tile.Tile ( int p1, int p2, int p3, int p4 ) 
```

### com.groupdocs.viewer.converter.options.CachedDocumentDescription

The following methods are added in the class.

```java
CachedDocumentDescription.getOutlookOptions ( )  :  OutlookOptions 
CachedDocumentDescription.getProjectOptions ( )  :  ProjectOptions 
CachedDocumentDescription.getSlidesOptions ( )  :  SlidesOptions 
CachedDocumentDescription.setOutlookOptions ( OutlookOptions p1 )  :  void 
CachedDocumentDescription.setProjectOptions ( ProjectOptions p1 )  :  void 
CachedDocumentDescription.setSlidesOptions ( SlidesOptions p1 )  :  void 
```

The following methods are removed from the class.

```java
CachedDocumentDescription.getDiagramOptions ( )  :  DiagramOptions 
CachedDocumentDescription.setDiagramOptions ( DiagramOptions p1 )  :  void 
```

### com.groupdocs.viewer.domain.cache.CachedDocumentDescription

The following methods are added in the namespace.

```java
CachedDocumentDescription.getOutlookOptions ( )  :  OutlookOptions 
CachedDocumentDescription.getProjectOptions ( )  :  ProjectOptions 
CachedDocumentDescription.getSlidesOptions ( )  :  SlidesOptions 
CachedDocumentDescription.setOutlookOptions ( OutlookOptions p1 )  :  void 
CachedDocumentDescription.setProjectOptions ( ProjectOptions p1 )  :  void 
CachedDocumentDescription.setSlidesOptions ( SlidesOptions p1 )  :  void 
```

The following methods are removed from the namespace.

```java
CachedDocumentDescription.getDiagramOptions ( )  :  DiagramOptions 
CachedDocumentDescription.setDiagramOptions ( DiagramOptions p1 )  :  void 
```

### com.groupdocs.viewer.domain.cache.CachedPageDescription

The following methods are added in the namespace.

```java
CachedPageDescription.getExtractText ( )  :  boolean 
CachedPageDescription.getOutlookOptions ( )  :  OutlookOptions 
CachedPageDescription.getProjectOptions ( )  :  ProjectOptions 
CachedPageDescription.getSlidesOptions ( )  :  SlidesOptions 
CachedPageDescription.setExtractText ( boolean p1 )  :  void 
CachedPageDescription.setOutlookOptions ( OutlookOptions p1 )  :  void 
CachedPageDescription.setProjectOptions ( ProjectOptions p1 )  :  void 
CachedPageDescription.setSlidesOptions ( SlidesOptions p1 )  :  void 
```

The following methods are removed from the namespace.

```java
CachedPageDescription.getDiagramOptions ( )  :  DiagramOptions 
CachedPageDescription.setDiagramOptions ( DiagramOptions p1 )  :  void  
```

### com.groupdocs.viewer.domain.CadFileData

The following methods are added in the namespace.

```java
CadFileData.CadFileData ( ) 
CadFileData.getLayers ( )  :  List<String> 
CadFileData.setLayers ( List<String> p1 )  :  void 
```

### com.groupdocs.viewer.domain.containers.CadDocumentInfoContainer

The following methods are added in the namespace.

```java
CadDocumentInfoContainer.CadDocumentInfoContainer ( ) 
CadDocumentInfoContainer.getLayers ( )  :  List<String> 
CadDocumentInfoContainer.setLayers ( List<String> p1 )  :  void 
```

### com.groupdocs.viewer.domain.containers.DocumentInfoContainer

The following methods are added in the namespace.

```java
DocumentInfoContainer.getFileFormat ( )  :  String 
DocumentInfoContainer.setFileFormat ( String p1 )  :  void 
```

### com.groupdocs.viewer.domain.containers.FileContainer

The following methods are added in the namespace.

```java
FileContainer.FileContainer ( String p1, InputStream p2 ) 
FileContainer.getFileName ( )  :  String 
FileContainer.setFileName ( String p1 )  :  void 
```

### com.groupdocs.viewer.domain.containers.ProjectDocumentInfoContainer

The following method is added in the namespace.

```java
ProjectDocumentInfoContainer.getEndDate ( )  :  Date 
ProjectDocumentInfoContainer.getStartDate ( )  :  Date 
ProjectDocumentInfoContainer.ProjectDocumentInfoContainer ( ) 
```

### com.groupdocs.viewer.domain.DocumentTypeFormat

The following method is removed from the namespace.

```java
DocumentTypeFormat.DocumentTypeFormat ( )
```

### com.groupdocs.viewer.domain.EmailAttachment

The following methods are removed from the namespace.

```java
EmailAttachment.EmailAttachment ( ) //DEPRECATED 
EmailAttachment.EmailAttachment ( String p1, String p2 ) //DEPRECATED 
EmailAttachment.getSize ( )  :  long //DEPRECATED 
EmailAttachment.setSize ( long p1 )  :  void //DEPRECATED 
```

### com.groupdocs.viewer.domain.EmailFileData

The following methods are removed from the namespace.

```java
EmailFileData.EmailFileData ( ) //DEPRECATED 
EmailFileData.getAttachments ( )  :  List<Attachment> //DEPRECATED 
EmailFileData.setAttachments ( List<Attachment> p1 )  :  void //DEPRECATED 
```

### com.groupdocs.viewer.domain.FileData

The following methods are added in the namespace.

```java
FileData.addPage ( int p1, int p2 )  :  void 
FileData.addPage ( int p1, int p2, boolean p3 )  :  void 
FileData.addPage ( int p1, int p2, List<RowData> p3 )  :  void 
FileData.addPage ( String p1, int p2, int p3 )  :  void 
FileData.addPage ( String p1, int p2, int p3, boolean p4 )  :  void 
FileData.getTextExtracted ( )  :  boolean 
FileData.setTextExtracted ( boolean p1 )  :  void 
```

The following methods are removed from the namespace.

```java
FileData.getMaxHeight ( )  :  int 
FileData.getMaxWidth ( )  :  int 
FileData.getPageCount ( )  :  int 
FileData.setMaxHeight ( int p1 )  :  void 
FileData.setMaxWidth ( int p1 )  :  void 
FileData.setPageCount ( int p1 )  :  void 
```

### com.groupdocs.viewer.domain.FileDescription

The following methods are added in the namespace.

```java
FileDescription.getFileFormat ( )  :  String 
```

### com.groupdocs.viewer.domain.FileFormat

The following method is added in the namespace.

```java
FileFormat.FileFormat ( ) 
```

### com.groupdocs.viewer.domain.html.HtmlResource

The following methods are added in the namespace.

```java
HtmlResource.getOutlookOptions ( )  :  OutlookOptions 
HtmlResource.getProjectOptions ( )  :  ProjectOptions 
HtmlResource.getResourceType ( )  :  int 
HtmlResource.HtmlResource ( String p1 ) 
HtmlResource.setOutlookOptions ( OutlookOptions p1 )  :  void 
HtmlResource.setProjectOptions ( ProjectOptions p1 )  :  void 
```

The following methods are removed from the namespace.

```java
HtmlResource.getDiagramOptions ( )  :  DiagramOptions 
HtmlResource.getResourceType ( )  :  HtmlResourceType 
HtmlResource.HtmlResource ( ) 
HtmlResource.setDiagramOptions ( DiagramOptions p1 )  :  void 
HtmlResource.setResourceType ( HtmlResourceType p1 )  :  void 
```

### com.groupdocs.viewer.domain.html.HtmlResourceType

The following method is added in the namespace.

```java
HtmlResourceType.HtmlResourceType ( )
```

The following methods are removed from the namespace.

```java
HtmlResourceType.equals ( HtmlResourceType p1 )  :  boolean 
HtmlResourceType.equals ( int p1 )  :  boolean 
HtmlResourceType.fromValue ( long p1 ) [static]  :  HtmlResourceType 
HtmlResourceType.value ( )  :  int 
HtmlResourceType.valueOf ( String p1 ) [static]  :  HtmlResourceType 
HtmlResourceType.values ( ) [static]  :  HtmlResourceType[ ]  
```

### com.groupdocs.viewer.domain.NetworkCredential

The following methods are added in the namespace.

```java
NetworkCredential.NetworkCredential ( String p1, String p2 ) 
NetworkCredential.NetworkCredential ( String p1, String p2, String p3 ) 
```

### com.groupdocs.viewer.domain.options.DocumentInfoOptions

The following methods are added in the namespace.

```java
DocumentInfoOptions.getDefaultFontName ( )  :  String 
DocumentInfoOptions.getExtractText ( )  :  boolean 
DocumentInfoOptions.getOutlookOptions ( )  :  OutlookOptions 
DocumentInfoOptions.getProjectOptions ( )  :  ProjectOptions 
DocumentInfoOptions.getShowHiddenPages ( )  :  boolean 
DocumentInfoOptions.getSlidesOptions ( )  :  SlidesOptions 
DocumentInfoOptions.setDefaultFontName ( String p1 )  :  void 
DocumentInfoOptions.setExtractText ( boolean p1 )  :  void 
DocumentInfoOptions.setOutlookOptions ( OutlookOptions p1 )  :  void 
DocumentInfoOptions.setProjectOptions ( ProjectOptions p1 )  :  void 
DocumentInfoOptions.setShowHiddenPages ( boolean p1 )  :  void 
DocumentInfoOptions.setSlidesOptions ( SlidesOptions p1 )  :  void
```

The following methods are removed from the namespace.

```java
DocumentInfoOptions.getDiagramOptions ( )  :  DiagramOptions 
DocumentInfoOptions.setDiagramOptions ( DiagramOptions p1 )  :  void 
```

### com.groupdocs.viewer.domain.options.PdfFileOptions

The following methods are added in the namespace.

```java
PdfFileOptions.getDefaultFontName ( )  :  String 
PdfFileOptions.getOutlookOptions ( )  :  OutlookOptions 
PdfFileOptions.getProjectOptions ( )  :  ProjectOptions 
PdfFileOptions.getShowHiddenPages ( )  :  boolean 
PdfFileOptions.getSlidesOptions ( )  :  SlidesOptions 
PdfFileOptions.setDefaultFontName ( String p1 )  :  void 
PdfFileOptions.setOutlookOptions ( OutlookOptions p1 )  :  void 
PdfFileOptions.setProjectOptions ( ProjectOptions p1 )  :  void 
PdfFileOptions.setShowHiddenPages ( boolean p1 )  :  void 
PdfFileOptions.setSlidesOptions ( SlidesOptions p1 )  :  void 
```

The following methods are removed from the namespace.

```java
PdfFileOptions.getDiagramOptions ( )  :  DiagramOptions 
PdfFileOptions.setDiagramOptions ( DiagramOptions p1 )  :  void  
```

### com.groupdocs.viewer.domain.ProjectFileData

The following methods are added in the namespace.

```java
ProjectFileData.getEndDate ( )  :  Date 
ProjectFileData.getStartDate ( )  :  Date 
ProjectFileData.ProjectFileData ( ) 
ProjectFileData.setEndDate ( Date p1 )  :  void 
ProjectFileData.setStartDate ( Date p1 )  :  void 
```

### com.groupdocs.viewer.domain.WindowsAuthenticationCredential

The following method is added in the namespace.

```java
WindowsAuthenticationCredential.toNetworkCredential ( )  :  NetworkCredential 
```

### com.groupdocs.viewer.exception.CacheFileNotFoundException

The following method is removed from the namespace.

```java
CacheFileNotFoundException.CacheFileNotFoundException ( String p1, ILocalizationHandler p2 ) 
```

### com.groupdocs.viewer.domain.CorruptedOrDamagedFileException

The following method is added in the namespace.

```java
CorruptedOrDamagedFileException.CorruptedOrDamagedFileException ( String p1 ) 
```

The following method is removed from the namespace.

```java
CorruptedOrDamagedFileException.CorruptedOrDamagedFileException ( String p1, ILocalizationHandler p2 ) 
```

### com.groupdocs.viewer.exception.FileNotFoundException

The following method is removed from the namespace.

```java
FileNotFoundException.FileNotFoundException ( String p1, Throwable p2 ) 
```

### com.groupdocs.viewer.domain.FileTypeNotSupportedException

The following method is added in the namespace.

```java
FileTypeNotSupportedException.FileTypeNotSupportedException ( String p1 )  
```

The following method is removed from the namespace.

```java
FileTypeNotSupportedException.FileTypeNotSupportedException ( String p1, ILocalizationHandler p2 )
```

### com.groupdocs.viewer.exception.GuidNotSpecifiedException

The following method is removed from the namespace.

```java
GuidNotSpecifiedException.GuidNotSpecifiedException ( ILocalizationHandler p1 ) 
```

### com.groupdocs.viewer.exception.InvalidPasswordException

The following methods are added in the namespace.

```java
InvalidPasswordException.InvalidPasswordException ( String p1 )  
```

The following methods are removed from the namespace.

```java
InvalidPasswordException.InvalidPasswordException ( String p1, ILocalizationHandler p2 )
```

### com.groupdocs.viewer.exception.InvalidPasswordException

The following method is added in the namespace.

```java
PasswordProtectedFileException.PasswordProtectedFileException ( String p1 ) 
```

The following methods are removed from the namespace.

```java
PasswordProtectedFileException.PasswordProtectedFileException ( String p1, ILocalizationHandler p2 ) 
```

### com.groupdocs.viewer.exception.StoragePathNotSpecifiedException

The following method is removed from the namespace.

```java
StoragePathNotSpecifiedException.StoragePathNotSpecifiedException ( ILocalizationHandler p1 ) 
```

### com.groupdocs.viewer.exception.TransformationFailedPageNotExistException

The following methods are added in the namespace.

```java
TransformationFailedPageNotExistException.TransformationFailedPageNotExistException ( String p1, int p2 ) 
```

The following method is removed from the namespace.

```java
TransformationFailedPageNotExistException.TransformationFailedPageNotExistException ( String p1, int p2, ILocalizationHandler p3 ) 
```

### com.groupdocs.viewer.handler.cache.ICacheDataHandler

The following methods are added in the namespace.

```java
ICacheDataHandler.clearCache ( ) [abstract]  :  void 
ICacheDataHandler.clearCache ( String p1 ) [abstract]  :  void 
```

The following method is removed from the namespace.

```java
ICacheDataHandler.clearCache ( long p1 ) [abstract]  :  void 
```

### com.groupdocs.viewer.handler.input.IInputDataHandler

The following method is removed from the namespace.

```java
IInputDataHandler.addFile ( String p1, InputStream p2 ) [abstract]  :  void 
```

### com.groupdocs.viewer.handler.ViewerHandler<T>

The following methods are added in the namespace.

```java
ViewerHandler<T>.clearCache ( String p1 )  :  void 
ViewerHandler<T>.reorderPage ( String p1, ReorderPageOptions p2, RenderOptions p3 )  :  void 
ViewerHandler<T>.rotatePage ( String p1, RotatePageOptions p2, RenderOptions p3 )  :  void 
ViewerHandler<T>.ViewerHandler<T> ( ViewerConfig p1, int p2 ) 
ViewerHandler<T>.ViewerHandler<T> ( ViewerConfig p1, int p2, CultureInfo p3 ) 
ViewerHandler<T>.ViewerHandler<T> ( ViewerConfig p1, int p2, IFileStorage p3, CultureInfo p4 ) 
ViewerHandler<T>.ViewerHandler<T> ( ViewerConfig p1, int p2, IInputDataHandler p3, ICacheDataHandler p4, CultureInfo p5 )
```

### com.groupdocs.viewer.handler.ViewerHtmlHandler

The following methods are added in the namespace.

```java
ViewerHtmlHandler.ViewerHtmlHandler ( IFileStorage p1 ) 
ViewerHtmlHandler.ViewerHtmlHandler ( IFileStorage p1, CultureInfo p2 ) 
ViewerHtmlHandler.ViewerHtmlHandler ( ViewerConfig p1, IFileStorage p2 ) 
ViewerHtmlHandler.ViewerHtmlHandler ( ViewerConfig p1, IFileStorage p2, CultureInfo p3 )
```

The following methods are removed from the namespace.

```java
ViewerHtmlHandler.ViewerHtmlHandler ( ViewerConfig p1, IInputDataHandler p2, ICacheDataHandler p3, IFileDataStore p4 ) 
ViewerHtmlHandler.ViewerHtmlHandler ( ViewerConfig p1, IInputDataHandler p2, ICacheDataHandler p3, IFileDataStore p4, CultureInfo p5 )
```

### com.groupdocs.viewer.handler.ViewerImageHandler

The following methods are added in the namespace.

```java
ViewerImageHandler.ViewerImageHandler ( IFileStorage p1 ) 
ViewerImageHandler.ViewerImageHandler ( IFileStorage p1, CultureInfo p2 ) 
ViewerImageHandler.ViewerImageHandler ( ViewerConfig p1, IFileStorage p2 ) 
ViewerImageHandler.ViewerImageHandler ( ViewerConfig p1, IFileStorage p2, CultureInfo p3 ) 
```

The following methods are removed from the namespace.

```java
ViewerImageHandler.ViewerImageHandler ( ViewerConfig p1, IInputDataHandler p2, ICacheDataHandler p3, IFileDataStore p4 ) 
ViewerImageHandler.ViewerImageHandler ( ViewerConfig p1, IInputDataHandler p2, ICacheDataHandler p3, IFileDataStore p4, CultureInfo p5 ) 
```

### com.groupdocs.viewer.helper.IFileDataStore

The following methods is removed from the namespace.

```java
IFileDataStore.getFileData ( FileDescription p1 ) [abstract]  :  FileData 
IFileDataStore.saveFileData ( FileDescription p1, FileData p2 ) [abstract]  :  void 
```

### com.groupdocs.viewer.licensing.License

The following methods are added in the namespace.

```java
License.isValidLicense ( ) [static]  :  boolean  
```

### com.groupdocs.viewer.Metered

This class moved into **com.groupdocs.viewer.licensing.metered** package.

### com.groupdocs.viewer.storage.FileInfo

The following methods are added in the namespace.

```java
FileInfo.FileInfo ( ) 
FileInfo.getLastModified ( )  :  Date 
FileInfo.getPath ( )  :  String 
FileInfo.getSize ( )  :  long 
FileInfo.isDirectory ( )  :  boolean 
FileInfo.setDirectory ( boolean p1 )  :  void 
FileInfo.setLastModified ( Date p1 )  :  void 
FileInfo.setPath ( String p1 )  :  void 
FileInfo.setSize ( long p1 )  :  void 
```

### com.groupdocs.viewer.storage.IFileInfo

The following methods are added in the namespace.

```java
IFileInfo.getLastModified ( ) [abstract]  :  Date 
IFileInfo.getPath ( ) [abstract]  :  String 
IFileInfo.getSize ( ) [abstract]  :  long 
IFileInfo.isDirectory ( ) [abstract]  :  boolean 
IFileInfo.setDirectory ( boolean p1 ) [abstract]  :  void 
IFileInfo.setLastModified ( Date p1 ) [abstract]  :  void 
IFileInfo.setPath ( String p1 ) [abstract]  :  void 
IFileInfo.setSize ( long p1 ) [abstract]  :  void  
```

### com.groupdocs.viewer.storage.IFileStorage

The following methods are added in the namespace.

```java
IFileStorage.deleteDirectory ( String p1 ) [abstract]  :  void 
IFileStorage.fileExists ( String p1 ) [abstract]  :  boolean 
IFileStorage.getFile ( String p1 ) [abstract]  :  InputStream 
IFileStorage.getFileInfo ( String p1 ) [abstract]  :  IFileInfo 
IFileStorage.getFilesInfo ( String p1 ) [abstract]  :  List<IFileInfo> 
IFileStorage.saveFile ( String p1, InputStream p2 ) [abstract]  :  void 
```

### com.groupdocs.viewer.storage.LocalFileStorage

The following methods are added in the namespace.

```java
LocalFileStorage.deleteDirectory ( String p1 )  :  void 
LocalFileStorage.fileExists ( String p1 )  :  boolean 
LocalFileStorage.getFile ( String p1 )  :  InputStream 
LocalFileStorage.getFileInfo ( String p1 )  :  IFileInfo 
LocalFileStorage.getFilesInfo ( String p1 )  :  List<IFileInfo> 
LocalFileStorage.LocalFileStorage ( ) 
LocalFileStorage.saveFile ( String p1, InputStream p2 )  :  void
```
