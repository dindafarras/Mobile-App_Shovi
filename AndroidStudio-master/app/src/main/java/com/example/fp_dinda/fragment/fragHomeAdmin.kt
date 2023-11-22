package com.example.fp_dinda.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fp_dinda.Admin
import com.example.fp_dinda.databinding.FragHomeAdminBinding

class fragHomeAdmin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragHomeAdminBinding.inflate(layoutInflater)

        bind.tes1.setOnClickListener{
            val intent = Intent (this@fragHomeAdmin.requireContext(), Admin::class.java)
            startActivity(intent)
        }
        return bind.root
    }

}