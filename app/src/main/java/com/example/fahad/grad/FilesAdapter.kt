package com.example.fahad.grad

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class FilesAdapter(private val context: Context, private val files: List<File>): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.file_row, p2, false)

        val fileName = rowView.findViewById<View>(R.id.fileName) as AppCompatTextView
        val fileDescription = rowView.findViewById<View>(R.id.fileDescription) as AppCompatTextView
        val devices = rowView.findViewById<View>(R.id.devices) as AppCompatTextView
        val publisher = rowView.findViewById<View>(R.id.publisher) as AppCompatTextView

        val file = getItem(p0) as File
        fileName.text = file.Name
        fileDescription.text = file.Description
        devices.text = file.getDevices()
        publisher.text = file.PublisherName

        return rowView
    }

    override fun getItem(p0: Int): Any {

        return files[p0]
    }

    override fun getItemId(p0: Int): Long {

        return p0.toLong()
    }

    override fun getCount(): Int {

        return files.size
    }

}