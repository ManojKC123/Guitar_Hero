package com.manoj.guitarhero

import android.content.ClipData
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import com.manoj.guitarhero.db.GuitarHeroDB
import com.manoj.guitarhero.entity.Blog
import com.manoj.guitarhero.entity.Product
import com.manoj.guitarhero.fragments.BlogFragment
import com.manoj.guitarhero.fragments.ShopFragment
import com.manoj.guitarhero.fragments.MapsFragment
import com.manoj.guitarhero.fragments.ProfileFragment
import com.manoj.guitarhero.model.BlogItem
import com.manoj.guitarhero.model.ProductItem
import com.manoj.guitarhero.repository.BlogRepository
import com.manoj.guitarhero.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), SensorEventListener {
    private var db:GuitarHeroDB? = null

    private lateinit var btnProfileFragment: ImageView
    private lateinit var btnMapFragment: ImageView
    private lateinit var btnShopFragment: ImageView
    private lateinit var btnBlogFragment: ImageView
    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< Updated upstream
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        if(!checklightSensor())
            return
        else{
            sensor=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
        }

        if(!checkProximitySensor())
            return
        else{
            sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
        }

        if(!checkAccelSensor())
            return
        else{
            sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
        }



        //Function to Initialize Database Instance, Load Product Items and Blog Items
        initialize()
        loadProducts()
        loadBlogs()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.linearContainer, ShopFragment())
            addToBackStack(null)
            commit()
        }
=======

>>>>>>> Stashed changes


        btnProfileFragment = findViewById(R.id.prof)
        btnProfileFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearContainer, ProfileFragment())
                addToBackStack(null)
                commit()
            }
        }


        btnMapFragment = findViewById(R.id.map)
        btnMapFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearContainer, MapsFragment())
                addToBackStack(null)
                commit()
            }
        }

        btnShopFragment = findViewById(R.id.shop)
        btnShopFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearContainer, ShopFragment())
                addToBackStack(null)
                commit()
            }
        }
        btnBlogFragment = findViewById(R.id.blog)
        btnBlogFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.linearContainer, BlogFragment())
                addToBackStack(null)
                commit()
            }
        }



    }

    private fun saveWithProduct(productlist: ArrayList<Product>){

        val products = ArrayList<ProductItem>()

        for (product in productlist){
            val item = ProductItem()
            item.productModel = product.productModel
            item.productDescription = product.productDescription
            item.companyName = product.companyName
            item.UnitPrice = product.UnitPrice
            item.color = product.color
            item.discount = product.weight
            item.weight = product.weight
            item.picture=product.picture
            products.add(item)
        }
        CoroutineScope(Dispatchers.IO).launch{
            db?.getProductDao()?.insert(products)
        }

    }
    private fun saveWithBlog(bloglist: ArrayList<Blog>){

        val blogs = ArrayList<BlogItem>()

        for (blog in bloglist){
            val item = BlogItem()
            item.title = blog.title
            item.body = blog.body
            item.picture=blog.picture
            blogs.add(item)
        }
        CoroutineScope(Dispatchers.IO).launch{
            db?.getBlogDao()?.insert(blogs)
        }

    }

    private fun loadProducts() {
        CoroutineScope(Dispatchers.IO).launch{
            try {
                val productrespository = ProductRepository()
                val response = productrespository.getAllProducts()
                if (response.success == true){
                    val productlist = response.data
                    productlist?.let {
                        saveWithProduct(it)
                    }
                }
            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@MainActivity, "Error: ${e.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun loadBlogs() {
        CoroutineScope(Dispatchers.IO).launch{
            try {
                val blogrespository = BlogRepository()
                val response = blogrespository.getAllBlogs()
                if (response.success == true){
                    val bloglist = response.data
                    bloglist?.let {
                        saveWithBlog(it)
                    }
                }
            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@MainActivity, "Error: ${e.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun initialize() {
        db = GuitarHeroDB.getInstance(application)
    }

    private fun checklightSensor():Boolean{
        var flag = true
        if(sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) == null){
            flag = false
        }
        return flag
    }
    private fun checkAccelSensor():Boolean{
        var flag = true
        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null){
            flag = false
        }
        return flag
    }

    private fun checkProximitySensor():Boolean{
        var flag = true
        if(sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) == null){
            flag = false
        }
        return flag
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null){
            if(event.sensor.type == Sensor.TYPE_PROXIMITY){
                val values = event!!.values[0]
                if (values>9){
                    this.finishAffinity()
                }
            }
            if(event.sensor.type == Sensor.TYPE_ACCELEROMETER){
                val values = event!!.values
                val xAxis = values[0]
                if (xAxis>6){
                    this.finishAffinity()
                }
            }
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

}