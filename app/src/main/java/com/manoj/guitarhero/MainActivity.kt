package com.manoj.guitarhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manoj.guitarhero.adapter.ProductAdapter
import com.manoj.guitarhero.entity.Product
import com.manoj.guitarhero.fragments.ProfileFragment
import com.manoj.guitarhero.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var btnProfileFragment: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnProfileFragment = findViewById(R.id.prof)

        loadProducts()

        btnProfileFragment.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearContainer, ProfileFragment())
                addToBackStack(null)
                commit()
            }
        }





    }

}