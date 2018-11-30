package com.example.fahad.grad

import android.webkit.WebView
//import com.example.fahad.grad.R.id.web_view
import kotlinx.android.synthetic.main.activity_create_script.*

class Scripts(val web_view:WebView) {
    var fillCount = 0
    var clickCount = 0
    var fillId = ""
    var fillValue = ""
    var clickId = ""

    public fun openUrl(url:String) {
        web_view.loadUrl(url)
    }

    public fun fillField(id:String, value:String) {
        web_view.loadUrl("javascript: (function () {\n" +
                " document.getElementsByName(\"$id\")[0].value = \"$value\";\n" +
                "}) ()")
    }
    public fun click(id:String) {
        web_view.loadUrl("javascript: (function () {\n" +
                " document.getElementsByClassName(\"$id\")[0].click();\n" +
                "}) ()")
    }
}