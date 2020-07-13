---
id: adjust-text-overflow-in-cells
url: viewer/java/adjust-text-overflow-in-cells
title: Adjust text overflow in cells
weight: 1
description: "This article explains how to adjust text-overflow in cells when viewing Spreadsheets with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
This article explains how to adjust text-overflow in cells when viewing Spreadsheets with [GroupDocs.Viewer](https://products.groupdocs.com/viewer) within your Java applications.

## Introduction

![](viewer/java/images/adjust-text-overflow-in-cells.png)

When Spreadsheet is rendered overflowed text inside the cell overlays subsequent cells until it meets non-empty cell. [GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides a setting to configure the mode which will be used for rendering overflowed text:

1.  To set the overflowed text to be hidden, set [setTextOverflowMode(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions#setTextOverflowMode(int)) of [SpreadsheetOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions)  class to [TextOverflowMode.HIDE_TEXT](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/TextOverflowMode#HIDE_TEXT) as shown in the example below.
2.  To set the overflowed text to overlay subsequent cells until it meets non empty cell, set [setTextOverflowMode(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions#setTextOverflowMode(int)) of [SpreadsheetOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions) object to [TextOverflowMode.OVERLAY_IF_NEXT_IS_EMPTY](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/TextOverflowMode#OVERLAY_IF_NEXT_IS_EMPTY). This is a default value.
3.  To set the overflowed text to overlay subsequent cells even they are not empty, set [setTextOverflowMode(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions#setTextOverflowMode(int)) of [SpreadsheetOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions) object to [TextOverflowMode.OVERLAY](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/TextOverflowMode#OVERLAY).
4.  To expand the cell width to fit overflowed text, set [setTextOverflowMode(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions#setTextOverflowMode(int)) of [SpreadsheetOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions) object to [TextOverflowMode.AUTO_FIT_COLUMN](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/TextOverflowMode#AUTO_FIT_COLUMN). 

NOTE: The same workflow is applicable for [JpgViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions), [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions), and [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfViewOptions) classes;

## How to adjust text overflow in cells 

The following steps are required to manage text-overflow:

*   Instantiate the [HtmlViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/HtmlViewOptions), [JpgViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/JpgViewOptions), [PngViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PngViewOptions) or [PdfViewOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/PdfViewOptions) object;
*   Set [setTextOverflowMode(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions#setTextOverflowMode(int)) of [SpreadsheetOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions) to [TextOverflowMode.HIDE_TEXT](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/TextOverflowMode#HIDE_TEXT)
*   Call [view(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method.

The following code sample shows how to hide text in case it overflows cell.

```java
    Viewer viewer = new Viewer("sample.xlsx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.getSpreadsheetOptions().setTextOverflowMode(TextOverflowMode.HIDE_TEXT);
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