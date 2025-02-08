plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "dev.xchillz"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("libs/nukkit.jar"))
    implementation("org.xerial:sqlite-jdbc:3.42.0.0")

    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType(JavaCompile::class.java) {
    options.encoding = "UTF-8"
}

tasks.shadowJar {
    archiveBaseName.set("practice")
    archiveClassifier.set("")
    archiveVersion.set("1.0.0")
}
