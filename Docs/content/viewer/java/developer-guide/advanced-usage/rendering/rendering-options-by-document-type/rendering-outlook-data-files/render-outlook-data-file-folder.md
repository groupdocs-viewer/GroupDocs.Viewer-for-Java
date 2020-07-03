---
id: render-outlook-data-file-folder
url: viewer/java/render-outlook-data-file-folder
title: Render Outlook Data File Folder
weight: 4
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) renders messages from all folders (including nested folders) by default. When you need to render items from a specific folder, use setter *htmlViewOptions.getOutlookOptions()setFolder()* as shown in the example below. Please note that you should use the following convention for naming folders and subfolders to specify it in *FolderName* option: *{Parent folder name}\\\\{Sub folder name}*. Thus, if you need to render items from Inbox folder just specify `Folder = "Inbox";` when you need to render subfolder named "Orion" that resides in a folder named "Urgent" that in turn resides in Inbox, set: set `Folder("Inbox\\Urgent\\Orion").` 

The following code samples show how to use this option for rendering:

```java
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
viewOptions.getOutlookOptions().setFolder("Inbox\\SubFolder\\SubFolder2");
 
Viewer viewer = new Viewer("subfolders.ost");
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