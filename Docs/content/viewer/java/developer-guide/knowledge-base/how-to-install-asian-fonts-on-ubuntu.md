---
id: how-to-install-asian-fonts-on-ubuntu
url: viewer/java/how-to-install-asian-fonts-on-ubuntu
title: How to install Asian Fonts on Ubuntu
weight: 2
description: "This article will guide you through the installation of Asian Fonts on Ubuntu."
keywords: Ubuntu, Asian Fonts
productName: GroupDocs.Viewer for Java
hideChildren: False
---
This article will guide you through the installation process of the Asian Fonts on Ubuntu operating system. We'll be installing packages with [apt-get](https://wiki.debian.org/apt-get) utility on the latest (at the moment of writing this article) available version of OS that is [Ubuntu **20.04 LTS**](https://wiki.ubuntu.com/Releases) but the process is quite the same for the previous versions of Ubuntu.


## Find the required packages

We'll be installing Japanese language support, so let's browse to [packages.ubuntu.com](https://packages.ubuntu.com/) and search for the language support packages first.

The language support packages for the Ubuntu 20.04 LTS can be found at [packages.ubuntu.com/focal/translations/](https://packages.ubuntu.com/focal/translations/).

Let's search for Japanese language support packages and as you can see on the screenshot below there are two packages found that have a name which starts with **language-pack-**.

![](viewer/java/images/how-to-install-asian-fonts-on-ubuntu.png)

We'll install the first one called **[language-pack-ja](https://packages.ubuntu.com/focal/translations/language-pack-ja)** and the second one will be installed automatically as first one depends on second.

## Install packages

Let's run Ubuntu in a Docker container and then install the **language-pack-ja** package.

![](viewer/java/images/how-to-install-asian-fonts-on-ubuntu_1.png)

Type the following command to update the packages list with updates and new packages.

```shell script
$ apt-get update
```

![](viewer/java/images/how-to-install-asian-fonts-on-ubuntu_2.png)

And type the following to install the Japanese language support.

```shell script
$ apt-get install -y language-pack-ja
```

![](viewer/java/images/how-to-install-asian-fonts-on-ubuntu_3.png)

When installation will be completed you should see "Generation complete." message.

![](viewer/java/images/how-to-install-asian-fonts-on-ubuntu_4.png)

That's all, language support is installed.

The Chinese and Korean language support can be installed by typing the following commands:

```shell script
$ apt-get install -y language-pack-zh*
$ apt-get install -y language-pack-ko
```
