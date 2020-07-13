---
id: enable-font-hinting
url: viewer/java/enable-font-hinting
title: Enable font hinting
weight: 3
description: "This article explains how to enable font hinting when viewing PDF Documents with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
To adjust the display of an outline font ([learn more about font hinting](https://en.wikipedia.org/wiki/Font_hinting)) when rendering PDF documents into image [GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides [setEnableFontHinting(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfOptions#setEnableFontHinting(boolean)) setting as shown below:

NOTE: this option is supported when rendering into PNG and JPG.

```java
    Viewer viewer = new Viewer("sample.pdf");
    PngViewOptions viewOptions = new PngViewOptions();
    viewOptions.getPdfOptions().setEnableFontHinting(true);

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
