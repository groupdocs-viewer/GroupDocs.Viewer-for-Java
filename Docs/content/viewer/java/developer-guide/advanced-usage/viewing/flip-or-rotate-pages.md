---
id: flip-or-rotate-pages
url: viewer/java/flip-or-rotate-pages
title: Flip or rotate pages
weight: 2
description: "This article explains how to flip or rotate pages when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: Flip rotate pages with GroupDocs.Viewer for Java API
productName: GroupDocs.Viewer for Java
hideChildren: False
---
![](viewer/java/images/flip-or-rotate-pages.png)

The [GroupDocs.Viewer](https://products.groupdocs.com/viewer) enables you to rotate individual pages when viewing documents in HTML/PDF/JPG/PNG formats. To flip/rotate pages use the [RotatePage](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/viewoptions/methods/rotatepage) method of [ViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/viewoptions) class.  The method accepts page number as the first parameter and rotation angle as the second parameter. There are three options that you can pass as the second parameter into [RotatePage](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/viewoptions/methods/rotatepage) method:

*   [Rotation.On90Degree](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/rotation) - instructs to rotate page on 90-degree clockwise; 
*   [Rotation.On180Degree](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/rotation) - instructs to rotate page on 180-degree clockwise;
*   [Rotation.On270Degree](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/rotation) - instructs to rotate page on 270-degree clockwise;

The following code snippet shows how to rotate output pages when viewing a document as PDF (t[his example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/blob/master/Examples/GroupDocs.Viewer.Examples.CSharp/AdvancedUsage/Rendering/CommonRenderingOptions/FlipRotatePages.cs) can be also found in our public [GitHub repository](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java).)

```java
    Viewer viewer = new Viewer("sample.docx");
    PdfViewOptions viewOptions = new PdfViewOptions();
    viewOptions.rotatePage(1, Rotation.ON_90_DEGREE);

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
