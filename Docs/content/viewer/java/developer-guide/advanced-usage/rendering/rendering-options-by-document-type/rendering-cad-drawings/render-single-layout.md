---
id: render-single-layout
url: viewer/java/render-single-layout
title: Render single layout
weight: 5
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) renders *Model* layout of CAD drawing by default. To render specific layout from a CAD drawing the API provides setter *htmlViewOptions.getCadOptions().setLayoutName()*  (or pngViewOptions, or jpgViewOptions, or pdfViewOptions). When this value is set, *cadOptions.setRenderLayouts()* value will be ignored.

Following are the steps to render specific layout in CAD drawing.

*   Create *HtmlViewOptions* object.
*   Use setter *htmlViewOptions.getCadOptions().setLayoutName()*.
*   Call *view()* method.

The following code sample shows how to render a specific layout.

```java
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
viewOptions.getCadOptions().setLayoutName("Model");

Viewer viewer = new Viewer("with_layers_and_layouts.dwg");
viewer.view(viewOptions);
viewer.close();
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