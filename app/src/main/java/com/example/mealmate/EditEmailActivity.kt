package com.example.mealmate

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class EditEmailActivity : AppCompatActivity() {
    private lateinit var btnVerifikasi: Button
    private lateinit var editEmail: EditText
    private lateinit var btnBack:ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_email)

            /* get id */
            btnVerifikasi = findViewById<Button>(R.id.btnVerivikasi)
            editEmail = findViewById<EditText>(R.id.editEmailVerif)
            btnBack = findViewById<ImageButton>(R.id.backEditEmail)


            editEmail.addTextChangedListener(loginTextWatcher)


            /* click the button */
            btnVerifikasi.setOnClickListener {
                val pindah = Intent(this, OtpEmailActivity::class.java)
                startActivity(pindah)
            }
             btnBack.setOnClickListener {
                val back = Intent(this, EmailDanPasswordActivity::class.java)
                startActivity(back)
            }

    }
    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val editEmail = editEmail.text.toString().trim()

            btnVerifikasi.isEnabled = editEmail.isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }
}