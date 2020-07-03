---
id: adjust-page-size
url: viewer/java/adjust-page-size
title: Adjust page size
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) allows setting output page size for rendering Email messages into HTML, PDF, and images. To enable this feature, the setter *htmlViewOptions.getEmailOptions.setPageSize()* is used. The following are the pages sizes that are supported and provided in *PageSize* Enumeration:

*   *Unspecified* - The default, unspecified page size
*   *Letter* - The size of the Letter page in points is 792 × 612
*   *Ledger* - The size of the Ledger page in points is 1224 × 792
*   *A0* - The size of the A0 page in points is 3371 × 2384
*   *A1* - The size of the A1 page in points is 2384 × 1685
*   *A2* - The size of the A2 page in points is 1684 × 1190
*   *A3* - The size of the A3 page in points is 1190 × 842
*   *A4* - The size of the A4 page in points is 842 × 595

The following are the steps to set size for email message:

*   Create *HtmlViewOptions*, *PngViewOptions*, *JpgViewOptions* or *PdfViewOptions*
*   Set *htmlViewOptions.getEmailOptions().setPageSize()*
*   Call *view()* method  
      
    
```java        
PdfViewOptions viewOptions = new PdfViewOptions("output.pdf");
viewOptions.getEmailOptions().setPageSize(PageSize.A4);
 
Viewer viewer = new Viewer("simple-email.msg");
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