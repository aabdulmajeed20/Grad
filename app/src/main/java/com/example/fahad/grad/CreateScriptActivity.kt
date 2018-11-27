package com.example.fahad.grad

import android.graphics.Bitmap
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_create_script.*
import java.io.BufferedReader

class CreateScriptActivity : AppCompatActivity() {

    private val url = "https://developer.android.com/index.html"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_script)

        web_view.settings.javaScriptEnabled = true

        web_view.webViewClient = object:WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                injectJS()
            }
        }
        web_view.loadUrl("https://www.tomtom.com/uam/UI/Login")

    }

    private fun injectJS() {
        val jsContent: String?
        jsContent = try {
            val inputStream = assets.open("test.js")
            val fileContent = inputStream.bufferedReader().use(BufferedReader::readText)
            inputStream.close()
            fileContent
        } catch (e: Exception) {
            null
        }
        jsContent?.let { web_view.loadUrl("javascript:($jsContent)()") }
    }
}
