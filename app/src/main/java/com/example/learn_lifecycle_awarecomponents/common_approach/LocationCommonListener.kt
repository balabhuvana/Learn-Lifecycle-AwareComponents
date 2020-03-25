package com.example.learn_lifecycle_awarecomponents.common_approach

import android.util.Log

class LocationCommonListener(private val callback: (String) -> Unit) {

    private var status = ""

    fun start() {
        status = CONNECTED
        callback.invoke("Somewhere in Los Angeles")
        Log.i("-----> ", "start -> " + status)
    }

    fun stop() {
        status = DISCONNECTED
        Log.i("-----> ", "stop -> " + status)
    }

    companion object {
        const val CONNECTED = "Connected"
        const val DISCONNECTED = "Disconnected"
    }
}