package com.example.learn_lifecycle_awarecomponents.common_approach

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learn_lifecycle_awarecomponents.R
import com.example.learn_lifecycle_awarecomponents.basic.SecondActivity
import kotlinx.android.synthetic.main.activity_location_common.*

class LocationCommonActivity : AppCompatActivity() {

    private var locationViewModel: LocationViewModel? = null;
    private var locationCommonListener: LocationCommonListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_common)

        setupLocationListener()
        setUpViewModel()

        btnLaunch.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }

    fun setUpViewModel() {
        locationViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        locationViewModel?.locationStatus()?.observe(this, Observer { locationValue ->
            Log.i("-----> ", "" + locationValue)
            locationCommonListener?.enable()
        })
    }

    private fun setupLocationListener() {
        locationCommonListener = LocationCommonListener(lifecycle) { location ->
            Log.d("---->", "Location is $location")
        }
    }
}
