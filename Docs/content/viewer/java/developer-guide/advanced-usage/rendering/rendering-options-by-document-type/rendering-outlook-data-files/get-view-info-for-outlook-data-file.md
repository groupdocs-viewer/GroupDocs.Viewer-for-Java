---
id: get-view-info-for-outlook-data-file
url: viewer/java/get-view-info-for-outlook-data-file
title: Get View Info for Outlook Data File
weight: 2
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) provides additional information for Outlook Data Files when calling *getViewInfo()* method. To retrieve view information for Outlook Data File call *getViewInfo()* method and cast output result to *OutlookViewInfo* type.

Following example demonstrates how to retrieve view information for Outlook Data File.

```java
ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
 
Viewer viewer = new Viewer("sample.ost");
OutlookViewInfo viewInfo = (OutlookViewInfo) viewer.getViewInfo(viewInfoOptions);
viewer.close();
 
System.out.println("File type is: " + viewInfo.getFileType());
System.out.println("Pages count: " + viewInfo.getPages().size());
 
for (String folder : viewInfo.getFolders()) {
        System.out.println(folder);
}      
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