---
id: groupdocs-viewer-for-java-21-2-release-notes
url: viewer/java/groupdocs-viewer-for-java-21-2-release-notes
title: GroupDocs.Viewer for Java 21.2 Release Notes
weight: 110
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) 21.2{{< /alert >}}

## Major Features

There are some features, improvements, and bug-fixes in this release, most notable are:

*   Added support of retrieving an attachment file type
*   Display folder name in the header when viewing archives
*   Added support of Microsoft Excel 97-2003 Template (.xlt) file format
*   Added new option that enables users to set filename when viewing archive files 
*   [Plotter Document (.plt, .hpg)](https://wiki.fileformat.com/cad/plt/) viewing support added, see [How to view PLT files]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-cad-drawings/how-to-view-plt-files.md" >}}) for more details;
*   Viewing specific [Design Web Format File (.dwf)](https://wiki.fileformat.com/cad/dwf) layers is now supported, see [How to view DWF file layers]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-cad-drawings/how-to-view-dwf-file-layers.md" >}}) for more details;
*   Added option to set background color when viewing CAD drawings, see [How to set background color when converting CAD Drawings]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-cad-drawings/how-to-set-background-color-when-converting-cad-drawings.md" >}}) for more details;
*   Added option to show spreadsheet column headings and row numbers, see [How to show spreadsheet column and row headings]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-excel-spreadsheets/how-to-show-spreadsheet-column-and-row-headings.md" >}}) for more details.
    NOTE: This feature is supported when rendering worksheets into a single page when `SpreadsheetOptions` is set to `SpreadsheetOptions.forOnePagePerSheet()`.
*   When converting CAD drawings to HTML, CAD drawings are converted to SVG instead of PNG   
*Related article* *[How to convert CAD to HTML]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-cad-drawings/how-to-convert-cad-to-html.md" >}})*
*   Added Flat XML ODF Template (.fodg) file format support  
*Related article [How to convert and view ODG and FODG files]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-image-files/how-to-convert-and-view-odg-and-fodg-files.md" >}})*
*   Added IGES Drawing File (.igs) file format support  
*Related article [How to convert and view IGS files]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-cad-drawings/how-to-convert-and-view-igs-files.md" >}})*
*   Added Common File Format File (.cf2) file-format support  
*Related article [How to convert and view CFF2 and CF2 files]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-cad-drawings/how-to-convert-and-view-cff2-and-cf2-files.md" >}})*
*   Added Wavefront 3D Object File (.obj) file-format support  
*Related article [How to convert and view OBJ files]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-cad-drawings/how-to-convert-and-view-obj-files.md" >}})*
*   Added support viewing MS Project documents with notes  
*Related article [How to convert and view MS Project documents with notes]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-ms-project-files/how-to-convert-and-view-ms-project-documents-with-notes.md" >}})*
*   Added support viewing OpenDocument Flat XML Presentation (.fodp) files  
*Related article [How to convert and view FODP and ODP files]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-powerpoint-presentations/how-to-convert-and-view-fodp-and-odp-files.md" >}})*
*   Improved default font support when converting PowerPoint files to HTML and PDF  
*Related article [How to substitute missing font when converting presentations]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-powerpoint-presentations/how-to-substitute-missing-font-when-converting-presentations.md" >}})*
*   [Fixed High RAM consumption issue when rendering a large text file]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-text-files/how-to-convert-and-view-txt-files.md">}})
*   [Improved rendering Outlook files (pst, ost) to HTML]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-outlook-data-files/how-to-convert-and-view-ost-and-pst-files.md">}})
*   [Show spreadsheet column headings and row numbers]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-excel-spreadsheets/how-to-show-spreadsheet-column-and-row-headings.md" >}}) was implemented for all options
*   [Support file format detection for passed stream]({{< ref "viewer/java/developer-guide/basic-usage/how-to-determine-file-type.md">}})
*   [Get sheet names from an Excel file]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-excel-spreadsheets/how-to-get-the-names-of-the-worksheets.md">}})
* Support setting margins when converting HTML files
* Rendering text files into a single HTML page
* Excel 2003 XML file (SpreadsheetML) (.xml) file-format support
* Apple numbers (.numbers) file-format support
* WinRAR Compressed Archive (.rar version 4) file-format support
* Support splitting up archives into multiple pages by rows and columns
* Support checking if a file is encrypted

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERNET-2318 | Support retrieving an attachment file type | Feature |
| VIEWERNET-2323 | Include folder name when rendering archive folders | Feature |
| VIEWERNET-1898 | Add Microsoft Excel 97-2003 Template (.xlt) file format support | Feature |
| VIEWERNET-2351 | Specify filename when rendering archive files | Feature |
| VIEWERNET-18 | Add Plotter Document (.plt, .hpg) file format support | Feature |
| VIEWERNET-2222 | Show spreadsheet column headings and row numbers | Feature |
| VIEWERNET-2392 | Set background color when viewing CAD Drawings | Feature |
| VIEWERNET-125 | Support viewing MS Project documents with notes | Feature |
| VIEWERNET-2034 | Add OpenDocument Flat XML Presentation (.fodp) file format support | Feature |
| VIEWERNET-2046 | Add Flat XML ODF Template (.fodg) file format support | Feature |
| VIEWERNET-2057 | Convert CAD drawings to SVG | Feature |
| VIEWERNET-2059 | Add IGES Drawing File (.igs) format support | Feature |
| VIEWERNET-2243 | Add Common File (.cf2) format support | Feature |
| VIEWERNET-2311 | Add Wavefront 3D Object File (.obj) file-format support | Feature |
| VIEWERNET-2485 | Get sheet names from an Excel file | Feature |
| VIEWERNET-2222 | Show spreadsheet column headings and row numbers | Feature |
| VIEWERNET-2474 | Support file format detection for passed stream | Feature |
|VIEWERNET-2219|Rendering text files into single HTML page|Feature|
|VIEWERNET-2492|Support setting margins when converting HTML files|Feature|
|VIEWERNET-2509|Add WinRAR Compressed Archive (.rar) file-format support|Feature|
|VIEWERNET-2535|Split up archives into multiple pages|Feature|
|VIEWERNET-2549|Add feature to identify if file is Password Protected|Feature|
|VIEWERNET-2575|Add Apple numbers (.numbers) file-format support|Feature|
|VIEWERNET-2578|Add Excel 2003 XML (SpreadsheetML) (.xml) file-format support|Feature|
| VIEWERNET-2324 | Recreate output files and resources instead of writing over | Improvement |
| VIEWERNET-2155 | Reduce margins when rendering LaTeX (.tex) files | Improvement |
| VIEWERNET-2355 | Return unknown file type when passing null or empty string as extension or media type | Improvement |
| VIEWERNET-2356 | Accept attachment object instead of attachment ID | Improvement |
| VIEWERNET-316 | Support viewing Design Web Format File (.dwf) layers | Improvement |
| VIEWERNET-2387 | Display Inbox folder by default when viewing personal storage PST/OST files | Improvement |
| VIEWERNET-2433 | Improve default font support when converting PowerPoint files | Improvement |
| VIEWERNET-2468 | Improved rendering Outlook files (pst, ost) to HTML | Improvement |
| VIEWERJAVA-2449 | Implement possibility to use custom serialization for caching | Improvement |
| VIEWERNET-8 | Overlapping Characters in Safari for iOS | Bug |
| VIEWERNET-226 | Files being created in Windows temp folder | Bug |
| VIEWERNET-257 | Incorrect rendering of DWG file as image | Bug |
| VIEWERNET-1202 | Invalid characters while viewing rendered HTML in IE | Bug |
| VIEWERNET-2175 | STL file is rendered into blank HTML or image | Bug |
| VIEWERNET-2306 | Issue in rendering/converting email attachments | Bug |
| VIEWERNET-2319 | Archive file name is missing when passing file stream | Bug |
| VIEWERNET-2320 | getViewInfo hangs indefinitely  | Bug |
| VIEWERNET-2321 | ArchiveViewInfo shows that current folder is sub-folder of itself | Bug |
| VIEWERNET-2343 | Document viewer size discrepancy  | Bug |
| VIEWERNET-86 | setDefaultFontName(...) setting is not working for rendering Word Processing documents into HTML | Bug |
| VIEWERNET-2120 | Page size is 0 for HTML mode | Bug |
| VIEWERNET-2347 | The number greater than zero is expected exception | Bug |
| VIEWERNET-2352 | Output shows compressed file content/data as Compressed Word File | Bug |
| VIEWERNET-2180 | Drawing objects are missing when rendering Word document as HTML | Bug |
| VIEWERNET-2317 | Docx to Html conversion issue, unit degree is missing in resultant file | Bug |
| VIEWERNET-2322 | Japanese Space is showing as lines | Bug |
| VIEWERNET-2325 | PDF with watermark to HTML rendering issue | Bug |
| VIEWERNET-2344 | PPTX-file with RTL text inside renders incorrectly. | Bug |
| VIEWERNET-258 | Exception when rendering DWG file as image | Bug |
| VIEWERNET-2125 | Same result when rendering presentation without and with excluded font | Bug |
| VIEWERNET-2285 | Link represented as span when rendering PDF into HTML | Bug |
| VIEWERNET-2424 | File is corrupted or damaged exception when converting MPX file | Bug |
| VIEWERNET-2434 | High RAM consumption issue when rendering a large text file | Bug |
| VIEWERNET-2466 | Rendering Archive to PDF does not show certain characters | Bug |
| VIEWERNET-2473 | Exception is thrown when rendering SVG file | Bug |
| VIEWERNET-2480 | "Image export failed" exception when rendering WMF file | Bug |
| VIEWERNET-2494 | "Input string was not in a correct format" exception when rendering XLSX | Bug |
| VIEWERNET-2496 | "Parameter is not valid" exception when rendering VSDX file | Bug |
| VIEWERNET-2497 | "Unable to read beyond the end of the stream" exception when rendering ICO file | Bug |
| VIEWERNET-2503 | "File is corrupted or damaged" exception when rendring CSV file | Bug |
| VIEWERNET-2505 | Exception: Invalid start row index on XLSB file | Bug |
| VIEWERNET-2529 | HTML representation generating stuck | Bug |
| VIEWERNET-2533 | The row index should not be inside the pivottable report | Bug |
| VIEWERNET-2532 | Not null and not empty string is expected | Bug |
| VIEWERNET-2430 | Saving email attachment using Viewer API shows evaluation tag | Bug |
|VIEWERNET-2181|Images are missing when rendering Excel as HTML/image/PDF|Bug|
|VIEWERNET-2217|AutoCad rendering issue|Bug|
|VIEWERNET-2348|Cannot access a disposed object error when disposing the Viewer |Bug|
|VIEWERNET-2465|Exception: Image export failed |Bug|
|VIEWERNET-2470|"Image export failed" exception when rendering EMF file"|Bug|
|VIEWERNET-2484|getViewInfo consumes a lot of memory |Bug|
|VIEWERNET-2498|Overflow error on VSDX file|Bug|
|VIEWERNET-2501|Partial Worksheet rendering issue|Bug|
|VIEWERNET-2530|File damaged or corrupted error|Bug|
|VIEWERNET-2537|Unable to cast object of type double to string|Bug|
|VIEWERNET-2543|VDX and VSS files rendered incorrectly|Bug|
|VIEWERNET-2544|XLSM file can't be viewed|Bug|
|VIEWERNET-2573|"File is corrupted or damaged" exception when rendring XLS file|Bug|
|VIEWERNET-2574|Determine attached file extension in EML|Bug|
|VIEWERNET-2580|Exception is thrown when rendering XLSX file|Bug|
|VIEWERNET-2590|"Parameter is not valid" exception when rendering VSD file|Bug|
|VIEWERNET-2596|Out of memory exception|Bug|
|VIEWERNET-2610|Can't view ICO file|Bug|
|VIEWERNET-2611|Can't get document info for ICO|Bug|
|VIEWERNET-2631|Exception is thrown when rendering VDX file|Bug|
|VIEWERNET-2637|Application never exits when converting SVG to PNG/JPG on Linux|Bug|
|VIEWERNET-2638|Application never exits when converting EMF to HTML on Linux|Bug|
|VIEWERNET-2639|Blank image when converting EMF to PNG on Linux|Bug|
|VIEWERNET-2640|Invalid row index|Bug|


## Public API and Backward Incompatible Changes

In version 21.2 following changes in public API were made:

### Changes in `PdfOptions` class

New methods were added to [PdfOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfOptions) class

```java
    class PdfOptions {
        /*
         * When this option enabled the output pages will have the same size
         * in pixels as page size in a source PDF document.
         * By default GroupDocs.Viewer calculates output image page size for better rendering quality.
         * Note: This option is supported when rendering into PNG or JPG formats.
         */
        void setEnableFontHinting(boolean value)
        boolean isRenderOriginalPageSize()
    }
```

### Changes in `FileType` class

New constants and methods were added to [FileType](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/FileType) class. 

More details and use cases can be found in [How to determine file type]({{< ref "viewer/java/developer-guide/basic-usage/how-to-determine-file-type.md" >}}) documentation article.

```java
    enum FileType {
        /*
         * Gnu Zipped File (.gz)
         */
        GZ("Gnu Zipped File", ".gz")
    
        /*
         * Gnu Zipped File (.gzip)
         */
        GZIP("Gnu Zipped File", ".gzip")
        
        /*
         * Microsoft Excel Template (.xlt)
         */
        XLT("Microsoft Excel Template", ".xlt")
        /*
         * Roshal ARchive (.rar) are compressed files generated using the RAR (WINRAR version 4) compression method.
         */
        RAR("Rar Compressed File", ".rar")
        
        /*
         * Excel 2003 XML (SpreadsheetML) represents Excel Binary File Format. 
         * Such files can be created by Microsoft Excel as well as other similar spreadsheet programs such as OpenOffice Calc or Apple Numbers.
         */
        EXCEL_2003_XML("Excel 2003 XML (SpreadsheetML)", ".xml")

        /*
         * Apple numbers represent Excel-like Binary File Format. Such files can be created by Apple numbers application.
         */
        NUMBERS("Apple numbers", ".numbers")
     
        /*
         * Maps file media type to file type e.g. 'application/pdf' will be mapped to `FileType.PDF`/>.
         * If `null` or `empty` was passed, it returns `FileType.Unknown` file type
         * @param mediaType File media type e.g. application/pdf.
         * @return corresponding media type when found, otherwise returns default `UNKNOWN` file type.
         */
        FileType fromMediaType(String mediaType)
    
        /*
         * This method now accepts `null` or `empty` string and returns `FileType.Unknown` file type instead of throwing `InvalidArgumentException`.
         */
        FileType fromExtension(String)
        /*
         * Detects file type by reading the file signature.
         * @param source The file stream.
         * @return Returns file type in case it was detected successfully otherwise returns default `FileType.Unknown` file type.
         */
        FileType fromStream(InputStream source)
        /*
         * Detects file type by reading the file signature.
         * @param source The file stream.
         * @param password The password to open the file.
         * @return Returns file type in case it was detected successfully otherwise returns default `FileType.Unknown` file type.
         */
        FileType fromStream(InputStream source, String password)
    }
```

### Changes in `ArchiveOptions` class

New methods were added to [ArchiveOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/ArchiveOptions)

```java
    class ArchiveOptions {
        /*
         * Methods were added to display in the header. By default, the name of the source file is displayed.
         */
        FileName getFileName()
        void setFileName(FileName fileName)

        /*
         * Methods were added to specify the number of records per page (for rendering to HTML only)
         */
        int getItemsPerPage()
        void setItemsPerPage(int)
    }
```

### Added `FileName` class

Class `FileName` was added to represent the name of the file.

```java
    class FileName {
        /**
         * The empty filename.
         */
        static EMPTY("<empty>")
        /**
         * The name of the source file.
         */
        static SOURCE("<source>")
    
        /**
         * Initializes new instance of FileName class.
         *
         * @param fileName The name of the file.
         */
        public FileName(String fileName)
    
        /**
         * Returns a string that represents the current object.
         */
        String toString()
    }
```

### Changes in `Attachment` class

New constructor was added to [Attachment](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/Attachment) class

```java
    class Attachment {
        /*
         * Initializes new instance of attachment class.
         * @param fileName file name.
         */
        public Attachment(String fileName)
    }
```

### Changes in `Viewer` class

New methods were added to [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class
See [How to check if file is encrypted]({{< ref "how-to-check-if-file-is-encrypted.md">}}) for more details and code sample.

```java
    class Viewer {
        /*
         * Method was set as deprecated. And will removed in future releases. Please switch to the method that accepts Attachment as a first parameter.
         */
        void saveAttachment(String attachmentId, OutputStream destination)
        
        /*
         * Method added to save attachment file to the destination stream.
         * @param attachment The attachment.
         * @param destination The writable stream.
         */
        void saveAttachment(Attachment attachment, OutputStream destination)

        /*
        * Added new method to support checking if file is encrypted or not.
        * Returns information about file such as file-type and flag that indicates if file is encrypted.
        */
        FileInfo getFileInfo()
    }
```

### Changes in `CadOptions` class

New methods were added to [CadOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/CadOptions) class

```java
    class CadOptions {
        /*
         * Image background color
         */
        Color getBackgroundColor()
        void setBackgroundColor(Color color)
    }
```

#### Changes in `SpreadsheetOptions` class

New methods were added to [SpreadsheetOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions) class
See [Split worksheets into pages]({{< ref "split-worksheets-into-pages.md" >}}) documentation article for more details and code samples.

```java
    class SpreadsheetOptions {
        /*
         * Enables headings rendering.
         */
        boolean isRenderHeadings()
        void setRenderHeadings(boolean render)

        /*
         * Initializes new instance of `SpreadsheetOptions` for rendering sheet into pages.
         * @param countRowsPerPage Rows count to include into each page.
         * @param countColumnsPerPage Columns count to include into each page.
         */
        SpreadsheetOptions forSplitSheetIntoPages(int countRowsPerPage, int countColumnsPerPage)

        /*
         * The method was added to support partial rendering of Excel spreadsheets by splitting worksheets into pages by rows and columns.
         * The columns count to include into each page when splitting worksheet into pages.
         */
        int getCountColumnsPerPage()
    }
```

### Added `FileInfo` class

Class `FileInfo` was added to support checking if file is encrypted or not.

```java
/*
 * Contains information about file.
 */
class FileInfo {

    /*
    * The type of the file.
    */
    FileType getFileType()
    /*
     * Indicates that file is encrypted.
     */
    boolean isEncrypted()
    void setEncrypted(boolean)

    /*
    * Returns a string that represents the current object.
    */
    String toString()
}
```

#### Changes in `HtmlViewOptions` class

New methods were added to [HtmlViewOptions](<https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions>) class
For more details see [Rendering text files into a single HTML page]({{< ref "how-to-convert-and-view-txt-files.md#convert-txt-to-html">}}).

```java
    class HtmlViewOptions {
        /*
         * Methods were added to support rendering text files to a single page
         * Enables HTML content will be rendered to single page
         */
        boolean isRenderSinglePage()
        void setRenderSinglePage(boolean)
    }
```

#### Changes in `WordProcessingOptions` class

New methods were added to [WordProcessingOptions](<https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/WordProcessingOptions>) class to support setting margins when rendering Web documents.
 See [How to convert and view HTML files with user defined margins]({{< ref "how-to-convert-and-view-html-files-with-margins.md" >}}) documentation article for more details and code samples.

```java
    class WordProcessingOptions {

        /*
         * Left page margin (for HTML rendering only)
         */
        float getLeftMargin()
        void setLeftMargin(float)
    
        /*
         * Right page margin (for HTML rendering only)
         */
        float getRightMargin()
        void setRightMargin(float)
    
        /*
         * Top page margin (for HTML rendering only)
         */
        float getTopMargin()
        void setTopMargin(float)
    
        /*
         * Bottom page margin (for HTML rendering only)
         */
        float getBottomMargin()
        void setBottomMargin(float)
    }
```

### Next classes were renamed and from them were extracted interfaces

* Class `ArchiveViewInfo` was renamed to [ArchiveViewInfoImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/ArchiveViewInfoImpl) and from it was extracted interface [ArchiveViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/ArchiveViewInfo)
* Class `Attachment` was renamed to [AttachmentImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/AttachmentImpl) and from it was extracted interface [Attachment](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/Attachment)
* Class `CadViewInfo` was renamed to [CadViewInfoImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/CadViewInfoImpl) and from it was extracted interface [CadViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/CadViewInfo)
* Class `Character` was renamed to [CharacterImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/CharacterImpl) and from it was extracted interface [Character](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/Character)
* Class `FileInfo` was renamed to [FileInfoImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/FileInfoImpl) and from it was extracted interface [FileInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/FileInfo)
* Class `Layer` was renamed to [LayerImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/LayerImpl) and from it was extracted interface [Layer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/Layer)
* Class `Layout` was renamed to [LayoutImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/LayoutImpl) and from it was extracted interface [Layout](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/Layout)
* Class `Line` was renamed to [LineImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/LineImpl) and from it was extracted interface [Line](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/Line)
* Class `LotusNotesViewInfo` was renamed to [LotusNotesViewInfoImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/LotusNotesViewInfoImpl) and from it was extracted interface [LotusNotesViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/LotusNotesViewInfo)
* Class `OutlookViewInfo` was renamed to [OutlookViewInfoImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/OutlookViewInfoImpl) and from it was extracted interface [OutlookViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/OutlookViewInfo)
* Class `Page` was renamed to [PageImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/PageImpl) and from it was extracted interface [Page](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/Page)
* Class `PdfViewInfo` was renamed to [PdfViewInfoImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/PdfViewInfoImpl) and from it was extracted interface [PdfViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/PdfViewInfo)
* Class `ProjectManagementViewInfo` was renamed to [ProjectManagementViewInfoImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/ProjectManagementViewInfoImpl) and from it was extracted interface [ProjectManagementViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/ProjectManagementViewInfo)
* Class `TextElement` was renamed to [TextElementImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/TextElementImpl) and from it was extracted interface [TextElement](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/TextElement)
* Class `ViewInfo` was renamed to [ViewInfoImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/ViewInfoImpl) and from it was extracted interface [ViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/ViewInfo)
* Class `Word` was renamed to [WordImpl](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/WordImpl) and from it was extracted interface [Word](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/Word)

**This changes were made to implement possibility to use custom serialization functionality with caching. More details you can find in [Using Custom model classes for caching]({{< ref "how-to-use-custom-cache-implementation.md" >}})**

**It is better** to use `CacheableFactory.getInstance().newCadViewInfo(...)`, `CacheableFactory.getInstance().newWord(...)` and so on to create new instances of classes above. But if you are not going to use custom serialization, you can still use `new CadViewInfoImpl(...)`, `new WordImpl(...)`, ...

### Behavior changes
*   Starting from 21.2 the CAD drawings are converted to SVG instead of PNG for better quality. Please refer to [How to convert CAD to HTML]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-cad-drawings/how-to-convert-cad-to-html.md" >}}) article for more details.

* In this version we've improved viewing of archives and text files - now it could be rendered to multiple and single pages (by default they are rendered to multiple pages). See [How to convert archive files to HTML]({{< ref "how-to-convert-archive-files-to-html.md" >}}) and [How to convert and view TXT files]({{< ref "how-to-convert-and-view-txt-files.md" >}}) for more details.

*   In this version we've improved viewing of Personal Storage [OST](https://wiki.fileformat.com/email/ost/)/[PST](https://wiki.fileformat.com/email/pst/) files and as a result, the behavior changed.  
    Now when viewing personal storage OST /PST files the **Inbox** folder is selected and displayed by default as it shown on the screenshot below.

![](viewer/java/images/groupdocs-viewer-for-net-20-4-release-notes.png)