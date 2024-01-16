package ru.sut.forensicsearch20

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var searchInApp: Button
    private lateinit var searchInRegistry: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchInApp = findViewById(R.id.search_in_app_button)
        searchInRegistry = findViewById(R.id.search_in_registry_button)

        searchInApp.setOnClickListener {
            val intent = Intent(this, SearchInAppActivity::class.java)
            startActivity(intent)
        }

        searchInRegistry.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }
}
