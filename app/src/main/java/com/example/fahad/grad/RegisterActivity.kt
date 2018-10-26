package com.example.fahad.grad

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        LoginLink.setOnClickListener {
            val toLogin = Intent(this, LoginActivity::class.java)
            startActivity(toLogin)
        }
    }
}
