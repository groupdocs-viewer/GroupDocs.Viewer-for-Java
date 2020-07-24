---
id: how-to-make-cache-thread-safe-in-your-java-csharp-application
url: viewer/java/how-to-make-cache-thread-safe-in-your-java-csharp-application
title: How to make cache thread-safe in your Java application
weight: 2
description: "This article explains how to make cache thread-safe with GroupDocs.Viewer within your Java applications."
keywords: GroupDocs.Viewer, thread-safe, cache
productName: GroupDocs.Viewer for Java
hideChildren: False
---
This tutorial will explain how to make cache thread-safe by using [synchronized](https://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html) block.

## Introduction

We can say that a method is thread-safe when multiple threads can call it without breaking the functionality of this method. Achieving thread safety is a complex task and so general-purpose classes are usually not thread-safe. The most common way to achieve thread-safety is by locking the resource for the exclusive use by a single thread at any given point of the time.

## The issue

We have a web-application where multiple users can simultaneously view the same file. The web-application uses [GroupDocs.Viewer](https://products.groupdocs.com/viewer) on the server-side and we want to make sure that multiple-threads can safely read from and write to the cache, in other words, make cache thread-safe.

The [GroupDocs.Viewer](https://products.groupdocs.com/viewer) enables users to use caching to improve the performance of the application when the same document is processed multiple times ([read more about caching here]({{< ref "viewer/java/developer-guide/advanced-usage/caching/_index.md" >}}).) The [FileCache](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.caching/FileCache) is a simple implementation of [Cache](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.caching/Cache) interface that uses a local disk to store the cache files is available from the com.groupdocs.viewer.caching package. The [FileCache](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.caching/FileCache) is not thread-safe, so our task is to make it thread-safe.

## The solution

The [FileCache](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.caching/FileCache) class uses a local disk to read and write output file copies, so we need to make reads and writes to disk thread-safe. The simplest way is using [synchronized](https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html) block. Let's implement a class which will wrap around not thread-safe class which implements the [Cache](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.caching/Cache) interface.

```java
    class ThreadSafeCache implements Cache {
        private final Cache _cache;

        public ThreadSafeCache(Cache cache) {
            _cache = cache;
        }

        public void set(String key, Object value) {
            synchronized (_cache) {
                _cache.set(key, value);
            }
        }

        public Object get(String key) {
            synchronized (_cache) {
                return _cache.get(key);
            }
        }

        public List<String> getKeys(String filter) {
            synchronized (_cache) {
                return _cache.getKeys(filter);
            }
        }
    }
```

## Conclusion

With [synchronized](https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html) statement we can write quite a simple code to achieve thread-safety in our applications as shown in this tutorial. 

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
