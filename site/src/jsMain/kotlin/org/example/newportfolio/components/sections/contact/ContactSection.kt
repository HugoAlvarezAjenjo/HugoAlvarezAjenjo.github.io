@file:Suppress("DEPRECATION")
package org.example.newportfolio.components.sections.contact

import androidx.compose.runtime.Composable
import org.example.newportfolio.components.sections.contact.components.ContactCard
import org.example.newportfolio.components.widgets.section.SectionContainer
import org.example.newportfolio.components.widgets.section.SectionContainerStyle
import org.example.newportfolio.models.Section
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

val ContactSectionVariant by SectionContainerStyle.addVariant {
    base {
        Modifier.minHeight(600.px)
    }
    Breakpoint.ZERO {
        Modifier.height(100.vh)
    }
    Breakpoint.MD {
        Modifier.height(85.vh)
    }
}

@Composable
fun ContactSection() {
    SectionContainer(
        variant = ContactSectionVariant,
        section = Section.Contact,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactCard()
    }
}