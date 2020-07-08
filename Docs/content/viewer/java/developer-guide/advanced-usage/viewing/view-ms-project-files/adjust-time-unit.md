---
id: adjust-time-unit
url: viewer/java/adjust-time-unit
title: Adjust time unit
weight: 1
description: "This article explains how to adjust a time unit when viewing MS Project Documents with GroupDocs.Viewer within your Java applications."
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
When rendering MS Project documents [GroupDocs.Viewer](https://products.groupdocs.com/viewer) tries to find optimal output size and time unit depending on the project's overall length. In case you need to set your own page size or time unit, you can set [ProjectManagementOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/projectmanagementoptions) class properties of corresponding [HtmlViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/htmlviewoptions) (or [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/jpgviewoptions), or [PngViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pngviewoptions), or [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions)) class as shown in code samples below. Time unit refers to the smallest unit (days, third of a month or month) used in timescale bar. When the *TimeUnit.Days* is selected, you will get the most detailed view of your tasks. Whereas, when *TimeUnit.Month* is selected, you will get the more general representation of tasks.

The [TimeUnit](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/timeunit) enumeration contains the following members:

*   *Unknown* - The unknown, unspecified time scale
*   *Days* - The one day interval
*   *ThirdsOfMonths* - The one third of the month
*   *Months* - The one month interval

The following are the steps to be followed to set time interval:

*   Create [HtmlViewOption](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/htmlviewoptions) / [PngViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pngviewoptions) / [JpgViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/jpgviewoptions) / [PdfViewOptions](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/pdfviewoptions) object;
*   Set [ProjectManagementOptions.TimeUnit](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer.options/projectmanagementoptions/properties/timeunit) property;
*   Call [View](https://apireference.groupdocs.com/java/viewer/groupdocs.viewer/viewer/methods/view) method.

The following code samples show how to render MS Project document by time intervals.

```java
    Viewer viewer = new Viewer("sample.mpp");
    HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
    viewOptions.getProjectManagementOptions().setTimeUnit(TimeUnit.DAYS);
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