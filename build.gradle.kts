plugins {
    kotlin("jvm") version "2.4.21"

    application
}

repositories {
    mavenCentral()
}

val ktorVersjon = "3.6.0"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:6.1.3")
    testImplementation("io.mockk:mockk:1.14.12")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("io.github.oshai:kotlin-logging-jvm:8.0.6")
    implementation("io.ktor:ktor-server-core:${ktorVersjon}")
    implementation("io.ktor:ktor-server-netty:${ktorVersjon}")
    implementation("io.ktor:ktor-server-metrics-micrometer:$ktorVersjon")
    implementation("io.micrometer:micrometer-registry-prometheus:1.17.2")
    runtimeOnly("ch.qos.logback:logback-classic:1.6.6")
    runtimeOnly("net.logstash.logback:logstash-logback-encoder:9.0")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

application {
    mainClass = "no.nav.uføre.AppKt"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "no.nav.uføre.AppKt"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.map { cp ->
        cp.map { if (it.isDirectory) it else zipTree(it) }
    })
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
