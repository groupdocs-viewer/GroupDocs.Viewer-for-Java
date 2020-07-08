---
id: render-all-layouts
url: viewer/java/render-all-layouts
title: Render all layouts
weight: 10
description: "This article explains how to view all CAD drawing layouts with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
![](viewer/java/images/render-all-layouts.jpg)

When [GroupDocs.Viewer](https://products.groupdocs.com/viewer) renders CAD drawings we get only Model representation. In order to render Model and all non-empty Layouts within CAD drawing, the property [CadOptions.RenderLayouts](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/cadoptions/properties/renderlayouts) of [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/htmlviewoptions) class (or [PngViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pngviewoptions), or [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/jpgviewoptions), or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions)) is used.

Following are the steps to render all the non-empty layouts along with the Model.

*   Create [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/htmlviewoptions) object.
*   Set [CadOptions.RenderLayouts](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/cadoptions/properties/renderlayouts) of [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/htmlviewoptions) to *true*
*   Call [View](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer/methods/view) method

The following code sample shows how to render layouts along with the Model of a CAD drawing.

```java
    Viewer viewer = new Viewer("sample.dwg");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.getCadOptions().setRenderLayouts(true);
    viewer.view(viewOptions);
    viewer.close();
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