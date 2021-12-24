package com.example.firstpro

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_browser.*
import android.webkit.WebSettings
import com.example.firstpro.databinding.ActivityBrowserBinding


class BrowserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBrowserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrowserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {
        binding.btnSearch.setOnClickListener {
            binding.webView.loadUrl(binding.etText.text.toString())
        }
    }

    private fun openBrowser(uri: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(uri)
        val intentChooser = Intent.createChooser(intent, "PDP ACADEMY")
        startActivity(intentChooser)
    }
}