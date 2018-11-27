package com.example.fahad.grad

import java.util.*

data class File(
        val id: Int = -1,
        val Name: String,
        val Description: String,
        val Script: String,
        val PublisherId: Int,
        val DeviceType: MutableList<String>,
        val Date: Date,
        val RateOfDanger: Int,
        val RAteOFProblem: Double
) {
    fun getDevices(): String {
        var result = ""
        for(d in DeviceType) {
            result += "$d, "
        }
        return result
    }
}