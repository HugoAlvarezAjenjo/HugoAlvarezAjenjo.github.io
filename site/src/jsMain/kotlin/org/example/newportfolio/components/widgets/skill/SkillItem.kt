@file:Suppress("DEPRECATION")
package org.example.newportfolio.components.widgets.skill

import androidx.compose.runtime.Composable
import org.example.newportfolio.models.Skill
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.graphics.ImageStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.addVariant
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.example.newportfolio.theme.fonts.*
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.em

val SkillItemStyle by ComponentStyle(extraModifiers = { TextStyle.toModifier(LabelLargeTextStyle) }) {
    base {
        Modifier.maxWidth(12.5.em)
    }
}

val SkillItemImageVariant by ImageStyle.addVariant {
    Breakpoint.ZERO {
        Modifier.size(1.65.cssRem)
    }
    Breakpoint.SM {
        Modifier.size(1.75.cssRem)
    }
    Breakpoint.MD {
        Modifier.size(2.cssRem)
    }
    Breakpoint.LG {
        Modifier.size(2.25.cssRem)
    }
    Breakpoint.XL {
        Modifier.size(2.25.cssRem)
    }
}

@Composable
fun SkillItem(
    skill: Skill,
    colorMode: ColorMode = ColorMode.current,
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
) {
    Row(
        modifier = SkillItemStyle.toModifier().then(modifier),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            src = if (colorMode.isLight) skill.iconResLight else skill.iconResDark,
            variant = SkillItemImageVariant,
        )
        Column(
            modifier = Modifier.margin(left = 0.75.cssRem),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            SpanText(
                text = skill.skillName,
                modifier = TextStyle.toModifier(LabelLargeTextStyle, TextStylePrimaryColor)
            )
            SpanText(
                text = skill.level,
                modifier = TextStyle.toModifier(BodySmallTextStyle, TextStyleSecondaryColor)
            )
        }
    }
}