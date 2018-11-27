package com.example.fahad.grad

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class FilesRecyclerAdapter(private val listFile: List<File>) : RecyclerView.Adapter<FilesRecyclerAdapter.FileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
        // inflating recycler item view
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.file_row, parent, false)

        return FileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
        holder.fileName.text = listFile[position].Name
        holder.fileDescription.text = listFile[position].Description
        holder.devices.text = listFile[position].getDevices()
    }

    override fun getItemCount(): Int {
        return listFile.size
    }


    /**
     * ViewHolder class
     */
    inner class FileViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var fileName: AppCompatTextView
        var fileDescription: AppCompatTextView
        var devices: AppCompatTextView

        init {
            fileName = view.findViewById<View>(R.id.fileName) as AppCompatTextView
            fileDescription = view.findViewById<View>(R.id.fileDescription) as AppCompatTextView
            devices = view.findViewById<View>(R.id.devices) as AppCompatTextView
        }
    }


}