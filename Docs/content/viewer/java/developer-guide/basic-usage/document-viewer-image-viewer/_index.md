---
id: document-viewer-image-viewer
url: viewer/java/document-viewer-image-viewer
title: Document viewer - Image Viewer
weight: 2
description: "Image Viewer component by GroupDocs allows you to display 100+ file formats as PNG or JPG images in your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: True
---
Document viewer can operate in different rendering modes, HTML, Image and PDF (see [Features Overview]({{< ref "viewer/java/getting-started/features-overview.md" >}}) for more information). This article will describe on how to view documents in Image mode with Image Viewer.

Image Viewer provides [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) and [JpgViewOptions ](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions) classes to set specific options for rendering the document into desired image format.

Here are the steps for rendering into image with [GroupDocs.Viewer](https://products.groupdocs.com/viewer) API:
*   Create new instance of [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class and pass source document path as a constructor parameter.    
*   Instantiate the [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) or [JpgViewOptions ](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions) object according to your requirements and specify saving path format for rendered document pages.    
*   Call [view(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method of [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class instance and pass [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) or [JpgViewOptions ](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions) to it.
    

## Document Viewer - Image Viewer (PNG)

This example shows how to render each document page into PNG image.

```java
    Viewer viewer = new Viewer("sample.docx");
    PngViewOptions viewOptions = new PngViewOptions();
    viewer.view(viewOptions);
    viewer.close();
```

## Document Viewer - Image Viewer (JPG)

This example shows how to render each document page into JPG image.

```java
    Viewer viewer = new Viewer("sample.docx");
    JpgViewOptions viewOptions= new JpgViewOptions();                  
    viewer.view(viewOptions);
    viewer.close();
```

{{< alert style="info" >}}[GroupDocs.Viewer](https://products.groupdocs.com/viewer) also provides an ability to customize rendering to image by setting additional options. To learn more about caching customization please refer to the following guides: [Image Viewer - Add text overlay over images]({{< ref "viewer/java/developer-guide/basic-usage/document-viewer-image-viewer/image-viewer-add-text-overlay-over-images.md" >}}), [Image Viewer - Adjust image size]({{< ref "viewer/java/developer-guide/basic-usage/document-viewer-image-viewer/image-viewer-adjust-image-size.md" >}}), [Image Viewer - Adjust quality for JPG]({{< ref "viewer/java/developer-guide/basic-usage/document-viewer-image-viewer/image-viewer-adjust-quality-for-jpg.md" >}}) and [Image Viewer - Get text coordinates]({{< ref "viewer/java/developer-guide/basic-usage/document-viewer-image-viewer/image-viewer-get-text-coordinates.md" >}}){{< /alert >}}

## More resources
### Advanced Usage Topics
To learn more about document viewing features, please refer to the [advanced usage section]({{< ref "viewer/java/developer-guide/advanced-usage/_index.md" >}}).

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