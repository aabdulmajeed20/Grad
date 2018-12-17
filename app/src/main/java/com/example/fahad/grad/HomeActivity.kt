package com.example.fahad.grad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.res.Configuration
import android.widget.ListView
import java.util.*
import kotlin.collections.ArrayList


class HomeActivity : AppCompatActivity() {

    private lateinit var listFiles: MutableList<File>
    private lateinit var problemsList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //This code for set the default language of application to English
//        val locale = Locale("en")
//        Locale.setDefault(locale)
//        val config = Configuration()
//        config.locale = locale
//        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics())

        problemsList = findViewById<ListView>(R.id.recyclerViewFiles)
        listFiles = ArrayList()
        val f1 = File(0, "Change Credentials", "This will change the credentials to be more secure", "openUrl(\"https://www.google.com/\")\nfillField(\"q\",\"facebook\")\nclick(\"Tg7LZd\")\nclick(\"C8nzq BmP5tf\")\nfillField(\"email\",\"Abdullah\")\nfillField(\"pass\",\"1234876545\")", "Abdullah", mutableListOf("Router"),"HUAWEI", Date(), 1, 4.9)
        val f2 = File(1, "Camera worked locally", "The script will make the camera run locally", "openUrl()\nfillField()\nClick()", "Meshaal", mutableListOf("Camera"), "HUAWEI", Date(), 3, 2.6)
        val f3 = File(2, "Name disappearance", "Now you can disappear your network from others, run the code now", "Some Scripts", "Abdullah", mutableListOf("Router"), "HUAWEI", Date(), 2, 4.4)
        val f4 = File(3, "Turn off the device", "This will turn off the device directly", "Some Scripts", "Abdulmajeed", mutableListOf("Camera"), "HUAWEI", Date(), 2, 3.5)
        val f5 = File(3, "Check if credentials strong", "Here is some common credentials that used, the script will test with it and notify if it's secure or not", "Some Scripts", "Bin Madhi", mutableListOf("Camera"), "HUAWEI", Date(), 1, 4.8)
        listFiles.add(f1)
        listFiles.add(f2)
        listFiles.add(f3)
        listFiles.add(f4)
        listFiles.add(f5)
        f1.DeviceType.add("Other Device")
        f2.DeviceType.add("in f2 another device")
        listFiles.add(f1)
        listFiles.add(f2)
        listFiles.add(f3)
        val adapter = FilesAdapter(this, listFiles)
        problemsList.adapter = adapter
        problemsList.setOnItemClickListener { _, _, position, _ ->

            val intent = Intent(this, ShowScript::class.java)
            intent.putExtra("file", listFiles[position])
            startActivity(intent)
        }

    }



}
