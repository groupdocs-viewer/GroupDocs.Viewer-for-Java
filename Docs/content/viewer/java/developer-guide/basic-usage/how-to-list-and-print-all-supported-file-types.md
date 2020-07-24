---
id: how-to-list-and-print-all-supported-file-types
url: viewer/java/how-to-list-and-print-all-supported-file-types
title: How to list and print all supported file types
weight: 5
description: "This article explains how to list and print file types supported by GroupDocs.Viewer for Java using Java / C#."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Get supported file formats

Here is the full list of [supported file formats]({{< ref "viewer/java/getting-started/supported-document-formats.md" >}}). In case you need to list or print out all of the supported file formats in your application you can do the following:

*   Call [getSupportedFileTypes()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/FileType#getSupportedFileTypes()) methodof [FileType](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/FileType) class;
*   Enumerate through the collection of [FileType](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/FileType) objects. 

The following code sample demonstrates how to print all supported file formats list to the console.

```java
    List<FileType> supportedFileTypes = FileType.getSupportedFileTypes();

    for (FileType fileType : supportedFileTypes) {
        System.out.println(fileType);
    }
```

## More resources
### Advanced Usage Topics
To learn more about document viewing features, please refer to the [advanced usage section]({{< ref "viewer/java/developer-guide/advanced-usage/_index.md" >}}).

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