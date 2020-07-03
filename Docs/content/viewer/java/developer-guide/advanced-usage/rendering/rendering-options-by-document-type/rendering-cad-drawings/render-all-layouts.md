---
id: render-all-layouts
url: viewer/java/render-all-layouts
title: Render all layouts
weight: 3
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
When [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) renders CAD drawings we get only Model representation. In order to render Model and all non-empty Layouts within CAD drawing, the setter set *RenderLayouts()* of *HtmlViewOptions.getCadOptions()* (or *PngViewOptions.getCadOptions()*, or *JpgViewOptions.getCadOptions()*,or *PdfViewOptions.getCadOptions()*) is used.

The following are the steps to render all the non-empty layouts along with the Model.

*   Create [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions) object.
*   Call [getCadOptions()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/BaseViewOptions#getCadOptions()) of [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions) object and then use [setRenderLayouts()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/CadOptions#setRenderLayouts(boolean)) and pass *true* value
*   Call [view()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/ViewOptions) method

The following code sample shows how to render layouts along with the Model of a CAD drawing.

```java
HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
options.getCadOptions().setRenderLayouts(true);
 
Viewer viewer = new Viewer("with_layers_and_layouts.dwg");
viewer.view(options); 
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