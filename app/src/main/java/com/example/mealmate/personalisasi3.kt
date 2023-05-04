package com.example.mealmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class personalisasi3 : AppCompatActivity() {
    private var inputTarget: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalisasi3)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        inputTarget = findViewById<EditText>(R.id.inputTarget)
        val buttonRekomendasi = findViewById<TextView>(R.id.buttonRekomendasi)
        buttonRekomendasi.setOnClickListener {
            // Mengisi inputSarapan dengan waktu yang diinginkan

            val waktuPengingat = findViewById<EditText>(R.id.waktuPengingat)
            setInputTarget("2040")
            waktuPengingat.setText("30")

        }

        val nextButton: Button = findViewById<Button>(R.id.button_lanjut)
        nextButton.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }

        val backButton: ImageView = findViewById<ImageView>(R.id.imageBack)
        backButton.setOnClickListener {
            val intent = Intent(this, personalisasi2::class.java)
            startActivity(intent)
        }

    }
    fun getInputTarget(): String {
        return inputTarget?.text.toString()
    }
    fun setInputTarget(value: String) {
        inputTarget?.setText(value)
    }
}