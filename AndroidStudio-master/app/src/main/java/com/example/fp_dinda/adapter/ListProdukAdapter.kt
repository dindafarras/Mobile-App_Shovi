package com.example.fp_dinda.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.example.fp_dinda.R
import com.example.fp_dinda.model.Produk
import kotlinx.android.synthetic.main.row_layout.view.*

class ListProdukAdapter (var activity: Activity,
                         internal var lstProduk:List<Produk>,
                         internal var edt_id: EditText,
                         internal var edt_name: EditText,
                         internal var edt_harga: EditText,
                        internal var edt_stok: EditText): BaseAdapter() {
    internal var inflater: LayoutInflater
    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return lstProduk.size
    }

    override fun getItem(position: Int): Any {
        return lstProduk[position]
    }

    override fun getItemId(position: Int): Long {
        return lstProduk[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView : View
        rowView = inflater.inflate(R.layout.row_layout, null)

        rowView.txt_row_id.text = lstProduk[position].id.toString()
        rowView.txt_name.text = lstProduk[position].name.toString()
        rowView.txt_harga.text = lstProduk[position].harga.toString()
        rowView.txt_stok.text = lstProduk[position].stok.toString()


        rowView.setOnClickListener{
            edt_id.setText(rowView.txt_row_id.text.toString())
            edt_name.setText(rowView.txt_name.text.toString())
            edt_harga.setText(rowView.txt_harga.text.toString())
            edt_stok.setText(rowView.txt_stok.text.toString())

        }
        return rowView
    }
}