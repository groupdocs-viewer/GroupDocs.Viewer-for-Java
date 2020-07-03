---
id: groupdocs-viewer-for-java-19-3-release-notes
url: viewer/java/groupdocs-viewer-for-java-19-3-release-notes
title: GroupDocs.Viewer for Java 19.3 Release Notes
weight: 5
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 19.3{{< /alert >}}

## Major Features

*   Added TSV (Tab-separated values) file format support
*   Added PCL (Printer command language) file format support 
*   Added support of default font feature when rendering MS OneNote documents into PDF and Image formats

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERJAVA-1887 | Develop feature for print restrictions | Feature |
| VIEWERJAVA-1881 | Add TSV (Tab-separated values) file format support | Feature |
| VIEWERJAVA-1880 | Add PCL file format support | Feature |
| VIEWERJAVA-1889 | Add support for DefaultFontName option when rendering MS OneNote documents into PDF and Image | Improvement |
| VIEWERJAVA-1878 | Exporting font files as external resources when rendering MS OneNote documents | Improvement |
| VIEWERJAVA-1877 | Extend support for ExcludeFonts setting of HtmlOptions class for MS OneNote documents | Improvement |
| VIEWERJAVA-1876 | Rendering attachments while working with source document's stream | Improvement |
| VIEWERJAVA-1875 | Rendering comments from ODP presentation documents that has no author  | Improvement |
| VIEWERJAVA-1874 | There is not watermark in the case of image mode for word and image files | Bug |

## Public API and Backward Incompatible Changes

### com.groupdocs.viewer.domain.containers.DocumentInfoContainer

#### String getDocumentType() method will be removed in the next version

This method is deprecated and will be removed in the next version. Use getFileFormat() method instead.

#### void getDocumentType(String value) method will be removed in the next version

This method is deprecated and will be removed in the next version. Use getFileFormat() method instead.

#### String getDocumentTypeFormat() method will be removed in the next version

This method is deprecated and will be removed in the next version. Use getFileFormat() method instead.

#### void setDocumentTypeFormat(String value) method will be removed in the next version

This method is deprecated and will be removed in the next version. Use setFileFormat() method instead.

#### String getFileType() method will be removed in the next version

This method is deprecated and will be removed in the next version. Use getFileFormat() method instead.

#### void setFileType(String value) method will be removed in the next version

This method is deprecated and will be removed in the next version. Use setFileFormat() method instead.

### com.groupdocs.viewer.domain.containers.PdfDocumentInfoContainer

#### public class PdfDocumentInfoContainer class has been added

```java
/**
 * <p>
 * Represents a container for PDF document description.
 * </p>
 */
public class PdfDocumentInfoContainer extends DocumentInfoContainer {
    /**
     * <p>
     * Indicates whether source document has restriction on printing
     * </p>
     */
    private boolean printingAllowed  = false;

    @Public
    public boolean getPrintingAllowed() {
        return printingAllowed;
    }

    @Public
    public void setPrintingAllowed(boolean value) {
        printingAllowed = value;
    }
}
```

####   
Check if source PDF document has restriction on printing

Since the version 19.3 GroupDocs.Viewer for Java API enables to check if PDF document has restriction on printing.

Following example demonstrates how to retrieve document information and check if document has restriction on printing.

**(Render document into PDF with security settings)**

```java
// Setup GroupDocs.Viewer config
ViewerConfig viewerConfig = new ViewerConfig();
viewerConfig.setStoragePath("C:\\storage");

// Create handler
ViewerImageHandler handler = new ViewerImageHandler(viewerConfig);

// Retrieve document information
String guid = "document.pdf";
PdfDocumentInfoContainer documentInfo = (PdfDocumentInfoContainer)handler.getDocumentInfo(guid);
 
boolean printingAllowed = documentInfo.getPrintingAllowed();
```

### com.groupdocs.viewer.domain.FileDescription

#### String getBaseName() method will be removed in next version

This method is deprecated and will be removed in the next version. To get base name use following code: org.apache.commons.io.FilenameUtils.getBaseName(fileDescription.getName())

#### String getDocumentType() method will be removed in next version

This method is deprecated and will be removed in the next version. Use getFileFormat() method instead..

#### String getFileType() method will be removed in next version

This method is deprecated and will be removed in the next version. Use getFileFormat() method instead.

