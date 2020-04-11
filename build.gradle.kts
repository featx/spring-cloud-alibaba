plugins {
    id("java")
}

allprojects {

    group = "org.featx.templet"
    version = "1.0.0-SNAPSHOT"
    java.sourceCompatibility = JavaVersion.VERSION_14
    java.targetCompatibility = JavaVersion.VERSION_14

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone")}
//        maven { url "https://artifacts.elastic.co/maven" }
        maven {
            url = uri("https://repo.rdc.aliyun.com/repository/67417-release-5dYQ7a/")
            credentials {
                username = "${property("MVN_USERNAME")}"
                password = "${property("MVN_PASSWORD")}"
            }
        }
        maven {
            url = uri("https://repo.rdc.aliyun.com/repository/67417-snapshot-6tKIEl/")
            credentials {
                username = "${property("MVN_USERNAME")}"
                password = "${property("MVN_PASSWORD")}"
            }
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}