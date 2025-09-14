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
 * ModuleName mingli-utils.jdk8
 * CurrentFile build.gradle.kts
 * LastUpdate 2025-09-14 18:19:04
 * UpdateUser MingLiPro
 */
plugins {
    id("java-library")
    id("maven-publish")
}
val GROUPSID = project.properties["GROUPSID"] as String
val VERSIONS = project.properties["VERSIONS"] as String
val ARTIFACTID = project.properties["ARTIFACTID"] as String
version = VERSIONS
group = GROUPSID

base.archivesName.set(ARTIFACTID)



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
            artifactId = "$ARTIFACTID-win-jdk8"
            groupId = GROUPSID
            version = VERSIONS
        }
    }
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))
dependencies {
    api(rootProject)
    implementation("com.mingliqiye.utils.jna:WinKernel32Platform:1.0.1")
}
