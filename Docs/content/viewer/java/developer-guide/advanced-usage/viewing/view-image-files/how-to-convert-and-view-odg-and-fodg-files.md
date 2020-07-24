---
id: how-to-convert-and-view-odg-and-fodg-files
url: viewer/java/how-to-convert-and-view-odg-and-fodg-files
title: How to convert and view ODG and FODG files
weight: 1
description: "This article explains how to convert and view ODG and FODG files with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction

FODG and ODG are OpenDocument Graphics formats. ODG consists from archive with set of files (e.g. styles and content in XML files) and [manifest file](https://en.wikipedia.org/wiki/Manifest_file). FODG is Flat OpenDocument Graphics format in uncompessed XML.

These files can be opened with LibreOffice(OpenOffice) draw.

In case you need to view a ODG(FODG) file in a browser or in a standard image or PDF viewer application, you can convert it to HTML, JPEG, PNG  PDF format with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java). 

![](viewer/java/images/how-to-convert-and-view-odg-and-fodg-files.png)

## How to convert FODG files

### Convert FODG to HTML

To convert FODG files to HTML with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    Viewer viewer = new Viewer("sample.fodg");
    HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("output.html");

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output HTML file opened in a browser.

![](viewer/java/images/how-to-convert-and-view-odg-and-fodg-files_1.png)

### Convert FODG to JPG

To convert FODG files to JPG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.fodg");
    JpgViewOptions options = new JpgViewOptions("output.jpg");
    
    viewer.view(options);
    viewer.close();
}
```

The following screenshot shows the output JPG file opened in a Windows Photo Viewer application.

![](viewer/java/images/how-to-convert-and-view-odg-and-fodg-files_2.png)

### Convert FODG to PNG

To convert PLT/HPG files to PNG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.fodg");
    PngViewOptions options = new PngViewOptions("output.png");
    
    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PNG file opened in a Windows Photo Viewer application.

![](viewer/java/images/how-to-convert-and-view-odg-and-fodg-files_3.png)

### Convert FODG to PDF

To convert FODG files to PDF with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.fodg");
    PdfViewOptions options = new PdfViewOptions("output.pdf");
    
    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PDF file opened in an Acrobat Reader.

![](viewer/java/images/how-to-convert-and-view-odg-and-fodg-files_4.png)

## More resources
### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for Java examples, plugins, and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-MVC)     

### Free Online App
Along with full-featured Java library we provide simple but powerful free Apps.
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.