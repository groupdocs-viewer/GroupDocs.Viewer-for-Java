# Build the project
FROM maven:latest as builder
COPY pom.xml    /usr/local/build/pom.xml
COPY src        /usr/local/build/src
WORKDIR         /usr/local/build
RUN mvn clean package -DskipTests -P jar

# Prepare to run
FROM eclipse-temurin:11-jre

RUN apt-get update && \
    apt-get install -y fontconfig ttf-mscorefonts-installer && \
    fc-cache -f && \
    rm -rf /var/lib/apt/lists/*
COPY /DocumentSamples /home/groupdocs/app/DocumentSamples
COPY /Licenses /home/groupdocs/app/Licenses
COPY /configuration.yml /home/groupdocs/app/configuration.yml
COPY /logback-spring.xml /home/groupdocs/app/logback-spring.xml
COPY --from=builder /usr/local/build/target/viewer-spring-*.jar /home/groupdocs/app/app.jar
WORKDIR /home/groupdocs/app

ENV LIC_PATH "/home/groupdocs/app/Licenses"
ENV DOWNLOAD_ON true
ENV UPLOAD_ON true
ENV PRINT_ON true
ENV BROWSE_ON true
ENV RIGHTCLICK_ON false
ENV FILES_DIR "DocumentSamples"
ENV RESULT_DIR "DocumentSamples"
ENV HOST_ADDRESS ""

EXPOSE 8080

VOLUME [ "/home/groupdocs/app", "/home/groupdocs/app/DocumentSamples", "/home/groupdocs/app/Licenses" ]

ENTRYPOINT [ "java", "-jar", "-Dlogback.configurationFile=/home/groupdocs/app/logback-spring.xml", "app.jar", "configuration.yml" ]