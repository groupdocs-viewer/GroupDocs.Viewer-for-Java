---
id: groupdocs-viewer-for-java-20-1-release-notes
url: viewer/java/groupdocs-viewer-for-java-20-1-release-notes
title: GroupDocs.Viewer for Java 20.1 Release Notes
weight: 120
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 20.1{{< /alert >}}

## Major Features

{{< alert style="danger" >}}In this version, we're introducing the reworked public API which was designed to be simple and easy to use. For more details about the new API please check Public Docs section. The legacy API has been moved into legacy package so after update to this version it is required to make project-wide replacement of namespace usages from com.groupdocs.viewer. to com.groupdocs.viewer.legacy. to resolve build issues. We strongly encourage you to move to the new public API as the Legacy API will be removed in the next release.{{< /alert >}}

There are 74 features, improvements and a bug-fixes in this release, the most notable are:

*   Introduced new public API
*   Added new file formats support:
    *   Device Independent Bitmap File (.dib)
    *   PowerPoint Template (.pot)
    *   Bzip2 Compressed File (.bz2)
    *   vCard (.vcard)
    *   Microsoft Excel 97-2003 Template (.xlt)
    *   Microsoft Excel Template (.xltx)
    *   Digitally Signed Email Message (.p7s)
    *   JPEG 2000 Code Stream (.jpc)
    *   Microsoft Project 2019 (.mpp)
    *   OpenDocument Flat XML Spreadsheet (.fods)
    *   OpenXPS File (.oxps)

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERJAVA-2003 | Exception when rendering documents from Amazon S3 | Bug |
| VIEWERJAVA-2029 | Exception in thread "main" java.lang.NoClassDefFoundError | Bug |
| VIEWERJAVA-2030 | Method getDocumentInfo() doesn't return any list of folder inside an archive | Bug |
| VIEWERJAVA-2153 | File locked after calling getDocumentInfo | Bug |
| VIEWERNET-1859 | Option for rendering content of the specified folder in the zip archive | Feature |
| VIEWERNET-1861 | Possibility to render files contained in zip archives as attachments | Feature |
| VIEWERNET-1940 | Add cdr file format support | Feature |
| VIEWERNET-1896 | Add Device Independent Bitmap File (.dib) file format support | Feature |
| VIEWERNET-1897 | Add PowerPoint template (.pot) file format support | Feature |
| VIEWERNET-1987 | Implement obtaining contained files (attachments) from password protected documents | Feature |
| VIEWERNET-1999 | Add .vcard file format support | Feature |
| VIEWERNET-2004 | Add bz2 archive format support | Feature |
| VIEWERNET-1898 | Add Microsoft Excel 97-2003 Template (.xlt) file format support | Feature |
| VIEWERNET-1900 | Add Microsoft Excel Template (.xltx) file format support | Feature |
| VIEWERNET-1979 | Add programming languages file formats support | Feature |
| VIEWERNET-2050 | Add JPEG 2000 Code Stream (.jpc) file format support | Feature |
| VIEWERNET-2075 | Credit based billing for Metered license | Feature |
| VIEWERNET-1933 | Add Microsoft Project 2019 (.mpp) file format support | Feature |
| VIEWERNET-2035 | Add OpenDocument Flat XML Spreadsheet (.fods) file format support | Feature |
| VIEWERNET-2043 | Add OpenXPS File (.oxps) file format support | Feature |
| VIEWERNET-2119 | Support default font setting when rendering PDF into PNG/JPG | Feature |
| VIEWERNET-2037 | Add StarOffice Calc Spreadsheet (.sxc) file format support | Feature |
| VIEWERNET-2074 | Add Gnu Zipped File (.gzip) file format support | Feature |
| VIEWERNET-2128 | Support rendering PDF documents without embedding or producing external font resources | Feature |
| VIEWERNET-2129 | Support excluding fonts when rendering PDF documents | Feature |
| VIEWERNET-2183 | Adjust page size when rendering email messages into HTML | Feature |
| VIEWERNET-1899 | Add Microsoft Excel Macro-Enabled Template (.xltm) file format support | Feature |
| VIEWERNET-2038 | Add Microsoft Excel Add-in (.xlam) file format support | Feature |
| VIEWERNET-2039 | Add Microsoft Project Exchange File (.mpx) file format support | Feature |
| VIEWERNET-2076 | New public API | Feature |
| VIEWERNET-1846 | Extend support for ViewerConfig.FontDirectories setting to vector image formats | Improvement |
| VIEWERNET-1857 | Rending attachments from password protected zip archives | Improvement |
| VIEWERNET-1932 | Extend support for ViewerConfig.FontDirectories setting to SVG format | Improvement |
| VIEWERNET-1912 | Improve performance when rendering Presentations into HTML | Improvement |
| VIEWERNET-2022 | Fit content by width when rendering mail messages into PDF/JPG/PNG | Improvement |
| VIEWERNET-2122 | Improve rendering of Markdown Documentation File (\*.md) file format | Improvement |
| VIEWERNET-1998 | Rendering custom folders from Outlook Data Files | Improvement |
| VIEWERNET-23 | Exception: Value does not fall within the expected range | Bug |
| VIEWERNET-51 | Some characters are missing when rendering PDF as Html | Bug |
| VIEWERNET-203 | Invalid Printable HTML  for MS Project documents with several pages  | Bug |
| VIEWERNET-225 | Missing characters when rendering PDF document as HTML | Bug |
| VIEWERNET-1227 | License is not applied in Unit Test project | Bug |
| VIEWERNET-1939 | ArchiveDocumentInfoContainer.Folders doesn't return the list of folders | Bug |
| VIEWERNET-1966 | First page of ODT documents is not rendering | Bug |
| VIEWERNET-1975 | Metered related exception when License is initialized with other GroupDocs products | Bug |
| VIEWERNET-1977 | Values in the form fields are missing when rendering PDF into HTML | Bug |
| VIEWERNET-1770 | Issue with rendering PCL documents | Bug |
| VIEWERNET-1834 | ViewerHtmlHandler.GetPages produces exception with custom fonts directory option | Bug |
| VIEWERNET-1849 | PDF to HTML rendering throws "Stack empty" exception | Bug |
| VIEWERNET-2002 | Pages are empty when rendering Archive documents with text extraction set on | Bug |
| VIEWERNET-2021 | The content of email gets cut in the output image and PDF | Bug |
| VIEWERNET-2025 | Pages are empty when rendering Outlook Data Files with text extraction set on | Bug |
| VIEWERNET-2052 | Excel document loses formatting when rendering into multiple pages per sheet | Bug |
| VIEWERNET-14 | Misplaced characters when rendering Word document into HTML or image | Bug |
| VIEWERNET-1907 | HTML representation of PPTX document takes too much time | Bug |
| VIEWERNET-2056 | JpegQuality option of PdfFileOptions not works when rendering ODP presentation | Bug |
| VIEWERNET-2113 | Page order ignored when rendering MS Project document into PDF | Bug |
| VIEWERNET-2118 | Incorrect page count for EPUB document | Bug |
| VIEWERNET-2123 | Styles are embedded when rendering XLSX into HTML with external resources | Bug |
| VIEWERNET-2130 | Failed to render password-protected ODP/OTP presentations | Bug |
| VIEWERNET-2135 | Incorrect links to resources when rendering into HTML | Bug |
| VIEWERNET-15 | DWG rendered empty | Bug |
| VIEWERNET-16 | A null reference or invalid value was found exception when rendering DWG as HTML | Bug |
| VIEWERNET-1996 | Rendering Diagram document provides improper output colors | Bug |
| VIEWERNET-2051 | Exception when rendering Word document as HTML | Bug |
| VIEWERNET-2054 | The print preview of the rendered HTML is zoomed in | Bug |
| VIEWERNET-2156 | Styles are lost when rendering XLSX into HTML | Bug |
| VIEWERNET-2157 | External resources failed to load when rendering Email messages | Bug |
| VIEWERNET-2159 | Rendering Word document is taking a long time | Bug |
| VIEWERNET-2168 | Blur image in when rendering slides as HTML | Bug |
| VIEWERNET-2169 | Incorrect image URLs when rendering email as HTML | Bug |
| VIEWERNET-2178 | Tiff rendered incorrectly | Bug |
| VIEWERNET-1869 | The form content of PDF document isn't visible in HTML representation | Bug |
| VIEWERNET-2079 | SVG files are always embedded into resulting HTML | Bug |

