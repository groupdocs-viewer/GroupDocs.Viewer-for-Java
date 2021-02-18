---
id:  how-to-convert-and-view-excel-spreadsheetml-files
url: viewer/java/how-to-convert-and-view-excel-spreadsheetml-files
title: How to convert and view Excel 2003 SpreadSheetML files
weight: 2
description: "In this article we show how to convert and view Excel 2003 SpreadSheetML files with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction

SpreadsheetML is Excel 2003 document format in XML file. It can be opened by Microsoft Excel 2003 or later applications.

![ExcelSpreadSheetML opened in Excel](viewer/java/images/how-to-convert-and-view-excel-spreadsheetml-files/spreadsheetml-in-excel.png)

## How to convert Excel 2003 SpreadSheetML files

### Convert Excel 2003 SpreadSheetML to HTML

To convert Excel 2003 SpreadSheetML files to HTML with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    try (Viewer viewer = new Viewer("sample-excel-2003-xml.xml", new LoadOptions(FileType.Excel2003XML))) {
       HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources("output.html");
       viewer.view(options);
    }
```

The following screenshot shows the output HTML file opened in a browser.

![HTML converted Excel 2003 SpreadSheetML](viewer/java/images/how-to-convert-and-view-excel-spreadsheetml-files/spreadsheetml-in-html.png)

### Convert Excel 2003 SpreadSheetML to JPG

To convert Excel 2003 SpreadSheetML files to JPG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    try (Viewer viewer = new Viewer("sample-excel-2003-xml.xml", new LoadOptions(FileType.Excel2003XML))) {
       JpgViewOptions options = new JpgViewOptions("output.jpg");
       viewer.view(options);
    }
```

The following screenshot shows the output JPG file opened in a Windows Photo Viewer application.

![JPEG converted Excel 2003 SpreadSheetML](viewer/java/images/how-to-convert-and-view-excel-spreadsheetml-files/spreadsheetml-in-jpg.png)

### Convert Excel 2003 SpreadSheetML to PNG

To convert Excel 2003 SpreadSheetML files to PNG with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    try (Viewer viewer = new Viewer("sample-excel-2003-xml.xml", new LoadOptions(FileType.Excel2003XML))) {
       PngViewOptions options = new PngViewOptions("output.png");
       viewer.view(options);
    }
```

The following screenshot shows the output PNG file opened in a Windows Photo Viewer application.

![PNG converted Excel 2003 SpreadSheetML](viewer/java/images/how-to-convert-and-view-excel-spreadsheetml-files/spreadsheetml-in-png.png)

### Convert Excel 2003 SpreadSheetML to PDF

To convert Excel 2003 SpreadSheetML files to PDF with [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) use following code:

```java
    try (Viewer viewer = new Viewer("sample-excel-2003-xml.xml", new LoadOptions(FileType.Excel2003XML))) {
       PdfViewOptions options = new PdfViewOptions("output.pdf");
       viewer.view(options);
    }
```

The following screenshot shows the output PDF file opened in an Acrobat Reader.

![PDF converted Excel 2003 SpreadSheetML](viewer/java/images/how-to-convert-and-view-excel-spreadsheetml-files/spreadsheetml-in-pdf.png)

## More resources
### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for Java examples, plugins, and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-MVC)     

### Free Online App
Along with full-featured Java library we provide simple but powerful free Apps.
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.