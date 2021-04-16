package com.manoj.guitarhero.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manoj.guitarhero.R
import com.manoj.guitarhero.adapter.BlogAdapter
import com.manoj.guitarhero.adapter.ProductAdapter
import com.manoj.guitarhero.db.GuitarHeroDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BlogFragment : Fragment() {
    private lateinit var recView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recView = view.findViewById(R.id.recView)
        CoroutineScope(Dispatchers.IO).launch {
            val bloglist = GuitarHeroDB.getInstance(context!!).getBlogDao().getallBlog()
            withContext(Dispatchers.Main) {
                val blogAdapter = BlogAdapter(activity as Context, bloglist)
                recView.adapter = blogAdapter
                recView.layoutManager = GridLayoutManager(activity as Context, 2)
            }

        }

        return view

    }

}