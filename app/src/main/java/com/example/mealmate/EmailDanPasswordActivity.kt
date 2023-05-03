package com.example.mealmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageButton
import android.widget.TextView

class EmailDanPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_dan_password)

        val btnEmail = findViewById<TextView>(R.id.editText1)
        btnEmail.setOnClickListener {
            val pindah = Intent(this, EditEmailActivity::class.java)
            startActivity(pindah)
        }
    }
}

