---
id: skip-rendering-of-empty-columns
url: viewer/java/skip-rendering-of-empty-columns
title: Skip rendering of empty columns
weight: 5
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Background

Sometimes Excel document contains information at the beginning of the worksheet and after that, it contains some count of empty (blank) columns. In case, if the number of empty columns is considerably huge, the rendering time increases and hence, it affects the performance. 

## The Solution

To skip rendering of empty columns [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) provides setter *spreadsheetOptions.setSkipEmptyColumns()*, which allow omitting to render empty columns as shown in the sample below.

```java
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
viewOptions.getSpreadsheetOptions().setSkipEmptyColumns(true);
 
Viewer viewer = new Viewer("with_empty_column.xlsx");
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