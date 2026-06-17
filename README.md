# GroupDocs.Viewer for Java - Examples and Demo Projects

[GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) is a document viewer API that supports over 170 document formats including Microsoft Office, OpenOffice, PDF, CAD, Photoshop, Visio, images, archives, email messages and more.

Render documents to HTML5, PDF, or image formats with high-quality output. Process documents page-by-page, all at once, or by custom page range. Customize appearance with watermarks, page rotation/reordering, and text extraction with coordinates.

## Important: Demo Applications Only

The projects in the [Demos](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Demos) folder and the Docker images published as [`groupdocs/viewer`](https://hub.docker.com/r/groupdocs/viewer) are **sample applications** intended to demonstrate [GroupDocs.Viewer for Java](https://products.groupdocs.com/viewer/java) features.

They are **not** production-ready services and must **not** be exposed to the public internet without additional hardening.

Before using a demo in any shared or production-like environment:

- Run it on `localhost` or a trusted private network only
- Do not publish Docker containers directly to the internet without authentication, a reverse proxy, and network restrictions
- Treat file upload, browse, and download features as untrusted input — validate and sandbox file paths in your own integration
- Add authentication, authorization, rate limiting, and logging appropriate for your security requirements
- Keep GroupDocs.Viewer and all dependencies up to date

For production integrations, use the library ([Examples](Examples), [documentation](https://docs.groupdocs.com/viewer/java/)) and implement your own secure document storage and API layer instead of deploying these demos as-is.

## Repository Structure

Directory | Description
--------- | -----------
[Demos](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Demos) | Demo projects for Spring, Dropwizard, Javalin, Ktor, Micronaut, and Compose Desktop.
[Examples](https://github.com/groupdocs-viewer/GroupDocs.Viewer-for-Java/tree/master/Examples) | Java API usage examples with sample documents.

## Demos

All web demos run on `http://localhost:8080/viewer/` and provide document viewing with zoom, thumbnails, text search, page rotation, download/upload, and print support.

| Demo | Framework | Language | Build | Version |
|------|-----------|----------|-------|---------|
| [Spring](Demos/Spring) | Spring Boot 2.5 | Java | `mvn clean spring-boot:run` | 26.5 |
| [Dropwizard](Demos/Dropwizard) | Dropwizard 1.3 | Java | `mvn clean compile exec:java` | 26.5 |
| [Javalin](Demos/Javalin) | Javalin 4.6 | Kotlin | `./gradlew run` | 26.5 |
| [Ktor](Demos/Ktor) | Ktor | Kotlin | `./gradlew run` | 26.5 |
| [Micronaut](Demos/Micronaut) | Micronaut 3.4 | Kotlin | `./gradlew run` | 26.5 |
| [Compose](Demos/Compose) | Compose Desktop | Kotlin | `gradlew run` | 26.5 |

The [Compose](Demos/Compose) demo is a standalone desktop application (not a web app).

## Docker

Pre-built Docker images are available on [Docker Hub](https://hub.docker.com/r/groupdocs/viewer).

```bash
docker pull groupdocs/viewer:latest
docker run -p 8080:8080 groupdocs/viewer:latest
```

**Security notice:** Docker images ship with demo defaults (e.g. upload and browse enabled, no authentication). Use them for local evaluation only. Do not expose port `8080` to untrusted networks without adding authentication, path validation, and other security controls required by your organization.

Available image tags follow the pattern `{version}-java-{jdk}-bullseye-{framework}`:

| Tag | JDK | Framework |
|-----|-----|-----------|
| `{ver}-java-openjdk8-bullseye-spring` | Eclipse Temurin 8 | Spring |
| `{ver}-java-openjdk11-bullseye-spring` | Eclipse Temurin 11 | Spring |
| `{ver}-java-openjdk18-bullseye-spring` | Eclipse Temurin 21 | Spring |
| `{ver}-java-openjdk8-bullseye-dropwizard` | Eclipse Temurin 8 | Dropwizard |
| `{ver}-java-openjdk11-bullseye-dropwizard` | Eclipse Temurin 11 | Dropwizard |
| `{ver}-java-openjdk18-bullseye-dropwizard` | Eclipse Temurin 21 | Dropwizard |

The `latest` tag points to the `openjdk18-bullseye-spring` variant.

## Getting Started

GroupDocs.Viewer for Java requires J2SE 8.0 (1.8) or above.

Add the [GroupDocs repository](https://releases.groupdocs.com/java/repo/) to your Maven project:

```xml
<repository>
    <id>GroupDocs Artifact Repository</id>
    <url>https://releases.groupdocs.com/java/repo/</url>
</repository>
```

Then add the dependency:

```xml
<dependency>
    <groupId>com.groupdocs</groupId>
    <artifactId>groupdocs-viewer</artifactId>
    <version>26.5</version>
</dependency>
```

See the [installation guide](https://docs.groupdocs.com/viewer/java/installation/) for details.

## Code Examples

### Render DOCX as Responsive HTML

```java
Viewer viewer = new Viewer("sample.docx");
HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources();
viewOptions.setRenderResponsive(true);
viewer.view(viewOptions);
viewer.close();
```

### View DOCX as Protected PDF

```java
Viewer viewer = new Viewer("sample.docx");
Security security = new Security();
security.setDocumentOpenPassword("o123");
security.setPermissionsPassword("p123");
security.setPermissions(Permissions.ALLOW_ALL ^ Permissions.DENY_PRINTING);

PdfViewOptions viewOptions = new PdfViewOptions(filePath);
viewOptions.setSecurity(security);

viewer.view(viewOptions);
viewer.close();
```

## Licensing

The license is not included in this repository. Without a license, GroupDocs.Viewer runs in [evaluation mode](https://docs.groupdocs.com/viewer/java/evaluation-limitations-and-licensing-of-groupdocs-viewer/). Request a temporary license at https://purchase.groupdocs.com/temporary-license.

## Resources

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/viewer/java) | [Documentation](https://docs.groupdocs.com/viewer/java/) | [API Reference](https://apireference.groupdocs.com/java/viewer) | [Online Demo](https://products.groupdocs.app/viewer/family) | [Blog](https://blog.groupdocs.com/category/viewer/) | [Free Support](https://forum.groupdocs.com/c/viewer) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
