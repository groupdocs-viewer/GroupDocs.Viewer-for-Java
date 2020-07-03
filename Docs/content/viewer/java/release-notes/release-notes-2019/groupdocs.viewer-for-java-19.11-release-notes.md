---
id: groupdocs-viewer-for-java-19-11-release-notes
url: viewer/java/groupdocs-viewer-for-java-19-11-release-notes
title: GroupDocs.Viewer for Java 19.11 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 19.11{{< /alert >}}

## Major Features

There are 20 features, improvements and a bug-fixes in this release, the most notable are:

*   Added Zipped File (.zip) file format support
*   Added Consolidated Unix File Archive (.tar) file format support
*   Added support of rendering PDF documents with security settings

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERJAVA-1983 | Add zip file format support | Feature |
| VIEWERJAVA-1984 | Add tar file format support | Feature |
| VIEWERJAVA-1996 | Obtaining list of folders contained in the zip archive | Feature |
| VIEWERJAVA-1997 | Add C# (.cs) file format support | Feature |
| VIEWERJAVA-1998 | Add Visual Basic (.vb) file format support | Feature |
| VIEWERJAVA-1999 | Print PDF documents which have restriction for printing | Feature |
| VIEWERJAVA-2000 | Specify owner password, user password and permissions when rendering into PDF | Feature |
| VIEWERJAVA-2002 | Detect restriction for the printing | Feature |
| VIEWERJAVA-1987 | Improve performance for rendering PSD image format into PDF | Improvement |
| VIEWERJAVA-1988 | Improve rendering Dicom, Dng and WebP formats into PDF | Improvement |
| VIEWERJAVA-1990 | Extend support for CellsOptions.TextOverflowMode option for rendering into image | Improvement |
| VIEWERJAVA-1991 | Extend support for CellsOptions.TextOverflowMode option for rendering into PDF | Improvement |
| VIEWERJAVA-1994 | Rendering contact photo from vCard file format (VCF) | Improvement |
| VIEWERJAVA-1995 | Improve output for rendering zip archives | Improvement |
| VIEWERJAVA-1985 | Unable to render .xls file | Bug |
| VIEWERJAVA-1986 | Output extension is empty when saving HTML page into cache | Bug |
| VIEWERJAVA-1989 | Object null reference exception when rendering DWG document | Bug |
| VIEWERJAVA-1992 | Watermark opacity set twice when rendering as HTML | Bug |
| VIEWERJAVA-1993 | Separator is wrong for the opacity value | Bug |
| VIEWERJAVA-2001 | Document corrupted exception | Bug |

## Public API and Backward Incompatible Changes

### com.groupdocs.viewer.converter.options.ArchiveOptions

#### public class ArchiveOptions has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

### com.groupdocs.viewer.converter.options.HtmlOptions

#### public ArchiveOptions getArchiveOptions() method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

#### public void setArchiveOptions(ArchiveOptions) method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

### com.groupdocs.viewer.converter.options.ImageOptions

#### public ArchiveOptions getArchiveOptions() method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

#### public void setArchiveOptions(ArchiveOptions) method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

### com.groupdocs.viewer.domain.ArchiveFileData

#### public class ArchiveFileData has been added

This class represents archive specific *FileData*.

### com.groupdocs.viewer.domain.cache.CachedDocumentDescription

#### public ArchiveOptions getArchiveOptions() method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

#### public void getArchiveOptions(ArchiveOptions) method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

### com.groupdocs.viewer.domain.cache.CachedPageDescription

#### public ArchiveOptions getArchiveOptions() method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

#### public void setArchiveOptions(ArchiveOptions) method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

### com.groupdocs.viewer.domain.containers.ArchiveDocumentInfoContainer

#### public class ArchiveDocumentInfoContainer has been added

*ArchiveDocumentInfoContainer *class provides archive documents specific information as explained in the article Rendering Archive documents.

### com.groupdocs.viewer.domain.containers.PdfDocumentInfoContainer

#### public class PdfDocumentInfoContainer class has been added

```java
**
 * <p>
 * Represents a container for PDF document description.
 * </p>
 */
@Public
public class PdfDocumentInfoContainer extends DocumentInfoContainer {
    /**
     * <p>
     * Indicates whether source document has restriction on printing
     * </p>
     */
    private boolean mPrintingAllowed = false;

    /**
     * <p>
     * Indicates whether source document has restriction on printing
     * </p>
     */
    @Public
    public boolean getPrintingAllowed() {
        return mPrintingAllowed;
    }

    /**
     * <p>
     * Indicates whether source document has restriction on printing
     * </p>
     */
    @Public
    public void setPrintingAllowed(boolean value) {
        mPrintingAllowed = value;
    }
}


```

####   
Check if source PDF document has restriction on printing

Since the version 19.11 GroupDocs.Viewer for Java API enables to check if PDF document has restriction on printing.

