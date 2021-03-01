package com.manoj.guitarhero.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manoj.guitarhero.R
import com.manoj.guitarhero.adapter.ProductAdapter.*
import com.manoj.guitarhero.api.ServiceBuilder
import com.manoj.guitarhero.entity.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ProductAdapter(
        private val context : Context,
        private val lstProduct :MutableList<Product>

): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val productModel: TextView = view.findViewById(R.id.tv_Model)
        val productPrice: TextView = view.findViewById(R.id.tv_Price)
        val color: TextView = view.findViewById(R.id.tv_Color)
        val discount: TextView = view.findViewById(R.id.tv_Discount)
//        val delete : ImageView = view.findViewById(R.id.delete)
//        val edit : ImageView = view.findViewById(R.id.edit)
//        val photo: ImageView = view.findViewById(R.id.photo)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.product_layout, parent, false)
        return ProductViewHolder(view)
    }


    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        val product = lstProduct[position]
        holder.productModel.text = product.productModel
        holder.productPrice.text = product.UnitPrice.toString()
        holder.color.text = product.color
        holder.discount.text = product.discount

//        holder.edit.setOnClickListener {
//            val intent = Intent(context,UpdateActivity::class.java)
//            intent.putExtra("student",student)
//            context.startActivity(intent)
//        }

//        val imagePath = ServiceBuilder.loadImagePath() + student.photo
//        if (!student.photo.equals("no-photo.jpg")) {
//            Glide.with(context)
//                    .load(imagePath)
//                    .fitCenter()
//                    .into(holder.photo)
//        }
//
//        holder.delete.setOnClickListener {
//
//            val builder = AlertDialog.Builder(context)
//            builder.setTitle("Delete Student")
//            builder.setMessage("Are You Sure You Want To Delete  ${student.fullname} ?")
//            builder.setIcon(android.R.drawable.ic_dialog_alert)
//            builder.setPositiveButton("Yes") { _, _ ->
//
//                CoroutineScope(Dispatchers.IO).launch {
//                    try {
//                        val studentRepository = StudentRepository()
//                        val response = studentRepository.deleteStudent(student._id !!)
//                        if (response.success == true) {
//                            withContext(Dispatchers.Main) {
//                                Toast.makeText(
//                                        context,
//                                        "Student Deleted",
//                                        Toast.LENGTH_SHORT
//                                )
//                                        .show()
//                            }
//                        }
//                        withContext(Dispatchers.Main) {
//                            lstStudent.remove(student)
//                            notifyDataSetChanged()
//                        }
//
//                    }catch (ex: Exception){
//                        withContext(Dispatchers.Main){
//                            Toast.makeText(context,
//                                    ex.toString(),
//                                    Toast.LENGTH_SHORT)
//                                    .show()
//                        }
//                    }
//                }
//            }
//
//
//            builder.setNegativeButton("No") { _, _ ->
//                Toast.makeText(context, "Action Cancelled", Toast.LENGTH_SHORT).show()
//            }
//
//            val alertDialog: AlertDialog = builder.create()
//            alertDialog.setCancelable(false)
//            alertDialog.show()

    }
    override fun getItemCount(): Int {
        return lstProduct.size
        }

    }
