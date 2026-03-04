# GroupDocs.Viewer for Java - Demo API Tests

Integration tests that verify the web APIs of the viewer demo applications.

## Test Profiles

Tests are split by how demos serve static resources:

- **Embedded** (Javalin, Ktor, Micronaut, Spring/Dropwizard with special config):

  ```bash
  mvn clean compile test -Pembedded
  ```

- **External** (Spring, Dropwizard with default config):

  ```bash
  mvn clean compile test -Pexternal
  ```

## Setup

Set the files directory before running a demo:

```bash
export FILES_DIR=/path/to/api-viewer-tests
```

Reference files were generated with the following JVM arguments:

```
-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8 -Duser.country=US -Duser.region=US -Duser.language=en -Duser.timezone=America/New_York
```

Spring and Dropwizard demos cache rendered output. Delete the `cache/` folder inside `FILES_DIR` between test runs to ensure clean results.

## Known Issues

- External tests were created using Spring. Running them against Dropwizard may produce minor differences that require manual review. Result files are saved in `target/`.
