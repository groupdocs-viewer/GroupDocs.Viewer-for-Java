---
id: enable-layered-rendering
url: viewer/java/enable-layered-rendering
title: Enable layered rendering
weight: 4
description: "This article explains how to enable layered rendering when viewing PDF Documents with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
When rendering into HTML [GroupDocs.Viewer](https://products.groupdocs.com/viewer) renders text and graphics as a single layer that improves performance and reduces HTML document size. To improve content positioning when rendering multi-layered PDF document [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) provides [setEnableLayeredRendering(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfOptions#setEnableLayeredRendering(boolean)) option that enables rendering of text and graphics according to z-order in original PDF document when rendering into HTML.

{{< alert style="info" >}}This option is supported when rendering to HTML only.{{< /alert >}}

Following code sample demonstrates how to enable layered rendering.

```java
    Viewer viewer = new Viewer("sample.pdf");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.getPdfOptions().setEnableLayeredRendering(true);

    viewer.view(viewOptions);
    viewer.close();
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