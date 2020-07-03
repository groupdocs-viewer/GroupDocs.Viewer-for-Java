---
id: adjust-text-overflow-in-cells
url: viewer/java/adjust-text-overflow-in-cells
title: Adjust text overflow in cells
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Background

When Spreadsheet is rendered overflowed text inside the cell overlays subsequent cells until it meets non-empty cell. [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) provides a setting to configure the mode which will be used for rendering overflowed text:

1.  To set the overflowed text to be hidden, use setter *htmlViewOptions.getSpreadsheetOptions().setTextOverflowMode()* (or *pngViewOptions*, or *jpgViewOptions*, or *pdfViewOptions*) to *TextOverflowMode.HideText* as shown in the example below.
2.  To set the overflowed text to overlay subsequent cells untill it meets non empty cell, use setter *htmlViewOptions.getSpreadsheetOptions().setTextOverflowMode()* (or *PngViewOptions*, or *JpgViewOptions*, or *pdfViewOptions*) to *TextOverflowMode.OverlayIfNextIsEmpty*.   
    This is a default value of the *SpreadsheetOptions.TextOverflowMode*.
3.  To set the overflowed text to overlay subsequent cells even they are not empty, use setter *htmlViewOptions.getSpreadsheetOptions().setTextOverflowMode()* (or *PngViewOptions*, or *JpgViewOptions*, or *pdfViewOptions*)to *TextOverflowMode.Overlay*.
4.  To expand the cell width to fit overflowed text, use setter *htmlViewOptions.getSpreadsheetOptions().setTextOverflowMode()* of *htmlViewOptions* (or *PngViewOptions*, or *JpgViewOptions*, or *pdfViewOptions*) to *TextOverflowMode.AutoFitColumn*. 

## Adjust text overflow in cells

The following steps are required to manage text-overflow:

*   Instantiate the *HtmlViewOptions* (or *PngViewOptions*, or *JpgViewOptions*, or *PdfViewOptions*) object;
*   Use setter *htmlViewOptions.getSpreadsheetOptions().setTextOverflowMode()* to *TextOverflowMode.HideText;*
*   Call *view()* method.

The following code sample shows how to hide text in case it overflows cell.

```java
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
        viewOptions.getSpreadsheetOptions().setTextOverflowMode(TextOverflowMode.HideText);
 
        Viewer viewer = new Viewer("sample.xlsx");
        viewer.view(viewOptions);
        viewer.close();
```

## More resources
### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)    
*   [GroupDocs.Viewer for Java examples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)    
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-MVC)    
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
    
### Free Online App
Along with full featured Java library we provide simple, but powerful free Apps.  
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online  **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.