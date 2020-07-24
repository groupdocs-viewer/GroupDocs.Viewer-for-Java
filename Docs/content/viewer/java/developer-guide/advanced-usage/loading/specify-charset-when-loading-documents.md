---
id: specify-charset-when-loading-documents
url: viewer/java/specify-charset-when-loading-documents
title: Specify charset when loading documents
weight: 3
description: "This article explains how to set charset when loading documents with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer) enables users to pass charset when rendering text documents or email messages.

This feature is supported for:

*   [Plain-text (.txt) files](https://wiki.fileformat.com/word-processing/txt/)
*   [Comma-separated values (.csv)](https://wiki.fileformat.com/spreadsheet/csv/) 
*   [Tab-separated values (.tsv)](https://wiki.fileformat.com/spreadsheet/tsv/)
*   [E-Mail Message (.eml)](https://wiki.fileformat.com/email/eml/)

Following code snippet sets the document charset.

```java
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setCharset(Charset.forName("windows-1251"));

        Viewer viewer = new Viewer("sample.txt", loadOptions);
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
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