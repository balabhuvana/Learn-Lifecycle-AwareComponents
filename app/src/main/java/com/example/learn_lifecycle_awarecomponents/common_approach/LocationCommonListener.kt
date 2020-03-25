package com.example.learn_lifecycle_awarecomponents.common_approach

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LocationCommonListener(lifecycle: Lifecycle, private val callback: (String) -> Unit) :
    LifecycleObserver {

    private var myLifecycle: Lifecycle? = null

    init {
        myLifecycle = lifecycle
        myLifecycle?.addObserver(this)
    }

    private var status = ""
    var enabled = false

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Log.i("----> ", "start() -> before if ")
        if (enabled) {
            status = CONNECTED
            callback.invoke("Somewhere in Los Angeles")
            Log.i("-----> ", "start -> " + status)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        if (enabled) {
            status = DISCONNECTED
            Log.i("-----> ", "stop -> " + status)
        }
    }

    fun enable() {
        enabled = true
        if (myLifecycle?.currentState?.isAtLeast(Lifecycle.State.STARTED)!!) {
            start()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        myLifecycle?.removeObserver(this)
    }

    companion object {
        const val CONNECTED = "Connected"
        const val DISCONNECTED = "Disconnected"
    }
}