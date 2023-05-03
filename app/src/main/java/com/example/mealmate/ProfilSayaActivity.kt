package com.example.mealmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class ProfilSayaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_saya)

        val btnBack = findViewById<ImageButton>(R.id.backProfilSaya)

        btnBack.setOnClickListener {
            val pindah = Intent(this, AkunActivity::class.java)
            startActivity(pindah)
        }
    }
}