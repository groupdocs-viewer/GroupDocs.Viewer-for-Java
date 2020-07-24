---
id: how-to-use-custom-cache-implementation
url: viewer/java/how-to-use-custom-cache-implementation
title: How to use custom cache implementation
weight: 1
description: "This article explains how to use custom caching implementation with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Despite the fact that [GroupDocs.Viewer](https://products.groupdocs.com/viewer) implements caching to local drive out of the box, it also allows you to cache rendering result in your own way. You can do this by using *Cache* interface implementation.  
Let see how to implement some custom cache implementation

## Using Custom cache (example)

The following steps should be followed.

*   Create `CustomCache` class which implements [Cache](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.caching/Cache) interface.
*   Instantiate the `CustomCache` class.
*   Pass the reference of the `RedisCache` class instance into the constructor of [ViewerSettings](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/ViewerSettings) class instance.
*   Instantiate [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class with [ViewerSettings](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/ViewerSettings) object.
*   Call [view(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method of [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class.

Below is the code that demonstrates how to use custom caching for [GroupDocs.Viewer](https://products.groupdocs.com/viewer):

```java
    String outputDirectory = "C:\\output";
    String pageFilePathFormat = Path.combine(outputDirectory, "page_{0}.html");

    MemoryCache cache = new MemoryCache("sample_");
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

    System.out.println("\nSource document rendered successfully.\nCheck output in " + outputDirectory + ".");
    viewer.close();
```

```java
public class MemoryCache implements Cache {
    private final Map<String, Object> data = new HashMap<>();
    private final String mPrefix;

    public MemoryCache(String prefix) {
        this.mPrefix = prefix;
    }

    @Override
    public void set(String key, Object value) {
        data.put(mPrefix + key, value);
    }

    @Override
    public Object get(String key) {
        return data.get(mPrefix + key);
    }

    @Override
    public List<String> getKeys(String filter) {
        List<String> result = new ArrayList<>();
        for (String key : data.keySet()) {
            if (key.contains(filter)) {
                result.add(key);
            }
        }
        return result;
    }
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