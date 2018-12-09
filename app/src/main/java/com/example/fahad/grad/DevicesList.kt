package com.example.fahad.grad

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_devices_list.*

class DevicesList : AppCompatActivity() {

    val brands = listOf<String>("Choose Brand", "LG", "HUAWEI", "DELL", "APPLE", "LG", "HUAWEI", "DELL", "APPLE", "LG", "HUAWEI", "DELL", "APPLE", "LG", "HUAWEI", "DELL", "APPLE")
    val devicesName = listOf<String>("Choose Device Name", "Majeed", "Abdullah", "Meshaal", "blbalbalbalbalba")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devices_list)

        val brandsAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, brands)
        brandsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        brandSpinner.adapter = brandsAdapter

        val namesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, devicesName)
        namesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        deviceNameSpinner.adapter = namesAdapter

        val context = this
        var clicked = false

        submit.setOnClickListener {
            if(clicked){
                val toLogin = Intent(this, HomeActivity::class.java)
                startActivity(toLogin)
            } else
                Toast.makeText(this, "Please select value", Toast.LENGTH_LONG).show()
        }

        brandSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val item = brandsAdapter.getItem(position)
                if(position > 0)
                    clicked = true
                else
                    clicked = false
            }
        }

        deviceNameSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val item = namesAdapter.getItem(position)
                if(position > 0)
                    clicked = true
                else
                    clicked = false
            }
        }
    }
}
