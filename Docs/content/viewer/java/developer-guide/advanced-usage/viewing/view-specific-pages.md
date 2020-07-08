---
id: view-specific-pages
url: viewer/java/view-specific-pages
title: View specific pages
weight: 10
description: "This article explains how to view specific pages when processing documents with GroupDocs.Viewer within your Java applications."
keywords: View specific pages with GroupDocs.Viewer for Java API
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## View specific pages

[GroupDocs.Viewer](https://products.groupdocs.com/viewer) also provides the features to render only the selected page numbers. You can specify a list of the document pages to be rendered. Follow the below steps to achieve this functionality. 

*   Instantiate the [Viewer](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer) object;
*   Instantiate the [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/htmlviewoptions) (or [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/jpgviewoptions), or [PngViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pngviewoptions), or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions)) object;
*   Pass desired page numbers to [View](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer/methods/view) method.
*   The following code sample shows how to render N consecutive pages of a document.
    

The following code sample shows how to render the first and third pages of a document.

```java
    Viewer viewer = new Viewer("sample.docx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewer.view(viewOptions, 1, 3);
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