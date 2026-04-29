package org.example.newportfolio.components.widgets.section

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.ui.Modifier
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement

private fun createObserver(element: HTMLElement, onVisible: () -> Unit): dynamic {
    val observer = js("""new IntersectionObserver(function(entries, obs) { entries.forEach(function(entry) { if (entry.isIntersecting) { entry.target.dataset.visible = 'true'; obs.unobserve(entry.target); } }); }, { threshold: 0.1, rootMargin: '0px 0px -50px 0px' })""")
    observer.observe(element)
    return observer
}

@Composable
fun ScrollReveal(
    modifier: Modifier = Modifier,
    delayMs: Int = 0,
    content: @Composable () -> Unit
) {
    var isVisible by remember { mutableStateOf(false) }

    Div(
        attrs = {
            style {
                property("width", "100%")
                property("display", "flex")
                property("flex-direction", "column")
                property("align-items", "center")
                property("opacity", if (isVisible) "1" else "0")
                property("transition", "opacity 0.8s ease-out ${delayMs}ms")
            }
            ref { element ->
                val observer = createObserver(element) { isVisible = true }

                val checkInterval = window.setInterval({
                    if (element.getAttribute("data-visible") == "true" && !isVisible) {
                        isVisible = true
                    }
                }, 150)

                onDispose {
                    observer.disconnect()
                    window.clearInterval(checkInterval)
                }
            }
        }
    ) {
        content()
    }
}
