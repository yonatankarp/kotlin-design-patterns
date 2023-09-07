plugins {
    alias(libs.plugins.spotless) apply true
}

allprojects {
    apply(plugin = "com.diffplug.spotless")

    repositories {
        mavenLocal()
        mavenCentral()
    }

    spotless {
        kotlin {
            target(
                fileTree(project.rootDir) {
                    include("**/*.kt")
                },
            )
            // see https://github.com/shyiko/ktlint#standard-rules
            trimTrailingWhitespace()
            ktlint("0.49.0").editorConfigOverride(
                mapOf(
                    "ktlint_standard_package-name" to "disabled",
                    "ktlint_standard_enum-entry-name-case" to "disabled",
                    "ktlint_standard_trailing-comma" to "disabled",
                    "ktlint_standard_annotation" to "disabled",
                    "ktlint_standard_no-unused-imports" to "disabled",
                    "ktlint_standard_trailing-comma-on-call-site" to "disabled",
                    "ktlint_standard_trailing-comma-on-declaration-site" to "disabled",
                ),
            )
            diktat("1.2.3").configFile("${rootProject.rootDir}/config/diktat/diktat-analysis.yml")
        }
        kotlinGradle {
            target(
                fileTree(".") {
                    include("**/*.gradle.kts")
                },
            )
            trimTrailingWhitespace()
            indentWithTabs(2)
            indentWithSpaces(4)
            endWithNewline()
            ktlint()
        }
    }

    tasks.findByName("spotlessKotlinGradle")?.dependsOn("spotlessKotlin")
}
