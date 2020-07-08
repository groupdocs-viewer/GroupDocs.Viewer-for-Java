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
[GroupDocs.Viewer](https://products.groupdocs.com/viewer) enables you to protect PDF document by setting permissions, password for opening and password for changing permissions.

The following steps are to be followed in order to set PDF document permissions.

*   Create a new instance of the [Viewer](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer) class and pass the source document path as a constructor parameter.
*   Initialize the instance of [Security](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/security) class;
*   Set [DocumentOpenPassword](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/security/properties/documentopenpassword) property if password is required to open PDF document;
*   Set [PermissionsPassword](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/security/properties/permissionspassword) property if it is required to change restrictions applied to PDF document; 
*   Set [Permissions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/permissions) property to specify exact permissions that should be applied to document;
*   Instantiate the [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions) object and specify saving path format for rendered document.
*   Initialize [Security](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions/properties/security) property of [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions) with object created at previous steps;
*   Pass [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions) object to [View](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer/methods/view) method of [Viewer](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer) class.

Following example demonstrates how to protect output PDF document.

```java
    Viewer viewer = new Viewer("sample.docx");
    Security security = new Security();
    security.setDocumentOpenPassword("o123");
    security.setPermissionsPassword("p123");
    security.setPermissions(Permissions.ALLOW_ALL ^ Permissions.DENY_PRINTING);

    PdfViewOptions viewOptions = new PdfViewOptions(filePath);
    viewOptions.setSecurity(security);

    viewer.view(viewOptions);
    viewer.close();
```

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
