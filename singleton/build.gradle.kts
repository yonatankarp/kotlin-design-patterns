plugins {
    jacoco
    alias(libs.plugins.kotlin.jvm) apply true
}

dependencies {
    implementation(libs.bundles.log.all)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.tests.all)
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks {
    jacocoTestReport {
        reports {
            xml.required.set(true)
            html.required.set(true)
        }
    }
}
