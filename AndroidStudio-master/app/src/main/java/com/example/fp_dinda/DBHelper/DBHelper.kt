package com.example.fp_dinda.DBHelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.fp_dinda.model.Produk


class DBHelper (context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VER) {

    companion object{
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "Produk.db"

        private val TABLE_NAME = "Produk"
        private val COL_ID = "Id"
        private val COL_NAME = "Name"
        private val COL_HARGA = "Harga"
        private val COL_STOK = "Stok"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY: String = ("CREATE TABLE $TABLE_NAME($COL_ID INTEGER PRIMARY KEY,$COL_NAME TEXT,$COL_HARGA TEXT,$COL_STOK TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    val allProduk: List<Produk>
        get(){
            val lstProduk = ArrayList<Produk>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db: SQLiteDatabase = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if(cursor.moveToFirst()){
                do{
                    val produk = Produk()
                    produk.id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID))
                    produk.name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME))
                    produk.harga = cursor.getString(cursor.getColumnIndexOrThrow(COL_HARGA))
                    produk.stok = cursor.getString(cursor.getColumnIndexOrThrow(COL_STOK))


                    lstProduk.add(produk)
                }while (cursor.moveToNext())
            }
            db.close()
            return lstProduk
        }
    fun addProduk(produk: Produk){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID, produk.id)
        values.put(COL_NAME, produk.name)
        values.put(COL_HARGA, produk.harga)
        values.put(COL_STOK, produk.stok)

        db.insert(TABLE_NAME, null,values)
        db.close()
    }

    fun updateProduk(produk: Produk): Int{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID, produk.id)
        values.put(COL_NAME, produk.name)
        values.put(COL_HARGA, produk.harga)
        values.put(COL_STOK, produk.stok)


        return db.update(TABLE_NAME, values, "$COL_ID=?", arrayOf(produk.id.toString()))
    }

    fun deleteProduk(produk: Produk) {
        val db = this.writableDatabase

        db.delete(TABLE_NAME,"$COL_ID=?", arrayOf(produk.id.toString()))
        db.close()
    }
    fun readProduk (): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
    }
}