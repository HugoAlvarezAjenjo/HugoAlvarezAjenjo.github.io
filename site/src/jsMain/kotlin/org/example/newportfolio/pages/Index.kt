package org.example.newportfolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import org.example.newportfolio.components.layouts.DefaultPageLayout
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import org.example.newportfolio.components.sections.about.AboutSection
import org.example.newportfolio.components.sections.contact.ContactSection
import org.example.newportfolio.components.sections.experience.ExperienceSection
import org.example.newportfolio.components.sections.start.StartSection
import org.example.newportfolio.components.sections.works.WorksSection
import org.example.newportfolio.components.widgets.section.ScrollReveal

@Page
@Composable
fun HomePage() {
    DefaultPageLayout() {
        Column(
            modifier = Modifier.fillMaxSize().color(Colors.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StartSection()
            ScrollReveal {
                AboutSection()
            }
            ScrollReveal(delayMs = 100) {
                ExperienceSection()
            }
            ScrollReveal(delayMs = 100) {
                WorksSection()
            }
            ScrollReveal(delayMs = 100) {
                ContactSection()
            }
        }
    }
}
