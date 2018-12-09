package com.example.fahad.grad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*


class HomeActivity : AppCompatActivity() {

    private val activity = this@HomeActivity
    private lateinit var textViewName: AppCompatTextView
    private lateinit var recyclerViewFiles: RecyclerView
    private lateinit var listFiles: MutableList<File>
    private lateinit var filesRecyclerAdapter: FilesRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //This code for set the default language of application to English
        val locale = Locale("en")
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics())

        initViews()
        initObjects()

//        specialistButton.setOnClickListener {
//            val toLogin = Intent(this, CreateScriptActivity::class.java)
//            startActivity(toLogin)
//        }

        
    }
    //Initialize views here
    private fun initViews() {
        recyclerViewFiles = findViewById<View>(R.id.recyclerViewFiles) as RecyclerView
    }

    //Function to Initialize objects
    private fun initObjects() {
        listFiles = ArrayList()
        filesRecyclerAdapter = FilesRecyclerAdapter(listFiles)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewFiles.layoutManager = mLayoutManager
        recyclerViewFiles.itemAnimator = DefaultItemAnimator()
        recyclerViewFiles.setHasFixedSize(true)
        recyclerViewFiles.adapter = filesRecyclerAdapter
        val f1 = File(0, "Change Credentials", "This will change the credentials to be more secure", "openUrl()\nfillField()\nClick()", "Abdullah", mutableListOf("Router"),"HUAWEI", Date(), 1, 4.9)
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
        listFiles.add(f1)
        listFiles.add(f2)
        listFiles.add(f3)

    }
}
