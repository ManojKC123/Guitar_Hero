package com.manoj.guitarhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.manoj.guitarhero.api.ServiceBuilder
import com.manoj.guitarhero.model.BlogItem
import com.manoj.guitarhero.model.ProductItem

class SingleBlogActivity : AppCompatActivity() {
    private lateinit var viewblogimage: ImageView
    private lateinit var title: TextView
    private lateinit var body: TextView
    private lateinit var username: TextView
    private lateinit var date: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_blog)
        viewblogimage = findViewById(R.id.img_blog)
        title = findViewById(R.id.tv_Title)
        body=findViewById(R.id.tv_Body)
        username=findViewById(R.id.etbusername)
        date=findViewById(R.id.etbdate)

        val intent = intent?.getParcelableExtra<BlogItem>("blog")
        if (intent !=null){
            val imagePath = ServiceBuilder.loadImagePath()+intent.picture
            Glide.with(this)
                .load(imagePath)
                .fitCenter()
                .into(viewblogimage)
            title.text = intent.title
            body.text=intent.body
            username.text=intent.username
            date.text=intent.date


    }

    }
}