---
id: add-text-watermark
url: viewer/java/add-text-watermark
title: Add text watermark
weight: 1
description: "This article explains how to add text watermark when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: Add watermark with GroupDocs.Viewer for Java API
productName: GroupDocs.Viewer for Java
hideChildren: False
---
GroupDocs.Viewer enables you to apply a watermark on the output pages (HTML / Image / PDF). 

Here is the recipe: 

*   Create instance of [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/htmlviewoptions) class (or [PngViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pngviewoptions), or [JpgViewOption](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/jpgviewoptions), or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions));
*   Create a [Watermark](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/watermark) object and populate its properties;
*   Assign [Watermark](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/watermark) object to [HtmlViewOptions.Watermark](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/viewoptions/properties/watermark) (or [PngViewOptions.Watermark](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/viewoptions/properties/watermark), or [JpgViewOptions.](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/viewoptions/properties/watermark)[Watermark](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/jpgviewoptions), or [PdfViewOptions.Watermark](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/viewoptions/properties/watermark)) property;
*   Call [View ](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer/methods/view) method.

The following code sample shows how to apply the watermark to the output pages.

```java
    Viewer viewer = new Viewer("sample.docx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.setWatermark(new Watermark("This is a watermark"));

    viewer.view(viewOptions);
```

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