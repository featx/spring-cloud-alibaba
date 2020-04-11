plugins {
    id("java")
    id("maven-publish")
}

extra["featxSpecVersion"] = "1.0.0"
extra["springVersion"] = "5.2.5.RELEASE"
extra["guavaVersion"] = "28.2-jre"
extra["lombokVersion"] = "1.18.12"
extra["slf4jVersion"] = "1.7.30"
extra["fastJsonVersion"] = "1.2.68"
extra["reactorVersion"] = "3.3.4.RELEASE"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation("org.featx.spec:spec:${property("featxSpecVersion")}")
    implementation("com.google.guava:guava:${property("guavaVersion")}")

    compileOnly("com.alibaba:fastjson:${property("fastJsonVersion")}")
    compileOnly("org.slf4j:slf4j-api:${property("slf4jVersion")}")
    compileOnly("io.projectreactor:reactor-core:${property("reactorVersion")}")
    compileOnly("org.springframework:spring-web:${property("springVersion")}")
    compileOnly("io.github.openfeign:feign-hystrix:10.7.0")
    compileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
}

tasks.withType<SourceJar> {
    from= sourceSets.main.allSource
}

tasks.withType<Javadoc> (type: Jar, dependsOn: "classes") {
    from javadoc.destinationDir
}

publishing {
    publications {
        maven(MavenPublication) {
            from=components.java

                    artifact sourceJar {
                classifier "src"
            }

            artifact javadocJar {
                classifier "doc"
            }
        }
    }

    repositories {
        maven {
            url = uri("https://repo.rdc.aliyun.com/repository/67417-release-5dYQ7a/")
            if (project.version.toString().endsWith("SNAPSHOT")) {
                url = uri("https://repo.rdc.aliyun.com/repository/67417-snapshot-6tKIEl/")
            }
            credentials {
                username = "${property("MVN_USERNAME")}"
                password = "${property("MVN_PASSWORD")}"
            }
        }
    }
}
