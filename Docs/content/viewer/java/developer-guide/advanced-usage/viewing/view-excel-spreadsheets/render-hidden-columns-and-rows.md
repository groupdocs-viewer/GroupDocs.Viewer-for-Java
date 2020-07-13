---
id: render-hidden-columns-and-rows
url: viewer/java/render-hidden-columns-and-rows
title: Render hidden columns and rows
weight: 4
description: "This article explains how to show hidden rows and cells when viewing Spreadsheets with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
This article explains how to show hidden rows and cells when viewing Spreadsheets with [GroupDocs.Viewer](https://products.groupdocs.com/viewer) within your Java applications.

## Background

Sometimes Excel document may contain hidden columns and rows (as shown in the image below). [GroupDocs.Viewer](https://products.groupdocs.com/viewer) doesn't render hidden columns and rows by default. However, there may be the case when you want to control the inclusion of hidden content in the rendering results. 

![](viewer/java/images/render-hidden-columns-and-rows.png)

## The Solution

[GroupDocs.Viewer](https://products.groupdocs.com/viewer) provides [setRenderHiddenRows(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions#setRenderHiddenRows(boolean)) and [setRenderHiddenColumns(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions#setRenderHiddenColumns(boolean)) options in [SpreadsheetOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions) class which enables rendering hidden rows and columns as shown in the following code samples. 

```java
    Viewer viewer = new Viewer("sample.xlsx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.getSpreadsheetOptions().setRenderHiddenColumns(true);
    viewOptions.getSpreadsheetOptions().setRenderHiddenRows(true);
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