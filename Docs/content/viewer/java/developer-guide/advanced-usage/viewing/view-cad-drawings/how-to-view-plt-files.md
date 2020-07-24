---
id: how-to-view-plt-files
url: viewer/java/how-to-view-plt-files
title: How to view PLT files
weight: 9
description: "This article explains how to convert PLT files with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction

[PLT](https://wiki.fileformat.com/cad/plt/) and HPG formats are based on the plotter language developed by Hewlett-Packard (HP-GL). These formats are designed for sending information to plotter printers, contain text/binary instructions on HPGL language to draw vector images on paper.

## How to view PLT files

The PLT/HPG can be opened with desktop applications like e.g. Autodesk AutoCAD.

In case you need to view a PLT/HPG file in a browser or in a standard image or PDF viewer application, you can convert it to HTML, JPEG, PNG  PDF format with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java). 

### Convert PLT to HTML

To convert PLT/HPG files to HTML with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    Viewer viewer = new Viewer("sample.plt");
    HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("output.html");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output HTML file opened in a browser.

![](viewer/java/images/how-to-view-plt-files.png)

### Convert PLT to JPG

To convert PLT/HPG files to JPG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.plt");
    JpgViewOptions options = new JpgViewOptions("output.html");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output JPG file opened in a Windows Photo Viewer application.

![](viewer/java/images/how-to-view-plt-files_1.png)

### Convert PLT to PNG

To convert PLT/HPG files to PNG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.plt");
    PngViewOptions options = new PngViewOptions("output.html");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PNG file opened in a Windows Photo Viewer application.

![](viewer/java/images/how-to-view-plt-files_2.png)

### Convert PLT to PDF

To convert PLT/HPG files to PDF with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.plt");
    PdfViewOptions options = new PdfViewOptions("output.pdf");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PDF file opened in a browser.

![](viewer/java/images/how-to-view-plt-files_3.png)

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