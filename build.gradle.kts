import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.flywaydb.gradle.task.FlywayMigrateTask

plugins {
    id("org.springframework.boot") version "2.3.0.M3"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.flywaydb.flyway") version "6.3.2"
    kotlin("jvm") version "1.3.70"
    kotlin("plugin.spring") version "1.3.70"
}

group = "org.featx.template"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

extra["springCloudVersion"] = "Hoxton.SR3"
extra["springCloudAlibabaVersion"] = "2.2.0.RELEASE"
extra["springMybatisVersion"] = "2.1.2"
extra["mysqlVersion"] = "8.0.19"
extra["HikariCPVersion"] = "3.4.2"
extra["guavaVersion"] = "28.2-jre"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

configurations.compile {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    exclude(group = "org.apache.tomcat")
    exclude(group = "org.apache.tomcat.embed")
    exclude(group = "org.apache.tomcat", module = "tomcat-jdbc")
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
    implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-sentinel")

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    implementation("org.apache.rocketmq:rocketmq-spring-boot-starter:2.1.0")
    implementation("com.alibaba.csp:sentinel-datasource-nacos")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:${property("springMybatisVersion")}")
    implementation("com.zaxxer:HikariCP:${property("HikariCPVersion")}")
    implementation("com.google.guava:guava:${property("guavaVersion")}")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("dev.miku:r2dbc-mysql")
    runtimeOnly("mysql:mysql-connector-java")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.projectreactor:reactor-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

flyway {
    url = ""
    locations = arrayOf("db/migration")
    user = "spring-cloud"
    password = ""
    schemas = arrayOf("spring-cloud")
}

tasks.withType<FlywayMigrateTask> {
    dependsOn("classes")
}