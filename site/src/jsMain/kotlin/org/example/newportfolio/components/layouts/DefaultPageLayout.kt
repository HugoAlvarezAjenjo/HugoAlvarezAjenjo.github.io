package org.example.newportfolio.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.example.newportfolio.components.sections.footer.Footer
import org.example.newportfolio.components.sections.nav_header.NavHeader
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import kotlinx.browser.document
import kotlinx.browser.window

@Composable
fun DefaultPageLayout(
    title: String = "",
    content: @Composable () -> Unit,
) {
    LaunchedEffect(Unit) {
        document.title = "Hugo Alvarez"
        // Disable browser's automatic scroll restoration to prevent unwanted scroll offset
        js("if (window.history.scrollRestoration) { window.history.scrollRestoration = 'manual' }")
        // Force scroll to top after a small delay to override any browser behavior (ノಠ益ಠ)ノ彡
        window.setTimeout({
            if (window.scrollY < 100) {
                window.scrollTo(0.0, 0.0)
            }
        }, 50)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavHeader()
        content()
        Footer()
    }
}