plugins {
    alias(libs.plugins.kotlin.jvm) apply true
}

repositories {
    maven {
        url = uri("https://maven.pkg.github.com/yonatankarp/kotlin-junit-tools")
        credentials {
            username = project.findProperty("gpr.user")?.toString() ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.key")?.toString() ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation(libs.bundles.kotlin.all)
    implementation(libs.bundles.log.all)
    testImplementation(libs.kotlin.junit.tools)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.tests.all)
}

tasks.test {
    useJUnitPlatform()
}
