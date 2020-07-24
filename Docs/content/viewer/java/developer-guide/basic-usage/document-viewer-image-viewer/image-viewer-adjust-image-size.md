---
id: image-viewer-adjust-image-size
url: viewer/java/image-viewer-adjust-image-size
title: Image Viewer - Adjust image size
weight: 2
description: "Check this guide to learn how to adjust PNG and JPG images size when viewing documents with Image Viewer by GroupDocs for Java."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Image Viewer allows you to set custom output image size in pixels through [setWidth(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions#setWidth(int)) and [setHeight(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions#setHeight(int)) properties in [JpgViewOptions ](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions) and [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) classes.

Keep in mind that aspect ratio is automatically applied when you set [setWidth(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions#setWidth(int)) or [setHeight(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions#setHeight(int)) only.

This example demonstrates how to set output image size

```java
    Viewer viewer = new Viewer("sample.docx");
    JpgViewOptions viewOptions = new JpgViewOptions();
    viewOptions.setWidth(600);
    viewOptions.setHeight(800);

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