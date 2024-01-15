plugins {
    id("java")
}

group = "at.fh.hagenberg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val jqwikVersion = "1.8.2"
val annotationVersion = "23.0.0"
val assertjVersion = "3.21.0"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // aggregate jqwik dependency
    testImplementation("net.jqwik:jqwik:${jqwikVersion}")
    testImplementation("org.assertj:assertj-core:${assertjVersion}")
    compileOnly("org.jetbrains:annotations:${annotationVersion}")
}

tasks.test {
    useJUnitPlatform {
        includeEngines("jqwik")
        includeEngines("junit-jupiter")
    }
    include("**/*Test.class")
    include("**/*Properties.class")
    include("**/*Tests.class")
}