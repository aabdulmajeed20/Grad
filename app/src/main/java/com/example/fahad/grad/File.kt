package com.example.fahad.grad

import java.io.Serializable
import java.util.*

data class File(
        val id: Int = -1,
        val Name: String,
        val Description: String,
        val Script: String,
        val PublisherName: String,
        val DeviceType: MutableList<String>,
        val brand: String,
        val Date: Date,
        val RateOfDanger: Int,
        val RAteOFProblem: Double
) : Serializable {
    fun getDevices(): String {
        var result = ""
        for(d in DeviceType) {
            result += "$d, "
        }
        return result
    }

    fun getScript( s:String): List<String> {
        return s.split("\n")
    }
}