---
id: show-document-comments
url: viewer/java/show-document-comments
title: Show document comments
weight: 5
description: "This article explains how to show comments when viewing documents with GroupDocs.Viewer within your Java applications."
keywords: GroupDocs.Viewer for Java Show Comments
productName: GroupDocs.Viewer for Java
hideChildren: False
---
Some document types like Microsoft Word, Excel, OpenOffice Text and Spreadsheet may contain comments. Your requirement to include or exclude the comments in output representation of the document may vary in different situations. [GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) enables you to control the rendering of document comments.  
By default, comments are not rendered into the output document. The API provides [setRenderComments](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/BaseViewOptions#setRenderComments(boolean)) method of [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/HtmlViewOptions), [PngViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PngViewOptions),  [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/JpgViewOptions) or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions) class that enables rendering of comments.

This feature is supported for:

*   Microsoft Word documents
*   Spreadsheets
*   PDF documents
*   Presentations

The following code sample shows how to render documents with comments.

```java
HtmlViewOptions options = HtmlViewOptions.forEmbeddedResources();
options.setRenderComments(true);

Viewer viewer = new Viewer("with_comments.docx");
viewer.view(options);
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