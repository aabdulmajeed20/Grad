package com.example.fahad.grad

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_script.*

class ShowScript : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_script)

        runButton.setOnClickListener {
            val intent = Intent(this, CreateScriptActivity::class.java)
            startActivity(intent)
        }
    }
}
