---
id: adjust-image-quality
url: viewer/java/adjust-image-quality
title: Adjust image quality
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) enables you to adjust quality of output images contained by the source PDF document. To adjust image quality use setter *htmlViewOptions.getPdfOptions().setImageQuality()*.

*getPdfOptions().setImageQuality()* can be set to:

*   *ImageQuality.Low* - The acceptable quality, best performance and least size of the output image.
*   *ImageQuality.Medium* - Better quality and slower performance.
*   *ImageQuality.High* - Best quality but slow performance.

NOTE: this option is supported when rendering to HTML only.

Following code snippet shows how to adjust image quality when rendering to HTML.

```java        
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
int quality = ImageQuality.Medium;
viewOptions.getPdfOptions().setImageQuality(quality);

Viewer viewer = new Viewer("sample.docx");
viewer.view(viewOptions);
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