---
id: evaluation-limitations-and-licensing-of-groupdocs-viewer
url: viewer/java/evaluation-limitations-and-licensing-of-groupdocs-viewer
title: Evaluation Limitations and Licensing of GroupDocs.Viewer
weight: 5
description: ""
keywords: 
productName: GroupDocs.Viewer for Java
hideChildren: False
---
{{< alert style="info" >}}You can use [GroupDocs.Viewer](https://products.groupdocs.com/viewer) without the license. The usage and functionalities are pretty much same as the licensed one but you will face few limitations while using the non-licensed API.{{< /alert >}}

## Evaluation Limitations

You can easily download [GroupDocs.Viewer](https://products.groupdocs.com/viewer) for evaluation. The evaluation download is the same as the purchased download. The evaluation version simply becomes licensed when you add a few lines of code to apply the license. You will face following limitations while using the API without the license:  

*   Only first 2 pages are processed.
*   Trial badges are placed in the document on the top of each page.

## Licensing

The license file contains details such as the product name, number of developers it is licensed to, subscription expiry date and so on. It contains the digital signature, so don't modify the file. Even inadvertent addition of an extra line break into the file will invalidate it. You need to set a license before utilizing [GroupDocs.Viewer](https://products.groupdocs.com/viewer) API if you want to avoid its evaluation limitations.   
The license can be loaded from a file or stream object. The easiest way to set a license is to put the license file in the same folder as the GroupDocs.Viewer.jar file and specify the file name, without a path, as shown in the examples below.

#### Setting License from File

The code below will explain how to set product license.

```java
    // For complete examples and data files, please go to https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java
    // Setup license.
    License license = new License();
    license.setLicense(licensePath);
```

#### Setting License from Stream

The following example shows how to load a license from a stream.

```java
    // For complete examples and data files, please go to https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java
    InputStream fileStream = new FileInputStream("GroupDocs.Viewer.lic");
    License license = new License();
    license.setLicense(fileStream);
    fileStream.close();
```

{{< alert style="info" >}}Calling License.setLicense(...) multiple times is not harmful but simply wastes processor time. Call License.setLicense(...) in your startup code, before using [GroupDocs.Viewer](https://products.groupdocs.com/viewer) classes.{{< /alert >}}

#### Setting Metered License

{{< alert style="info" >}}You can also set Metered license as an alternative to license file. It is a new licensing mechanism that will be used along with existing licensing method. It is useful for the customers who want to be billed based on the usage of the API features. For more details, please refer to Metered Licensing FAQ section.{{< /alert >}}

Here are the simple steps to use the [Metered](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Metered) class.

1.  Create an instance of [Metered](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Metered) class.
2.  Pass public & private keys to [setMeteredKey(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Metered#setMeteredKey(java.lang.String,%20java.lang.String)) method.
3.  Do processing (perform task).
4.  call method [getConsumptionQuantity(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Metered#getConsumptionQuantity()) of the [Metered](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Metered) class.
5.  It will return the amount/quantity of API requests that you have consumed so far.
6.  call method [getConsumptionCredit(...)](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Metered#getConsumptionCredit()) of the [Metered](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Metered) class.
7.  It will return the credit that you have consumed so far.

Following is the sample code demonstrating how to use [Metered](https://apireference.groupdocs.com/viewer/java/com.groupdocs.viewer/Metered) class.

```java
    // For complete examples and data files, please go to https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java
    String publicKey = ""; // Your public license key
    String privateKey = ""; // Your private license key
    
    Metered metered = new Metered();
    metered.setMeteredKey(publicKey, privateKey);
    
    // Get amount (MB) consumed
    double amountConsumed = Metered.getConsumptionQuantity();
    System.out.println("Amount (MB) consumed: " + amountConsumed);
    
    // Get count of credits consumed
    double creditsConsumed = Metered.getConsumptionCredit();
    System.out.println("Credits consumed: " + creditsConsumed);
```
