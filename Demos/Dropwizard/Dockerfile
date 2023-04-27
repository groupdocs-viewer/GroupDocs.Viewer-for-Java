# Build the project
FROM maven:latest as builder
COPY pom.xml    /usr/local/build/pom.xml
COPY src        /usr/local/build/src
WORKDIR         /usr/local/build
RUN mvn clean package -DskipTests -P jar

# Prepare to run
FROM openjdk:8-jre-alpine
RUN mkdir -p /home/groupdocs/app && apk add fontconfig && apk add msttcorefonts-installer && update-ms-fonts && fc-cache -f
COPY /DocumentSamples /home/groupdocs/app/DocumentSamples
COPY /Licenses /home/groupdocs/app/Licenses
COPY /configuration.yml /home/groupdocs/app/configuration.yml
COPY --from=builder /usr/local/build/target/viewer-*.jar /home/groupdocs/app/app.jar
WORKDIR /home/groupdocs/app

ENV LIC_PATH "Licenses"
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

ENTRYPOINT [ "java", "-jar", "app.jar", "configuration.yml" ]