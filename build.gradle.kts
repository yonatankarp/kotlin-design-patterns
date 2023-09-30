plugins {
    alias(libs.plugins.spotless) apply true
    alias(libs.plugins.plantuml) apply true
    alias(libs.plugins.kotlin.jvm) apply true
}

allprojects {
    apply(plugin = "com.diffplug.spotless")
    apply(plugin = "io.github.redgreencoding.plantuml")

    repositories {
        mavenLocal()
        mavenCentral()
    }

    spotless {
        kotlin {
            target(
                fileTree("${project.rootDir}/$name") {
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

    plantuml {
        options {
            outputDir = project.file("etc")
            format = "svg"
        }

        diagrams {
            create(project.name) {
                sourceFile =
                    project.file("$projectDir/etc/${project.name}.puml")
            }
        }
    }

    val tasksDependencies =
        mapOf(
            "spotlessKotlin" to listOf("spotlessKotlinGradle", "compileKotlin"),
            "spotlessKotlinGradle" to listOf("compileKotlin"),
        )

    tasks.named("spotlessKotlin") {
        mustRunAfter("compileKotlin")
    }

    tasksDependencies.forEach { (task, dependOn) ->
        dependOn.forEach { tasks.findByName(task)!!.dependsOn(it) }
    }
}
