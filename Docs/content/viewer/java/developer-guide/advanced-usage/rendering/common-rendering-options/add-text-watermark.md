---
id: add-text-watermark
url: viewer/java/add-text-watermark
title: Add text watermark
weight: 1
description: "This article explains how to add text watermark when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: GroupDocs.Viewer for Java Text Watermark
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) enables you to apply a watermark on the output pages (HTML / Image / PDF). 

Here is the recipe: 

*   Create [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions) (or [PngViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PngViewOptions), or [JpgViewOption](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/JpgViewOptions), or[PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions)) object;
*   Create a [Watermark ](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/Watermark) object and populate its properties;
*   Assign [Watermark](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/Watermark) object via [HtmlViewOptions.setWatermark](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/ViewOptions#setWatermark(com.groupdocs.viewer.options.Watermark)) method (or [PngViewOptions.setWatermark](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/ViewOptions#setWatermark(com.groupdocs.viewer.options.Watermark)), or [JpgViewOptions.setWatermark](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/ViewOptions#setWatermark(com.groupdocs.viewer.options.Watermark)), or [PdfViewOptions.setWatermark](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/ViewOptions#setWatermark(com.groupdocs.viewer.options.Watermark))) property;
*   Call [view()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method.

The following code sample shows how to apply the watermark to the output pages.

```java
HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources();
options.setWatermark(new Watermark("This is a watermark"));

Viewer viewer = new Viewer("sample.docx");
viewer.view(options);
viewer.close();
```

## More resources
### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)    
*   [GroupDocs.Viewer for Java examples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)    
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-MVC)    
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
    
### Free Online App
Along with full featured Java library we provide simple, but powerful free Apps.  
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online  **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.
