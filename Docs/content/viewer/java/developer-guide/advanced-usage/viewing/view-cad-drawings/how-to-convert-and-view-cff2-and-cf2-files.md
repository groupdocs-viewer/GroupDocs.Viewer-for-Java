---
id: how-to-convert-and-view-cff2-and-cf2-files
url: viewer/java/how-to-convert-and-view-cff2-and-cf2-files
title: How to convert and view CFF2 and CF2 files
weight: 2
description: "This article demonstrates how to convert and view CFF2 and CF2 files with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction

CF2 (also CF2, CFF2) is a Common File Format File of revision 2. This file format is designed for exchange of cardboard boxes (goods packaging) drawings. It contains text instructions splitted by sections for the numerical control machine ([NC machine](https://en.wikipedia.org/wiki/Numerical_control)) tool.

## View CF2 files

The CF2 can be opened with desktop applications like e.g. PicView 8.

In case you need to view a CF2 file in a browser or in a standard image or PDF viewer application, you can convert it to HTML, JPEG, PNG  PDF format with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java). 

![](viewer/java/images/how-to-convert-and-view-cff2-and-cf2-files.png)

### Convert CF2 to HTML

To convert CF2 files to HTML with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    Viewer viewer = new Viewer("sample.cf2");

    HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("output.html");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output HTML file opened in a browser.

![](viewer/java/images/how-to-convert-and-view-cff2-and-cf2-files_1.png)

### Convert CF2 to JPG

To convert CF2 files to JPG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.cf2");

    JpgViewOptions options = new JpgViewOptions("output.jpg");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output JPG file opened in a Windows Photo Viewer application.

![](viewer/java/images/how-to-convert-and-view-cff2-and-cf2-files_2.png)

### Convert CF2 to PNG

To convert CF2 files to PNG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.cf2");
    PngViewOptions options = new PngViewOptions("output.png");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PNG file opened in a Windows Photo Viewer application.

![](viewer/java/images/how-to-convert-and-view-cff2-and-cf2-files_3.png)

### Convert CF2 to PDF

To convert CF2 files to PDF with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.cf2");

    PdfViewOptions options = new PdfViewOptions("output.pdf");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PDF file opened in a browser.

![](viewer/java/images/how-to-convert-and-view-cff2-and-cf2-files_4.png)

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