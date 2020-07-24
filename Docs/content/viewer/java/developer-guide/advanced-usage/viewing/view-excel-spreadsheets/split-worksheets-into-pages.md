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
There might be the case when you do not want to render the whole Spreadsheet on a single page and limit the number of rows that would be rendered on each output page. In this situation, the [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) allows you to specify the number of rows in an Spreadsheet to be rendered on each page.

The following steps are required for partial rendering of large Excel sheets.

*   Instantiate the [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions), [JpgViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions), [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) or [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfViewOptions) object
*   Instantiate [SpreadsheetOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions) object by calling [forSplitSheetIntoPages(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions#forSplitSheetIntoPages(int)) method and specifying desired `countRowsPerPage` parameter.
*   Call [view(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method.

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