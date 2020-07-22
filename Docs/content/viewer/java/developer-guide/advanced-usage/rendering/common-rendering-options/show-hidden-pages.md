---
id: show-hidden-pages
url: viewer/java/show-hidden-pages
title: Show hidden pages
weight: 7
description: "This article explains how to show hidden pages when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: Show hidden pages with GroupDocs.Viewer for Java
productName: GroupDocs.Viewer for Java
hideChildren: False
---

Hidden pages are not rendered by default. In order to include them into the rendering [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) provides [setRenderHiddenPages()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/BaseViewOptions#setRenderHiddenPages(boolean)) method of [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions), [PngViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PngViewOptions), [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/JpgViewOptions) or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions) class to enable rendering document with notes set value of [setRenderHiddenPages()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/BaseViewOptions#setRenderHiddenPages(boolean)) to true as shown in the example below.

This feature is supported for:

* Diagrams with hidden pages
* Presentations with hidden slides
* Spreadsheets with hidden worksheets

The following code sample shows how to render hidden pages.

```java
HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources();
options.setRenderHiddenPages(true);

Viewer viewer = new Viewer("with_hidden_slide.pptx");
viewer.view(options);
viewer.close();
```

## More resources

### GitHub Examples

You may easily run the code above and see the feature in action in our GitHub examples:

* [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)
* [GroupDocs.Viewer for Java examples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)
* [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-MVC)
* [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)
* [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)
* [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)

### Free Online App

Along with full featured Java library we provide simple, but powerful free Apps.  
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.
