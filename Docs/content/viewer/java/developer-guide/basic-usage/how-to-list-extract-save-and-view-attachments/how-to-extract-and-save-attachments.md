---
id: how-to-extract-and-save-attachments
url: viewer/java/how-to-extract-and-save-attachments
title: How to extract and save attachments
weight: 2
description: "This article will help you learn how to save attachments from PDF document, Outlook data file or email with file viewer by GroupDocs."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
You can save/export attachments from Email documents, Outlook data files, Archives and PDF documents with only a few lines of code using GroupDocs.Viewer for Java API.

Follow these steps to get and save (export) attachments:

*   Instantiate [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) object  for the file that contains attachment(s);
*   Call [getAttachments()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getAttachments()) method which will return document attachments collection;
*   Iterate through attachments collection and save attachment by calling [saveAttachment(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#saveAttachment(java.lang.String,%20java.io.OutputStream)) method.

Following example demonstrates on how to get and save attachments from MSG files.

```java
    String outputPath = "C:\\output";
    Viewer viewer = new Viewer("with_attachments.msg");
    List<Attachment> attachments = viewer.getAttachments();
    for (Attachment attachment : attachments) {
        String filePath = Path.combine(outputPath, attachment.getFileName());
        viewer.saveAttachment(attachment.getFileName(), new FileOutputStream(filePath));
    }
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