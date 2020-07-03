---
id: view-specific-pages
url: viewer/java/view-specific-pages
title: View specific pages
weight: 9
description: "This article explains how to view specific pages when processing documents with GroupDocs.Viewer within your Java applications."
keywords: View specific pages with GroupDocs.Viewer for Java API
productName: GroupDocs.Viewer for Java
hideChildren: False
---

[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) also provides the features to render only the selected page numbers. You can specify a list of the document pages to be rendered. Follow the below steps to achieve this functionality. 

*   Instantiate the [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) object;
*   Instantiate the [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions), [PngViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PngViewOptions), [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/JpgViewOptions) or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions) object;
*   Pass desired page numbers to [view()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method;
*   The following code sample shows how to render N consecutive pages of a document.
    
The following code sample shows how to render first and third pages of a document.

```java
HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources();
 
Viewer viewer = new Viewer("sample.docx");
viewer.view(options, 1, 3);
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