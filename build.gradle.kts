import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    idea
    id("java-library")
    id("maven-publish")
}

val GROUPSID = project.properties["GROUPSID"] as String
val VERSIONS = project.properties["VERSIONS"] as String
val ARTIFACTID = project.properties["ARTIFACTID"] as String

group = GROUPSID
version = VERSIONS

base {
    archivesName.set(ARTIFACTID)
}

java {
    withJavadocJar()
    withSourcesJar()
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

dependencies {
    annotationProcessor("org.jetbrains:annotations:24.0.0")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    compileOnly("org.springframework.boot:spring-boot-starter:2.7.14")
    compileOnly("com.fasterxml.jackson.core:jackson-databind:2.19.2")
    compileOnly("org.mybatis:mybatis:3.5.19")
    compileOnly("org.projectlombok:lombok:1.18.38")
    implementation("org.bouncycastle:bcprov-jdk18on:1.81")
    implementation("com.github.f4b6a3:uuid-creator:6.1.0")
    implementation("org.mindrot:jbcrypt:0.4")
    implementation("org.jetbrains:annotations:24.0.0")
    implementation("net.java.dev.jna:jna:5.17.0")
}


sourceSets.main.configure {
    java.setSrcDirs(files("src"))
    resources.setSrcDirs(files("resources"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs = listOf(
        "-Dfile.encoding=UTF-8",
        "-Dsun.stdout.encoding=UTF-8",
        "-Dsun.stderr.encoding=UTF-8"
    )
}


tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

tasks.withType<org.gradle.jvm.tasks.Jar> {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to ARTIFACTID,
                "Implementation-Version" to VERSIONS,
                "Implementation-Package" to GROUPSID,
                "Implementation-Vendor" to "minglipro",
                "Implementation-Build-Time" to LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS"))

            )
        )
    }
}

repositories {
    mavenCentral()
}

publishing {
    repositories {
        maven {
            name = "MavenRepositoryRaw"
            url = uri("C:/data/git/maven-repository-raw")
        }
    }
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = GROUPSID
            artifactId = ARTIFACTID
            version = VERSIONS
        }
    }
}

tasks.processResources {
    filesMatching("META-INF/meta-data") {
        expand(
            mapOf(
                "buildTime" to LocalDateTime.now()
                    .format(
                        DateTimeFormatter.ofPattern(
                            "yyyy-MM-dd HH:mm:ss.SSSSSSS"
                        )
                    )
            ) + project.properties
        )
    }
}

