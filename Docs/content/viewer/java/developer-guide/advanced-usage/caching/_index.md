---
id: caching
url: viewer/java/caching
title: Caching
weight: 2
description: "This article contains caching use-cases with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
In some cases document rendering may be a time-consuming operation (dependent on source document content, structure and complexity). For such situations caching can be a solution - rendered document representation is stored into cache (for example at the local drive) and in a case of repetitive rendering of the document, GroupDocs.Viewer uses cached representation. This thing helps to avoid the processing of the same document again and again.  
To enable caching you have to:

*   Instantiate desired cache object (for example [FileCache](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.caching/filecache) will store document rendering results at the local drive)
*   Instantiate [ViewerSettings](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewersettings) object with cache object;
*   Pass [ViewerSettings](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewersettings) object to constructor of a [Viewer](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer) class.
*   Call [View](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer/methods/view) method of [Viewer](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer) class.

Here is a code that demonstrates how to enable caching for GroupDocs.Viewer. 

```java
    String outputDirectory = "C:\\output";
    String cachePath = Path.combine(outputDirectory, "cache");
    String pageFilePathFormat = Path.combine(outputDirectory, "page_{0}.html");
    
    FileCache cache = new FileCache(cachePath);
    ViewerSettings settings = new ViewerSettings(cache);
    
    Viewer viewer = new Viewer("C:\\sample.docx", settings);
    
    HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
    
    long stopWatch = System.currentTimeMillis();
    viewer.view(options);
    stopWatch = System.currentTimeMillis() - stopWatch;
    System.out.println("Time taken on first call to View method " + stopWatch + " (ms).");
    
    stopWatch = System.currentTimeMillis();
    viewer.view(options);
    stopWatch = System.currentTimeMillis() - stopWatch;
    System.out.println("Time taken on second call to View method " + stopWatch + " (ms).");
    viewer.close();
```

{{< alert style="info" >}}GroupDocs.Viewer also provides an ability to customize caching behavior. To learn more about caching customization please refer to Caching guide.{{< /alert >}}

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