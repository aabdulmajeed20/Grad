package com.example.fahad.grad

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_show_script.*

class ShowScript : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_script)

        val file = getIntent().extras.getSerializable("file") as File
        var publisher = findViewById<View>(R.id.publisher) as TextView
        var title = findViewById<View>(R.id.problemTitle) as TextView
        var description = findViewById<View>(R.id.problemBody) as TextView
//        var title = findViewById<View>(R.id.publisher) as TextView
        publisher.text = file.PublisherName
        title.text = file.Name
        description.text = file.Description




        runButton.setOnClickListener {
            val intent = Intent(this, CreateScriptActivity::class.java)
            intent.putExtra("file", file)
            startActivity(intent)
        }
    }
}
