---
id: load-password-protected-document
url: viewer/java/load-password-protected-document
title: Load password-protected document
weight: 2
description: "This article explains how to load password-protected document with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---

The encryption is used to protect data and allow only authorized persons to open the file. When a file is encrypted, the passwords must be specified to open the file. [GroupDocs.Viewer](https://products.groupdocs.com/viewer) supports rendering documents that are protected with a password. To learn how to check if the file is encrypted please refer to [How to check if file is encrypted]({{< ref "how-to-check-if-file-is-encrypted.md" >}}) documentation article.

The following are the steps to render password-protected documents.

*   Instantiate the [LoadOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/LoadOptions) object;
*   Set password in [setPassword(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/LoadOptions#setPassword(java.lang.String)) property;
*   Instantiate the [Viewer](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer) with created [LoadOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/LoadOptions) object
*   Call [view(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method with parameters that you need.

The following code sample shows how to render password-protected documents.

```java
    LoadOptions loadOptions = new LoadOptions();
    loadOptions.setPassword("123456");

    try (Viewer viewer = new Viewer("sample.docx", loadOptions)) {
        HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
        viewer.view(viewOptions);
    }
```

{{< alert style="info" >}}
In case the password is not specified [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) will throw [PasswordRequiredException](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.exception/PasswordRequiredException).
{{< /alert >}}

## More resources
### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Viewer for Java examples, plugins, and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java)
*   [Document Viewer for .NET App WebForms UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET-WebForms)    
*   [Document Viewer for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Dropwizard)    
*   [Document Viewer for Java Spring UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-Spring)
*   [GroupDocs.Viewer for .NET samples, plugins and showcase](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-.NET)
*   [Document Viewer for .NET MVC UI Example](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java-MVC)     

### Free Online App
Along with full-featured Java library we provide simple but powerful free Apps.
You are welcome to view Word, PDF, Excel, PowerPoint documents with free to use online **[GroupDocs Viewer App](https://products.groupdocs.app/viewer)**.