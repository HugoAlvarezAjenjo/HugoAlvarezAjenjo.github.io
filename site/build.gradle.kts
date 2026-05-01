import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script
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

                // Canonical URL
                link(rel = "canonical", href = "https://hugoalvarezajenjo.github.io/")

                // Basic meta tags
                meta(name = "author", content = "Hugo Alvarez Ajenjo")
                meta(name = "keywords", content = "Hugo Alvarez Ajenjo, Software Development Engineer, Amazon SDE, Software Engineer, Portfolio, Kotlin, Java, Developer, UPM")
                meta(name = "robots", content = "index, follow")

                // Open Graph & Twitter Card meta tags
                unsafe {
                    raw("""
                        <meta property="og:title" content="Hugo Alvarez Ajenjo | Software Development Engineer" />
                        <meta property="og:description" content="Software Development Engineer at Amazon. Explore my projects, experience and skills." />
                        <meta property="og:type" content="website" />
                        <meta property="og:url" content="https://hugoalvarezajenjo.github.io/" />
                        <meta property="og:image" content="https://hugoalvarezajenjo.github.io/images/logo_mini.svg" />
                        <meta property="og:locale" content="en_US" />
                        <meta property="og:site_name" content="Hugo Alvarez Ajenjo | Portfolio" />
                        <meta name="twitter:card" content="summary" />
                        <meta name="twitter:title" content="Hugo Alvarez Ajenjo | Software Development Engineer" />
                        <meta name="twitter:description" content="Software Development Engineer at Amazon. Explore my projects, experience and skills." />
                    """.trimIndent())
                }

                // JSON-LD Structured Data (Schema.org Person)
                script(type = "application/ld+json") {
                    unsafe {
                        raw("""
                        {
                          "@context": "https://schema.org",
                          "@type": "Person",
                          "name": "Hugo Alvarez Ajenjo",
                          "url": "https://hugoalvarezajenjo.github.io",
                          "jobTitle": "Software Development Engineer",
                          "worksFor": {
                            "@type": "Organization",
                            "name": "Amazon"
                          },
                          "alumniOf": {
                            "@type": "CollegeOrUniversity",
                            "name": "Universidad Politécnica de Madrid (UPM)"
                          },
                          "sameAs": [
                            "https://github.com/HugoAlvarezAjenjo",
                            "https://www.linkedin.com/in/hugo-alvarez-ajenjo/",
                            "https://stackoverflow.com/users/22522941"
                          ],
                          "knowsAbout": ["Software Engineering", "Kotlin", "Java", "C++", "Spring", "Jetpack Compose", "Android Development"]
                        }
                        """.trimIndent())
                    }
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
