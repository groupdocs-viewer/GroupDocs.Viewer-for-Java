---
id: how-to-convert-and-view-igs-files
url: viewer/java/how-to-convert-and-view-igs-files
title: How to convert and view IGS files
weight: 3
description: "This article demonstrates how to convert and view IGS files with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction

IGS is a 2D/3D vector format file based on the Initial Graphics Exchange Specification (IGES). It consists of text instructions and all lines are fixed 80 bytes length with 72 bytes of data.

It can be opened with desktop applications like e.g. Autodesk AutoCAD.

In case you need to view an IGS file in a browser or in a standard image or PDF viewer application, you can convert it to HTML, JPEG, PNG  PDF format with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java). 

## How to convert IGS files

### Convert IGS to HTML

To convert IGS files to HTML with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    Viewer viewer = new Viewer("sample.igs");

    HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("output.html");
    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output HTML file opened in a browser.

![](viewer/java/images/how-to-convert-and-view-igs-files.png)

### Convert IGS to JPG

To convert IGS files to JPG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.igs");

    JpgViewOptions options = new JpgViewOptions("output.jpg");
    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output JPG file opened in a Windows Photo Viewer application.

![](viewer/java/images/how-to-convert-and-view-igs-files_1.png)

### Convert IGS to PNG

To convert IGS files to PNG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.igs");
    PngViewOptions options = new PngViewOptions("output.png");
    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PNG file opened in a Windows Photo Viewer application.

![](viewer/java/images/how-to-convert-and-view-igs-files_2.png)

### Convert IGS to PDF

To convert IGS files to PDF with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.igs");
    PdfViewOptions options = new PdfViewOptions("output.pdf");

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PDF file opened in an Acrobat Reader.

![](viewer/java/images/how-to-convert-and-view-igs-files_3.png)

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