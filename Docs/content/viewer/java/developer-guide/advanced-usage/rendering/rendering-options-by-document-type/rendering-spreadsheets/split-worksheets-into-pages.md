---
id: split-worksheets-into-pages
url: viewer/java/split-worksheets-into-pages
title: Split worksheets into pages
weight: 7
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
There might be the case when you do not want to render the whole Spreadsheet on a single page and limit the number of rows that would be rendered on each output page. In this situation, the [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) allows you to specify the number of rows in an Spreadsheet to be rendered on each page.

The following steps are required for partial rendering of large Excel sheets.

*   Instantiate the *HtmlViewOptions* (or *PngViewOptions*, or *JpgViewOptions*, or *PdfViewOptions*) object
*   Instantiate *SpreadsheetOptions* object by calling *SpreadsheetOptions.forSplitSheetIntoPages()* method and specifying desired *countRowsPerPage* parameter.
*   Call *view* method.

```java
int countRowsPerPage = 45;
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
viewOptions.setSpreadsheetOptions(SpreadsheetOptions.forSplitSheetIntoPages(countRowsPerPage));
 
Viewer viewer = new Viewer("sample.xlsx");
viewer.view(viewOptions);
viewer.close();
```

## More resources
### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)    
*   [GroupDocs.Viewer for Java examples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)    
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-MVC)    
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
    
### Free Online App
Along with full featured Java library we provide simple, but powerful free Apps.  
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online  **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.