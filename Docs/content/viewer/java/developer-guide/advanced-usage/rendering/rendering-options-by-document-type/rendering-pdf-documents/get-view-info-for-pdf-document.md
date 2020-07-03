---
id: get-view-info-for-pdf-document
url: viewer/java/get-view-info-for-pdf-document
title: Get View Info for PDF Document
weight: 5
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) provides additional information for PDF documents when calling *getViewInfo()* method. To retrieve view information for PDF document call *getViewInfo()* method and cast output result to *PdfViewInfo* type.

The following example demonstrates how to retrieve view information for PDF documents.

```java
        ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
 
        Viewer viewer = new Viewer("sample.pdf");
        PdfViewInfo viewInfo = (PdfViewInfo) viewer.getViewInfo(viewInfoOptions);
        viewer.close();
 
        System.out.println("Document type is: " + viewInfo.getFileType());
        System.out.println("Pages count: " + viewInfo.getPages().size());
        System.out.println("Printing allowed: " + viewInfo.isPrintingAllowed());

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