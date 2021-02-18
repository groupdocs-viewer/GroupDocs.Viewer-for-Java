---
id: how-to-show-spreadsheet-column-and-row-headings
url: viewer/java/how-to-show-spreadsheet-column-and-row-headings
title: How to show spreadsheet column and row headings
weight: 2
description: "This article explains how to adjust text-overflow in cells when viewing Spreadsheets with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction

Excel worksheet columns and rows numeration are described by letters (A, B, C, etc.) for columns and by numbers (1, 2, 3, etc.) for rows, numeration is located in headings of Excel worksheet. The column headings are used to identify the column and row numbers are used to identify the row in the worksheet. The combination of the column letter and the row number (A1, D3, F7, etc.) is called cell reference and used to identify the cell in the worksheet. 

The column and row headings are highlighted in the following screenshot. 

![](viewer/java/images/how-to-show-spreadsheet-column-and-row-headings.png)

## Background

Let's take a sample workbook and open it with Excel. Then we'll process the same file with GroupDocs.Viewer and compare results.

The following screenshot shows the default spreadsheet view in Excel.

![](viewer/java/images/how-to-show-spreadsheet-column-and-row-headings_1.png)

When processing spreadsheets with [GroupDocs.Viewer](https://products.groupdocs.com/viewer) the row and column headings are not shown by default.

The following screenshot shows the default spreadsheet HTML view in a browser. 

![](viewer/java/images/how-to-show-spreadsheet-column-and-row-headings_2.png)

## How to show spreadsheet column and row headings

{{< alert style="danger" >}}This feature is supported when rendering worksheets into a single page when SpreadsheetOptions is set to SpreadsheetOptions.forOnePagePerSheet().{{< /alert >}}

To show of column and row headings in the output document you just need to set [setRenderHeadings(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions#setRenderHeadings(boolean)) property of [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions), [JpgViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions), [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) or [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfViewOptions) object to true

The following code sample shows how to enable rendering of column and row headings.

```java
    try (Viewer viewer = new Viewer("sample.xlsx")) {
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
        viewOptions.setSpreadsheetOptions(SpreadsheetOptions.forOnePagePerSheet());
        viewOptions.getSpreadsheetOptions().setRenderHeadings(true);
        viewer.view(viewOptions);
    }
```

When headings rendering is enabled, the spreadsheet HTML view in a browser will contain row and column headings as shown in the screenshot below.

![](viewer/java/images/how-to-show-spreadsheet-column-and-row-headings_3.png)

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