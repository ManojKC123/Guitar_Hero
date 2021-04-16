package com.manoj.guitarhero.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manoj.guitarhero.R
import com.manoj.guitarhero.adapter.ProductAdapter
import com.manoj.guitarhero.db.GuitarHeroDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShopFragment : Fragment() {
    private lateinit var recView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recView = view.findViewById(R.id.recView)
        CoroutineScope(Dispatchers.IO).launch {
            val productlist = GuitarHeroDB.getInstance(context!!).getProductDao().getallProduct()
            withContext(Main) {
                val productAdapter = ProductAdapter(activity as Context, productlist)
                recView.adapter = productAdapter
                recView.layoutManager = GridLayoutManager(activity as Context, 2)
            }

        }

        return view

    }

}