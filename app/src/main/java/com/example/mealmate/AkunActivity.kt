package com.example.mealmate

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AkunActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akun)

        /* get id */
      val  btnProfileAkun= findViewById<Button>(R.id.btnProfilAkun)
       val btnProfilEmailPass  = findViewById<Button>(R.id.btnProfilEmailPass)
       val btnProfilKeluar  = findViewById<Button>(R.id.btnProfilKeluar)



        /* click the button */
        btnProfileAkun.setOnClickListener {
            val pindah = Intent(this, ProfilSayaActivity::class.java)
            startActivity(pindah)
        }
        btnProfilEmailPass.setOnClickListener {
            val pindahEmpas = Intent(this, EmailDanPasswordActivity::class.java)
            startActivity(pindahEmpas)
        }
        btnProfilKeluar.setOnClickListener {
            val pindahKeluar = Intent(this, SignInActivity::class.java)
            startActivity(pindahKeluar)
        }




    }
}
