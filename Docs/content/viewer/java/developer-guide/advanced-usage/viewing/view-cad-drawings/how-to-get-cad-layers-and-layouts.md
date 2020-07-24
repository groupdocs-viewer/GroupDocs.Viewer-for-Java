---
id: how-to-get-cad-layers-and-layouts
url: viewer/java/how-to-get-cad-layers-and-layouts
title: How to get CAD layers and layouts
weight: 6
description: "This article explains how to retrieve information about CAD drawings with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Retrieving layers and layouts

[GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides additional information about CAD drawings such as list of layouts and layers when calling [getViewInfo(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method. To retrieve view information for CAD drawing call [getViewInfo(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method and cast output result to [CadViewInfo](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.results/CadViewInfo) type.

Following example demonstrates how to retrieve view information for CAD drawing.

```java
    Viewer viewer = new Viewer("sample.dwg");
    ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();
    CadViewInfo viewInfo = (CadViewInfo) viewer.getViewInfo(viewInfoOptions);

    System.out.println("File type: " + viewInfo.getFileType());
    System.out.println("Pages count: " + viewInfo.getPages().size());

    for (Layout layout : viewInfo.getLayouts()) {
        System.out.println(layout);
    }

    for (Layer layer : viewInfo.getLayers()) {
        System.out.println(layer);
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