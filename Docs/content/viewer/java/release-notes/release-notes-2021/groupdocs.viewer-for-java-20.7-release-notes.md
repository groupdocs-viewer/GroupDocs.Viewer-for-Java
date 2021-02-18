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
    NOTE: This feature is supported when rendering worksheets into a single page when *SpreadsheetOptions* is set to SpreadsheetOptions.ForOnePagePerSheet().
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
There are 19 features, improvements, and bug-fixes in this release, most notable are:
*   [Fixed High RAM consumption issue when rendering a large text file]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-text-files/how-to-convert-and-view-txt-files.md">}})
*   [Improved rendering Outlook files (pst, ost) to HTML]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-outlook-data-files/how-to-convert-and-view-ost-and-pst-files.md">}})
*   [Show spreadsheet column headings and row numbers]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-excel-spreadsheets/how-to-show-spreadsheet-column-and-row-headings.md" >}}) was implemented for all options
*   [Support file format detection for passed stream]({{< ref "viewer/java/developer-guide/basic-usage/how-to-determine-file-type.md">}})
*   [Get sheet names from an Excel file]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-excel-spreadsheets/how-to-get-the-names-of-the-worksheets.md">}})
* Support setting margins when converting HTML files
* Rendering text files into a single HTML page
* Excel 2003 XML file (SpreadsheetML) (.xml) file-format support
* Apple numbers (.numbers) file-format support
* WinRAR Compressed Archive (.rar) file-format support
* Support splitting up archives into multiple pages by rows and columns
* Support checking if a file is encrypted

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERNET-2318 | Support retrieving an attachment file type | Feature |
| VIEWERNET-2323 | Include folder name when rendering archive folders | Feature |
| VIEWERNET-2324 | Recreate output files and resources instead of writing over | Improvement |
| VIEWERNET-8 | Overlapping Characters in Safari for iOS | Bug |
| VIEWERNET-226 | Files being created in Windows temp folder | Bug |
| VIEWERNET-257 | Incorrect rendering of DWG file as image | Bug |
| VIEWERNET-1202 | Invalid characters while viewing rendered HTML in IE | Bug |
| VIEWERNET-2175 | STL file is rendered into blank HTML or image | Bug |
| VIEWERNET-2306 | Issue in rendering/converting email attachments | Bug |
| VIEWERNET-2315 | Getting evaluation message on second server even license is applied  | Bug |
| VIEWERNET-2319 | Archive file name is missing when passing file stream | Bug |
| VIEWERNET-2320 | GetViewInfo hangs indefinitely  | Bug |
| VIEWERNET-2321 | ArchiveViewInfo shows that current folder is sub-folder of itself | Bug |
| VIEWERNET-2343 | Document viewer size discrepancy  | Bug |
| VIEWERNET-1898 | Add Microsoft Excel 97-2003 Template (.xlt) file format support | Feature |
| VIEWERNET-2351 | Specify filename when rendering archive files | Feature |
| VIEWERNET-2155 | Reduce margins when rendering LaTeX (.tex) files | Improvement |
| VIEWERNET-2355 | Return unknown file type when passing null or empty string as extension or media type | Improvement |
| VIEWERNET-2356 | Accept attachment object instead of attachment ID | Improvement |
| VIEWERNET-86 | DefaultFontName setting is not working for rendering Word Processing documents into HTML | Bug |
| VIEWERNET-2120 | Page size is 0 for HTML mode | Bug |
| VIEWERNET-2347 | The number greater than zero is expected exception | Bug |
| VIEWERNET-2352 | Output shows compressed file content/data as Compressed Word File | Bug |
| VIEWERNET-18 | Add Plotter Document (.plt, .hpg) file format support | Feature |
| VIEWERNET-2222 | Show spreadsheet column headings and row numbers | Feature |
| VIEWERNET-2392 | Set background color when viewing CAD Drawings | Feature |
| VIEWERNET-316 | Support viewing Design Web Format File (.dwf) layers | Improvement |
| VIEWERNET-2387 | Display Inbox folder by default when viewing personal storage PST/OST files | Improvement |
| VIEWERNET-2180 | Drawing objects are missing when rendering Word document as HTML | Bug |
| VIEWERNET-2317 | Docx to Html conversion issue, unit degree is missing in resultant file | Bug |
| VIEWERNET-2322 | Japanese Space is showing as lines | Bug |
| VIEWERNET-2325 | PDF with watermark to HTML rendering issue | Bug |
| VIEWERNET-2344 | PPTX-file with RTL text inside renders incorrectly. | Bug |
| VIEWERNET-125 | Support viewing MS Project documents with notes | Feature |
| VIEWERNET-2034 | Add OpenDocument Flat XML Presentation (.fodp) file format support | Feature |
| VIEWERNET-2046 | Add Flat XML ODF Template (.fodg) file format support | Feature |
| VIEWERNET-2057 | Convert CAD drawings to SVG | Feature |
| VIEWERNET-2059 | Add IGES Drawing File (.igs) file format support | Feature |
| VIEWERNET-2243 | Add Common File Format File (.cf2) file-format support | Feature |
| VIEWERNET-2311 | Add Wavefront 3D Object File (.obj) file-format support | Feature |
| VIEWERNET-2433 | Improve default font support when converting PowerPoint files | Improvement |
| VIEWERNET-258 | Exception when rendering DWG file as image | Bug |
| VIEWERNET-2125 | Same result when rendering presentation without and with excluded font | Bug |
| VIEWERNET-2285 | Link represented as span when rendering PDF into HTML | Bug |
| VIEWERNET-2424 | File is corrupted or damaged exception when converting MPX file | Bug |
| VIEWERNET-2458 | Unable to load shared library 'gdi32.dll' or one of its dependencies exception when processing TEX files on Linux | Bug |
| VIEWERNET-2485 | Get sheet names from an Excel file | Feature |
| VIEWERNET-2222 | Show spreadsheet column headings and row numbers | Feature |
| VIEWERNET-2474 | Support file format detection for passed stream | Feature |
| VIEWERNET-2468 | Improved rendering Outlook files (pst, ost) to HTML | Improvement |
| VIEWERNET-2434 | High RAM consumption issue when rendering a large text file | Bug |
| VIEWERNET-2466 | Rendering Archive to PDF does not show certain characters | Bug |
| VIEWERNET-2473 | Exception is thrown when rendering SVG file | Bug |
| VIEWERNET-2476 | Exception: A generic error occurred in GDI+ | Bug |
| VIEWERNET-2480 | "Image export failed" exception when rendering WMF file | Bug |
| VIEWERNET-2494 | Input string was not in a correct format" exception when rendering XLSX | Bug |
| VIEWERNET-2495 | "A generic error occurred in GDI+" exception occurs when rendering VSDX file | Bug |
| VIEWERNET-2496 | "Parameter is not valid" exception when rendering VSDX file | Bug |
| VIEWERNET-2497 | "Unable to read beyond the end of the stream" exception when rendering ICO file | Bug |
| VIEWERNET-2503 | "File is corrupted or damaged" exception when rendring CSV file | Bug |
| VIEWERNET-2504 | "A generic error occurred in GDI+" exception occurs when rendering ICO file | Bug |
| VIEWERNET-2505 | Exception: Invalid start row index on XLSB file | Bug |
| VIEWERNET-2529 | HTML representation generating stuck | Bug |
| VIEWERNET-2533 | The row index should not be inside the pivottable report | Bug |
| VIEWERNET-2532 | Not null and not empty string is expected | Bug |
| VIEWERNET-2430 | Saving email attachment using Viewer API shows evaluation tag | Bug |
|VIEWERNET-2219|Rendering text files into single HTML page|Feature|
|VIEWERNET-2492|Support setting margins when converting HTML files|Feature|
|VIEWERNET-2509|Add WinRAR Compressed Archive (.rar) file-format support|Feature|
|VIEWERNET-2535|Split up archives into multiple pages|Feature|
|VIEWERNET-2549|Add feature to identify File is Password Protected|Feature|
|VIEWERNET-2575|Add Apple numbers (.numbers) file-format support|Feature|
|VIEWERNET-2578|Add Excel 2003 XML file (SpreadsheetML) (.xml) file-format support|Feature|
|VIEWERNET-2181|Images are missing when rendering Excel as HTML/image/PDF|Bug|
|VIEWERNET-2217|AutoCad rendering issue|Bug|
|VIEWERNET-2348|Cannot access a disposed object error when disposing the Viewer |Bug|
|VIEWERNET-2465|Exception: Image export failed |Bug|
|VIEWERNET-2470|"Image export failed" exception when rendering EMF file"|Bug|
|VIEWERNET-2484|GetViewInfo consumes a lot of memory |Bug|
|VIEWERNET-2498|Overflow error on VSDX file|Bug|
|VIEWERNET-2501|Partial Worksheet rendering issue|Bug|
|VIEWERNET-2530|File damaged or corrupted error|Bug|
|VIEWERNET-2537|Unable to cast object of type double to string|Bug|
|VIEWERNET-2543|VDX and VSS files rendered incorrectly|Bug|
|VIEWERNET-2544|XLSM file can't be viewed|Bug|
|VIEWERNET-2573|"File is corrupted or damaged" exception when rendring XLS file"|Bug|
|VIEWERNET-2574|Determine attached file extension in EML|Bug|
|VIEWERNET-2580|Exception is thrown when rendering XLSX file|Bug|
|VIEWERNET-2590|"Parameter is not valid" exception when rendering VSD file"|Bug|
|VIEWERNET-2596|Out of memory exception|Bug|
|VIEWERNET-2610|Can't view ICO file|Bug|
|VIEWERNET-2611|Can't get document info for ICO|Bug|
|VIEWERNET-2631|Exception is thrown when rendering VDX file|Bug|
|VIEWERNET-2637|Application never exits when converting SVG to PNG/JPG on Linux|Bug|
|VIEWERNET-2638|Application never exits when converting EMF to HTML on Linux|Bug|
|VIEWERNET-2639|Blank image when converting EMF to PNG on Linux|Bug|
|VIEWERNET-2640|Invalid row index|Bug|


