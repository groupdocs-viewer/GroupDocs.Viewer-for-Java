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

    try (Viewer viewer = new Viewer("C:\\sample.docx", settings)) {
    
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
    }
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

### Using Custom model classes for caching

Default Viewer models implements Serializable interface, but sometimes it is not enough. Sometimes you would like to use 3rd party libraries for serialization. Lots of them want you to annotate classes and fields of classes, that would be serialized.
Fortunately you can create custom models with fields you want and configure Viewer to use them.

To do it you need:
* Create custom models, implementing Viewer model's interfaces, like ViewInfo, FileInfo and so on (Full list of interfaces can be found investigating `CacheableFactory` class)
* Create custom model factory (`CustomFactory`) extending class `CacheableFactory`. Each method in the class must be overridden to return instance of your cache model.
* Configure Viewer to use CustomFactory using method `CacheableFactory.setInstance(new CustomFactory())` before creating Viewer object.
* After that configure Viewer cache as usual. Viewer will put your model's objects into method `set` of Cache implementation so that you can serialize it in any way.
 
 
```java
public class CustomFileInfoJackson implements FileInfo {
    @JsonProperty("FileType")
    private final String mFileType;
    @JsonProperty("Encrypted")
    private boolean mEncrypted;

    @JsonCreator
    public CustomFileInfoJackson(@JsonProperty("FileType") String fileType) {
        mFileType = fileType;
    }

    @Override
    public FileType getFileType() {
        return FileType.valueOf(mFileType);
    }

    @Override
    public boolean isEncrypted() {
        return mEncrypted;
    }

    @Override
    public void setEncrypted(boolean encrypted) {
        mEncrypted = encrypted;
    }
}
```

```java

public class CustomFactory extends CacheableFactory {

    //...

    @Override
    public FileInfo newFileInfo(FileType fileType) {
        return new CustomFileInfoJackson(fileType.name());
    }

    //...

}
```

```java
public class JacksonCache implements Cache {

    //...

    @Override
    public void set(String key, Object value) {
        final byte[] bytes;
        if (value instanceof InputStream) {
            bytes = IOUtils.toByteArray((InputStream) value);
        } else {
            // Serialize in any way
            bytes = jacksonMapper.writeValueAsBytes(value);
        }
        // Here bytes could be written to file or sent somewhere
        mData.put(key, bytes);
    }

    //...

    @Override
    public <T> T get(String key, Class<T> clazz) {
        final byte[] bytes = mData.get(key);
        if (InputStream.class.equals(clazz)) {
            return (T) new ByteArrayInputStream(bytes);
        } else {
            // Deserialize in any way
            return jacksonMapper.readValue(bytes, clazz);
        }
    }

    //...

}
```

```java
    CacheableFactory.setInstance(new CustomFactory());

    Cache cache = new JacksonCache();
    ViewerSettings settings = new ViewerSettings(cache);
    try (Viewer viewer = new Viewer("document.doc", settings)) {
        // Do work
    }
```

## More resources
### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for Java examples, plugins, and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-MVC)     

### Free Online App
Along with full-featured Java library we provide simple but powerful free Apps.
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.