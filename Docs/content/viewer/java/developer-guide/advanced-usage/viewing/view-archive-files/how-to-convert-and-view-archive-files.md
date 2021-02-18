---
id:  how-to-convert-and-view-archive-files
url: viewer/java/how-to-convert-and-view-archive-files
title: How to convert and view archive files
weight: 2
description: "In this article we show how to convert and view archive files with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction

Archive file formats are related to files compression. There various archive formats:
Mostly used in Windows: ZIP, RAR
Mostly used in Linux (Unix): TAR, BZIP2 (BZ2), GZIP

ZIP archives can be opened with Windows explorer,
RAR, TAR, BZIP2, GZIP formats can be opened with WinRar,

![Archive in windows explorer](viewer/java/images/how-to-convert-and-view-archive-files/zip-in-explorer.png)

## How to convert archive files

### Convert archive files to multiple pages HTML

To convert archive files to multiple pages HTML with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    try (Viewer viewer = new Viewer("sample.zip")) {
       HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("output_page_{0}.html");

       viewer.View(options);
    }
```

The following screenshot shows the output HTML file opened in a browser.

![Multiple pages HTML converted archive](viewer/java/images/how-to-convert-and-view-archive-files/zip-to-multiple-html.png)

### Convert archive files to single HTML

To convert archive files to single page HTML with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    try (Viewer viewer = new Viewer("sample.zip")) {
       HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("output.html");
       options.setRenderSinglePage(true);
       viewer.view(options);
    }
```

The following screenshot shows the output HTML file opened in a browser.

![Single page HTML converted zip](viewer/java/images/how-to-convert-and-view-archive-files/zip-to-single-html.png)

### Convert archive files to JPG

To convert archive files to JPG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    try (Viewer viewer = new Viewer("sample.zip")) {
       JpgViewOptions options = new JpgViewOptions("output_page_{0}.jpg");
       viewer.view(options);
    }
```

The following screenshot shows the output JPG file opened in a Windows Photo Viewer application.

![JPEG converted archive](viewer/java/images/how-to-convert-and-view-archive-files/zip-in-jpg.png)

### Convert archive files to PNG

To convert archive files to PNG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    try (Viewer viewer = new Viewer("sample.zip")) {
       PngViewOptions options = new PngViewOptions("output_page_{0}.png");
       viewer.view(options);
    }
```

The following screenshot shows the output PNG file opened in a Windows Photo Viewer application.

![PNG converted archive](viewer/java/images/how-to-convert-and-view-archive-files/zip-in-png.png)

### Convert archive to PDF

To convert Roshal Archive files to PDF with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    try (Viewer viewer = new Viewer("sample.zip")) {
       PdfViewOptions options = new PdfViewOptions("output.pdf");
       viewer.view(options);
    }
```

The following screenshot shows the output PDF file opened in an Acrobat Reader.

![PDF converted archive](viewer/java/images/how-to-convert-and-view-archive-files/zip-in-pdf.png)

## More resources
### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for Java examples, plugins, and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-MVC)     

### Free Online App
Along with full-featured Java library we provide simple but powerful free Apps.
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.