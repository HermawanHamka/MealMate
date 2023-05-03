package com.example.mealmate

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AkunActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akun)

        val btnProfil = findViewById<Button>(R.id.btnProfilAkun)
        btnProfil.setBackgroundColor(Color.TRANSPARENT)
    }
}