## Public API and Backward Incompatible Changes

In version 20.2 following public class members were added:

*   Added new property to **[PdfOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfOptions)** class

```csharp
/// <summary>
/// When this option enabled the output pages will have the same size
/// in pixels as page size in a source PDF document.
/// By default GroupDocs.Viewer calculates output image page size for better rendering quality.
/// </summary>
/// <remarks>
/// This option is supported when rendering into PNG or JPG formats.
/// </remarks>
public bool RenderOriginalPageSize { get; set; }
```

*   Added two fields and one method to **[FileType](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/FileType)** class

```csharp
/// <summary>
/// Gnu Zipped File (.gz)
/// </summary>
public static readonly FileType GZ = new FileType("Gnu Zipped File", ".gz");

/// <summary>
/// Gnu Zipped File (.gzip)
/// </summary>
public static readonly FileType GZIP = new FileType("Gnu Zipped File", ".gzip");
 
/// <summary>
/// Maps file media type to file type e.g. 'application/pdf' will be mapped to <see cref="FileType.PDF"/>.
/// </summary>
/// <param name="mediaType">File media type e.g. application/pdf.</param>
/// <exception cref="T:System.ArgumentException">Thrown when <paramref name="mediaType"/> is null or empty string.</exception>
/// <returns>Returns corresponding media type when found, otherwise returns default <see cref="Unknown"/> file type.</returns>
public static FileType FromMediaType(string mediaType)
```

