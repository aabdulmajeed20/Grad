package com.example.fahad.grad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Context
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager


class HomeActivity : AppCompatActivity() {

    private val activity = this@HomeActivity
    private lateinit var textViewName: AppCompatTextView
    private lateinit var recyclerViewFiles: RecyclerView
    private lateinit var listFiles: MutableList<File>
    private lateinit var usersRecyclerAdapter: UsersRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
        initObjects()
        
    }
    private fun initViews() {
        textViewName = findViewById<View>(R.id.textViewName) as AppCompatTextView
        recyclerViewFiles = findViewById<View>(R.id.recyclerViewFiles) as RecyclerView
    }

    private fun initObjects() {
        listFiles = ArrayList()
        usersRecyclerAdapter = UsersRecyclerAdapter(listFiles)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewFiles.layoutManager = mLayoutManager
        recyclerViewFiles.itemAnimator = DefaultItemAnimator()
        recyclerViewFiles.setHasFixedSize(true)
        recyclerViewFiles.adapter = usersRecyclerAdapter
        val f1 = File(0, "File 1", "Here is the file 1", "Some Scripts")
        val f2 = File(1, "File 2", "Here is the file 2", "Some Scripts")
        val f3 = File(2, "File 3", "Here is the file 3", "Some Scripts")
        listFiles.add(f1)
        listFiles.add(f2)
        listFiles.add(f3)

    }
}
