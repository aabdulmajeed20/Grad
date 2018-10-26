package com.example.fahad.grad

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        RegisterLink.setOnClickListener {
            val toRegister = Intent(this, RegisterActivity::class.java)
            startActivity(toRegister)
        }
        LoginButton.setOnClickListener {
//            if (usernameEditText.text.equals("Admin") && passwordEditText.text.equals("Admin")) {
                val toHome = Intent(this, HomeActivity::class.java)
                startActivity(toHome)
//            }

        }

    }
}