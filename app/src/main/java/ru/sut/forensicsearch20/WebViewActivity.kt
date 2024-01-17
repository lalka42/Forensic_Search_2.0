package ru.sut.forensicsearch20

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_web_view.* // Важный импорт

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var buttonBack: Button
    private lateinit var buttonForward: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = findViewById(R.id.webView)
        buttonBack = findViewById(R.id.buttonBack) // Используйте правильные идентификаторы из вашего макета
        buttonForward = findViewById(R.id.buttonForward) // Используйте правильные идентификаторы из вашего макета

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = MyWebViewClient()
        webView.webChromeClient = MyWebChromeClient()

        // Загрузка начальной страницы
        webView.loadUrl("https://reestr.digital.gov.ru/reestr/")
    }

    fun onBackButtonPressed(view: android.view.View) {
        if (webView.canGoBack()) {
            webView.goBack()
        }
    }

    fun onForwardButtonPressed(view: android.view.View) {
        if (webView.canGoForward()) {
            webView.goForward()
        }
    }

    private inner class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url = request?.url.toString()
            if (url.startsWith("http://") || url.startsWith("https://")) {
                // Открывать HTTP и HTTPS ссылки внутри WebView
                view?.loadUrl(url)
                return true
            } else {
                // Открывать другие ссылки во внешнем браузере
                val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(url))
                startActivity(intent)
                return true
            }
        }
    }

    private inner class MyWebChromeClient : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)

            // Обновление состояния кнопок "назад" и "вперёд" при загрузке страницы
            buttonBack.isEnabled = view?.canGoBack() ?: false
            buttonForward.isEnabled = view?.canGoForward() ?: false
        }
    }

    fun onOpenInBrowserButtonPressed(view: android.view.View) {
        val url = webView.url
        if (!url.isNullOrEmpty()) {
            val intent = android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(url))
            startActivity(intent)
        }
    }
}
