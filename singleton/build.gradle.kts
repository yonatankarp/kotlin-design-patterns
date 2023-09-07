plugins {
    alias(libs.plugins.kotlin.jvm) apply true
}

dependencies {
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.tests.all)
}

tasks.test {
    useJUnitPlatform()
}
