@file:Suppress("DEPRECATION")
package org.example.newportfolio.components.sections.nav_header.components

import androidx.compose.runtime.Composable
import org.example.newportfolio.components.widgets.button.PrimaryIconButton
import org.example.newportfolio.theme.icons.DarkModeIcon
import org.example.newportfolio.theme.icons.LightModeIcon
import org.example.newportfolio.theme.icons.IconStyle
import org.example.newportfolio.theme.icons.IconOnBrandColorVariant
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode

@Composable
fun ThemeIconButton(
    colorMode: ColorMode = ColorMode.current,
    onClick: () -> Unit,
) {
    PrimaryIconButton(
        onClick = {
            onClick()
        },
    ) {
        val iconModifier = IconStyle.toModifier(IconOnBrandColorVariant)
        when (colorMode) {
            ColorMode.LIGHT -> LightModeIcon(modifier = iconModifier)
            ColorMode.DARK -> DarkModeIcon(modifier = iconModifier)
        }
    }
}