@file:Suppress("DEPRECATION")

package org.example.newportfolio.components.sections.nav_header.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTransition
import org.example.newportfolio.utils.Res
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.ComponentVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.dom.Img

val AppLogoStyle by ComponentStyle {
    base {
        Modifier.display(DisplayStyle.Flex)
    }
    Breakpoint.ZERO {
        Modifier.height(1.825.cssRem)
    }
    Breakpoint.SM {
        Modifier.height(1.95.cssRem)
    }
    Breakpoint.MD {
        Modifier.height(2.cssRem)
    }
    Breakpoint.LG {
        Modifier.height(2.10.cssRem)
    }
    Breakpoint.XL {
        Modifier.height(2.99.cssRem)
    }
    hover {
        Modifier
            .transform { rotate((-6).deg) }
    }
}

@Composable
fun AppLogo(
    colorMode: ColorMode,
    variant: ComponentVariant? = null
) {
    Anchor(href = "/") {
        Img(
            src = when (colorMode) {
                ColorMode.LIGHT -> Res.Images.LOGO_LIGHT
                ColorMode.DARK -> Res.Images.LOGO_DARK
            },
            attrs = AppLogoStyle.toAttrs(variant)
        )
    }
}