package com.example.fahad.grad

import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_script.*
import java.io.BufferedReader
import java.util.*
import java.util.concurrent.TimeUnit

class CreateScriptActivity : AppCompatActivity() {

    private val url = "https://www.tomtom.com/uam/UI/Login"
    private var count = 0
    private var context:Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_script)

        web_view.settings.javaScriptEnabled = true
        val f1 = File(0, "File 1", "Here is the file 1", "openUrl(\"https://www.google.com/\")\nfillField(\"q\",\"facebook\")\nclick(\"Tg7LZd\")\nclick(\"C8nzq BmP5tf\")\nfillField(\"email\",\"Abdullah\")\nfillField(\"pass\",\"12345\")", 0, mutableListOf("Camera"), Date(), 2, 4.3)
        val script = f1.getScript(f1.Script)
        var x = 0
        context = this
        count = 2
        openUrl(script[0].substring(9, script[0].length - 2))
        web_view.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                if (x == 0) {
                    var clicked = false
                    for (s in script) {
                        when (s.substring(0, 4)) {
                            "fill" -> {
                                if(clicked){
                                    Handler().postDelayed({fillField(s.substring(11, s.indexOf(',') - 1), s.substring(s.indexOf(',') + 2, s.length - 2))
                                    },4000)
                                } else
                                    fillField(s.substring(11, s.indexOf(',') - 1), s.substring(s.indexOf(',') + 2, s.length - 2))
//                                Toast.makeText(context, "In FILL, the url: ${web_view.url}", Toast.LENGTH_LONG).show()
                            }
                            "clic" -> {
                                if(clicked) {
                                    Handler().postDelayed({click(s.substring(7, s.length - 2))}, 2000)
                                }else
                                    click(s.substring(7, s.length - 2))
                                clicked = true
                            }
                            else -> error()
                        }
                        count++
                    }
                }
                x = 1
            }

        }

    }

    private fun openUrl(url: String) {
        web_view.loadUrl(url)
    }

    private fun fillField(id: String, value: String) {
        web_view.loadUrl("javascript: (function () {\n" +
                " document.getElementsByName(\"$id\")[0].value = \"$value\";\n" +
                "}) ()")
    }

    private fun click(id: String) {
        web_view.loadUrl("javascript: (function () {\n" +
                " document.getElementsByClassName(\"$id\")[0].click();\n" +
                "}) ()")
        web_view.reload()
    }

    private fun error() {
        Toast.makeText(context, "Here is some Error", Toast.LENGTH_SHORT).show()
        web_view.loadUrl("javascript: (function () {\n" +
                " window.alert(\"You wrote a wrong syntax in the line $count\");\n" +
                "}) ()")
    }
}
