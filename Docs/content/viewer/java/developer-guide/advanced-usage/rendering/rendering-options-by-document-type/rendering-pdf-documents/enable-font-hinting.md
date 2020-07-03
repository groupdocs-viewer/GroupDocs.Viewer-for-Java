---
id: enable-font-hinting
url: viewer/java/enable-font-hinting
title: Enable font hinting
weight: 3
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
To adjust the display of an outline font([learn more about font hinting](https://en.wikipedia.org/wiki/Font_hinting)) when rendering PDF documents into image [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) provides *htmlViewOptions.getPdfOptions().setEnableFontHinting()* setting as shown below:

NOTE: this option is supported when rendering into PNG and JPG.

```java
PngViewOptions viewOptions = new PngViewOptions(pageFilePathFormat);
viewOptions.getPdfOptions().setEnableFontHinting(true);
 
Viewer viewer = new Viewer("sample.pdf");
viewer.view(viewOptions);
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