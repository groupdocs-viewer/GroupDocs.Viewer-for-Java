---
id: how-to-set-background-color-when-converting-cad-drawings
url: viewer/java/how-to-set-background-color-when-converting-cad-drawings
title: How to set background color when converting CAD Drawings
weight: 7
description: "This article explains how to set background color when converting CAD Drawings with GroupDocs.Viewer within your Java applications"
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction

When converting CAD drawings with [GroupDocs.Viewer](https://products.groupdocs.com/viewer) there is no background color set by default but we proved an option that enables you to set any background color.

## Setting background color when converting CAD Drawings

Let's check how does output looks when converting sample CAD drawing with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java).

And as you can see the background color of the output image below is white.

![](viewer/java/images/how-to-set-background-color-when-converting-cad-drawings.png)

Now, lets set background color and convert CAD drawing one more time.

To set background color you need to specify the [setBackgroundColor(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/CadOptions#setBackgroundColor(java.awt.Color)) property value in the [CadOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/CadOptions) class. 

The following code snippet shows how to set background color.

```java
    Viewer viewer = new Viewer("input.dwg"))
    PngViewOptions options = new PngViewOptions(pageFilePathFormat);
    options.getCadOptions().setBackgroundColor(Color.BLUE);
    viewer.view(options);
    viewer.close();
```

And here is output image with blue background color:

![](viewer/java/images/how-to-set-background-color-when-converting-cad-drawings_1.png)

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