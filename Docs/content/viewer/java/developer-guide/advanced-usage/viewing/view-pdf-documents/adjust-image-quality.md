---
id: adjust-image-quality
url: viewer/java/adjust-image-quality
title: Adjust image quality
weight: 1
description: "This article explains how to adjust image quality when viewing PDF Documents with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer) enables you to adjust quality of output images contained by the source PDF document. To adjust image quality use [setImageQuality(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfOptions#setImageQuality(int)) option of [PdfOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfOptions) class ([getPdfOptions()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/BaseViewOptions#getPdfOptions()) of [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions) class).

[setImageQuality(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfOptions#setImageQuality(int)) can be set to:

*   [ImageQuality.LOW](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/ImageQuality#Low) - Best quality but slow performance.
*   [ImageQuality.MEDIUM](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/ImageQuality#Medium) - Better quality and slower performance.
*   [ImageQuality.HIGH](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/ImageQuality#High) - The acceptable quality, best performance and least size of the output image.

NOTE: this option is supported when rendering to HTML only.

Following code snippet shows how to adjust image quality when rendering to HTML.

```java
    Viewer viewer = new Viewer("sample.docx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.getPdfOptions().setImageQuality(ImageQuality.MEDIUM);

    viewer.view(viewOptions);
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