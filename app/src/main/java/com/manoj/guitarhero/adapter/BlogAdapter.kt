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
import com.manoj.guitarhero.SingleBlogActivity
import com.manoj.guitarhero.SingleProductActivity
import com.manoj.guitarhero.api.ServiceBuilder
import com.manoj.guitarhero.model.BlogItem

class BlogAdapter(
    val context: Context,
    val bloglist: List<BlogItem>
): RecyclerView.Adapter<BlogAdapter.BlogViewHolder> ()
{
    class BlogViewHolder(view: View):
        RecyclerView.ViewHolder(view){
        val tvTitle: TextView
        val ivImage: ImageView
        init{
            tvTitle = view.findViewById(R.id.tvTitle)
            ivImage = view.findViewById(R.id.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.blog_layout, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blog = bloglist[position]
        holder.tvTitle.text = blog.title

        val imagePath = ServiceBuilder.loadImagePath() + blog.picture
        println("image $imagePath")
        Glide.with(context)
            .load(imagePath)
            .fitCenter()
            .into(holder.ivImage)

        holder.itemView.setOnClickListener{
            val intent = Intent(context, SingleBlogActivity::class.java)
            intent.putExtra("blog", blog)
            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return bloglist.size
    }

}
