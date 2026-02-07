/*
 * Copyright 2026 mingliqiye
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
 * LastUpdate 2026-02-08 03:14:06
 * UpdateUser MingLiPro
 */

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    idea
    java
    signing
    `java-library`
    `maven-publish`
    kotlin("jvm") version "2.2.20"
    id("org.jetbrains.dokka") version "2.0.0"
    kotlin("kapt") version "2.2.20"
}
val GROUPSID = project.properties["GROUPSID"] as String
val VERSIONS = project.properties["VERSIONS"] as String
val ARTIFACTID = project.properties["ARTIFACTID"] as String

group = GROUPSID
version = VERSIONS

base {
    archivesName.set(ARTIFACTID)
}

val buildDir: java.nio.file.Path = File("build").toPath()

sourceSets {
    main {
        java {
            srcDirs("src/main/java")
        }
        kotlin {
            srcDirs("src/main/kotlin")
        }
        resources {
            srcDirs("src/main/resources")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

java {
    withSourcesJar()
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

dependencies {

    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("com.mingliqiye.utils.jna:WinKernel32Api:1.0.1")
    implementation(kotlin("reflect"))

    compileOnly("org.mindrot:jbcrypt:0.4")

    compileOnly("com.squareup.okhttp3:okhttp:5.3.2")
    compileOnly("com.fasterxml.jackson.core:jackson-databind:2.21.0")
    compileOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.21.0")
    compileOnly("org.springframework.boot:spring-boot-starter-web:2.7.18")
    compileOnly("com.google.code.gson:gson:2.13.2")
    compileOnly("org.mybatis:mybatis:3.5.19")
    compileOnly("io.netty:netty-all:4.1.130.Final")
    compileOnly("com.baomidou:mybatis-plus-core:3.5.15")
    compileOnly("net.java.dev.jna:jna:5.17.0")
    compileOnly("com.baomidou:mybatis-plus-extension:3.5.15")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
//    testImplementation("com.squareup.okhttp3:okhttp:5.3.2")
    testImplementation("com.mingliqiye.logger:logger-log4j2:1.0.5")
    testImplementation("com.google.code.gson:gson:2.13.2")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.21.0")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.21.0")
}


tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}


tasks.withType<JavaExec>().configureEach {
    jvmArgs = listOf(
        "-Dfile.encoding=UTF-8", "-Dsun.stdout.encoding=UTF-8", "-Dsun.stderr.encoding=UTF-8"
    )
}

kapt {
    arguments {
        arg(
            "kapt.kotlin.generated",
            project.layout.buildDirectory.dir("generated/source/kapt/main").get().asFile.absolutePath
        )
    }
}

tasks.withType<org.gradle.jvm.tasks.Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from("LICENSE") { into("META-INF") }
    from("NOTICE") { into("META-INF") }
    manifest {
        attributes(
            mapOf(
                "Main-Class" to "com.mingliqiye.utils.main.Main",
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
val isJdk8Build = project.findProperty("buildForJdk8") == "true"



repositories {
    maven {
        url = uri("https://maven.aliyun.com/repository/public/")
    }
    mavenCentral()
}
tasks.register<Jar>("javaDocJar") {
    group = "build"
    archiveClassifier.set("javadoc")
    dependsOn("dokkaJavadoc")
    from(buildDir.resolve("dokka/javadoc"))
}
tasks.register<Jar>("kotlinDocJar") {
    group = "build"
    archiveClassifier.set("kotlindoc")
    dependsOn("dokkaHtml")
    from(buildDir.resolve("dokka/html"))
}
publishing {
    repositories {
        maven {
            name = "MavenRepositoryRaw"
            url = uri("C:/data/git/maven-repository-raw")
        }
        maven {
            name = "OSSRepository"
            url = uri("C:/data/git/maven-repository-raw-utils")
        }
    }
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifact(tasks.named("javaDocJar"))
            artifact(tasks.named("kotlinDocJar"))
            artifactId = ARTIFACTID
            java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))
            pom {
                name = "mingli-utils"
                url = "https://mingli-utils.mingliqiye.com"
                description = "A Java/kotlin Utils"
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "minglipro"
                        name = "mingli"
                        email = "minglipro@163.com"
                    }
                }
                scm {
                    connection = "scm:git:https://git.mingliqiye.com/minglipro/mingli-utils.git"
                    developerConnection = "scm:git:https://git.mingliqiye.com:minglipro/mingli-utils.git"
                    url = "https://git.mingliqiye.com/minglipro/mingli-utils"
                }
            }
        }
    }
    signing {
        sign(publishing.publications)
    }
}

tasks.build {
    dependsOn("javaDocJar", "kotlinDocJar")
}




tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    outputs.upToDateWhen { false }
    filesMatching(listOf("META-INF/meta-data", "fabric.mod.json")) {
        expand(
            project.properties + mapOf(
                "buildTime" to LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd HH:mm:ss.SSSSSSS"
                    )
                )
            )
        )
    }
}