## Public API and Backward Incompatible Changes

### All public types from com.groupdocs.viewer package are moved and marked as deprecated

1.  All public types have been moved into com.**com.groupdocs.viewer.legacy** package
2.  Marked as **Deprecated** with the message: *This interface/class/enumeration is obsolete and will be removed in the next release.*

#### Full list of types that have been moved and marked as obsolete:
1.  com.groupdocs.viewer.storage.FileInfo => com.groupdocs.viewer.legacy.storage.FileInfo    
2.  com.groupdocs.viewer.storage.IFileInfo => com.groupdocs.viewer.legacy.storage.IFileInfo    
3.  com.groupdocs.viewer.storage.IFileStorage => com.groupdocs.viewer.legacy.storage.IFileStorage    
4.  com.groupdocs.viewer.storage.LocalFileStorage => com.groupdocs.viewer.legacy.storage.LocalFileStorage    
5.  com.groupdocs.viewer.handler.ViewerHandler => com.groupdocs.viewer.legacy.handler.ViewerHandler    
6.  com.groupdocs.viewer.handler.ViewerHtmlHandler => com.groupdocs.viewer.legacy.handler.ViewerHtmlHandler    
7.  com.groupdocs.viewer.handler.ViewerImageHandler => com.groupdocs.viewer.legacy.handler.ViewerImageHandler    
8.  com.groupdocs.viewer.handler.input.IInputDataHandler => com.groupdocs.viewer.legacy.handler.input.IInputDataHandler    
9.  com.groupdocs.viewer.handler.cache.ICacheDataHandler => com.groupdocs.viewer.legacy.handler.cache.ICacheDataHandler    
10.  com.groupdocs.viewer.exception.GroupDocsViewerException => com.groupdocs.viewer.legacy.exception.GroupDocsViewerException    
11.  com.groupdocs.viewer.exception.TransformationFailedPageNotExistException => com.groupdocs.viewer.legacy.exception.TransformationFailedPageNotExistException    
12.  com.groupdocs.viewer.exception.InvalidPasswordException => com.groupdocs.viewer.legacy.exception.InvalidPasswordException    
13.  com.groupdocs.viewer.exception.CorruptedOrDamagedFileException => com.groupdocs.viewer.legacy.exception.CorruptedOrDamagedFileException    
14.  com.groupdocs.viewer.exception.FileTypeNotSupportedException => com.groupdocs.viewer.legacy.exception.FileTypeNotSupportedException    
15.  com.groupdocs.viewer.exception.PasswordProtectedFileException => com.groupdocs.viewer.legacy.exception.PasswordProtectedFileException    
16.  com.groupdocs.viewer.domain.ArchiveFileData => com.groupdocs.viewer.legacy.domain.ArchiveFileData    
17.  com.groupdocs.viewer.domain.CadLayer => com.groupdocs.viewer.legacy.domain.CadLayer    
18.  com.groupdocs.viewer.domain.PdfFileData => com.groupdocs.viewer.legacy.domain.PdfFileData    
19.  com.groupdocs.viewer.domain.OutlookFileData => com.groupdocs.viewer.legacy.domain.OutlookFileData    
20.  com.groupdocs.viewer.domain.ProjectFileData => com.groupdocs.viewer.legacy.domain.ProjectFileData    
21.  com.groupdocs.viewer.domain.Attachment => com.groupdocs.viewer.legacy.domain.Attachment    
22.  com.groupdocs.viewer.domain.AttachmentBase => com.groupdocs.viewer.legacy.domain.AttachmentBase    
23.  com.groupdocs.viewer.domain.CadFileData => com.groupdocs.viewer.legacy.domain.CadFileData    
24.  com.groupdocs.viewer.domain.DocumentTypeName => com.groupdocs.viewer.legacy.domain.DocumentTypeName    
25.  com.groupdocs.viewer.domain.FileFormat => com.groupdocs.viewer.legacy.domain.FileFormat    
26.  com.groupdocs.viewer.domain.FileData => com.groupdocs.viewer.legacy.domain.FileData    
27.  com.groupdocs.viewer.domain.Page => com.groupdocs.viewer.legacy.domain.Page    
28.  com.groupdocs.viewer.domain.PageData => com.groupdocs.viewer.legacy.domain.PageData    
29.  com.groupdocs.viewer.domain.RowData => com.groupdocs.viewer.legacy.domain.RowData    
30.  com.groupdocs.viewer.domain.Transformation => com.groupdocs.viewer.legacy.domain.Transformation    
31.  com.groupdocs.viewer.domain.Watermark => com.groupdocs.viewer.legacy.domain.Watermark    
32.  com.groupdocs.viewer.domain.WatermarkPosition => com.groupdocs.viewer.legacy.domain.WatermarkPosition    
33.  com.groupdocs.viewer.domain.WindowsAuthenticationCredential => com.groupdocs.viewer.legacy.domain.WindowsAuthenticationCredential    
34.  com.groupdocs.viewer.domain.FileDescription => com.groupdocs.viewer.legacy.domain.FileDescription    
35.  com.groupdocs.viewer.domain.image.PageImage => com.groupdocs.viewer.legacy.domain.image.PageImage    
36.  com.groupdocs.viewer.domain.html.HtmlResource => com.groupdocs.viewer.legacy.domain.html.HtmlResource    
37.  com.groupdocs.viewer.domain.html.HtmlResourceType => com.groupdocs.viewer.legacy.domain.html.HtmlResourceType    
38.  com.groupdocs.viewer.domain.html.PageHtml => com.groupdocs.viewer.legacy.domain.html.PageHtml    
39.  com.groupdocs.viewer.domain.cache.CachedDocumentDescription => com.groupdocs.viewer.legacy.domain.cache.CachedDocumentDescription    
40.  com.groupdocs.viewer.domain.cache.CachedAttachmentDescription => com.groupdocs.viewer.legacy.domain.cache.CachedAttachmentDescription    
41.  com.groupdocs.viewer.domain.cache.CacheFileDescription => com.groupdocs.viewer.legacy.domain.cache.CacheFileDescription    
42.  com.groupdocs.viewer.domain.cache.CacheFileType => com.groupdocs.viewer.legacy.domain.cache.CacheFileType    
43.  com.groupdocs.viewer.domain.cache.CachedPageResourceDescription => com.groupdocs.viewer.legacy.domain.cache.CachedPageResourceDescription    
44.  com.groupdocs.viewer.domain.cache.CachedPageDescription => com.groupdocs.viewer.legacy.domain.cache.CachedPageDescription    
45.  com.groupdocs.viewer.domain.options.PdfFilePermissions => com.groupdocs.viewer.legacy.domain.options.PdfFilePermissions    
46.  com.groupdocs.viewer.domain.options.PdfFileSecurity => com.groupdocs.viewer.legacy.domain.options.PdfFileSecurity    
47.  com.groupdocs.viewer.domain.options.FileListOptions => com.groupdocs.viewer.legacy.domain.options.FileListOptions    
48.  com.groupdocs.viewer.domain.options.DocumentInfoOptions => com.groupdocs.viewer.legacy.domain.options.DocumentInfoOptions    
49.  com.groupdocs.viewer.domain.options.PdfFileOptions => com.groupdocs.viewer.legacy.domain.options.PdfFileOptions    
50.  com.groupdocs.viewer.domain.options.PrintableHtmlOptions => com.groupdocs.viewer.legacy.domain.options.PrintableHtmlOptions    
51.  com.groupdocs.viewer.domain.options.ReorderPageOptions => com.groupdocs.viewer.legacy.domain.options.ReorderPageOptions    
52.  com.groupdocs.viewer.domain.options.RotatePageOptions => com.groupdocs.viewer.legacy.domain.options.RotatePageOptions    
53.  com.groupdocs.viewer.domain.containers.ArchiveDocumentInfoContainer => com.groupdocs.viewer.legacy.domain.containers.ArchiveDocumentInfoContainer    
54.  com.groupdocs.viewer.domain.containers.PdfDocumentInfoContainer => com.groupdocs.viewer.legacy.domain.containers.PdfDocumentInfoContainer    
55.  com.groupdocs.viewer.domain.containers.OutlookDocumentInfoContainer => com.groupdocs.viewer.legacy.domain.containers.OutlookDocumentInfoContainer    
56.  com.groupdocs.viewer.domain.containers.ProjectDocumentInfoContainer => com.groupdocs.viewer.legacy.domain.containers.ProjectDocumentInfoContainer    
57.  com.groupdocs.viewer.domain.containers.CadDocumentInfoContainer => com.groupdocs.viewer.legacy.domain.containers.CadDocumentInfoContainer    
58.  com.groupdocs.viewer.domain.containers.DocumentFormatsContainer => com.groupdocs.viewer.legacy.domain.containers.DocumentFormatsContainer    
59.  com.groupdocs.viewer.domain.containers.DocumentInfoContainer => com.groupdocs.viewer.legacy.domain.containers.DocumentInfoContainer    
60.  com.groupdocs.viewer.domain.containers.FileContainer => com.groupdocs.viewer.legacy.domain.containers.FileContainer    
61.  com.groupdocs.viewer.domain.containers.PrintableHtmlContainer => com.groupdocs.viewer.legacy.domain.containers.PrintableHtmlContainer    
62.  com.groupdocs.viewer.domain.containers.FileListContainer => com.groupdocs.viewer.legacy.domain.containers.FileListContainer    
63.  com.groupdocs.viewer.converter.options.ArchiveOptions => com.groupdocs.viewer.legacy.converter.options.ArchiveOptions    
64.  com.groupdocs.viewer.converter.options.OutlookOptions => com.groupdocs.viewer.legacy.converter.options.OutlookOptions    
65.  com.groupdocs.viewer.converter.options.EmailField => com.groupdocs.viewer.legacy.converter.options.EmailField    
66.  com.groupdocs.viewer.converter.options.ImageQuality => com.groupdocs.viewer.legacy.converter.options.ImageQuality    
67.  com.groupdocs.viewer.converter.options.PageSize => com.groupdocs.viewer.legacy.converter.options.PageSize    
68.  com.groupdocs.viewer.converter.options.ProjectOptions => com.groupdocs.viewer.legacy.converter.options.ProjectOptions    
69.  com.groupdocs.viewer.converter.options.SlidesOptions => com.groupdocs.viewer.legacy.converter.options.SlidesOptions    
70.  com.groupdocs.viewer.converter.options.CadOptions => com.groupdocs.viewer.legacy.converter.options.CadOptions    
71.  com.groupdocs.viewer.converter.options.TextOverflowMode => com.groupdocs.viewer.legacy.converter.options.TextOverflowMode    
72.  com.groupdocs.viewer.converter.options.EmailOptions => com.groupdocs.viewer.legacy.converter.options.EmailOptions    
73.  com.groupdocs.viewer.converter.options.TimeUnit => com.groupdocs.viewer.legacy.converter.options.TimeUnit    
74.  com.groupdocs.viewer.converter.options.Tile => com.groupdocs.viewer.legacy.converter.options.Tile    
75.  com.groupdocs.viewer.converter.options.WordsOptions => com.groupdocs.viewer.legacy.converter.options.WordsOptions    
76.  com.groupdocs.viewer.converter.options.CellsOptions => com.groupdocs.viewer.legacy.converter.options.CellsOptions    
77.  com.groupdocs.viewer.converter.options.ConvertImageFileType => com.groupdocs.viewer.legacy.converter.options.PdfOptions    
78.  com.groupdocs.viewer.converter.options.HtmlOptions => com.groupdocs.viewer.legacy.converter.options.HtmlOptions    
79.  com.groupdocs.viewer.converter.options.ImageOptions => com.groupdocs.viewer.legacy.converter.options.ImageOptions    
80.  com.groupdocs.viewer.converter.options.RenderOptions => com.groupdocs.viewer.legacy.converter.options.RenderOptions    
81.  com.groupdocs.viewer.config.ViewerConfig => com.groupdocs.viewer.legacy.config.ViewerConfig