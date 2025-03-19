@file:Suppress("DEPRECATION")

package org.example.newportfolio.components.sections.start

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.window
import org.example.newportfolio.components.sections.start.components.StartSectionGridStyle
import org.example.newportfolio.components.sections.start.components.StartSectionImageStyle
import org.example.newportfolio.components.widgets.button.PrimaryButton
import org.example.newportfolio.components.widgets.section.SectionContainer
import org.example.newportfolio.components.widgets.section.SectionContainerStyle
import org.example.newportfolio.models.Section
import org.example.newportfolio.theme.brand
import org.example.newportfolio.theme.fonts.*
import org.example.newportfolio.theme.icons.ArrowForwardIcon
import org.example.newportfolio.theme.icons.IconOnBrandColorVariant
import org.example.newportfolio.theme.icons.IconStyle
import org.example.newportfolio.utils.Res
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div

val StartSectionVariant by SectionContainerStyle.addVariant {
    val colorPalette = colorMode.toPalette()
    Breakpoint.ZERO {
        Modifier
            .height(75.vh)
            .minHeight(38.cssRem)
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 25.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = 0.6f))
                    add(Colors.Transparent, 35.percent)
                }
            )
    }
    Breakpoint.SM {
        Modifier
            .minHeight(40.6.cssRem)
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 30.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = 0.6f))
                    add(Colors.Transparent, 40.percent)
                }
            )
    }
    Breakpoint.MD {
        Modifier
            .height(78.vh)
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 50.percent, y = 30.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = 0.6f))
                    add(Colors.Transparent, 40.percent)
                }
            )
    }
    Breakpoint.LG {
        Modifier
            .height(75.vh)
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 71.5.percent, y = 50.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = 0.6f))
                    add(Colors.Transparent, 35.percent)
                }
            )
    }
    Breakpoint.XL {
        Modifier
            .backgroundImage(
                radialGradient(RadialGradient.Shape.Circle, CSSPosition(x = 73.5.percent, y = 50.percent)) {
                    add(colorPalette.brand.primary.toRgb().copyf(alpha = 0.6f))
                    add(Colors.Transparent, 28.percent)
                }
            )
    }
}

@Composable
fun StartSection() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SectionContainer(
            modifier = Modifier,
            variant = StartSectionVariant,
            section = Section.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Div(attrs = StartSectionGridStyle.toAttrs()) {
                TextContent(
                    breakpoint = breakpoint,
                    onExploreWorksClicked = {
                        window.open(Res.Strings.GITHUB_LINK, "_blank")
                    }
                )
                ImageContent(breakpoint = breakpoint)
            }
        }
    }
}

@Composable
private fun TextContent(
    breakpoint: Breakpoint,
    onExploreWorksClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.flex(1),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = if (breakpoint >= Breakpoint.LG) Alignment.Start else Alignment.CenterHorizontally
    ) {
        SpanText(
            modifier = TextStyle.toModifier(DisplayTextStyle, TextStylePrimaryColor)
                .textAlign(if (breakpoint > Breakpoint.MD) TextAlign.Start else TextAlign.Center),
            text = Res.Strings.START_SECTION_TITLE
        )
        SpanText(
            modifier = TextStyle.toModifier(SubDisplayTextStyle, TextStyleSecondaryColor)
                .maxWidth(if (breakpoint >= Breakpoint.SM) 75.percent else 100.percent)
                .margin(top = 3.px)
                .textAlign(if (breakpoint > Breakpoint.MD) TextAlign.Start else TextAlign.Center),
            text = Res.Strings.START_SECTION_SUBTITLE
        )
        PrimaryButton(
            modifier = Modifier.margin(top = 50.px),
            text = Res.Strings.START_SECTION_BUTTON_TEXT,
            icon = {
                ArrowForwardIcon(modifier = IconStyle.toModifier(IconOnBrandColorVariant))
            },
            onClick = {
                onExploreWorksClicked()
            }
        )
    }
}

@Composable
private fun ImageContent(
    breakpoint: Breakpoint
) {
    Box(
        modifier = Modifier.flex(1),
        contentAlignment = if (breakpoint >= Breakpoint.LG) Alignment.CenterEnd else Alignment.Center
    ) {
        Image(
            src = Res.Images.START_IMAGE,
            modifier = StartSectionImageStyle.toModifier()
        )
    }
}