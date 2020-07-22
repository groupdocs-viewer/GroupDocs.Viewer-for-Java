---
id: get-file-information
url: viewer/java/get-file-information
title: Get file information
weight: 5
description: "This article explains how to detect document file type and calculate pages count when displaying file with GroupDocs.Viewer."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---

[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) for Java API allows you to extract file information from different document types through [ViewInfo](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.results/ViewInfo) class which will include following methods:

* [getFileType()](https://apireference.groupdocs.com/java/viewer/java/com.groupdocs.viewer.results/ViewInfo#getFileType())
* [getPages()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.results/ViewInfo#getPages())

For the following document types GroupDocs.Viewer provides additional information:

* Archive files - collection of folders inside archive (see [Get View Info for Archive File]({{< ref "get-view-info-for-archive-file.md" >}}));
* CAD drawings - collection of layouts and layers (see [Get View Info for CAD Drawing]({{< ref "get-view-info-for-cad-drawing.md" >}}));
* Outlook data files - collection of folders inside data file (see [Get View Info for Outlook Data File]({{< ref "get-view-info-for-outlook-data-file.md" >}}));
* PDF documents - flag that indicates whether document printing is allowed or not (see [Get View Info for PDF Document]({{< ref "get-view-info-for-pdf-document.md" >}}));
* MS Project documents - project start/end dates (see [Get View Info for MS Project Document]({{< ref "get-view-info-for-ms-project-document.md" >}})).

## Get file information for the file from local disk

```java
ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();

Viewer viewer = new Viewer("sample.pdf");
ViewInfo info = viewer.getViewInfo(viewInfoOptions);
viewer.close();

System.out.println("File type is: " + info.getFileType());
System.out.println("Pages count: " + info.getPages().size());
```

## Get file information for the file from stream

```java
ViewInfoOptions viewInfoOptions = ViewInfoOptions.forHtmlView();

FileInputStream fileStream = new FileInputStream("sample.pdf");

Viewer viewer = new Viewer(fileStream);
ViewInfo info = viewer.getViewInfo(viewInfoOptions);
viewer.close();

System.out.println("File type is: " + info.getFileType());
System.out.println("Pages count: " + info.getPages().size());
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
