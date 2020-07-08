---
id: load-password-protected-document
url: viewer/java/load-password-protected-document
title: Load password-protected document
weight: 2
description: "This article explains how to load password-protected document with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer) supports rendering documents that are protected with a password.

The following are the steps to render password-protected documents.

*   Instantiate the [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/groupdocs.viewer.options/htmlviewoptions) (or [PngViewOptions](https://apireference.groupdocs.com/viewer/java/groupdocs.viewer.options/pngviewoptions), or [JpgViewOptions](https://apireference.groupdocs.com/viewer/java/groupdocs.viewer.options/jpgviewoptions), or [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/groupdocs.viewer.options/pdfviewoptions)) object;
*   Set password in [HtmlViewOptions.Password](https://apireference.groupdocs.com/viewer/java/groupdocs.viewer.options/loadoptions/properties/password) property;
*   Call [View](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer/methods/view) method.

The following code sample shows how to render password-protected documents.

```java
    LoadOptions loadOptions = new LoadOptions();
    loadOptions.setPassword("123456");

    Viewer viewer = new Viewer("sample.docx", loadOptions);
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