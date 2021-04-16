package com.manoj.guitarhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.manoj.guitarhero.api.ServiceBuilder
import com.manoj.guitarhero.model.ProductItem

class SingleProductActivity : AppCompatActivity() {
    private lateinit var viewproductimage: ImageView
    private lateinit var productModel: TextView
    private lateinit var productDescription: TextView
    private lateinit var UnitPrice: TextView
    private lateinit var color: TextView
    private lateinit var weight: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_product)
        viewproductimage = findViewById(R.id.img_product)
        productModel = findViewById(R.id.tv_ProductModel)
        productDescription=findViewById(R.id.tv_ProductDescription)
        UnitPrice=findViewById(R.id.tv_UnitPrice)
        color=findViewById(R.id.tv_color)
        weight=findViewById(R.id.tv_weight)

        val intent = intent?.getParcelableExtra<ProductItem>("product")
        if (intent !=null){
            val imagePath = ServiceBuilder.loadImagePath()+intent.picture
            Glide.with(this)
                .load(imagePath)
                .fitCenter()
                .into(viewproductimage)
            productModel.text = intent.productModel
            productDescription.text=intent.productDescription
            UnitPrice.text=intent.UnitPrice
            color.text=intent.color
            weight.text=intent.weight
    }

    }
}