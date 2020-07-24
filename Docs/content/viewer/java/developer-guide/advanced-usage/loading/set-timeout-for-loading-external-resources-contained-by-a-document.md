---
id: set-timeout-for-loading-external-resources-contained-by-a-document
url: viewer/java/set-timeout-for-loading-external-resources-contained-by-a-document
title: Set timeout for loading external resources contained by a document
weight: 5
description: "This article explains how to set timeout for loading external resources contained by a document with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
The documents may contain external resources such as graphics that should be loaded during document rendering. 

Before v19.12 default timeout was 100 seconds which may slow down rendering in case a service that provides external resources is down.

In v19.12 we've set default timeout to 30 seconds and enabled users to specify the desired timeout in [LoadOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/LoadOptions) class.

This feature is supported for:

*   [Word Processing File Formats](https://wiki.fileformat.com/word-processing/)   
      
    

The following code snippet shows how to set a timeout for loading external resources:

```java
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setResourceLoadingTimeout(5000);

        Viewer viewer = new Viewer("sample.doc", loadOptions);

        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
        viewer.view(viewOptions);
        viewer.close();
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