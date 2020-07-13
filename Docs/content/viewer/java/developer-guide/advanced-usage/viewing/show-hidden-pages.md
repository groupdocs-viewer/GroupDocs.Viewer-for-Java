---
id: show-hidden-pages
url: viewer/java/show-hidden-pages
title: Show hidden pages
weight: 8
description: "This article explains how to show hidden pages when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: Show hidden pages with GroupDocs.Viewer for Java
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Hidden pages are not rendered by default. In order to include them into the rendering [GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides [setRenderHiddenPages(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/BaseViewOptions#setRenderHiddenPages(boolean)) property of the [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions), [JpgViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions), [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) or [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfViewOptions) class to `true` as shown in the example below.

This feature is supported for:

*   Diagrams with hidden pages
*   Presentations with hidden slides
*   Spreadsheets with hidden worksheets

The following code sample shows how to render hidden pages.

```java
    Viewer viewer = new Viewer("sample.pptx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.setRenderHiddenPages(true);
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