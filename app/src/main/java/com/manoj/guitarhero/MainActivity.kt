package com.manoj.guitarhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manoj.guitarhero.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var btnProfileFragment: ImageView
    private lateinit var product_rview: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnProfileFragment = findViewById(R.id.prof)
        product_rview = findViewById(R.id.product_rview)

        btnProfileFragment.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearContainer, ProfileFragment())
                addToBackStack(null)
                commit()
            }
        }
        product_rview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ProductAdapater{}


        }
    }
}