---
id: groupdocs-viewer-for-java-17-5-1-release-notes
url: viewer/java/groupdocs-viewer-for-java-17-5-1-release-notes
title: GroupDocs.Viewer for Java 17.5.1 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 17.5.1.{{< /alert >}}

## Major Features

This release includes one new feature and two bug fixes.

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERJAVA-1601 | Add method to clean up temporary files | New Feature |
| VIEWERJAVA-1582 | NullPointerException when rendering PDF as HTML | Bug |
| VIEWERJAVA-1568 | Performance degradation during consequent iterations through the same documents | Bug |

##  Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Viewer for Java 17.5.1. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Viewer which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### How to clean up temporary files

While rendering documents, GroupDocs.Viewer creates temporary files which were removed automatically after each operation. As removing temporary files is time-consuming operation new method **clearTempFiles **was introduced. This method is thread-safe and can be called any time so it won't affect documents rendering. GroupDocs.Viewer uses default system temporary folder to store temp files, it can be changed by setting temporary directory in process properties e.g. `System.setProperty("java.io.tmpdir", "c:/my_temp_files/");`

**How to clean up temporary files**

```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath(STORAGE_PATH);
  
// Create image or html handler
ViewerImageHandler handler = new ViewerImageHandler(config);
 
// Cleanup temporary files
handler.clearTempFiles();
```
