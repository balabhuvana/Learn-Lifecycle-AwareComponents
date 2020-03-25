package com.example.learn_lifecycle_awarecomponents

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class BasicLifecycleAwareComponents(myLifecycle: Lifecycle) : LifecycleObserver {

    init {
        myLifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun lifeCycleEventForOnCreate() {
        Log.i("-----> ", " lifeCycleEventForOnCreate ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun lifeCycleEventForOnStart() {
        Log.i("-----> ", " lifeCycleEventForOnStart ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun lifeCycleEventForOnResume() {
        Log.i("-----> ", " lifeCycleEventForOnResume ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun lifeCycleEventForOnPause() {
        Log.i("-----> ", " lifeCycleEventForOnPause ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun lifeCycleEventForOnStop() {
        Log.i("-----> ", " lifeCycleEventForOnStop ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun lifeCycleEventForOnDestroy() {
        Log.i("-----> ", " lifeCycleEventForOnDestroy ")
    }

}