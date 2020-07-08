---
id: how-to-convert-and-view-obj-files
url: viewer/java/how-to-convert-and-view-obj-files
title: How to convert and view OBJ files
weight: 4
description: "This article demonstrates how to convert and view OBJ files with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction

Wavefront 3D Object Files (.obj) are 3D format images developed by Wavefront Technologies for the Advanced Visualizer (TAV) software. It contains text descriptions of vertexes, texture vertices and texture mapping (UV-position).

![](viewer/java/images/how-to-convert-and-view-obj-files.png)

## How to convert OBJ files

### Convert OBJ to HTML

To convert OBJ files to HTML with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    Viewer viewer = new Viewer("sample.obj");
    HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("output.html");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output HTML file opened in a browser.

![](viewer/java/images/how-to-convert-and-view-obj-files_1.png)

### Convert OBJ to JPG

To convert OBJ files to JPG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.obj");
    JpgViewOptions options = new JpgViewOptions("output.jpg");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width
    
    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output JPG file opened in a Windows Photo Viewer application.

![](viewer/java/images/how-to-convert-and-view-obj-files_2.png)

### Convert OBJ to PNG

To convert PLT/HPG files to PNG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.obj");
    PngViewOptions options = new PngViewOptions("output.png");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PNG file opened in a Windows Photo Viewer application.

![](viewer/java/images/how-to-convert-and-view-obj-files_3.png)

### Convert OBJ to PDF

To convert OBJ files to PDF with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 

```java
    Viewer viewer = new Viewer("sample.obj");
    PdfViewOptions options = new PdfViewOptions("output.pdf");
//    options.setCadOptions(CadOptions.forRenderingByScaleFactor(0.7f)); // Render image and reduce it by 30%
//    options.setCadOptions(CadOptions.forRenderingByWidthAndHeight(400, 400)); // Render image and set output size to 400x400
//    options.setCadOptions(CadOptions.forRenderingByWidth(500)); // Render image, fix width by 500 px and recalculate height
//    options.setCadOptions(CadOptions.forRenderingByHeight(500)); // Render image, fix height by 500 px and recalculate width

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PDF file opened in an Acrobat Reader.

![](viewer/java/images/how-to-convert-and-view-obj-files_4.png)

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