### Changes in GroupDocs.Viewer.FileType class

public static readonly FileType XLT = new FileType("Microsoft Excel Template", ".xlt"); field added

Microsoft Excel Template (.xlt)

public static FileType FromExtension(string extension) method behavior changed

This method now accepts *null* or *empty* string and returns *FileType.Unknown* file type instead of throwing *InvalidArgumentException*.

public static FileType FromMediaType(string mediaType) method behavior changed

This method now accepts *null* or *empty* string and returns *FileType.Unknown* file type instead of throwing *InvalidArgumentException*.

### Changes in GroupDocs.Viewer.Options.ArchiveOptions class

public FileName FileName { get; set; } property added

The filename to display in the header. By default, the name of the source file is displayed.

### Changes in GroupDocs.Viewer.Options.FileName class

public class FileName class added

This class represents the name of the file.

```csharp
/// <summary>
/// The filename.
/// </summary>
public class FileName
{
    internal string Text { get; }
 
    /// <summary>
    /// The empty filename.
    /// </summary>
    public static readonly FileName Empty = new FileName("<empty>");
 
    /// <summary>
    /// The name of the source file.
    /// </summary>
    public static readonly FileName Source = new FileName("<source>");
 
    /// <summary>
    /// Initializes new instance of <see cref="FileName"/> class.
    /// </summary>
    /// <param name="fileName">The name of the file.</param>
    /// <exception cref="System.ArgumentNullException">Thrown when <paramref name="fileName"/> is null.</exception>
    public FileName(string fileName)
    {
        if (fileName == null)
            throw new ArgumentNullException(nameof(fileName));
        Text = fileName;
    }
 
    /// <summary>
    /// Returns a string that represents the current object.
    /// </summary>
    /// <returns>A string that represents the current object.</returns>
    public override string ToString()
    {
        return Text;
    }
}
```

