---
id: reorder-pages
url: viewer/java/reorder-pages
title: Reorder pages
weight: 2
description: "This article explains how to reorder pages when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: Reorder pages with GroupDocs.Viewer for Java API
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) allows you to reorder the document pages. The order of the pages in the source document is never changed, instead, the API reorders pages in the resultant PDF document.

To reorder the pages:

*   Instantiate [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) object;
*   Create [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions)*;*
*   Call [view()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method specifying desired page numbers order.

The following code snippet shows how to reorder pages. 

```java
PdfViewOptions options = new PdfViewOptions("output.pdf");
 
Viewer viewer = new Viewer("sample.docx");
// Pass page numbers in the order you want to render them
viewer.view(options, 2, 1);
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