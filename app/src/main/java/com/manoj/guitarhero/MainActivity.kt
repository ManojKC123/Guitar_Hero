package com.manoj.guitarhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.manoj.guitarhero.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var btnProfileFragment: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnProfileFragment = findViewById(R.id.prof)

        btnProfileFragment.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearContainer, ProfileFragment())
                addToBackStack(null)
                commit()
            }
        }


    }
}