### Changes in GroupDocs.Viewer.Results.Attachment class

public Attachment(string fileName) constructor added

Initializes new instance of Attachment class.

```csharp
/// <summary>
/// Initializes new instance of <see cref="Attachment"/> class.
/// </summary>
/// <param name="fileName">Attachment file name.</param>
/// <exception cref="System.ArgumentException">Thrown when <paramref name="fileName"/> is null or empty.</exception>
public Attachment(string fileName)
```

### Changes in GroupDocs.Viewer.Viewer class

public Viewer(String filePath, Common.Func<LoadOptions> getLoadOptions) constructor has been removed 

Please switch to the constructor that accepts LoadOptions object instead of factory method.

Viewer(String filePath, Common.Func<LoadOptions> getLoadOptions, ViewerSettings settings) constructor has been removed

Please switch to the constructor that accepts LoadOptions object instead of factory method.

public void SaveAttachment(string attachmentId, Stream destination) method set as obsolete

This method is obsolete and will removed in June 2020 (v20.6). Please switch to the method that accepts Attachment as a first parameter.

public void SaveAttachment(Attachment attachment, Stream destination) method added

Saves attachment file to the destination stream.

```csharp
/// <summary>
/// Saves attachment file to <paramref name="destination"/> stream.
/// </summary>
/// <param name="attachment">The attachment.</param>
/// <param name="destination">The writable stream.</param>
/// <exception cref="System.ArgumentNullException">Thrown when <paramref name="attachment"/> is null.</exception>
/// <exception cref="System.ArgumentNullException">Thrown when <paramref name="destination"/> is null.</exception>
/// <exception cref="Exceptions.PasswordRequiredException">Thrown when password is required to open the document.</exception>
/// <exception cref="Exceptions.IncorrectPasswordException">Thrown when password that was specified is incorrect.</exception>
/// <exception cref="Exceptions.GroupDocsViewerException">Thrown when attachment could not be found.</exception>
public void SaveAttachment(Attachment attachment, Stream destination)
```

