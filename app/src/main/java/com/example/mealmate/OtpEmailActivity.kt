package com.example.mealmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class OtpEmailActivity : AppCompatActivity() {
    private lateinit var backOtpBtn:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_email)

        val backOtpBtn = findViewById<ImageButton>(R.id.backOtpBtn)

        backOtpBtn.setOnClickListener {
            val backk = Intent(this, EditEmailActivity::class.java)
            startActivity(backk)
        }
    }
}