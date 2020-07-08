---
id: split-worksheets-into-pages
url: viewer/java/split-worksheets-into-pages
title: Split worksheets into pages
weight: 8
description: "This article explains how to split worksheets into pages when viewing Spreadsheets with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
There might be the case when you do not want to render the whole Spreadsheet on a single page and limit the number of rows that would be rendered on each output page. In this situation, the [GroupDocs.Viewer](https://products.groupdocs.com/viewer) allows you to specify the number of rows in an Spreadsheet to be rendered on each page.

The following steps are required for partial rendering of large Excel sheets.

*   Instantiate the [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/htmlviewoptions) (or [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/jpgviewoptions), or [PngViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pngviewoptions), or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions)) object
*   Instantiate [SpreadsheetOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/spreadsheetoptions) object by calling [SpreadsheetOptions.ForSplitSheetIntoPages](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/spreadsheetoptions/methods/forsplitsheetintopages) method and specifying desired *countRowsPerPage* parameter.
*   Call [View](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer/methods/view) method.

```java
    Viewer viewer = new Viewer("sample.xlsx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.setSpreadsheetOptions(SpreadsheetOptions.forSplitSheetIntoPages(45));
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