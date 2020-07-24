---
id: groupdocs-viewer-for-java-20-7-release-notes
url: viewer/java/groupdocs-viewer-for-java-20-7-release-notes
title: GroupDocs.Viewer for Java 20.7 Release Notes
weight: 110
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) 20.7{{< /alert >}}

## Major Features

There are some features, improvements, and bug-fixes in this release, most notable are:

* Added AutoCAD Drawing Template (.dwt) file-format support
* Improved performance when rendering documents in chunks
* Improved rendering MS Project documents
* Added OpenDocument Graphic Template (.otg) file-format support
* Improved rendering presentations to responsive HTML
* Removed legacy API

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERNET-127 | Add AutoCAD Drawing Template (.dwt) file-format support | Feature |
| VIEWERNET-2257 | Timeout when loading external resources contained by text documents | Feature |
| VIEWERNET-2045 | Add OpenDocument Graphic Template (.otg) file format support | Feature |
| VIEWERJAVA-2175 | Add method to clear temporary files | Feature |
| VIEWERJAVA-2188 | Add possibility to set background color of the converted file | Feature |
| VIEWERJAVA-2191 | Add possibility to render DWG files to SVG format | Feature |
| VIEWERNET-1993 | Reduce the number of resources created when rendering MS Project documents | Improvement |
| VIEWERNET-2174 | Improve performance when rendering document in chunks | Improvement |
| VIEWERNET-2240 | Improve rendering presentations to responsive HTML  | Improvement |
| VIEWERNET-1937 | Console output is printed when rendering ODG images | Bug |
| VIEWERNET-1934 | The code hangs while converting PDF document to HTML output | Bug |
| VIEWERNET-6 | Empty result when rendering DWG to image or PDF | Bug |
| VIEWERNET-2133 | Incorrect font when rendering PDF to HTML | Bug |
| VIEWERNET-2251 | Empty folder list for ZIP archive created in Windows | Bug |
| VIEWERNET-2277 | Resource loading timeout is not working for some files | Bug |
| VIEWERNET-2282 | Parameter is not valid exception when resizing image | Bug |
| VIEWERJAVA-16 | Bulleted list images replaced with envelop images when rendering ODP as HTML | Bug |
| VIEWERJAVA-410 | API consumes a lot of memory and generates OutOfMemoryError (java.lang.OutOfMemoryError: Java heap space) | Bug |
| VIEWERJAVA-1635 | Missing images and background when rendering VST and VTX files | Bug |
| VIEWERJAVA-1862 | Process is stuck when rendering CGM to HTML | Bug |
| VIEWERJAVA-1951 | Content is shifted when rendering presentation with comments | Bug |
| VIEWERJAVA-2087 | There is no html link after viewing pdf file in html mode | Bug |
| VIEWERJAVA-2178 | Chinese characters are garbled when converting DWG format files to PDF in Linux | Bug |
| VIEWERJAVA-2187 | IndexOutOfBoundsException exception when calling getViewInfo() method. | Bug |
| VIEWERJAVA-2302 | Text is lost when a PDF file with Chinese content is rendered to HTML | Bug |
| VIEWERJAVA-2305 | Null reference exception when converting PDF to HTML with external resources | Bug |

## Public API and Backward Incompatible Changes

### public Viewer(InputStream inputStream, ViewerSettings settings) constructor has been added

```java
/**
 * <p>
 * Initializes new instance of {@link Viewer} class.
 * </p>
 *
 * @param inputStream The file stream
 * @param settings    The Viewer settings.
 * @throws IllegalArgumentException Thrown when {@code inputStream} is null.
 * @throws IllegalArgumentException Thrown when {@code settings} is null.
 */
public Viewer(InputStream inputStream, ViewerSettings settings)
```

### public static void clearTempFiles() method has been added

```java
/**
 * <p>Removes temporary files created during rendering.</p>
 */
public static void clearTempFiles()
```

### public void setResourceLoadingTimeout(int resourceLoadingTimeout) method has been added in LoadOptions class

```java
/**
 * he external resources e.g. graphics loading timeout.
 * The default value is 30 seconds.
 * This option is supported for Word Processing documents that contain external resources.
 *
 * @param resourceLoadingTimeout loading timeout
 */
public void setResourceLoadingTimeout(int resourceLoadingTimeout)
```

### public void setBackgroundColor(Color mBackgroundColor) method has been added in CadOptions class

```java
/**
 * Sets image background color
 * @param mBackgroundColor Image background color
 */
public void setBackgroundColor(Color backgroundColor)
```
