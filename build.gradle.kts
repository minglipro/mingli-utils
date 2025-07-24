import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.Date

plugins {
    id("java")
    id("java-library")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version ("8.1.1")
}

val GROUPSID = project.properties["GROUPSID"] as String
val VERSIONS = project.properties["VERSIONS"] as String
val ARTIFACTID = project.properties["ARTIFACTID"] as String
val MAINCLASS = project.properties["MAINCLASS"] as String
val buildTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())

val jarNameStr = "${ARTIFACTID}-${VERSIONS}"
val jarName = "${jarNameStr}.jar"
val srcJarName = "${jarNameStr}-sources.jar"
val fatJarName = "${jarNameStr}-all.jar"
group = GROUPSID
version = VERSIONS

val libDir = rootDir.resolve("build").resolve("libs")
val publicationsDir =
    rootDir.resolve("build").resolve("publications").resolve("mavenJava")

java {
    withSourcesJar()
}


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.jetbrains:annotations:24.0.0")
    annotationProcessor("org.jetbrains:annotations:24.0.0")
}

tasks.test {
    useJUnitPlatform()
}

private fun generateHash(file: File, string: String): String {
    val md = MessageDigest.getInstance(string)
    file.forEachBlock(4096) { bytes, size ->
        md.update(bytes, 0, size)
    }
    return md.digest().joinToString("") {
        "%02x".format(it)
    }
}

private fun getHash(outpath: String, file: File) {
    val md5 = generateHash(file, "MD5")
    val sha1 = generateHash(file, "SHA-1")
    val sha256 = generateHash(file, "SHA-256")
    val sha512 = generateHash(file, "SHA-512")
    val md5f = File(outpath, file.getName() + ".md5")
    val sha1f = File(outpath, file.getName() + ".sha1")
    val sha256f = File(outpath, file.getName() + ".sha256")
    val sha512f = File(outpath, file.getName() + ".sha512")
    md5f.writeText(md5)
    sha1f.writeText(sha1)
    sha256f.writeText(sha256)
    sha512f.writeText(sha512)
}



tasks.shadowJar {
    archiveFileName.set(fatJarName)
    archiveClassifier.set("all")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.main.get().output)  // 编译输出
    from(project.configurations.runtimeClasspath)  // 运行时依赖
    from("src/main/resources") {  // 资源文件
        into(".")
    }
    manifest {
        attributes["Main-Class"] = MAINCLASS
        attributes["Implementation-GroupId"] = GROUPSID
        attributes["Implementation-ArtifactId"] = ARTIFACTID
        attributes["Implementation-Version"] = VERSIONS
        attributes["Email"] = "minglipro@163.com"
        attributes["Implementation-Vendor"] = "minglipro|Armamem0t"
        attributes["Copyright"] =
            "Copyright 2026 minglipro All rights reserved."
        attributes["Env"] = "prod"
        attributes["LICENSE"] = "Apache License 2.0"
        attributes["Created"] = "2025-06-26 09:13:51"
        attributes["Updated"] = buildTime
    }
    mergeServiceFiles()
    exclude("META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")  // 排除签名文件
    from("LICENSE")
    into(".")
}


tasks.jar {
    archiveFileName.set(jarName)
    doFirst {
        delete(libDir)
        mkdir(libDir)
    }
    manifest {
        attributes["Main-Class"] = MAINCLASS
        attributes["Implementation-GroupId"] = GROUPSID
        attributes["Implementation-ArtifactId"] = ARTIFACTID
        attributes["Implementation-Version"] = VERSIONS
        attributes["Email"] = "minglipro@163.com"
        attributes["Implementation-Vendor"] = "minglipro|Armamem0t"
        attributes["Copyright"] =
            "Copyright 2026 minglipro All rights reserved."
        attributes["Env"] = "prod"
        attributes["LICENSE"] = "Apache License 2.0"
        attributes["Created"] = "2025-06-26 09:13:51"
        attributes["Updated"] = buildTime
    }
    from("LICENSE")
    into(".")
}
tasks.register("build-jar") {
    dependsOn(tasks.jar)
    dependsOn(tasks.shadowJar)
    dependsOn(tasks["sourcesJar"])
    dependsOn(tasks["generatePomFileForMavenJavaPublication"])
    dependsOn(tasks["generateMetadataFileForMavenJavaPublication"])
    doLast {
        getHash(libDir.toString(),File(libDir, jarName))
        getHash(libDir.toString(),File(libDir, fatJarName))
        getHash(libDir.toString(),File(libDir, srcJarName))
        getHash(publicationsDir.toString(),File(publicationsDir, "module.json"))
        getHash(publicationsDir.toString(),File(publicationsDir, "pom-default.xml"))
    }
}
components {
    withType<AdhocComponentWithVariants>().configureEach {
        withVariantsFromConfiguration(configurations["shadowRuntimeElements"]) {
            skip()
        }
    }
}
publishing {
    repositories {
        maven {
            url = uri("D:/git/maven-repository-raw")
        }
    }
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifact(tasks.shadowJar.get())
            groupId = GROUPSID
            artifactId = ARTIFACTID
            version = VERSIONS
        }
    }
}


