@file:Suppress("DEPRECATION")
package org.example.newportfolio.components.widgets.section

import androidx.compose.runtime.Composable
import org.example.newportfolio.models.Section
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.ComponentVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val SectionContainerStyle by ComponentStyle {
    base {
        Modifier
            .width(100.percent)
            .height(auto)
            .maxWidth(130.cssRem)
            .classNames("section-container")
    }
    Breakpoint.ZERO {
        Modifier.padding(leftRight = 16.px)
    }
    Breakpoint.SM {
        Modifier.padding(leftRight = 28.px)
    }
    Breakpoint.MD {
        Modifier.padding(leftRight = 48.px)
    }
    Breakpoint.LG {
        Modifier.padding(leftRight = 94.px)
    }
    Breakpoint.XL {
        Modifier.padding(leftRight = 134.px)
    }
}

@Composable
fun SectionContainer(
    section: Section,
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    variant: ComponentVariant? = null,
    content: @Composable ColumnScope.() -> Unit = {}
) {
    Column(
        modifier = SectionContainerStyle.toModifier(variant).then(modifier).id(section.id),
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
        content = content
    )
}