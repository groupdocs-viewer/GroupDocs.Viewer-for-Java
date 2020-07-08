---
id: set-custom-fonts
url: viewer/java/set-custom-fonts
title: Set custom fonts
weight: 5
description: "This article explains how to set custom fonts when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: Setting custom fonts with GroupDocs.Viewer for Java API
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides the feature to add custom font sources. 

Following code snippet shows how to set a custom font source.

```java
    FolderFontSource fontSource = new FolderFontSource("C:\\custom_fonts", SearchOption.TOP_FOLDER_ONLY);
    FontSettings.setFontSources(fontSource);

    Viewer viewer = new Viewer("sample.docx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
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