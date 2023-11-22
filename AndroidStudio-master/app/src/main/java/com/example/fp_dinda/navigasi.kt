package com.example.fp_dinda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fp_dinda.fragment.fragHomeAdmin
import com.example.fp_dinda.fragment.fragSetting
import com.example.fp_dinda.fragment.fragorders
import com.google.android.material.bottomnavigation.BottomNavigationView

class navigasi : AppCompatActivity() {

    private val fragHomeAdmin = fragHomeAdmin()
    private val fragorders = fragorders()
    private val fragSetting = fragSetting()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigasi)
        replaceFragment(fragHomeAdmin)

        var bottom_navigation = findViewById(R.id.bottom_navigation) as BottomNavigationView

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homepage -> replaceFragment(fragHomeAdmin)
                R.id.order -> replaceFragment(fragorders)
                R.id.setting -> replaceFragment(fragSetting)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}