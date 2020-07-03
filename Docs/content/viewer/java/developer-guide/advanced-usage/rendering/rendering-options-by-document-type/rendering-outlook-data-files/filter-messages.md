---
id: filter-messages
url: viewer/java/filter-messages
title: Filter messages
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
MS Outlook allows to filter messages inside folders by some text value from message content and by part of the sender's or recipient's address.

[GroupDocs.Viewer](https://products.groupdocs.com/viewer/java) also allows filtering the rendered messages using the following filters:

*   Filter by subject and content using *outlookOptions.setTextFilter()*
*   Filter by the sender's and recipient's email addresses using *outlookOptions.setAddressFilter()*

As an example, when setting *htmlViewOptions.getOutlookOptions().setTextFilter()* as 'Microsoft' the API will render all messages that contain the text 'Microsoft' in the message's subject or body. Whereas, setting *htmlViewOptions.getOutlookOptions().setAddressFilter()* as 'susan' will filter messages that contain 'susan' as a part of the sender's or recipient's address. The following code samples show how to filter the messages.

```java
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources("page_{0}.html");
viewOptions.getOutlookOptions().setTextFilter("Microsoft");
viewOptions.getOutlookOptions().setAddressFilter("susan");
 
Viewer viewer = new Viewer("sample.ost");
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