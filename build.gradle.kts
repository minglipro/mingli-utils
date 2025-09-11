/*
 * Copyright 2025 mingliqiye
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ProjectName mingli-utils
 * ModuleName mingli-utils
 * CurrentFile build.gradle.kts
 * LastUpdate 2025-09-10 11:08:55
 * UpdateUser MingLiPro
 */

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    idea
    java
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



sourceSets {
    main {
        java {
            srcDirs("src/main/java")
        }
        resources {
            srcDirs("src/main/resources")
        }
    }
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
    // https://mvnrepository.com/artifact/jakarta.annotation/jakarta.annotation-api
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")

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
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes(
            mapOf(
                "Main-Class" to "com.mingliqiye.utils.Main",
                "Specification-Title" to ARTIFACTID,
                "Specification-Version" to VERSIONS,
                "Specification-Vendor" to "minglipro",
                "Specification-Build-Time" to LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS")),
                "Specification-Package" to GROUPSID,
                "Specification-Build-Number" to "1",
                "Specification-Build-OS" to System.getProperty("os.name"),
                "Specification-Build-Java" to System.getProperty("java.version"),
                "Specification-Build-Java-Vendor" to System.getProperty("java.vendor"),
                "Specification-Build-Java-Vendor-URL" to System.getProperty("java.vendor.url"),
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
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    outputs.upToDateWhen { false }
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