### Behavior changes

*   In this version we've improved viewing of Presonal Storage [OST](https://wiki.fileformat.com/email/ost/)/[PST](https://wiki.fileformat.com/email/pst/) files and as a result, the behavior changed.  
    Now when viewing personal storage OST /PST files the **Inbox** folder is selected and displayed by default as it shown on the screenshot below.

![](viewer/java/images/groupdocs-viewer-for-net-20-4-release-notes.png)

### Changes in the public API 

*   Added new property to [CadOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/CadOptions) class

```csharp
/// <summary>
/// Image background color
/// </summary>
public Color BackgroundColor { get; set; }
```

*   Added new property to [SpreadsheetOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions) class

```csharp
/// <summary>
/// Enables headings rendering.
/// </summary>
public bool RenderHeadings { get; set; }
```

### Behavior changes
*   Starting from 20.5 the CAD drawings are converted to SVG instead of PNG for better quality please refer to [How to convert CAD to HTML]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-cad-drawings/how-to-convert-cad-to-html.md" >}}) article for more details.

### GroupDocs.Viewer.FileType
Two new methods added to the FileType class. The more details and use cases can be found in How to determine file type documentation article.

```csharp
/// <summary>Detects file type by reading the file signature.</summary>
/// <param name="stream">The file stream.</param>
/// <returns>Returns file type in case it was detected successfully otherwise returns default <see cref="F:GroupDocs.Viewer.FileType.Unknown" /> file type.</returns>
public static FileType FromStream(Stream stream)
 
/// <summary>Detects file type by reading the file signature.</summary>
/// <param name="stream">The file stream.</param>
/// <param name="password">The password to open the file.</param>
/// <returns>Returns file type in case it was detected successfully otherwise returns default <see cref="F:GroupDocs.Viewer.FileType.Unknown" /> file type.</returns>
public static FileType FromStream(Stream stream, string password)
```

### GroupDocs.Viewer.Results.Page
Three constructors have been added to the Page class to support retrieving worksheet or page names that is described in How to get the names of the worksheets.

```csharp
/// <summary>
/// Initializes new instance of <see cref="Page"/> class.
/// </summary>
/// <param name="number">The page number.</param>
/// <param name="name">The worksheet or page name.</param>
/// <param name="visible">The page visibility indicator.</param>
/// <exception cref="System.ArgumentException">Thrown when <paramref name="number"/> is less or equal to zero.</exception>
public Page(int number, string name, bool visible)
 
/// <summary>
/// Initializes new instance of <see cref="Page"/> class.
/// </summary>
/// <param name="number">The page number.</param>
/// <param name="name">The worksheet or page name.</param>
/// <param name="visible">The page visibility indicator.</param>
/// <param name="width">The width of the page in pixels when viewing as JPG or PNG.</param>
/// <param name="height">The height of the page in pixels when viewing as JPG or PNG.</param>
/// <exception cref="System.ArgumentException">Thrown when <paramref name="number"/> is less or equal to zero.</exception>
/// <exception cref="System.ArgumentException">Thrown when <paramref name="width"/> is less or equal to zero.</exception>
/// <exception cref="System.ArgumentException">Thrown when <paramref name="height"/> is less or equal to zero.</exception>
public Page(int number, string name, bool visible, int width, int height)
 
/// <summary>
/// Initializes new instance of <see cref="Page"/> class.
/// </summary>
/// <param name="number">The page number.</param>
/// <param name="name">The worksheet or page name.</param>
/// <param name="visible">The page visibility indicator.</param>
/// <param name="width">The width of the page in pixels when viewing as JPG or PNG.</param>
/// <param name="height">The height of the page in pixels when viewing as JPG or PNG.</param>
/// <param name="lines">The lines contained by the page when viewing as JPG or PNG with enabled Text Extraction.</param>
/// <exception cref="System.ArgumentException">Thrown when <paramref name="number"/> is less or equal to zero.</exception>
/// <exception cref="System.ArgumentException">Thrown when <paramref name="width"/> is less or equal to zero.</exception>
/// <exception cref="System.ArgumentException">Thrown when <paramref name="height"/> is less or equal to zero.</exception>
/// <exception cref="System.ArgumentNullException">Thrown when <paramref name="lines"/> is null.</exception>
public Page(int number, string name, bool visible, int width, int height, IList<Line> lines)
```

