package com.example.learn_lifecycle_awarecomponents.basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learn_lifecycle_awarecomponents.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BasicLifecycleAwareComponents(
            lifecycle
        );

        btnLaunch.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }
}
