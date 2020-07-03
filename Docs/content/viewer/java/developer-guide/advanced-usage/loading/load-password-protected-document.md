---
id: load-password-protected-document
url: viewer/java/load-password-protected-document
title: Load password-protected document
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) supports rendering documents that are protected with a password.

The following are the steps to render password-protected documents.

*   Instantiate the [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions) (or [PngViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PngViewOptions), or [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/JpgViewOptions), or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions)) object;
*   Set password in [LoadOptions.setPassword()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/LoadOptions#setPassword(java.lang.String)) method;
*   Call [view()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method.

The following code sample shows how to render password-protected documents.

```java
        LoadOptions loadOptions = new LoadOptions(FileType.DOCX);    
        loadOptions.setPassword("12345");

        Viewer viewer = new Viewer("sample.docx", loadOptions);
        viewer.view(HtmlViewOptions.forEmbeddedResources());     
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
