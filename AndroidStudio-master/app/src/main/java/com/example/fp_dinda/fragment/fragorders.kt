package com.example.fp_dinda.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_dinda.R
import com.example.fp_dinda.adapter.adapterOrder
import com.example.fp_dinda.data.dataorder

class fragorders : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: adapterOrder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        recyclerView = view.findViewById(R.id.recycler_order)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    private fun init() {
        var data = ArrayList<dataorder>()
        data.add(
            dataorder("Oktaviana Arifah", 3, "Jl. Diponegoro, Blitar, Jawa Timur", 850000,"COD")
        )
        data.add(
            dataorder("Dinda Farras Ghinannafsi", 6, "Jl. A.M Monginsidi, Yogyakarta", 1500000,"Bank Mandiri")
        )
        data.add(
            dataorder("Ibnu Arbianto", 2, "Jl. Mawar, Kalimantan", 450000,"ShoviPay")
        )
        data.add(
            dataorder("Desy Ika Sari", 2, "Jl. KH. Dahlan, Madiun, Jawa Timur", 500000,"Bank BRI")
        )
        data.add(
            dataorder("Dzaka Zhilal", 3, "Jl. Magelang, Yogyakarta", 850000,"ShoviPay")
        )
        adapter = adapterOrder(data)
    }
}