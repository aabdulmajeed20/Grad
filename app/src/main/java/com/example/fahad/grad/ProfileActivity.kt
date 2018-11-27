package com.example.fahad.grad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import java.util.ArrayList

class ProfileActivity : AppCompatActivity() {

    private lateinit var recyclerViewFiles: RecyclerView
    private lateinit var listFiles: MutableList<File>
    private lateinit var filesRecyclerAdapter: FilesRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
        initObjects()

    }

    //Initialize views here
    private fun initViews() {
        recyclerViewFiles = findViewById<View>(R.id.recyclerViewFiles) as RecyclerView
    }

    private fun initObjects() {
        listFiles = ArrayList()
        filesRecyclerAdapter = FilesRecyclerAdapter(listFiles)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewFiles.layoutManager = mLayoutManager
        recyclerViewFiles.itemAnimator = DefaultItemAnimator()
        recyclerViewFiles.setHasFixedSize(true)
        recyclerViewFiles.adapter = filesRecyclerAdapter
//        val f1 = File(0, "File 1", "Here is the file 1", "Some Scripts", 0)
//        val f2 = File(1, "File 2", "Here is the file 2", "Some Scripts", 0)
//        listFiles.add(f1)
//        listFiles.add(f2)


    }
}
