val kotlin_version: String by project
val koin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"
}

group = "com.groupdocs.ui.viewer.javalin"
version = "23.2.1"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repository.groupdocs.com/repo/")
}

application {
    mainClass.set("com.groupdocs.ui.viewer.javalin.ApplicationKt")
}

tasks {
    create("stage").dependsOn("installDist")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")

    implementation("com.groupdocs:groupdocs-viewer:23.2")

    implementation("io.insert-koin:koin-core:$koin_version")

    implementation("io.javalin:javalin:4.6.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    implementation("io.github.config4k:config4k:0.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-hocon:1.3.3")

    implementation("org.slf4j:slf4j-simple:1.7.36")
//    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}