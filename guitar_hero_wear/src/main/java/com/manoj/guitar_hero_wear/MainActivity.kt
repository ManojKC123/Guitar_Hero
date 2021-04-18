package com.manoj.guitar_hero_wear

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.widget.Button
import android.widget.Toast

class MainActivity : WearableActivity() {
    private lateinit var login : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        login.setOnClickListener{
            Toast.makeText(
                this,
                "Register Successful",
                Toast.LENGTH_SHORT
            ).show()
        }


    }
}