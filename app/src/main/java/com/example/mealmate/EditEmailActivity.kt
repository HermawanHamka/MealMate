package com.example.mealmate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class EditEmailActivity : AppCompatActivity() {
    private lateinit var btnVerifikasi: Button
    private lateinit var editEmail: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_email)

            /* get id */
            btnVerifikasi = findViewById(R.id.btnVerivikasi)
            editEmail = findViewById(R.id.editEmailVerif)


            editEmail.addTextChangedListener(loginTextWatcher)


            /* click the button */
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