package com.example.mealmate


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.mealmate.fragmentnavbar.AkunFragment

class EmailDanPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_dan_password)


        val btnEmail = findViewById<TextView>(R.id.editText1)
        val btnPass = findViewById<TextView>(R.id.editText2)
        val btnBack = findViewById<ImageButton>(R.id.backEmailPass)

        btnEmail.setOnClickListener {
            val pindah = Intent(this, EditEmailActivity::class.java)
            startActivity(pindah)
        }

        btnPass.setOnClickListener {
            val pindah_pass = Intent(this, InactivePasswordActivity::class.java)
            startActivity(pindah_pass)
        }

           btnBack.setOnClickListener {
            val back_akun = Intent(this, HomeActivity::class.java)
            startActivity(back_akun)
        }
    }

}


