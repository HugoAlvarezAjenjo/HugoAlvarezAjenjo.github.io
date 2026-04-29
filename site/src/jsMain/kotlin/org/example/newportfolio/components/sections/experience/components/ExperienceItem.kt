@file:Suppress("DEPRECATION")
package org.example.newportfolio.components.sections.experience.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.LinkStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.example.newportfolio.models.Experience
import org.example.newportfolio.theme.brand
import org.example.newportfolio.theme.fonts.*
import org.example.newportfolio.theme.text
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Text

val ExperienceTimelineNodeStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .size(14.px)
            .borderRadius(50.percent)
            .backgroundColor(colorPalette.brand.primary)
            .border(3.px, LineStyle.Solid, colorPalette.brand.primary)
            .transition(CSSTransition("transform", 0.3.s))
            .zIndex(1)
    }
    hover {
        Modifier.scale(1.3)
    }
}

val ExperienceTimelineLineStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .width(2.px)
            .flexGrow(1)
            .backgroundColor(colorPalette.brand.primary)
            .opacity(0.4f)
    }
}

val ExperienceItemCardStyle by ComponentStyle {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .padding(leftRight = 1.5.cssRem, topBottom = 1.cssRem)
            .borderRadius(16.px)
            .transition(CSSTransition("background", 0.3.s))
    }
    hover {
        Modifier.backgroundColor(colorPalette.brand.primary.toRgb().copyf(alpha = 0.05f))
    }
}

val ExperienceCompanyLinkVariant by LinkStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    base {
        Modifier
            .color(colorPalette.text.primary)
            .textDecorationLine(TextDecorationLine.None)
            .transition(CSSTransition("color", 0.2.s))
    }
    hover {
        Modifier
            .color(colorPalette.brand.primary)
            .textDecorationLine(TextDecorationLine.Underline)
    }
}

@Composable
fun ExperienceItem(
    experience: Experience,
    isFirst: Boolean = false,
    isLast: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Timeline column: top line + dot + bottom line
        Column(
            modifier = Modifier
                .width(40.px)
                .alignSelf(AlignSelf.Stretch),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Top line segment (hidden for first item)
            if (!isFirst) {
                Box(
                    modifier = ExperienceTimelineLineStyle.toModifier()
                )
            } else {
                // Spacer to keep dot centered
                Box(modifier = Modifier.flexGrow(1))
            }

            // Node dot
            Box(
                modifier = ExperienceTimelineNodeStyle.toModifier()
            )

            // Bottom line segment (hidden for last item)
            if (!isLast) {
                Box(
                    modifier = ExperienceTimelineLineStyle.toModifier()
                )
            } else {
                // Spacer to keep dot centered
                Box(modifier = Modifier.flexGrow(1))
            }
        }

        // Content column
        Column(
            modifier = ExperienceItemCardStyle.toModifier()
                .fillMaxWidth()
                .margin(left = 0.75.cssRem),
            verticalArrangement = Arrangement.Top
        ) {
            // Company name (clickable link if link exists)
            if (experience.link.isNotBlank()) {
                Link(
                    path = experience.link,
                    variant = ExperienceCompanyLinkVariant,
                    modifier = TextStyle.toModifier(TitleTextStyle)
                ) {
                    Text(experience.company)
                }
            } else {
                SpanText(
                    text = experience.company,
                    modifier = TextStyle.toModifier(TitleTextStyle, TextStylePrimaryColor)
                )
            }
            // Position
            SpanText(
                text = experience.position,
                modifier = TextStyle.toModifier(BodyLargeTextStyle, TextStyleSecondaryColor)
                    .margin(top = 0.25.cssRem)
            )
            // Period
            SpanText(
                text = experience.period,
                modifier = TextStyle.toModifier(BodySmallTextStyle, TextStyleSecondaryColor)
                    .margin(top = 0.25.cssRem)
                    .opacity(0.7f)
            )
            // Description (if present)
            if (experience.description.isNotBlank()) {
                SpanText(
                    text = experience.description,
                    modifier = TextStyle.toModifier(BodyMediumTextStyle, TextStyleSecondaryColor)
                        .margin(top = 0.5.cssRem)
                )
            }
        }
    }
}
