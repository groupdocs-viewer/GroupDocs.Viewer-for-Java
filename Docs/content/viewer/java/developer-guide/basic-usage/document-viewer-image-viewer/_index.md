---
id: document-viewer-image-viewer
url: viewer/java/document-viewer-image-viewer
title: Document viewer - Image Viewer
weight: 2
description: "Image Viewer component by GroupDocs allows you to display 100+ file formats as PNG or JPG images in your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Document viewer can operate in different rendering modes, HTML, Image and PDF (see [Document viewer - Image Viewer]({{< ref "viewer/java/developer-guide/basic-usage/document-viewer-image-viewer/_index.md" >}}) for more information). This article will describe on how to view documents in Image mode with Image Viewer.

Image Viewer provides [PngViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PngViewOptions) and [JpgViewOptions ](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/JpgViewOptions) classes to set specific options for rendering the document into desired image format.

Here are the steps for rendering into image with GroupDocs.Viewer API:
*   Create new instance of [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) class and pass source document path as a constructor parameter.    
*   Instantiate the [PngViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PngViewOptions) or [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/JpgViewOptions)[ ](https://apireference.groupdocs.com/net/viewer/groupdocs.viewer.options/jpgviewoptions) object according to your requirements and specify saving path format for rendered document pages.    
*   Call [view()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method of [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) class instance and pass [PngViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PngViewOptions) or [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/JpgViewOptions)[ ](https://apireference.groupdocs.com/net/viewer/groupdocs.viewer.options/jpgviewoptions) to it.
    

## Document Viewer - Image Viewer (PNG)

This example shows how to render each document page into PNG image.

```java
PngViewOptions options = new PngViewOptions("page-{0}.png");
 
Viewer viewer = new Viewer("sample.docx");
viewer.view(options);
viewer.close();
```

## Document Viewer - Image Viewer (JPG)

This example shows how to render each document page into JPG image.

```java
JpgViewOptions options = new JpgViewOptions("page-{0}.jpg");
 
Viewer viewer = new Viewer("sample.docx");                 
viewer.view(options);
viewer.close();
```

{{< alert style="info" >}}GroupDocs.Viewer also provides an ability to customize rendering to image by setting additional options. To learn more about caching customization please refer to the following guides:Image Viewer - Add text overlay over imagesImage Viewer - Adjust image sizeImage Viewer - Adjust quality for JPGImage Viewer - Get text coordinates{{< /alert >}}