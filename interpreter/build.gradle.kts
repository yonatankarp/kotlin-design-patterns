plugins {
    alias(libs.plugins.kotlin.jvm) apply true
}

dependencies {
    implementation(libs.bundles.kotlin.all)
    implementation(libs.bundles.log.all)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.tests.all)
}

tasks.test {
    useJUnitPlatform()
}
