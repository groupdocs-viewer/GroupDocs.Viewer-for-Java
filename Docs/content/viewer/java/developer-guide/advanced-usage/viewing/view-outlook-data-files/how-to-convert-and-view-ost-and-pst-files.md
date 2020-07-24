---
id: how-to-convert-and-view-ost-and-pst-files
url: viewer/java/how-to-convert-and-view-ost-and-pst-files
title: How to convert and view OST and PST files
weight: 2
description: "This article explains how to filter messages when viewing Outlook Data Files with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction
OST (Offline Storage Table) and PST (Personal Storage Table) are formats of Personal Folder File (PFF). Both formats contains e-mail messages, contacts and appoitments.  

* PST files - contain data of user personal Outlook folders  
* OST files - contain data, that downloaded from Exchange Server.

## View OST and PST files
The OST/PST can be opened with Microsoft Outlook.
In case you need to view a PST/OST file in a browser or in a standard image or PDF viewer application, you can convert it to HTML, JPEG, PNG  PDF format with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java). 
![](viewer/java/images/how-to-convert-and-view-ost-and-pst-files.png)

### Convert OST and PST to HTML
To convert OST and PST files to HTML with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:
```java
    Viewer viewer = new Viewer("sample.pst");
    HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("output.html");

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output HTML file opened in a browser.
![](viewer/java/images/how-to-convert-and-view-ost-and-pst-files_1.png)

### Convert OST and PST to JPG
To convert OST and PST files to JPG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 
```java
    Viewer viewer = new Viewer("sample.pst");
    JpgViewOptions options = new JpgViewOptions("output.jpg");

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output JPG file opened in a Windows Photo Viewer application.
![](viewer/java/images/how-to-convert-and-view-ost-and-pst-files_2.png)

### Convert OST and PST to PNG
To convert OST and PST files to PNG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 
```java
    Viewer viewer = new Viewer("sample.pst");
    PngViewOptions options = new PngViewOptions("output.png");

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PNG file opened in a Windows Photo Viewer application.
![](viewer/java/images/how-to-convert-and-view-ost-and-pst-files_3.png)

### Convert OST and PST files to PDF
To convert OST/PST files to PDF with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code: 
```java
    Viewer viewer = new Viewer("sample.pst");
    PdfViewOptions options = new PdfViewOptions("output.pdf");

    viewer.view(options);
    viewer.close();
```

The following screenshot shows the output PDF file opened in a browser.
![](viewer/java/images/how-to-convert-and-view-ost-and-pst-files_4.png)

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
You are welcome to view your documents with free to use online [GroupDocs Viewer App](https://products.groupdocs.app/viewer).
