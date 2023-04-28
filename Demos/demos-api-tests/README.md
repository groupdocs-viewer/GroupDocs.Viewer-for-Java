
# Tests that checks web APIs of viewer samples

There are two types of samples:

* For cases when resources are embedded (Javalin, Ktor, Micronaut, Spring with special configuration, Dropwizard with special configuration)
* For cases when resources are external (Spring with default configuration, Dropwizard with default configuration)

They can be run using next commands

```shell
mvn clean compile test -Pembedded
```

```shell
mvn clean compile test -Pexternal
```

Etalon files were created using next VM Arguments:

```
-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8 -Duser.country=US -Duser.region=US -Duser.language=en -Duser.timezone=America/New_York
```

It is important to run a sample specifying directory with files:

```shell
SET FILES_DIR=C:\api-viewer-tests
```

Also, keep in mind that Spring and Dropwizard samples have cache functionality, so you should remove `cache` folder in `FILES_DIR` directory
