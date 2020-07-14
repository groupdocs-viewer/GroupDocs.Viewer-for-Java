---
id: specify-file-type-when-loading-a-document
url: viewer/java/specify-file-type-when-loading-a-document
title: Specify file type when loading a document
weight: 1
description: "This article explains how to set the file type when loading a document with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
When passing file path into [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class constructor the [GroupDocs.Viewer](https://products.groupdocs.com/viewer) determines file type by file extension but when file passed as [InputStream](https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html) the [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) tries to detect file type by file signature or file content and this may affect application performance. The API enables you to specify the file type of the processing document by passing [LoadOptions ](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/LoadOptions) object as the second parameter of [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) class constructor. When you're passing file type it instructs [GroupDocs.Viewer](https://products.groupdocs.com/viewer) to skip file type detection feature and proceed with rendering.

The following code sample shows how to pass the file type when loading a document.

```java
   LoadOptions loadOptions = new LoadOptions(FileType.DOCX);

   Viewer viewer = new Viewer(new FileInputStream("sample.docx"), loadOptions);
   HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
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