The following example demonstrates how to retrieve document information and check if the document has restrictions on printing.

**Java (Render document into PDF with security settings)**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath("c:\\storage");

// Create image handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);

// Retrieve document information
String guid = "document.pdf";
PdfDocumentInfoContainer documentInfo = (PdfDocumentInfoContainer) imageHandler.getDocumentInfo(guid);
 
boolean printingAllowed = documentInfo.getPrintingAllowed();
```

### com.groupdocs.viewer.domain.html.HtmlResource

#### public ArchiveOptions getArchiveOptions() method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

#### public void setArchiveOptions(ArchiveOptions) method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

### com.groupdocs.viewer.domain.options

#### public enum PdfFilePermissions class has been added

```java
/**
 * PDF file permissions
 */
@Public
public class PdfFilePermissions extends Enum {
    /**
     * Deny printing, modification and data extraction
     */
    public static final int NONE = 0;

    /**
     * Allow printing
     */
    public static final int PRINTING = 1;

    /**
     * Allow to modify content, fill in forms, add or modify annotations
     */
    public static final int MODIFICATION = 2;

    /**
     * Allow text and graphics extraction
     */
    public static final int DATA_EXTRACTION = 4;

    /**
     * Allow printing, modification and data extraction
     */
    public static final int ALL = PRINTING | MODIFICATION | DATA_EXTRACTION;
   
}


```

#### public class PdfFileSecurity class has been added

```java
/**
 * Enables to specify owner password, user password and PDF file permissions
 */
public class PdfFileSecurity {
    private String mOwnerPassword;

    /**
     * Owner password enables to set PDF file permissions
     */
    @Public
    public String getOwnerPassword() {
        return mOwnerPassword;
    }

    private String mUserPassword;

    /**
     * User password restricts opening PDF file
     */
    @Public
    public String getUserPassword() {
        return mUserPassword;
    }

    private int mPdfFilePermissions;

    /**
     * PDF file permissions
     */
    @Public
    public int getPdfFilePermissions() {
        return mPdfFilePermissions;
    }

    /**
     * Creates new instance of this class
     *
     * @param ownerPassword      Owner password enables to set document permissions
     * @param userPassword       User password restricts opening PDF file
     * @param pdfFilePermissions PDF file permissions
     */
    @Public
    public PdfFileSecurity(String ownerPassword, String userPassword, int pdfFilePermissions) {
        if (ownerPassword == null)
            throw new ArgumentNullException("ownerPassword");
        if (userPassword == null)
            throw new ArgumentNullException("userPassword");

        mOwnerPassword = ownerPassword;
        mUserPassword = userPassword;
        mPdfFilePermissions = pdfFilePermissions;
    }
}


```

#### public PdfFileSecurity getPdfFileSecurity() method has been added to PdfFileOptions class

This method enables you to retrieve PDF file security settings.

#### public void setPdfFileSecurity(PdfFileSecurity) method has been added to PdfFileOptions class

This method enables you to set PDF file security settings.

#### Specify owner password, user password, and permissions when rendering into PDF

Since the version 19.11 GroupDocs.Viewer for Java API enables to specify owner password, user password, and PDF file permissions when rendering into PDF. API provides the following settings:  

*   **Owner password** - set owner password to require a password to change document permissions
*   **User password** - set user password to required password when opening a document
*   **PDF file permissions** - set permissions to allow or deny printing, modification and data extraction

Following example demonstrates how to render a document into PDF and set a password for opening, password to change document permissions and permissions to deny printing

**(Render document into PDF with security settings)**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath("c:\\storage");

// Create image handler
ViewerImageHandler imageHandler = new ViewerImageHandler(config);

// Create PDF file security
String ownerPassword = "owner password";
String userPassword = "user password";
int denyPrinting = PdfFilePermissions.ALL ^ PdfFilePermissions.PRINTING;
PdfFileSecurity pdfFileSecurity = new PdfFileSecurity(ownerPassword, userPassword, denyPrinting);

// Create options
PdfFileOptions pdfFileOptions = new PdfFileOptions();
pdfFileOptions.setPdfFileSecurity(pdfFileSecurity);

String guid = "document.doc";
FileContainer fileContainer = imageHandler.getPdfFile(guid, pdfFileOptions);
```

### com.groupdocs.viewer.domain.options.DocumentInfoOptions

#### public ArchiveOptions getArchiveOptions() method has been added

ArchiveOptions class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

#### public void setArchiveOptions(ArchiveOptions) method has been added

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

### com.groupdocs.viewer.domain.options.PdfFileOptions

#### public ArchiveOptions getArchiveOptions() method has been added.

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.

#### public void setArchiveOptions(ArchiveOptions) method has been added.

*ArchiveOptions* class allows specifying archive documents specific rendering options as explained in the article Rendering Archive documents.
