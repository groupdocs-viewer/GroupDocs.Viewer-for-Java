---
id: rename-email-fields
url: viewer/java/rename-email-fields
title: Rename email fields
weight: 2
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
When rendering email messages, by default the API uses the English language to render field labels such as From, To, Subject etc.. There might be the case when you want to change the label of the fields in email message's header.   
[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) is flexible enough to allow you to use the custom field labels for email header. The API provides a new setter *htmlViewOptions.getEmailOptions().setFieldTextMap()* to change the field labels.  
  
Following code sample shows how to use custom field labels.

```java
Map<Field, String> fieldTextMap = new HashMap<Field, String>();
fieldTextMap.put(Field.FROM, "Sender");
fieldTextMap.put(Field.TO, "Receiver");
fieldTextMap.put(Field.SENT, "Date");
fieldTextMap.put(Field.SUBJECT, "Topic");
 
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
viewOptions.getEmailOptions().setFieldTextMap(fieldTextMap);
 
Viewer viewer = new Viewer("simple-email.msg");
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