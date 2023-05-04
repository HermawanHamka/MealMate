package com.example.mealmate.fragmentnavbar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mealmate.EmailDanPasswordActivity
import com.example.mealmate.ProfilSayaActivity
import com.example.mealmate.R
import com.example.mealmate.SignInActivity


class AkunFragment : Fragment() {
    private lateinit var btnProfileAkun : Button
    private lateinit var btnProfilEmailPass : Button
    private lateinit var btnProfilKeluar : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_akun, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* get id */
        btnProfileAkun = view.findViewById<Button>(R.id.btnProfilAkun)
        btnProfilEmailPass  = view.findViewById<Button>(R.id.btnProfilEmailPass)
        btnProfilKeluar  = view.findViewById<Button>(R.id.btnProfilKeluar)



        /* click the button */
        btnProfileAkun.setOnClickListener {
            val pindah = Intent(activity, ProfilSayaActivity::class.java)
            startActivity(pindah)
        }
        btnProfilEmailPass.setOnClickListener {
            val pindahEmpas = Intent(activity, EmailDanPasswordActivity::class.java)
            startActivity(pindahEmpas)
        }
        btnProfilKeluar.setOnClickListener {
            val pindahKeluar = Intent(activity, SignInActivity::class.java)
            startActivity(pindahKeluar)
        }
    }

}