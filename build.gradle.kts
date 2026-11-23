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
 * LastUpdate 2026-11-22 07:59:57
 * UpdateUser MingLiPro
 */

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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
 * LastUpdate 2026-11-17 10:18:28
 * UpdateUser MingLiPro
 */



plugins {
	idea
	java
	signing
	`java-library`
	`maven-publish`
	kotlin("jvm") version "2.2.20"
	kotlin("kapt") version "2.2.20"
	id("org.jetbrains.dokka") version "2.1.0"
	id("org.jetbrains.dokka-javadoc") version "2.1.0"
	kotlin("plugin.spring") version "2.1.0"
}
val GROUPSID = project.properties["GROUPSID"] as String
val VERSIONS = project.properties["VERSIONS"] as String
val ARTIFACTID = project.properties["ARTIFACTID"] as String
val JDKVERSIONS = (project.properties["JDKVERSIONS"] as String).toInt()


group = GROUPSID
version = VERSIONS

base {
	archivesName.set(ARTIFACTID)
}

val buildDir: java.nio.file.Path = File("build").toPath()

java {
	toolchain.languageVersion.set(JavaLanguageVersion.of(JDKVERSIONS))
	withSourcesJar()
}
kotlin {
	jvmToolchain(JDKVERSIONS)
}

repositories {
	mavenLocal()
	maven {
		name = "mingliqiye-public"
		url = uri("https://repository.mingliqiye.com/repository/maven-public/")
	}
	mavenCentral()
}
dependencies {
	implementation("org.slf4j:slf4j-api:2.0.17")
	implementation(kotlin("reflect"))
	api("com.mingliqiye.utils.aliasfor:alias-for:1.0.1")
	compileOnly("org.mindrot:jbcrypt:0.4")
	compileOnly("com.squareup.okhttp3:okhttp:5.3.2")
	compileOnly("com.fasterxml.jackson.core:jackson-databind:2.21.0")
	compileOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.21.0")
	compileOnly("org.springframework:spring-context:5.3.0")
	compileOnly("org.springframework.boot:spring-boot-autoconfigure:2.7.16")
	compileOnly("tools.jackson.core:jackson-databind:3.1.0")
	compileOnly(fileTree("libs"))
	compileOnly("com.google.code.gson:gson:2.13.2")
	compileOnly("org.mybatis:mybatis:3.5.19")
	compileOnly("io.netty:netty-all:4.2.15.Final")
	compileOnly("com.baomidou:mybatis-plus-core:3.5.15")
	compileOnly("net.java.dev.jna:jna:5.17.0")
	compileOnly("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.8")
	compileOnly("com.baomidou:mybatis-plus-extension:3.5.15")
	compileOnly("com.baomidou:mybatis-plus-jsqlparser:3.5.15")
	compileOnly("com.baomidou:mybatis-plus-spring:3.5.9")
	compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
	compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.10.2")
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
	testImplementation("com.mingliqiye.logger:logger-log4j2:1.0.9")
	testImplementation("com.google.code.gson:gson:2.13.2")

	testImplementation("com.fasterxml.jackson.core:jackson-databind:2.21.0")
	testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.21.0")

	testImplementation("tools.jackson.module:jackson-module-kotlin:3.1.0")
	testImplementation("tools.jackson.core:jackson-databind:3.1.0")
	testImplementation(kotlin("test"))
}

repositories {
	mavenLocal()
}


tasks.withType<JavaCompile>().configureEach {
	options.encoding = "UTF-8"
}

tasks.named<Test>("test") {
	useJUnitPlatform()
}


tasks.withType<JavaExec> {
	jvmArgs(
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


dokka {
	pluginsConfiguration.html {
		customAssets.from("logo.png")
	}
}

tasks.register<Jar>("javaDocJar") {
	group = "build"
	archiveClassifier.set("javadoc")
	dependsOn("dokkaGenerateJavadoc")
	from(buildDir.resolve("dokka/javadoc"))
}

tasks.register<Jar>("kotlinDocJar") {
	group = "build"
	archiveClassifier.set("kotlindoc")
	dependsOn("dokkaGeneratePublicationHtml")
	from(buildDir.resolve("dokka/html"))
}
publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
			artifact(tasks.named("javaDocJar"))
			artifact(tasks.named("kotlinDocJar"))
			artifactId = ARTIFACTID
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

signing {
	val secretKeyRingFile = System.getenv("SIGNING_SECRET_KEY_RING_FILE")
	val keyId = System.getenv("SIGNING_KEY_ID")
	useGpgCmd()
	project.ext.set("signing.secretKeyRingFile", secretKeyRingFile)
	project.ext.set("signing.keyId", keyId)
	project.ext.set("signing.password", "")
}
