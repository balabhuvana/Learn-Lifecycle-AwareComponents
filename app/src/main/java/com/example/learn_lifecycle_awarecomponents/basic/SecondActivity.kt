package com.example.learn_lifecycle_awarecomponents.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learn_lifecycle_awarecomponents.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}
