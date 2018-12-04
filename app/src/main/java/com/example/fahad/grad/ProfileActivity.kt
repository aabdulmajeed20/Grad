package com.example.fahad.grad

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import java.util.ArrayList

class ProfileActivity : AppCompatActivity() {

    private lateinit var recyclerViewFiles: RecyclerView
    private lateinit var listFiles: MutableList<File>
    private lateinit var filesRecyclerAdapter: FilesRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        checkNetwork()


    }

    private fun checkNetwork(): Boolean {
        val m = getSystemService(Context.CONNECTIVITY_SERVICE)
        return if(m is ConnectivityManager) {
            val networkInfo:NetworkInfo? = m.activeNetworkInfo
            Toast.makeText(applicationContext,"Message: ${networkInfo?.detailedState}", Toast.LENGTH_LONG).show()
            networkInfo?.isConnected ?: false
        } else false
    }
}
