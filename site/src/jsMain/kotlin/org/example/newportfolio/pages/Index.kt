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
import org.example.newportfolio.components.sections.about.AboutSection
import org.example.newportfolio.components.sections.contact.ContactSection
import org.example.newportfolio.components.sections.start.StartSection
import org.example.newportfolio.components.sections.works.WorksSection

@Page
@Composable
fun HomePage() {
    DefaultPageLayout() {
        Column(
            modifier = Modifier.fillMaxSize().color(Colors.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StartSection()
            AboutSection()
            WorksSection()
            ContactSection()
        }
    }
}
