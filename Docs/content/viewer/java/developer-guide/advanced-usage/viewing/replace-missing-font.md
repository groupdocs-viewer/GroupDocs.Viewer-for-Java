---
id: replace-missing-font
url: viewer/java/replace-missing-font
title: Replace missing font
weight: 4
description: "This article explains how to replace missing font when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: Replace missing font with GroupDocs.Viewer for Java API
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer) enables you to set default font name which may be useful in following cases:

1.  You want to generally specify the default font to fall back on if a particular font in a document cannot be found during rendering;
2.  The document uses a font that contains non-English characters and you want to make sure that any missing font is replaced with one which has the same character set available.

Following code snippet shows how to set default font name.

```java
    Viewer viewer = new Viewer("sample.pptx");

    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.setDefaultFontName("Courier New");
    viewer.view(viewOptions);
    viewer.close();
```

.

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