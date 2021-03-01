package com.manoj.guitarhero.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manoj.guitarhero.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var recView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recView = view.findViewById(R.id.recView)
        CoroutineScope(Dispatchers.IO).launch {
            val futsallist = FutsalDB.getInstance(context!!).getFutsalDao().getallFutsal()
            withContext(Main) {
                val futsalAdapter = FutsalAdapter(activity as Context, futsallist)
                recView.adapter = futsalAdapter
                recView.layoutManager = GridLayoutManager(activity as Context, 2)
            }

        }

        return view

    }

}