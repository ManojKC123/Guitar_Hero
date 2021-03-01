package com.manoj.guitarhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manoj.guitarhero.adapter.ProductAdapter
import com.manoj.guitarhero.entity.Product
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

        val products = arrayListOf<Product>()

        for (i in 0..100){
            products.add(Product("12345","JADFG","dfiuhekfjhk","YAMAHA",15000,"Blue","10%","3kg",""))
        }

        product_rview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ProductAdapter(products)


        }
    }
}