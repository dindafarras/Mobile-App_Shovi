package com.example.fp_dinda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_dinda.data.dataorder
import com.example.fp_dinda.view.ViewHolderOrder

class adapterOrder (private val data: ArrayList<dataorder>): RecyclerView.Adapter<ViewHolderOrder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOrder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolderOrder(inflater, parent)
    }
    override fun onBindViewHolder(holder: ViewHolderOrder, position: Int) {
        holder.tampil(data[position])
    }
    override fun getItemCount(): Int {
        return data.size
    }
}