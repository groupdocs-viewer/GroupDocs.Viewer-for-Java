---
id: migration-notes
url: viewer/java/migration-notes
title: Migration Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
### Why To Migrate?
  
Here are the key reasons to use the new updated API provided by GroupDocs.Viewer for Java since version 19.11:

*   **Viewer** class introduced as a **single entry point** to manage the document rendering process to any supported file format (instead of **ViewerHtmlHander** / **ViewerImageHander** classes from previous versions).    
*   The overall **rendering speed improved** dramatically by saving rendered page as soon as it was rendered, not when all pages list were rendered. 
*   Product architecture was redesigned from scratch in order to **decreased memory usage** (from 10% to 400% approx. depending on the document type).
*   Document **viewing options simplified** so it’s easy to instantiate proper options class and control over document rendering and saving processes.        
    

### How To Migrate?

Here is a brief comparison of how to display document into HTML form using old and new API.  

**Old coding style**

```java
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler();

HtmlOptions options = new HtmlOptions();
options.setEmbedResources(true);

List<PageHtml> pages = htmlHandler.getPages("sample.docx", options);
```

**New coding style**

```java
Viewer viewer = new Viewer("sample.docx");
viewer.view(HtmlViewOptions.forEmbeddedResources());
viewer.close();
```

For more code examples and specific use cases please refer to our [Developer Guide]({{< ref "viewer/java/developer-guide/_index.md" >}}) documentation or [GitHub](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java) samples and showcases.
