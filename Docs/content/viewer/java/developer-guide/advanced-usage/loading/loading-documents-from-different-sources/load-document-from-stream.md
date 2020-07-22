---
id: load-document-from-stream
url: viewer/java/load-document-from-stream
title: Load document from Stream
weight: 3
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---

There might be the case when your document is not physically located on the disk. Instead, you have the document in the form of a stream. In this case, to avoid the overhead of saving stream as a file on disk, [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) enables you to render the file streams directly.

The following are the steps to be followed:

* Specify the method to obtain document stream;
* Pass method's name to [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) class constructor.

Following code snippet serves this purpose.

```java
FileInputStream fileSteream = new FileInputStream("sample.docx");
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();

Viewer viewer = new Viewer(fileSteream);
viewer.view(viewOptions);
viewer.close();
```

## More resources

### GitHub Examples

You may easily run the code above and see the feature in action in our GitHub examples:

* [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)
* [GroupDocs.Viewer for Java examples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)
* [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-MVC)
* [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)
* [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)
* [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)

### Free Online App

Along with full featured Java library we provide simple, but powerful free Apps.  
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.
