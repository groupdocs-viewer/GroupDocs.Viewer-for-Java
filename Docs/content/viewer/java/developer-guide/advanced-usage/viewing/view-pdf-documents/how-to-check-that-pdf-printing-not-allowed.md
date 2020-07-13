---
id: how-to-check-that-pdf-printing-not-allowed
url: viewer/java/how-to-check-that-pdf-printing-not-allowed
title: How to check that PDF printing not allowed
weight: 5
description: "This article explains how to retrieve information about PDF Documents with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Checking that printing not allowed

[GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides additional information for PDF documents when calling [getViewInfo(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method. To retrieve view information for PDF document call [getViewInfo(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method and cast output result to [PdfViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/PdfViewInfo) type.

Following example demonstrates how to retrieve view information for PDF document.

```java
    Viewer viewer = new Viewer("sample.pdf");
    ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
    PdfViewInfo viewInfo = (PdfViewInfo) viewer.getViewInfo(viewInfoOptions);

    System.out.println("Document type is: " + viewInfo.getFileType());
    System.out.println("Pages count: " + viewInfo.getPages().size());
    System.out.println("Printing allowed: " + viewInfo.isPrintingAllowed());
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