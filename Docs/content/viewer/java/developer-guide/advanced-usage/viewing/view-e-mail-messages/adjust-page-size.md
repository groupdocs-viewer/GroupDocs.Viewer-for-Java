---
id: adjust-page-size
url: viewer/java/adjust-page-size
title: Adjust page size
weight: 1
description: "This article explains how to adjust page size when viewing E-Mail Messages with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer) allows setting output page size for rendering Email messages into HTML, PDF, and images. To enable this feature, the [setPageSize(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/EmailOptions#setPageSize(int)) property of the [EmailOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/EmailOptions) class is used. The following are the pages sizes that are supported and provided in [setPageSize(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/EmailOptions#setPageSize(int)) enumeration:

*   [PageSize.UNSPECIFIED](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PageSize#UNSPECIFIED) - The default, unspecified page size
*   [PageSize.LETTER](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PageSize#LETTER) - The size of the Letter page in points is 792 × 612
*   [PageSize.LEDGER](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PageSize#LEDGER) - The size of the Ledger page in points is 1224 × 792
*   [PageSize.A0](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PageSize#A0) - The size of the A0 page in points is 3371 × 2384
*   [PageSize.A1](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PageSize#A1) - The size of the A1 page in points is 2384 × 1685
*   [PageSize.A2](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PageSize#A2) - The size of the A2 page in points is 1684 × 1190
*   [PageSize.A3](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PageSize#A3) - The size of the A3 page in points is 1190 × 842
*   [PageSize.A4](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PageSize#A4) - The size of the A4 page in points is 842 × 595

The following are the steps to set size for email message:

*   Create [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions), [JpgViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions), [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) or [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfViewOptions) object;
*   Set [setPageSize(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/EmailOptions#setPageSize(int)) value;
*   Call [view(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method.

```java
    Viewer viewer = new Viewer("sample.msg");
    PdfViewOptions viewOptions = new PdfViewOptions();
    viewOptions.getEmailOptions().setPageSize(PageSize.A4);
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