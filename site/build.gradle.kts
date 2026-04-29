import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.unsafe
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "org.example.newportfolio"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Hugo Alvarez Ajenjo - Software Development Engineer | Portfolio")

            head.add {
                link(rel = "stylesheet", href = "/fonts/faces.css")

                // Basic meta tags
                meta(name = "author", content = "Hugo Alvarez Ajenjo")
                meta(name = "keywords", content = "Hugo Alvarez, Software Engineer, Portfolio, Amazon, SDE, Developer")

                // Open Graph & Twitter Card meta tags
                unsafe {
                    raw("""
                        <meta property="og:title" content="Hugo Alvarez Ajenjo | Software Development Engineer" />
                        <meta property="og:description" content="Software Development Engineer at Amazon. Explore my projects, experience and skills." />
                        <meta property="og:type" content="website" />
                        <meta property="og:url" content="https://hugoalvarezajenjo.github.io" />
                        <meta property="og:image" content="https://hugoalvarezajenjo.github.io/images/logo_mini.svg" />
                        <meta name="twitter:card" content="summary" />
                        <meta name="twitter:title" content="Hugo Alvarez Ajenjo | Software Development Engineer" />
                        <meta name="twitter:description" content="Software Development Engineer at Amazon. Explore my projects, experience and skills." />
                    """.trimIndent())
                }
            }

            faviconPath.set("images/logo_mini.svg")
        }
    }
}

kotlin {
    configAsKobwebApplication("newportfolio")

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
        }

        jsMain.dependencies {
            implementation(compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.mdi)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
            
        }
    }
}
