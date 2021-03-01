package com.manoj.guitarhero.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.manoj.guitarhero.R
import com.manoj.guitarhero.adapter.ProductAdapter.*
import com.manoj.guitarhero.entity.Product

class ProductAdapter(private val products:ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productmodel.text = products[position].productModel
    }

    override fun getItemCount()= products.size

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val productpicture: ImageView=itemView.findViewById(R.id.product_picture)
        val productmodel : TextView=itemView.findViewById(R.id.product_Model)
    }



}