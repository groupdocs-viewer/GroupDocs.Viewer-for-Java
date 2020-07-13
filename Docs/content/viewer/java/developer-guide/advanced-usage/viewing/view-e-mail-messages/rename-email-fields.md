---
id: rename-email-fields
url: viewer/java/rename-email-fields
title: Rename email fields
weight: 2
description: "This article explains how to translate fields when viewing E-Mail Messages with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
When rendering email messages, by default the API uses the English language to render field labels such as `From`, `To`, `Subject` etc. There might be the case when you want to change the label of the fields in email message's header.  
[GroupDocs.Viewer](https://products.groupdocs.com/viewer) is flexible enough to allow you to use the custom field labels for email header. The API provides a new property [getFieldTextMap()](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/EmailOptions#getFieldTextMap()) in [EmailOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/EmailOptions) class to change the field labels.  
  
Following code sample shows how to use custom field labels.

```java
    Viewer viewer = new Viewer("sample.msg");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
    viewOptions.getEmailOptions().getFieldTextMap().put(Field.FROM, "Sender");
    viewOptions.getEmailOptions().getFieldTextMap().put(Field.TO, "Receiver");
    viewOptions.getEmailOptions().getFieldTextMap().put(Field.SENT, "Date");
    viewOptions.getEmailOptions().getFieldTextMap().put(Field.SUBJECT, "Topic");
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