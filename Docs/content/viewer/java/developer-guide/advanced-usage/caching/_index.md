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
In some cases document rendering may be a time-consuming operation (dependent on source document content, structure and complexity). For such situations caching can be a solution - rendered document representation is stored into cache (for example at the local drive) and in a case of repetitive rendering of the document, [GroupDocs.Viewer](https://products.groupdocs.com/viewer) uses cached representation. This thing helps to avoid the processing of the same document again and again.  
To enable caching you have to:

*   Instantiate desired cache object (for example [FileCache](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.caching/FileCache) will store document rendering results at the local drive)
*   Instantiate [ViewerSettings](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/ViewerSettings) object with cache object;
*   Pass [ViewerSettings](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/ViewerSettings) object to constructor of a [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class.
*   Call [view(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method of [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class.

Here is a code that demonstrates how to enable caching for [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java). 

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

{{< alert style="info" >}}[GroupDocs.Viewer](https://products.groupdocs.com/viewer) also provides an ability to customize caching behavior. To learn more about caching customization please refer to [Caching guide]({{< ref "viewer/java/developer-guide/advanced-usage/caching/how-to-use-custom-cache-implementation.md" >}}).{{< /alert >}}

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