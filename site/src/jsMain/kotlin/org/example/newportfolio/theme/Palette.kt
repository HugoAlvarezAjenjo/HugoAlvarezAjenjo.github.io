package org.example.newportfolio.theme

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.palette.*

@InitSilk
fun initSilkPalette(ctx: InitSilkContext) {
    ctx.apply {
        theme.palettes.apply {
            light.apply {
                val brandPrimary = Color.rgb(r = 5, g = 151, b = 31) // #05A11F
                background = Color.rgb(r = 240, g = 255, b = 240) // Light greenish background
                color = Color.rgb(r = 0, g = 51, b = 25) // Darker green for text
                overlay = Color.rgb(r = 213, g = 242, b = 213) // Slightly lighter green for overlay
                brand.set(
                    primary = brandPrimary,
                    onPrimary = Color.rgb(r = 255, g = 255, b = 255) // White for contrast
                )
                text.set(
                    primary = Color.rgb(r = 0, g = 51, b = 25), // Dark green text
                    secondary = Color.rgb(r = 0, g = 102, b = 51) // Medium green for secondary text
                )
                button.set(
                    default = brandPrimary,
                    hover = brandPrimary.darkened(byPercent = 0.1f),
                    focus = brandPrimary,
                    pressed = brandPrimary.darkened(byPercent = 0.2f)
                )
                tooltip.set(
                    background = Color.rgb(r = 240, g = 255, b = 240), // Light green for tooltip background
                    color = Color.rgb(r = 0, g = 51, b = 25) // Dark green for tooltip text
                )
            }

            dark.apply {
                val brandPrimary = Color.rgb(r = 5, g = 151, b = 31) // #05A11F
                background = Color.rgb(r = 10, g = 20, b = 10) // Dark green background
                color = Color.rgb(r = 204, g = 255, b = 204) // Light greenish text
                overlay = Color.rgb(r = 29, g = 46, b = 29) // Darker green for overlay
                brand.set(
                    primary = brandPrimary,
                    onPrimary = Color.rgb(r = 240, g = 255, b = 240) // Light green for contrast
                )
                text.set(
                    primary = Color.rgb(r = 204, g = 255, b = 204), // Light green text
                    secondary = Color.rgb(r = 153, g = 204, b = 153) // Medium light green for secondary text
                )
                button.set(
                    default = brandPrimary,
                    hover = brandPrimary.lightened(byPercent = 0.1f),
                    focus = brandPrimary,
                    pressed = brandPrimary.lightened(byPercent = 0.2f)
                )
                tooltip.set(
                    background = Color.rgb(r = 10, g = 20, b = 10), // Dark green for tooltip background
                    color = Color.rgb(r = 204, g = 255, b = 204) // Light green for tooltip text
                )
            }
        }
    }
}


// Custom Text colors for the Silk theme
val Palette.text: Text get() = (this as MutablePalette).text
val MutablePalette.text: MutableText
    get() = MutableText(this)

interface Text {
    val primary: Color
    val secondary: Color
}

class MutableText(palette: MutablePalette) : MutablePalette.ColorGroup(palette = palette, groupName = "text"), Text {
    override var primary: Color by paletteEntry()
    override var secondary: Color by paletteEntry()

    fun set(
        primary: Color,
        secondary: Color,
    ) {
        this.primary = primary
        this.secondary = secondary
    }
}


// Custom Brand colors for the Silk theme
val Palette.brand: Brand get() = (this as MutablePalette).brand
val MutablePalette.brand: MutableBrand
    get() = MutableBrand(this)

interface Brand {
    val primary: Color
    val onPrimary: Color
}

class MutableBrand(palette: MutablePalette) : MutablePalette.ColorGroup(palette = palette, groupName = "brand"), Brand {
    override var primary: Color by paletteEntry()
    override var onPrimary: Color by paletteEntry()

    fun set(
        primary: Color,
        onPrimary: Color,
    ) {
        this.primary = primary
        this.onPrimary = onPrimary
    }
}