### Behavior changes

{{< alert style="warning" >}}In this version we've improved viewing of archives and text files - now it could be rendered to multiple and single pages, they are rendered to multiple pages by default. See [How to convert archive files to HTML]({{< ref "how-to-convert-archive-files-to-html.md" >}}) and [How to convert and view TXT files]({{< ref "how-to-convert-and-view-txt-files.md" >}}) for more details.{{< /alert >}}

### Changes in the public API

### GroupDocs.Viewer.Viewer

Added new method _GetFileInfo()_ and related _FileInfo_ class to support checking if file is encrypted or not. See [How to check if file is encrypted]({{< ref "how-to-check-if-file-is-encrypted.md">}}) for more details and code sample.

```csharp
/// <summary>
/// Returns information about file such as file-type and flag that indicates if file is encrypted.
/// </summary>
/// <returns>The file information.</returns>
/// <remarks>
/// <b>Learn more</b>
///   <list type="bullet">
///     <item>
///         Learn more about file information:
///      <a target="_blank" href="https://docs.groupdocs.com/viewer/java/how-to-check-if-file-is-encrypted/">How to check if file is encrypted</a>
///     </item>
///   </list>
/// </remarks>
public FileInfo GetFileInfo()
```

#### GroupDocs.Viewer.FileType

