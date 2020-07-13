---
id: render-tracked-changes
url: viewer/java/render-tracked-changes
title: Render tracked changes
weight: 1
description: "This article explains how to show tracked changes when viewing Word Processing Documents with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer) does not render tracked changes of Word Processing documents by default. If you want to see tracked changes in your rendering result, use [setRenderTrackedChanges(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/WordProcessingOptions#setRenderTrackedChanges(boolean)) property of [WordProcessingOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/WordProcessingOptions) that can be set using property [setWordProcessingOptions(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/BaseViewOptions#setWordProcessingOptions(com.groupdocs.viewer.options.WordProcessingOptions)) of [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions), [JpgViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions), [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) or [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfViewOptions) class and pass it to [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) object constructor.

Follow below steps to render WordProcessing document with tracked changes.

*   Initialize the [WordProcessingOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/WordProcessingOptions) object.
*   Set [setRenderTrackedChanges(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/WordProcessingOptions#setRenderTrackedChanges(boolean)) to `true`.
*   Initialize the [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions) object.
*   Pass [WordProcessingOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/WordProcessingOptions) object to [setWordProcessingOptions(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/BaseViewOptions#setWordProcessingOptions(com.groupdocs.viewer.options.WordProcessingOptions)) property.
*   Pass [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions) object to [view(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method.

The following code sample shows how to render a Word document including tracked changes.

```java
    Viewer viewer = new Viewer("sample.docx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.getWordProcessingOptions().setRenderTrackedChanges(true);
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