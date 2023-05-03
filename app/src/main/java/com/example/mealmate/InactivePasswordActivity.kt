package com.example.mealmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class InactivePasswordActivity : AppCompatActivity() {
    private lateinit var perbaruiBtn:Button
    private lateinit var passLama:EditText
    private lateinit var passBaru:EditText
    private lateinit var passKonfirmasi:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inactive_password)
        /* get id */
        perbaruiBtn = findViewById(R.id.btnPerbarui)
        passLama = findViewById(R.id.editPassLama)
        passBaru = findViewById(R.id.editPassBaru)
        passKonfirmasi = findViewById(R.id.editPassKonfirmasi)

        passLama.addTextChangedListener(loginTextWatcher)
        passBaru.addTextChangedListener(loginTextWatcher)
        passKonfirmasi.addTextChangedListener(loginTextWatcher)

        /* click the button */

    }
        private val loginTextWatcher = object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
              val pass_lama = passLama.text.toString().trim()
              val pass_baru = passBaru.text.toString().trim()
              val pass_konfirmasi = passKonfirmasi.text.toString().trim()

              perbaruiBtn.isEnabled = pass_lama.isNotEmpty() && pass_baru.isNotEmpty() && pass_konfirmasi.isNotEmpty()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        }

}