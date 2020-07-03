---
id: pdf-viewer-adjust-quality-for-jpg-images
url: viewer/java/pdf-viewer-adjust-quality-for-jpg-images
title: PDF Viewer - Adjust quality for JPG images
weight: 1
description: "Check this guide and learn how to adjust JPG images quality and size when displaying documents with PDF Viewer by GroupDocs."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
When rendering documents to PDF format that contains JPG images it may be reasonable to reduce size of the output file by adjusting quality of the JPG images. [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) enables you to adjust quality of images in the output PDF document with [setJpgQuality()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions#setJpgQuality(byte)) method of [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions) class. The supported values range of [setJpgQuality()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions#setJpgQuality(byte)) is from 1 to 100. Default value is 90.

The following steps are to be followed in order to set image quality.

*   Initialize the object of [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions);
*   Set [PdfViewOptions.setJpgQuality()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions#setJpgQuality(byte)) value;
*   Pass [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions) object to *View* function.

The following code sample shows how to adjust JPG image quality in the output PDF document.

```java 			
PdfViewOptions options = new PdfViewOptions("output.pdf");
options.setJpgQuality((byte)10);

Viewer viewer = new Viewer("with_jpg_image.docx");
viewer.view(options);
viewer.close();
```

## More resources
### Advanced Usage Topics
To learn more about document viewing features, please refer the [advanced usage section]({{< ref "viewer/java/developer-guide/advanced-usage/_index.md" >}}).

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
