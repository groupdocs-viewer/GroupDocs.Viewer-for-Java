---
id: limit-count-of-items-to-render
url: viewer/java/limit-count-of-items-to-render
title: Limit count of items to render
weight: 3
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) allows rendering the items in Outlook Data Files (OST/PST). *OutlookOptions* is used to set rendering options for OST and PST formats. The following steps are to be followed when rendering the items in Outlook Data Files.

*   Create *Viewer* object
*   Create *HtmlViewOptions* (or *PngViewOptions*, or *JpgViewOptions*, or *PdfViewOptions*)
*   Set Outlook options i.e. *htmlViewOptions.getOutlookOptions().setMaxItemsInFolder()*
*   Call *view* method

The following code samples show how to render the items in an Outlook Data File by setting a maximum limit.

```java
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
viewOptions.getOutlookOptions().setMaxItemsInFolder(1000);
 
Viewer viewer = new Viewer("sample.ost");
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