---
id: get-supported-file-formats
url: viewer/java/get-supported-file-formats
title: Get supported file formats
weight: 6
description: "This article explains how to obtain supported file formats list when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) allows to get the list of all supported file formats by following the below steps:

*   Call [getSupportedFileTypes()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/FileType#getSupportedFileTypes()) method of [FileType](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/FileType) class;
*   Enumerate through the collection of [FileType](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/FileType) objects.

The following code sample demonstrates how to get the supported file formats list.

```java
List<FileType> fileTypes = FileType.getSupportedFileTypes();

for (FileType fileType : fileTypes) {
    System.out.println(fileType);
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