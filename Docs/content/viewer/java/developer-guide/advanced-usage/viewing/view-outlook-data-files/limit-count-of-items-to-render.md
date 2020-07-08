---
id: limit-count-of-items-to-render
url: viewer/java/limit-count-of-items-to-render
title: Limit count of items to render
weight: 3
description: "This article explains how to set a limit for items to view of Outlook Data Files with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
GroupDocs.Viewer allows rendering the items in Outlook Data Files (OST/PST). [OutlookOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/outlookoptions) is used to set rendering options for OST and PST formats. The following steps are to be followed when rendering the items in Outlook Data Files.

*   Create [Viewer](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer) object;
*   Create [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/htmlviewoptions) (or [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/jpgviewoptions), or [PngViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pngviewoptions), or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions)) object;
*   Set Outlook options i.e. [HtmlViewOptions.OutlookOptions.MaxItemsInFolder](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/outlookoptions/properties/maxitemsinfolder)*;*
*   Call [View](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer/methods/view) method.

The following code samples show how to render the items in an Outlook Data File by setting a maximum limit.

```java
    Viewer viewer = new Viewer("sample.ost");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.getOutlookOptions().setMaxItemsInFolder(1000);
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