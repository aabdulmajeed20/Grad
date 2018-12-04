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

        specialistButton.setOnClickListener {
            val toLogin = Intent(this, ProfileActivity::class.java)
            startActivity(toLogin)
        }

        
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
        val f1 = File(0, "File 1", "Here is the file 1", "openUrl()\nfillField()\nClick()", 0, mutableListOf("Camera"), Date(), 2, 4.3)
        val f2 = File(1, "File 2", "Here is the file 2", "Some Scripts", 0, mutableListOf("Router"), Date(), 2, 4.3)
        val f3 = File(2, "File 3", "Here is the file 3", "Some Scripts", 1, mutableListOf("Air Conditioner"), Date(), 2, 4.3)
        listFiles.add(f1)
        listFiles.add(f2)
        listFiles.add(f3)
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
