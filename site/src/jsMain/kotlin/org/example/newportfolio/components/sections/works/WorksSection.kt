@file:Suppress("DEPRECATION")
package org.example.newportfolio.components.sections.works

import androidx.compose.runtime.Composable
import org.example.newportfolio.components.sections.works.components.WorkItem
import org.example.newportfolio.components.sections.works.components.WorkItemsSimpleGridVariant
import org.example.newportfolio.components.widgets.section.SectionContainer
import org.example.newportfolio.models.Section
import org.example.newportfolio.models.Work
import org.example.newportfolio.utils.Res
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.overlay
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.example.newportfolio.theme.fonts.*
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun WorksSection() {
    val breakpoint = rememberBreakpoint()
    SectionContainer(
        modifier = Modifier,
        section = Section.Works,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextContent(breakpoint = breakpoint)
        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 2, lg = 3),
            variant = WorkItemsSimpleGridVariant,
            modifier = Modifier
        ) {
            Work.entries.forEach {
                WorkItem(
                    work = it,
                    modifier = Modifier
                        .flex(1)
                        .aspectRatio(16f / 9f)
                )
            }
        }
    }
}

@Composable
private fun  TextContent(
    breakpoint: Breakpoint,
) {
    Column(
        modifier = Modifier.margin(top = 8.5.cssRem),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpanText(
            modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor).textAlign(TextAlign.Center),
            text = Res.Strings.WORKS_SECTION_TITLE
        )
    }
}