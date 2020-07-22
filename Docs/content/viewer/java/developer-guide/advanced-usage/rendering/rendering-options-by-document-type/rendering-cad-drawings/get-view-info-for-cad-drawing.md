---
id: get-view-info-for-cad-drawing
url: viewer/java/get-view-info-for-cad-drawing
title: Get View Info for CAD Drawing
weight: 2
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) provides additional information about CAD drawings such as list of layouts and layers when calling [g*etViewInfo*](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method. To retrieve view information for CAD drawing call [g*etViewInfo*](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#getViewInfo(com.groupdocs.viewer.options.ViewInfoOptions)) method and cast output result to *[CadViewInfo](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.results/CadViewInfo)* type.

Following example demonstrates how to retrieve view information for CAD drawing.

```java
ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();

Viewer viewer = new Viewer("wiht_layers_and_layouts.dwg");
CadViewInfo info = (CadViewInfo) viewer.getViewInfo(viewInfoOptions);
viewer.close();

System.out.println("Document type is: " + info.getFileType());
System.out.println("Pages count: " + info.getPages().size());

for (Layout layout : info.getLayouts()) {
    System.out.println(layout);
}

for (Layer layer : info.getLayers()) {
    System.out.println(layer);
}
```

## More resources
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