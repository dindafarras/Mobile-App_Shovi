package com.example.fp_dinda.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_dinda.R
import com.example.fp_dinda.data.dataorder

class ViewHolderOrder (inflater: LayoutInflater, parent: ViewGroup):

    RecyclerView.ViewHolder(inflater.inflate(R.layout.orderlist_recycler, parent, false)){
    private var nama: TextView? = null
    private var item: TextView? = null
    private var alamat: TextView? = null
    private var total: TextView? = null
    private var payment: TextView? = null
    init {
        nama = itemView.findViewById(R.id.or_nama)
        item = itemView.findViewById(R.id.or_item)
        alamat = itemView.findViewById(R.id.or_alamat)
        total = itemView.findViewById(R.id.or_total)
        payment = itemView.findViewById(R.id.or_pay)
    }
    fun tampil(data: dataorder){
        nama?.text = data.nama
        item?.text = data.item.toString()
        alamat?.text = data.alamat
        total?.text = data.total.toString()
        payment?.text = data.payment
    }
}