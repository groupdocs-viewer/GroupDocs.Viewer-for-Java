---
id: pdf-viewer-protect-pdf-document
url: viewer/java/pdf-viewer-protect-pdf-document
title: PDF Viewer - Protect PDF document
weight: 2
description: "Check this guide and learn how to view protected PDF documents inside your Java application using PDF Viewer by GroupDocs."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) enables you to protect PDF document by setting permissions, password for opening and password for changing permissions.

The following steps are to be followed in order to set PDF document permissions.

*   Create a new instance of the [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) class and pass the source document path as a constructor parameter.
*   Initialize the instance of [Security](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/Security) class;
*   Call [setDocumentOpenPassword()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/Security#setDocumentOpenPassword(java.lang.String)) method if password is required to open PDF document;
*   Call [setPermissionsPassword()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/Security#setPermissionsPassword(java.lang.String)) method if it is required to change restrictions applied to PDF document; 
*   Call [setPermissions()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/Security#setPermissions(int)) method to specify exact permissions that should be applied to document;
*   Instantiate the [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions) object and specify saving path format for rendered document.
*   Initialize [Security](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/Security) property of [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions) with object created at previous steps;
*   Pass [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer.options/PdfViewOptions) object to [view()](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer#view(com.groupdocs.viewer.options.ViewOptions)) method of [Viewer](https://apireference.groupdocs.com/java/viewer/com.groupdocs.viewer/Viewer) class.

Following example demonstrates how to protect output PDF document.

```java
Security security = new Security();
security.setDocumentOpenPassword("o123");
security.setPermissionsPassword("p123");
security.setPermissions(Permissions.AllowAll ^ Permissions.DenyPrinting);

PdfViewOptions options = new PdfViewOptions("output.pdf");
options.setSecurity(security);

Viewer viewer = new Viewer("sample.docx");
viewer.view(options);
viewer.close();
```

## More resources
### Advanced Usage Topics
To learn more about document viewing features, please refer the [advanced usage section]({{< ref "viewer/java/developer-guide/advanced-usage/_index.md" >}}).

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
