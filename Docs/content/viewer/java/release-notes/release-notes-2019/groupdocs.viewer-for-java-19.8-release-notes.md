---
id: groupdocs-viewer-for-java-19-8-release-notes
url: viewer/java/groupdocs-viewer-for-java-19-8-release-notes
title: GroupDocs.Viewer for Java 19.8 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Viewer for Java 19.8{{< /alert >}}

## Major Features

There are 23 features, improvements and bug fixes in this release, the most notable are:

*   Added vCard File (.vcf) file format support
*   Improved rendering of Outlook Data Files
    *   Support of obtaining list of folders
    *   Support of rendering folder
    *   Reading messages as attachments
    *   Filtering messages
*   Added support of skipping rendering of empty columns when rendering Spreadsheets

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| VIEWERJAVA-1909 | Feature | Obtaining the list of folders contained in OST/PST formats |
| VIEWERJAVA-1910 | Feature | Setting for rendering specific folder from OST/PST formats |
| VIEWERJAVA-1911 | Feature | Ignore empty columns when rendering spreadsheet documents |
| VIEWERJAVA-1915 | Feature | Add support for VCF format |
| VIEWERJAVA-1916 | Feature | Obtaining email messages contained in OST/PST formats as attachments |
| VIEWERJAVA-1917 | Feature | Settings for filtering messages from OST/PST documents by subject and content |
| VIEWERJAVA-1918 | Feature | Settings for filtering messages from OST/PST formats by sender |
| VIEWERJAVA-1919 | Feature | Obtaining layers statuses for CAD documents |
| VIEWERJAVA-1905 | Improvement | Ignore empty string when it passed as path to directory with fonts |
| VIEWERJAVA-1906 | Improvement | Improve rendering into HTML for Outlook Data Files with sub folders and empty folders |
| VIEWERJAVA-1907 | Improvement | Set exception localization feature as obsolete |
| VIEWERJAVA-1908 | Improvement | Prevent rendering frozen and invisible CAD layers by default |
| VIEWERJAVA-1912 | Improvement | Add support for rendering password protected ODS documents |
| VIEWERJAVA-1913 | Improvement | Descriptive Exception message when non existing default font name is set |
| VIEWERJAVA-1914 | Improvement | Simplify caching interface |
| VIEWERJAVA-371 | Bug | Particular PDF document is not rendering as expected |
| VIEWERJAVA-1923 | Bug | The view of xls files in html and image mode is without cells |
| VIEWERJAVA-1924 | Bug | Rendering CAD documents into image provides invalid output |
| VIEWERJAVA-1925 | Bug | Issue with the image source when rendering Excel to HTML with embedded resources |
| VIEWERJAVA-1926 | Bug | Header is missing when rendering Word document |
| VIEWERJAVA-1927 | Bug | Exception when getting document info of .msg file using Stream |
| VIEWERJAVA-1929 | Bug | Images are not visible in Chrome browser when rendering OneNote documents |
| VIEWERJAVA-1948 | Bug | Exception: Dimensions are too large |

## Public API and Backward Incompatible Changes

### Retrieving the list of Outlook folders

Since the version v19.8 Groupdocs.Viewer for Java API allows to retrieve the list of containing folders. For the detail please visit the link as follows:

*   [Retrieving list of Outlook folders]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-outlook-data-files/how-to-get-outlook-data-file-folders.md" >}})

### Rendering messages from specified folder only

By default, messages from all folders (including nested folders) are rendered. Version 19.8 allows you to render items form specific folder. Please visit the following link for the detail:

*   [Rendering messages from specified folder]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-outlook-data-files/render-outlook-data-file-folder.md" >}})

### Ignoring empty columns when rendering Spreadsheet documents

Since version 19.8, the GroupDocs.Viewer for Java allows to omit and do not render empty columns. Please visit the following link:

*   [Ignoring Empty Columns in Excel Worksheets When Rendering]({{< ref "viewer/java/developer-guide/advanced-usage/viewing/view-excel-spreadsheets/skip-rendering-of-empty-columns.md" >}})

### Public API changes in this version

In the version 19.8 following public class members were added, marked as deprecated, removed or replaced:


#### com.groupdocs.viewer.config.ViewerConfig

**public String getLocalesPath() method set as deprecated**

**public void setLocalesPath(String value) method set as deprecated**

This methods are deprecated and will be removed after v19.10. GroupDocs.Viewer no longer provides localization supports.

#### com.groupdocs.viewer.converter.options.ImageOptions

**public String getFileExtension() method has been set deprecated**

#### com.groupdocs.viewer.converter.options.OutlookOptions

