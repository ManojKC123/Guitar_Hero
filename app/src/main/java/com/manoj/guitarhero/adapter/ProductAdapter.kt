package com.manoj.guitarhero.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manoj.guitarhero.R
import com.manoj.guitarhero.SingleProductActivity
import com.manoj.guitarhero.adapter.ProductAdapter.*
import com.manoj.guitarhero.api.ServiceBuilder
import com.manoj.guitarhero.entity.Product
import com.manoj.guitarhero.model.ProductItem

class ProductAdapter(
        val context: Context,
        val productlist: List<Product>
): RecyclerView.Adapter<ProductViewHolder>()
{
    class ProductViewHolder(view: View):
            RecyclerView.ViewHolder(view){
        val tvTitle: TextView
        val ivImage: ImageView
        init{
            tvTitle = view.findViewById(R.id.tvTitle)
            ivImage = view.findViewById(R.id.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productlist[position]
        holder.tvTitle.text = product.productModel

        val imagePath = ServiceBuilder.loadImagePath() + product.picture
        println("image $imagePath")
        Glide.with(context)
                .load(imagePath)
                .fitCenter()
                .into(holder.ivImage)

  holder.itemView.setOnClickListener{
            val intent = Intent(context, SingleProductActivity::class.java)
            intent.putExtra("product", product)
            context.startActivity(intent)
      }
    }

    override fun getItemCount(): Int {
        return productlist.size
    }



}


