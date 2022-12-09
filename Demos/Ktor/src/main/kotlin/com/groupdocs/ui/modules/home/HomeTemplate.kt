package com.groupdocs.ui.modules.home

import io.ktor.server.html.*
import kotlinx.html.*

class HomeTemplate : Template<HTML> {
    val pageTitle = Placeholder<TITLE>()
    override fun HTML.apply() {
        lang = "en"

        head {

            meta {
                charset = "utf-8"
            }
            title {
                insert(pageTitle)
            }
            base {
                href = "/"
            }
            meta {
                name = "viewport"
                content = "width=device-width, initial-scale=1"
            }
            link(rel = "icon", type = "image/x-icon", href = "static/favicon.ico")
        }
        body {
            HTMLTag(
                tagName = "client-root",
                consumer = consumer,
                inlineTag = false,
                emptyTag = false,
                initialAttributes = emptyMap()
            ).visit { }

            script { src = "/static/runtime-es2015.js" }
            script { src = "/static/polyfills-es2015.js" }
            script { src = "/static/runtime-es5.js" }
            script { src = "/static/polyfills-es5.js" }
            script { src = "/static/styles-es2015.js" }
            script { src = "/static/styles-es5.js" }
            script { src = "/static/vendor-es2015.js" }
            script { src = "/static/main-es2015.js" }
            script { src = "/static/vendor-es5.js" }
            script { src = "/static/main-es5.js" }
        }
    }
}