#### String getDocumentTypeFormat() method will be removed in next version

This method is deprecated and will be removed in the next version. Use getFileFormat() method instead.

### com.groupdocs.viewer.handler.input.IInputDataHandler

#### public java.util.Date getLastModificationDate(String guid) method has been removed

GroupDocs.Viewer will rely on LastModificationDate value in FileDescription object returned by getFileDescription() method of IInputDataHandler interface.

### com.groupdocs.viewer.handler.ViewerHtmlHandler

#### public FileContainer getFile(InputStream fileStream, AttachmentBase attachment) overload has been added

Use this overload of **getFile** method to obtain attachment from document stream as shown in the following example.

**Obtaining attachment original file using document stream**

 

```java
// Create handler
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler();

// Create attachment object and print out its name and file type
Attachment attachment = new Attachment("document-with-attachments.msg", "attachment-image.png");

// Get attachment original file using document stream
FileInputStream fileStream = new FileInputStream("document-with-attachments.msg");
FileContainer fileContainer = htmlHandler.getFile(fileStream, attachment);

System.out.println("Attach stream length: " + fileContainer.getStream().available());
```

#### public java.util.List<PageHtml> getPages(InputStream fileStream, AttachmentBase attachment) overload has been added

Use this overload of **getPages** method to render attachment from document stream as shown below.

#### public java.util.List<PageHtml> getPages(InputStream fileStream, AttachmentBase attachment, HtmlOptions htmlOptions) overload has been added

Use this overload of **getPages** method to render attachment from document stream as shown below.

**Rendering attachment using document stream**

 

```java
FileInputStream fileStream = new FileInputStream("document-with-attachments.msg");
	
// Init viewer image handler
ViewerHtmlHandler handler = new ViewerHtmlHandler();
DocumentInfoContainer info = handler.getDocumentInfo(fileStream);
fileStream.close();
 
// Iterate over the attachments collection
for (AttachmentBase attachment : info.getAttachments())
{
   	System.out.println("Attachment name: " + attachment.getName());

	fileStream = new FileInputStream("document-with-attachments.msg");
   	List<PageHtml> pages = handler.getPages(fileStream, attachment);
    fileStream.close();
 
   	for (PageHtml page : pages) {
       	System.out.println("  Page: " + page.getPageNumber());
		System.out.println("  Content length: " + page.getHtmlContent().length());
	}
}
```

### com.groupdocs.viewer.handler.ViewerImageHandler

#### public FileContainer getFile(InputStream fileStream, AttachmentBase attachment) overload has been added

Use this overload of **getFile** method to obtain attachment from document stream as shown in the following example.

**Obtaining attachment original file using document stream**

 

```java
// Create handler
ViewerImageHandler handler = new ViewerImageHandler();

// Create attachment object and print out its name and file type
Attachment attachment = new Attachment("document-with-attachments.msg", "attachment-image.png");

// Get attachment original file using document stream
FileInputStream fileStream = new FileInputStream("document-with-attachments.msg");
FileContainer fileContainer = handler.getFile(fileStream, attachment);

System.out.println("Attach stream length: " + fileContainer.getStream().available());
```

#### public java.util.List<PageImage> getPages(InputStream fileStream, AttachmentBase attachment) overload has been added

Use this overload of **getPages** method to render attachment from document stream as shown below.

#### public java.util.List<PageImage> getPages(InputStream fileStream, AttachmentBase attachment, ImageOptions imageOptions) overload has been added

Use this overload of **getPages** method to render attachment from document stream as shown below.

**Rendering attachment using document stream**

 

```java
FileInputStream fileStream = new FileInputStream("document-with-attachments.msg");
	
// Init viewer image handler
ViewerImageHandler handler = new ViewerImageHandler();
DocumentInfoContainer info = handler.getDocumentInfo(fileStream);
fileStream.close();
 
// Iterate over the attachments collection
for (AttachmentBase attachment : info.getAttachments())
{
   	System.out.println("Attachment name: " + attachment.getName());

	fileStream = new FileInputStream("document-with-attachments.msg");
   	List<PageImage> pages = handler.getPages(fileStream, attachment);
    fileStream.close();
 
   	for (PageImage page : pages) {
       	System.out.println("  Page: " + page.getPageNumber());
		System.out.println("  Content length: " + page.getStream().available());
	}
}
```
