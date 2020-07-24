---
id: image-viewer-adjust-quality-for-jpg
url: viewer/java/image-viewer-adjust-quality-for-jpg
title: Image Viewer - Adjust quality for JPG
weight: 3
description: "Following this guide you will learn how to adjust JPG images quality when viewing documents with Image Viewer by GroupDocs."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
When rendering documents and files to JPG with [GroupDocs.Viewer](https://products.groupdocs.com/viewer) you can adjust quality of the output images by setting [setQuality(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions#setQuality(byte)) property of [JpgViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions) class. The supported values range of [setQuality(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions#setQuality(byte)) is from 1 to 100. Default value is 90.

This example demonstrates how to adjust quality of the output JPG image.

```java
    Viewer viewer = new Viewer("sample.docx");
    JpgViewOptions viewOptions = new JpgViewOptions();
    viewOptions.setQuality((byte) 50);

    viewer.view(viewOptions);
    viewer.close();
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