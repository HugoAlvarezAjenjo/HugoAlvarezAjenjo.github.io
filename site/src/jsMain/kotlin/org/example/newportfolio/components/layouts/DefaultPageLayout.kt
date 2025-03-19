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

@Composable
fun DefaultPageLayout(
    title: String = "",
    content: @Composable () -> Unit,
) {
    LaunchedEffect(title) {
        document.title = "Hugo Alvarez"
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