---
id: show-document-notes
url: viewer/java/show-document-notes
title: Show document notes
weight: 6
description: "This article explains how to show notes when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: Show notes when viewing documents with GroupDocs.Viewer for Java API
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) does not include notes in the rendering results. However, you can choose between to show or hide the notes in the output. If you want to see notes in your rendering result, use setter [setRenderNotes()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/BaseViewOptions#setRenderNotes(boolean)) of [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions), [PngViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PngViewOptions), [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/JpgViewOptions) or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions) class and pass it to [Viewer's](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) object [view()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method.

![](viewer/java/images/show-document-notes.png)

The following are the steps to include the notes in the rendering result.

*   Initialize the object of [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions)
*   Use setter set **RenderNotes()** of object [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions) to set value into *true*
*   Pass [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions) object to [view(](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions))) method

The following code sample renders Presentation with notes.

```java       
HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources();
options.setRenderNotes(true);

Viewer viewer = new Viewer("with_notes.pptx");
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