Three new fields added to [GroupDocs.Viewer.FileType](<https://apireference.groupdocs.com/viewer/java/groupdocs.viewer/filetype>) class that reflect new file formats that we're supporting starting from v20.7.

```csharp
/// <summary>
/// Roshal ARchive (.rar) are compressed files generated using the RAR (WINRAR) compression method.
/// Learn more about this file format <a href="https://wiki.fileformat.com/compression/rar">here</a>.
/// </summary>
public static readonly FileType RAR = new FileType("Rar Compressed File", ".rar");

/// <summary>
/// Excel 2003 XML (SpreadsheetML) represents Excel Binary File Format. Such files can be created by Microsoft Excel as well as other similar spreadsheet programs such as OpenOffice Calc or Apple Numbers.
/// Learn more about this file format <a href="https://wiki.fileformat.com/spreadsheet/xls">here</a>.
/// </summary>
public static readonly FileType Excel2003XML = new FileType("Excel 2003 XML (SpreadsheetML)", ".xml");

/// <summary>
/// Apple numbers represent Excel-like Binary File Format. Such files can be created by Apple numbers application.
/// Learn more about this file format <a href="https://fileinfo.com/extension/numbers">here</a>.
/// </summary>
public static readonly FileType NUMBERS = new FileType("Apple numbers", ".numbers");

```

### GroupDocs.Viewer.Results.FileInfo

Added _FileInfo_ class to support checking if file is encrypted or not.

```csharp
/// <summary>
/// Contains information about file.
/// </summary>
[Serializable]
public class FileInfo
{
    /// <summary>
    /// The type of the file.
    /// </summary>
    public FileType FileType { get; }

    /// <summary>
    /// Indicates that file is encrypted.
    /// </summary>
    public bool Encrypted { get; set; }

    /// <summary>
    /// Initializes new instance of <see cref="FileType"/> class.
    /// </summary>
    /// <param name="fileType">The type of the file.</param>
    /// <exception cref="System.ArgumentNullException">Thrown when <paramref name="fileType"/> is null.</exception>
    public FileInfo(FileType fileType)
    {
        if (fileType == null)
            throw new ArgumentNullException(nameof(fileType));

        FileType = fileType;
    }

    /// <summary>
    /// Returns a string that represents the current object.
    /// </summary>
    /// <returns>A string that represents the current object.</returns>
    public override string ToString()
    {
        return string.Format("{0}; Encrypted: {1}", FileType, Encrypted ? "Yes" : "No");
    }
}
```

#### GroupDocs.Viewer.Options.ArchiveOptions

The new property _ItemsPerPage_ has been added to to [GroupDocs.Viewer.Options.CadOptions](<https://apireference.groupdocs.com/viewer/java/groupdocs.viewer.options/archiveoptions>) class to support.

```csharp
/// <summary>
/// Number of records per page (for rendering to HTML only)
/// </summary>
public int ItemsPerPage { get; set; }

```

#### GroupDocs.Viewer.Options.HtmlViewOptions

Added new property _RenderSinglePage_ to [GroupDocs.Viewer.Options.HtmlViewOptions](<https://apireference.groupdocs.com/viewer/java/groupdocs.viewer.options/htmlviewoptions>) class to support rendering text files to a single page see [Rendering text files into a single HTML page]({{< ref "how-to-convert-and-view-txt-files.md#convert-txt-to-html">}}) for more details.

```csharp
/// <summary>
/// Enables HTML content will be rendered to single page
/// </summary>
public bool RenderSinglePage { get; set; }
```

#### GroupDocs.Viewer.Options.SpreadsheetOptions

The new factory method _ForSplitSheetIntoPages()_ and property _CountColumnsPerPage_ has been added to [GroupDocs.Viewer.Options.SpreadsheetOptions](<https://apireference.groupdocs.com/viewer/java/groupdocs.viewer.options/spreadsheetoptions>) to support partial rendering of Excel spreadsheets by splitting worksheets into pages by rows and columns. See [Split worksheets into pages]({{< ref "split-worksheets-into-pages.md" >}}) documentation article for more details and code samples.

```csharp
/// <summary>
/// The columns count to include into each page when splitting worksheet into pages.
/// </summary>
public int CountColumnsPerPage { get; private set; }

/// <summary>
/// Initializes new instance of <see cref="SpreadsheetOptions"/> for rendering sheet into pages.
/// </summary>
/// <param name="countRowsPerPage">Rows count to include into each page.</param>
/// <param name="countColumnsPerPage">Columns count to include into each page.</param>
/// <returns>New instance of <see cref="SpreadsheetOptions"/> for rendering sheet into pages.</returns>
/// <exception cref="System.ArgumentException">Thrown when <paramref name="countRowsPerPage"/> is equals or less than zero.</exception>
/// <exception cref="System.ArgumentException">Thrown when <paramref name="countColumnsPerPage"/> is equals or less than zero.</exception>
public static SpreadsheetOptions ForSplitSheetIntoPages(int countRowsPerPage, int countColumnsPerPage)
```

#### GroupDocs.Viewer.Options.WordProcessingOptions

Added new properties to [GroupDocs.Viewer.Options.WordProcessingOptions](<https://apireference.groupdocs.com/viewer/java/groupdocs.viewer.options/wordprocessingoptions>) class to support setting margins when rendering Web documents see [How to convert and view HTML files with user defined margins]({{< ref "how-to-convert-and-view-html-files-with-margins.md" >}}) documentation article for more details and code samples.

```csharp
/// <summary>
/// Left page margin (for HTML rendering only)
/// </summary>
public float LeftMargin { get; set; }

/// <summary>
/// Right page margin (for HTML rendering only)
/// </summary>
public float RightMargin { get; set; }

/// <summary>
/// Top page margin (for HTML rendering only)
/// </summary>
public float TopMargin { get; set; }

/// <summary>
/// Bottom page margin (for HTML rendering only)
/// </summary>
public float BottomMargin { get; set; }

```