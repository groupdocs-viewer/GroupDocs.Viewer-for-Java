---
id: render-print-areas
url: viewer/java/render-print-areas
title: Render print areas
weight: 5
description: "This article explains how to view Spreadsheet print areas with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
This article explains how to view Spreadsheet print areas with [GroupDocs.Viewer](https://products.groupdocs.com/viewer) within your Java applications.

## Introduction

Spreadsheet document allows to set a print area if you want to print a specific section on a worksheet. There can be the case when you want to render only the print area of the worksheet using GroupDocs.Viewer. 

![](viewer/java/images/render-print-areas.png)

## The Solution

[GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides an option to render sections of the worksheet(s) defined as the "print area". It renders each print area in a worksheet as a separate page. The following code samples show how to render only the print areas from worksheets.

```java
    Viewer viewer = new Viewer("sample.xlsx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.setSpreadsheetOptions(SpreadsheetOptions.forRenderingPrintArea());
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