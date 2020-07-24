---
id: how-to-list-extract-save-and-view-attachments
url: viewer/java/how-to-list-extract-save-and-view-attachments
title: How to list extract save and view attachments
weight: 6
description: "This documentation section describes how process attachments using Java / C# with GroupDocs.Viewer for Java."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Processing attachments

Some files such as Email documents, Outlook data files, Archives and PDF documents may contain attachments, those attachments can be viewed, extracted or printed with help of [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) API.

In order to access document attachment use [getAttachments()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getAttachments()) method of [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) object. Just follow steps below:

*   Instantiate [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) object for the file that contains attachment(s);
*   Call [getAttachments()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#getAttachments()) method which will return document attachments collection;
*   Process attachments according to your needs (print a list of attachment names, save or view attachments, etc.)

See following examples on how to process document attachments in more details: [How to convert and view attachments]({{< ref "viewer/java/developer-guide/basic-usage/how-to-list-extract-save-and-view-attachments/how-to-convert-and-view-attachments.md" >}}), [How to extract and save attachments]({{< ref "viewer/java/developer-guide/basic-usage/how-to-list-extract-save-and-view-attachments/how-to-extract-and-save-attachments.md" >}}) and [How to list attachments]({{< ref "viewer/java/developer-guide/basic-usage/how-to-list-extract-save-and-view-attachments/how-to-list-attachments.md" >}})

## More resources
### Advanced Usage Topics
To learn more about document viewing features, please refer to the [advanced usage section]({{< ref "viewer/java/developer-guide/advanced-usage/_index.md" >}}).

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