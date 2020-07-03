---
id: html-viewer-responsive-layout
url: viewer/java/html-viewer-responsive-layout
title: HTML Viewer - Responsive layout
weight: 3
description: "Learn how to render and display your document with responsive HTML layout that looks great on mobile and desktop devices."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
![](viewer/java/images/html-viewer-responsive-layout.jpg)

[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) also enables you to make your rendering into HTML look well across all types of devices. To achieve this, the API provides [setRenderResponsive()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions#setRenderResponsive(boolean)) method of [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions) class as shown in below sample code.

```java
String pageFilePathFormat = "page_{0}.html";

HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
options.setRenderResponsive(true);

Viewer viewer = new Viewer("sample.docx");
viewer.view(options);
viewer.close();
```

## More resources
### Advanced Usage Topics
To learn more about document viewing features, please refer the [advanced usage section]({{< ref "viewer/java/developer-guide/advanced-usage/_index.md" >}}).

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
