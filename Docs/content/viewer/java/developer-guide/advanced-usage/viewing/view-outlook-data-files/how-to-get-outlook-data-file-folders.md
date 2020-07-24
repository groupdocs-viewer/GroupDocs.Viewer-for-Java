---
id: how-to-get-outlook-data-file-folders
url: viewer/java/how-to-get-outlook-data-file-folders
title: How to get Outlook Data file folders
weight: 2
description: "This article explains how to retrieve information about Outlook Data File with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Retrieving folders

[GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides additional information for Outlook Data Files when calling [getViewInfo(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method. To retrieve view information for Outlook Data File call [getViewInfo(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method and cast output result to [OutlookViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/OutlookViewInfo) type.

Following example demonstrates how to retrieve view information for Outlook Data File.

```java
    Viewer viewer = new Viewer("sample.ost");
    ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
    OutlookViewInfo viewInfo = (OutlookViewInfo) viewer.getViewInfo(viewInfoOptions);

    System.out.println("File type is: " + viewInfo.getFileType());
    System.out.println("Pages count: " + viewInfo.getPages().size());

    for (String folder : viewInfo.getFolders()) {
        System.out.println(folder);
    }
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