package com.example.fp_dinda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_login = findViewById(R.id.btn_login) as Button


        btn_login.setOnClickListener(){
            val intent= Intent(MainActivity@this, navigasi::class.java)
            startActivity(intent)
        }
    }
}