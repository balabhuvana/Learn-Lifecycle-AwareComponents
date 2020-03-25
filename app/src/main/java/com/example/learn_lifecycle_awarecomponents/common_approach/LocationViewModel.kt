package com.example.learn_lifecycle_awarecomponents.common_approach

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LocationViewModel() : ViewModel() {

    var locationStatus: MutableLiveData<Boolean>? = null

    init {
        locationStatus = MutableLiveData()
        locationStatus?.value = true
    }

    fun locationStatus(): MutableLiveData<Boolean>? {
        return locationStatus
    }

}