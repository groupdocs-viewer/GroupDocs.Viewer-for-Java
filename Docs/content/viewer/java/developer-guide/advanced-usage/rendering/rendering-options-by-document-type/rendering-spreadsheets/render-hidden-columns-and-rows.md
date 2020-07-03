---
id: render-hidden-columns-and-rows
url: viewer/java/render-hidden-columns-and-rows
title: Render hidden columns and rows
weight: 3
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Background

Sometimes Excel documents may contain hidden columns and rows. [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) doesn't render hidden columns and rows by default. However, there may be the case when you want to control the inclusion of hidden content in the rendering results. 

## The Solution

*GroupDocs.Viewer* provides setters *setRenderHiddenRows()* and *setRenderHiddenColumns()* in *SpreadsheetOptions* class which enables rendering hidden rows and columns as shown in the following code samples. 

```java
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
viewOptions.getSpreadsheetOptions().setRenderHiddenColumns(true);
viewOptions.getSpreadsheetOptions().setRenderHiddenRows(true);
 
Viewer viewer = new Viewer("hidden_rows_and_columns.xlsx");
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