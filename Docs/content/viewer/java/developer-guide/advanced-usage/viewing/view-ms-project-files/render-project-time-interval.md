---
id: render-project-time-interval
url: viewer/java/render-project-time-interval
title: Render project time interval
weight: 4
description: "This article explains how to view the specific time interval of MS Project Document with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
There is the possibility that you are required to render a part of the MS Project within the specified time interval. In that case, [GroupDocs.Viewer](https://products.groupdocs.com/viewer) allows rendering part of MS Project document according to specified [setStartDate(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/ProjectManagementOptions#setStartDate(java.util.Date)) and [setEndDate(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/ProjectManagementOptions#setEndDate(java.util.Date)) properties of [ProjectManagementOptions](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/ProjectManagementOptions) class as shown in code samples below. When only one of these properties is set, rendering starts from the project's start date or ends on the project's end date correspondingly.

The following code samples show how to render MS Project document using [setStartDate(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/ProjectManagementOptions#setStartDate(java.util.Date)) and [setEndDate(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer.options/ProjectManagementOptions#setEndDate(java.util.Date)). 

```java
    Viewer viewer = new Viewer("sample.mpp");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();

    viewOptions.getProjectManagementOptions().setStartDate(new Date(2008, Calendar.JUNE, 1));
    viewOptions.getProjectManagementOptions().setEndDate(new Date(2008, Calendar.JULY, 1));

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
