package com.example.fp_dinda.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fp_dinda.Admin
import com.example.fp_dinda.R
import com.example.fp_dinda.databinding.SettingBinding

class fragSetting : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Variable untuk activity biasa
        val bind = SettingBinding.inflate(layoutInflater)

        //Variable untuk fragment
        val homeAdmin = fragHomeAdmin()
        val frag_orders = fragorders()

        // Intent Activity dr fragment ke Fragment
        bind.homeadmin.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment_container, homeAdmin, fragHomeAdmin::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
        bind.order.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment_container, frag_orders, fragorders::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
        // Intent Activity ke Activity biasa
        bind.catalog.setOnClickListener{
            val intent = Intent (this@fragSetting.requireContext(), Admin::class.java)
            startActivity(intent)
        }
        return bind.root
    }
}