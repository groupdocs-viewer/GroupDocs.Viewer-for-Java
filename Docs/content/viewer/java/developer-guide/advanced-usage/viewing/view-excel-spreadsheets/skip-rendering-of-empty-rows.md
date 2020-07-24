---
id: skip-rendering-of-empty-rows
url: viewer/java/skip-rendering-of-empty-rows
title: Skip rendering of empty rows
weight: 7
description: "This article explains how to hide empty rows when viewing Spreadsheets with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
This article explains how to hide empty rows when viewing Spreadsheets with [GroupDocs.Viewer](https://products.groupdocs.com/viewer) within your Java applications.

## Introduction

Sometimes Excel document contains information at the beginning of the worksheet and after that, it contains some count of empty (blank) rows. In case, if the number of empty rows is considerably huge, the rendering time increases and hence, it affects the performance. 

## The Solution

To skip rendering of empty rows [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) provides [setSkipEmptyRows(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions#setSkipEmptyRows(boolean)) property of [SpreadsheetOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/SpreadsheetOptions) class, which allows to omit rendering empty rows as shown in the sample below:

```java
    Viewer viewer = new Viewer("sample.xlsx");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.getSpreadsheetOptions().setSkipEmptyRows(true);
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