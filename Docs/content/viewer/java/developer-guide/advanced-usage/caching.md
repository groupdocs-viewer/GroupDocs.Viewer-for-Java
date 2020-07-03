---
id: caching
url: viewer/java/caching
title: Caching
weight: 2
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
In some cases, document rendering may be a time-consuming operation (dependent on source document content, structure, and complexity). For such situations caching can be a solution - rendered document representation is stored into the cache (for example at the local drive) and in a case of repetitive rendering of the document, [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) uses cached representation. This thing helps to avoid the processing of the same document again and again.   
To enable caching you have to:

*   Instantiate desired cache object (for example [FileCache](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.caching/FileCache) will store document rendering results at the local drive)
*   Instantiate [ViewerSettings](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.caching/FileCache) object with cache object;
*   Pass [ViewerSettings](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.caching/FileCache) object to constructor of a *Viewer* class.
*   Call [view()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method of [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) class.

Here is a code that demonstrates how to enable caching for GroupDocs.Viewer.

```java
FileCache cache = new FileCache("cache");
ViewerSettings settings = new ViewerSettings(cache);

HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("page_{0}.html");

Viewer viewer = new Viewer("sample.docx", settings);
viewer.view(options);
viewer.close();
```
