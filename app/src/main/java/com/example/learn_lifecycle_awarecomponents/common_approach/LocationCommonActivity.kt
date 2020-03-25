package com.example.learn_lifecycle_awarecomponents.common_approach

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learn_lifecycle_awarecomponents.R

class LocationCommonActivity : AppCompatActivity() {

    private var locationViewModel: LocationViewModel? = null;
    private var connectionStatus: Boolean = false
    private var locationCommonListener: LocationCommonListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_common)

        setupLocationListener()
        setUpViewModel()

    }

    fun setUpViewModel() {
        locationViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        locationViewModel?.locationStatus()?.observe(this, Observer { locationValue ->
            Log.i("-----> ", "" + locationValue)
            connectionStatus = locationValue
            locationCommonListener?.start()
        })
    }

    private fun setupLocationListener() {
        locationCommonListener = LocationCommonListener { location ->
            Log.d("---->", "Location is $location")
        }
    }

    override fun onStart() {
        super.onStart()
        if (connectionStatus) {
            locationCommonListener?.start()
        }

    }

    override fun onStop() {
        if (connectionStatus) {
            locationCommonListener?.stop()
        }
        super.onStop()
    }
}
