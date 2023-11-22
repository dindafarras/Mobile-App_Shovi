package com.example.fp_dinda.model

class Produk {
    var id: Int=0
    var name:String?=null
    var harga:String?=null
    var stok:String?=null

    constructor(){}

    constructor(id:Int, name:String, harga:String, stok:String)
    {
        this.id=id
        this.name=name
        this.harga=harga
        this.stok=stok
    }
}