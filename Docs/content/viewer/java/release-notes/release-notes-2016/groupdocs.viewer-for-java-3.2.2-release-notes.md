---
id: groupdocs-viewer-for-java-3-2-2-release-notes
url: viewer/java/groupdocs-viewer-for-java-3-2-2-release-notes
title: GroupDocs.Viewer for Java 3.2.2 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 3.2.2{{< /alert >}}

## Major Features

There are 1 new feature in this release:

*   Ability to specify custom fonts path

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERJAVA-1201 | Add ability to specify custom fonts path | New Feature |

## Public API and Backward Incompatible Changes

##### How to specify custom fonts path

**How to specify custom fonts path**



```java
// Setup GroupDocs.Viewer config
ViewerConfig config = new ViewerConfig();
config.setStoragePath("C:\\storage");

// Add custom fonts directories to FontDirectories list
config.getFontDirectories().add(fontPaths);

// Init viewer handler with config
ViewerHtmlHandler htmlHandler = new ViewerHtmlHandler(config);


```
