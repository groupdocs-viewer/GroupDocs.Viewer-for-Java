#SHELL=CMD
SHELL=/bin/bash

VIEWER_VERSION=24.12

# Groupdocs.Viewer for Java - Spring sample

build-openjdk8: VERSION_NAME = openjdk8-bullseye
build-openjdk8:
	@echo Building $(VIEWER_VERSION)-$(VERSION_NAME)-spring
	docker build -f ./docker/Dockerfile-$(VERSION_NAME) -t viewer:$(VIEWER_VERSION)-java-$(VERSION_NAME)-spring ./

build-openjdk11: VERSION_NAME = openjdk11-bullseye
build-openjdk11:
	@echo Building $(VIEWER_VERSION)-$(VERSION_NAME)-spring
	docker build -f ./docker/Dockerfile-$(VERSION_NAME) -t viewer:$(VIEWER_VERSION)-java-$(VERSION_NAME)-spring ./

build-openjdk18: VERSION_NAME = openjdk18-bullseye
build-openjdk18:
	@echo Building $(VIEWER_VERSION)-$(VERSION_NAME)-spring
	docker build -f ./docker/Dockerfile-$(VERSION_NAME) -t viewer:$(VIEWER_VERSION)-java-$(VERSION_NAME)-spring ./

build: build-openjdk8 build-openjdk11 build-openjdk18

run-openjdk8: VERSION_NAME = openjdk8-bullseye
run-openjdk8: CONTAINER_NAME = viewer-$(VERSION_NAME)
run-openjdk8:
	@echo Running $(CONTAINER_NAME)
	docker run -p 8080:8080 --name $(CONTAINER_NAME) --rm viewer:$(VIEWER_VERSION)-java-$(VERSION_NAME)-spring

run-openjdk11: VERSION_NAME = openjdk11-bullseye
run-openjdk11: CONTAINER_NAME = viewer-$(VERSION_NAME)
run-openjdk11:
	@echo Running $(CONTAINER_NAME)
	docker run -p 8080:8080 --name $(CONTAINER_NAME) --rm viewer:$(VIEWER_VERSION)-java-$(VERSION_NAME)-spring

run-openjdk18: VERSION_NAME = openjdk18-bullseye
run-openjdk18: CONTAINER_NAME = viewer-$(VERSION_NAME)
run-openjdk18:
	@echo Running $(CONTAINER_NAME)
	docker run -p 8080:8080 --name $(CONTAINER_NAME) --rm viewer:$(VIEWER_VERSION)-java-$(VERSION_NAME)-spring

