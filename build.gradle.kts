plugins {
    alias(libs.plugins.kotlin.jvm)

    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.mockk)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(libs.kotlin.logging.jvm)
    runtimeOnly(libs.logback.classic)
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
    archiveFileName.set("ufore-template-kotlin.jar")
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
