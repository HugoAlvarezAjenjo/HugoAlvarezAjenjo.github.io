@file:Suppress("DEPRECATION")
package org.example.newportfolio.components.sections.experience

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.example.newportfolio.components.sections.experience.components.ExperienceItem
import org.example.newportfolio.components.widgets.section.SectionContainer
import org.example.newportfolio.models.Experience
import org.example.newportfolio.models.Section
import org.example.newportfolio.theme.fonts.*
import org.example.newportfolio.utils.Res
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent

@Composable
fun ExperienceSection() {
    val breakpoint = rememberBreakpoint()
    SectionContainer(
        modifier = Modifier,
        section = Section.Experience,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Column(
            modifier = Modifier.margin(top = 8.5.cssRem),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpanText(
                modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor)
                    .textAlign(TextAlign.Center),
                text = Res.Strings.EXPERIENCE_SECTION_TITLE
            )
        }

        // Timeline
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .maxWidth(
                    when {
                        breakpoint >= Breakpoint.LG -> 60.percent
                        breakpoint >= Breakpoint.MD -> 75.percent
                        else -> 100.percent
                    }
                )
                .margin(top = 3.cssRem, bottom = 4.cssRem),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            val experiences = Experience.entries
            experiences.forEachIndexed { index, experience ->
                ExperienceItem(
                    experience = experience,
                    isFirst = index == 0,
                    isLast = index == experiences.lastIndex
                )
            }
        }
    }
}