**public final String getFolderName() method has been added**

**public final void setFolderName(String value) method has been added**

Use this option to specify Outlook folders as described in Working with Outlook Data Files article.

**public final String getTextFilter() method has been added**

**public final void setTextFilter(String value) method has been added**

Use this methods to filer messages from Outlook Data File documents that are rendered by specified keywords in the content or subject.

**public final String getAddressFilter() method has been added**

**public final void setAddressFilter(String value) method has been added**

Use this methods to filer messages from Outlook Data File documents that are rendered by specified sender or recipient.

#### com.groupdocs.viewer.domain.containers.DocumentInfoContainer

**String getDocumentType() method has been removed**

Use getFileFormat() method instead.

**public void setDocumentType(String value) method has been removed**

Use setFileFormat(String value) method instead.

**String getFileType() method has been removed**

Use getFileFormat() method instead.

**public void setFileType(String value) method has been removed**

Use setFileFormat(String value) method instead.

**String getDocumentTypeFormat() method has been removed**

Use getFileFormat() method instead.

**public void setDocumentTypeFormat(String value) method has been removed**

Use setFileFormat(String value) method instead.

#### com.groupdocs.viewer.domain.FileDescription

**String getBaseName() method has been removed**

To get base name use following method instead org.apache.commons.io.FilenameUtils.removeExtension()

**String DocumentType() method has been removed**

Use getFileFormat() method instead.

**String getFileType() method has been removed**

Use getFileFormat() method instead.

**String getDocumentTypeFormat() method has been removed**

Use getFileFormat() method instead.

#### com.groupdocs.viewer.handler.cache.ICacheDataHandler

**public Date getLastModificationDate(CacheFileDescription cachedPageDescription) method has been set as deprecated** 

This method is deprecated and will be removed after v19.10. GroupDocs.Viewer will no longer rely on document last modification date while caching or retrieving render results from cache.

#### com.groupdocs.viewer.handler.ViewerHtmlHandler

**public ViewerHtmlHandler(ViewerConfig viewerConfig, CultureInfo cultureInfo) constructor set as deprecated**

This constructor is deprecated and will be removed after v19.10.

**public ViewerHtmlHandler(ViewerConfig viewerConfig, IInputDataHandler inputDataHandler, CultureInfo cultureInfo) constructor set as deprecated**

This constructor is deprecated and will be removed after v19.10.

**public ViewerHtmlHandler(ViewerConfig viewerConfig, IInputDataHandler inputDataHandler, ICacheDataHandler cacheDataHandler, CultureInfo cultureInfo) constructor set as deprecated**

This constructor is deprecated and will be removed after v19.10.

**public ViewerHtmlHandler(IFileStorage fileStorage, CultureInfo cultureInfo) constructor set as deprecated**

This constructor is deprecated and will be removed after v19.10.

**public ViewerHtmlHandler(ViewerConfig viewerConfig, IFileStorage fileStorage, CultureInfo cultureInfo) constructor set as deprecated**

This constructor is deprecated and will be removed after v19.10.

####  com.groupdocs.viewer.handler.ViewerImageHandler

**public ViewerImageHandler(ViewerConfig viewerConfig, CultureInfo cultureInfo) constructor set as deprecated**

This constructor is deprecated and will be removed after v19.10.

**public ViewerImageHandler(ViewerConfig viewerConfig, IInputDataHandler inputDataHandler, CultureInfo cultureInfo) constructor set as deprecated**

This constructor is deprecated and will be removed after v19.10.

**public ViewerImageHandler(ViewerConfig viewerConfig, IInputDataHandler inputDataHandler, ICacheDataHandler cacheDataHandler, CultureInfo cultureInfo) constructor set as deprecated**

This constructor is deprecated and will be removed after v19.10.

**public ViewerImageHandler(IFileStorage fileStorage, CultureInfo cultureInfo) constructor set as deprecated**

This constructor is deprecated and will be removed after v19.10.

**public ViewerImageHandler(ViewerConfig viewerConfig, IFileStorage fileStorage, CultureInfo cultureInfo) constructor set as deprecated**

This constructor is deprecated and will be removed after v19.10.

#### com.groupdocs.viewer.localization.ILocalizationHandler

**public interface ILocalizationHandler set as deperecated**

This interface is deperecated and will be removed after v19.10.

**String getString(String key) method set as deperecated**

This method is deperecated and will be removed after v19.10.

#### com.groupdocs.viewer.localization.LocalizedStringKeys

**public class LocalizedStringKeys set as deprecated**

This class and all of its constants are deprecated and will be removed after v19.10.

  

###
