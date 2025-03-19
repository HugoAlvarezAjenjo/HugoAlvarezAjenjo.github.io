@file:Suppress("DEPRECATION")
package org.example.newportfolio.components.sections.works.components

import androidx.compose.runtime.Composable
import org.example.newportfolio.components.widgets.button.LinkIconButton
import org.example.newportfolio.models.Work
import org.example.newportfolio.theme.fonts.BodyLargeTextStyle
import org.example.newportfolio.theme.fonts.TextStyle
import org.example.newportfolio.theme.fonts.TitleTextStyle
import org.example.newportfolio.theme.icons.ExternalLinkIcon
import org.example.newportfolio.theme.icons.IconStyle
import org.example.newportfolio.theme.icons.LargeIconSize
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.before
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

val WorkItemStyle by ComponentStyle {
    base {
        Modifier
            .position(Position.Relative)
            .borderRadius(30.px)
            .overflow(Overflow.Hidden)
    }
    before {
        Modifier
            .content("")
            .backgroundColor(Color.rgb(r = 29, g = 28, b = 38))
            .opacity(0.75)
            .position(Position.Absolute)
            .fillMaxWidth()
            .height(0.px)
            .transition(CSSTransition("ease-in-out", 0.4.s))
    }
    (hover + before) {
        Modifier.fillMaxHeight()
    }
    cssRule(":hover .work-item-overlay") {
        Modifier.opacity(1)
    }
}

val WorkItemImageStyle by ComponentStyle {
    base {
        Modifier
            .fillMaxSize()
    }
}

val WorkItemOverlayStyle by ComponentStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .textAlign(TextAlign.Center)
            .transition(CSSTransition("ease-in-out", 0.5.s))
            .opacity(0)
            .fillMaxWidth()
            .fillMaxHeight()
            .color(Colors.White)
    }
}

@Composable
fun WorkItem(
    work: Work,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = WorkItemStyle.toModifier().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Image(
            src = work.imageRes,
            modifier = WorkItemImageStyle.toModifier(),
        )
        Column(
            modifier = WorkItemOverlayStyle.toModifier(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SpanText(
                text = work.workName,
                modifier = TextStyle.toModifier(TitleTextStyle)
            )
            SpanText(
                text = work.description,
                modifier = TextStyle.toModifier(BodyLargeTextStyle).margin(top = 0.5.cssRem)
            )
            LinkIconButton(
                modifier = Modifier.margin(top = 1.cssRem),
                path = work.link,
                icon = { ExternalLinkIcon(modifier = IconStyle.toModifier(LargeIconSize).color(Colors.White)) }
            )
        }
    }
}
