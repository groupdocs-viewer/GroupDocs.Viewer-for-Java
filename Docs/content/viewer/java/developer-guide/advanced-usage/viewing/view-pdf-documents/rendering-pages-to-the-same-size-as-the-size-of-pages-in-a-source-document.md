---
id: rendering-pages-to-the-same-size-as-the-size-of-pages-in-a-source-document
url: viewer/java/rendering-pages-to-the-same-size-as-the-size-of-pages-in-a-source-document
title: Rendering pages to the same size as the size of pages in a source document
weight: 6
description: "This article explains how to set the output image size to be the same as the page size of a PDF Document with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This option is supported when rendering to JPG and PNG only.{{< /alert >}}

  
![](viewer/java/images/rendering-pages-to-the-same-size-as-the-size-of-pages-in-a-source-document.png)

When viewing PDF documents in JPG and PNG formats by default [GroupDocs.Viewer](https://products.groupdocs.com/viewer) calculates output image size for better viewing quality. In case you want to make output JPG and PNG images to be the same size in pixels as the size of pages in a source PDF document [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) provides a new option called [setRenderOriginalPageSize(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfOptions#setRenderOriginalPageSize(boolean)) of the [PdfOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfOptions) class. 

The following code snippet shows how to convert pages to the same size as the size of pages in a source document.

```java
    try (Viewer viewer = new Viewer("sample.pdf")) {
        PngViewOptions viewOptions = new PngViewOptions();
        viewOptions.getPdfOptions().setRenderOriginalPageSize(true);
                       
        viewer.view(viewOptions);
    }
```

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