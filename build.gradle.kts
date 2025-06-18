plugins {
    id("fabric-loom") version "1.5-SNAPSHOT"
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.4")
    mappings("net.fabricmc:yarn:1.21.4+build.11:v2")
    modImplementation("net.fabricmc:fabric-api:0.91.0+1.21.4")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}