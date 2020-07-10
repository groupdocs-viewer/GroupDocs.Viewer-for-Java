---
id: document-viewer-pdf-viewer
url: viewer/java/document-viewer-pdf-viewer
title: Document viewer - PDF Viewer
weight: 3
description: "Following this guide you will to learn how to display documents of more than 100 types in PDF format with PDF Viewer by GroupDocs."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: True
---  
Document viewer can operate in different rendering modes, HTML, Image and PDF (see [Features Overview]({{< ref "viewer/java/getting-started/features-overview.md" >}}) for more information).

This article will describe on how to view documents in PDF mode with PDF Viewer. When rendering to PDF format with [GroupDocs.Viewer](https://products.groupdocs.com/viewer), it saves all pages of source document as a single target PDF document.  
Here are the steps for rendering to PDF with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java):
*   Create new instance of [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class and pass source document path as a constructor parameter.    
*   Instantiate the [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfViewOptions) object and specify saving path format for rendered document.    
*   Call [view(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method of [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class instance and pass [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfViewOptions) to it.    

The following code sample shows how to get **PDF** representation of the document.

```java
    Viewer viewer = new Viewer("sample.docx");
    PdfViewOptions viewOptions = new PdfViewOptions();
    viewer.view(viewOptions);
```

{{< alert style="info" >}}[GroupDocs.Viewer](https://products.groupdocs.com/viewer) also provides an ability to customize rendering to PDF by setting additional options. To learn more about caching customization please refer to the following guides: [PDF Viewer - Adjust quality for JPG images]({{< ref "viewer/java/developer-guide/basic-usage/document-viewer-pdf-viewer/pdf-viewer-adjust-quality-for-jpg-images.md" >}}) and [PDF Viewer - Protect PDF document]({{< ref "viewer/java/developer-guide/basic-usage/document-viewer-pdf-viewer/pdf-viewer-protect-pdf-document.md" >}}){{< /alert >}}

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