---
id: html-viewer-exclude-fonts
url: viewer/java/html-viewer-exclude-fonts
title: HTML Viewer - Exclude fonts
weight: 1
description: "Learn how to exclude system pre-installed fonts from HTML markup to reduce rendered document size when displaying documents with GroupDocs.Viewer."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
When rendering documents into HTML, by default the fonts that are used in the document are added to HTML content. This ensures fonts availability so that you can be pretty sure that the text from the original document will appear similar in the HTML, regardless of whether the fonts are installed on the viewer's device or not. Depending on type of Html rendering (with embedded or with external resources) the fonts are added inline as base64-encoded fonts or as external resources.   
  
The following document types support adding fonts into HTML:

| Format Name | Extension |
| --- | --- |
| Portable Document Format | PDF |
| Microsoft Word | DOC, DOCX, DOCM, DOT, DOTX, DOTM |
| Microsoft Outlook | MSG, EML |
| Apple Mail | EMLX |
| OpenDocument Formats | ODT, OTT |
| Rich Text Format | RTF |
| Electronic publication | EPUB |
| Mobipocket e-book format | MOBI |
| LaTeX | TEX |
| Microsoft PowerPoint | PPT, PPTX, PPS, PPSX |
| OpenDocument Formats | ODP |
| Image files | SVG  |

Embedding fonts increase the size of the rendered result. In order to prevent adding specific fonts (that are commonly available on most of the devices) into HTML, add excluded font name into [getFontsToExclude()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions#getFontsToExclude()) collection of [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions) class as shown in the code sample below.   
**NOTE:** Currently, it works only for Presentation documents. However, the support for this feature will be extended for all document types where it is applicable in the upcoming releases.

```java
    Viewer viewer = new Viewer("sample.docx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.getFontsToExclude().add("Times New Roman");
    viewer.view(viewOptions);
    viewer.close();
```

## More resources
### Advanced Usage Topics
To learn more about document viewing features, please refer to the [advanced usage section]({{< ref "viewer/java/developer-guide/advanced-usage/_index.md" >}}).

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