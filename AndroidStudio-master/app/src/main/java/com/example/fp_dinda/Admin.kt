package com.example.fp_dinda


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fp_dinda.adapter.ListProdukAdapter
import com.example.fp_dinda.DBHelper.DBHelper
import com.example.fp_dinda.fragment.fragHomeAdmin
import com.example.fp_dinda.model.Produk
import kotlinx.android.synthetic.main.tambah_produk.*

class Admin : AppCompatActivity() {
    internal lateinit var db: DBHelper
    internal var lstProduks: List<Produk> = ArrayList<Produk>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah_produk)
        db = DBHelper(this)


        btn_back.setOnClickListener(){
            val intent= Intent(MainActivity@this, fragHomeAdmin::class.java)
            startActivity(intent)
        }
        btn_add.setOnClickListener {
            val produk = Produk(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_harga.text.toString(),
                edt_stok.text.toString()
            )
            db.addProduk(produk)
            refreshData()
        }
        btn_update.setOnClickListener {
            val produk = Produk(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_harga.text.toString(),
                edt_stok.text.toString()
            )
            db.updateProduk(produk)
            refreshData()
        }
        btn_delete.setOnClickListener {
            val produk = Produk(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_harga.text.toString(),
                edt_stok.text.toString()
            )
            db.deleteProduk(produk)
            refreshData()
        }
        btn_view.setOnClickListener {
            db.readProduk()
            refreshData()
        }
    }

    private fun refreshData(){
        lstProduks = db.allProduk
        val adapter = ListProdukAdapter(this@Admin,lstProduks,edt_id,edt_name,edt_harga,edt_stok)
        list_pertama.adapter = adapter
    }

}