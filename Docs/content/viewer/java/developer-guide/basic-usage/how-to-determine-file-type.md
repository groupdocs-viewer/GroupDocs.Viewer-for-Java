---
id: how-to-determine-file-type
url: viewer/java/how-to-determine-file-type
title: How to determine file type
weight: 4
description: "This article explains how to get a type of a file with GroupDocs.Viewer for Java using Java / C#."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
## Introduction
**File type** or **file format** is the way to classify and differentiate one kind of file from another. For example, Microsoft Excel and Adobe PDF are two different **file types**. The common way to determine the file type is by its extension, so when you have a file e.g. sample.docx you expect that this file will be opened by some text processing application like Microsoft Word. But there are the cases when you don't know the file type e.g. when the file came from the Internet but you don't know its name or filename doesn't have an extension.

## Determining file type
**GroupDocs.Viewer** enables you to determine the file type by file extension, media-type, or raw bytes. The code snippets provided in this article can also be found in [our public examples at GitHub.](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/blob/master/Examples/GroupDocs.Viewer.Examples.CSharp/HowTo/HowToDetermineFileType.cs)

### Determining file-type from the file extension
To determine file type from the file extension use [FromExtension()](https://apireference.groupdocs.com/viewer/java/groupdocs.viewer/filetype/methods/fromextension) method of [FileType](https://apireference.groupdocs.com/viewer/java/groupdocs.viewer/filetype) class.

```java
    String extension = ".docx";
    FileType fileType = FileType.fromExtension(extension);
    System.out.println("\nExtension " + extension + "; File type: " + fileType + ".");
```

As you can see from the screenshot below the file type detected correctly.
![](viewer/java/images/how-to-determine-file-type.png)

A similar output would be printed in case of [GroupDocs.Viewer](https://products.groupdocs.com/viewer) detected the file type successfully.
![](viewer/java/images/how-to-determine-file-type_2.png)

## More resources
### GitHub Examples 
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for Java examples, plugins, and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-MVC)    
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-WebForms)
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
    
### Free Online App 
Along with full-featured Java library we provide simple but powerful free Apps.
You are welcome to view your documents with free to use online [GroupDocs Viewer App](https://products.groupdocs.app/viewer).