---
id: how-to-convert-and-view-attachments
url: viewer/java/how-to-convert-and-view-attachments
title: How to convert and view attachments
weight: 1
description: "Follow this guide and learn how to view or preview PDF document, Outlook data file or email attachments with file viewer by GroupDocs."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
View email/file attachments in the same way as you would view any other documents.

There are many different use cases when you need to view/preview attachments form an emails, save attachments to specific location, parse or extract attachments. So we made this process easy and simple with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) API.

[GroupDocs.Viewer](https://products.groupdocs.com/viewer) supports attachments from following formats:

*   Email attachments
*   Outlook attachments
*   Archives
*   PDF

To view attachments just follow steps below:

*   Instantiate [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) object for the file that contains attachment(s);
*   Call [saveAttachment(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#saveAttachment(java.lang.String,%20java.io.OutputStream)) method and save attachment (to local disk, memory stream, etc);
*   Instantiate new [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) object with previously saved attachment;
*   Specify view options depending on desired output format - [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions) / [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) / [JpgViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions) / [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfViewOptions);
*   Call [view(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method.

Following code snippet demonstrates on how to view attachments from MSG file.

```java
    ByteArrayOutputStream attachmentStream = new ByteArrayOutputStream();

    Viewer viewer = new Viewer("sample.msg");
    viewer.saveAttachment("attachment-word.doc", attachmentStream);
    viewer.close();
    
    Viewer viewer = new Viewer(new ByteArrayInputStream(attachmentStream.toByteArray()));
    HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources();
    viewer.view(options);
    viewer.close();
```

{{< alert style="info" >}}NOTE: provided code example is actual for all document types that support attachments - Email documents, Outlook data files, Archives and PDF documents.{{< /alert >}}

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