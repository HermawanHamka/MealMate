package com.example.mealmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.widget.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var passwordConEditText: EditText
    private lateinit var regisButton: Button
    private lateinit var passwordTextInputLayout: FrameLayout
    private lateinit var passwordConfirmTextInputLayout: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //Kembali ke SignIn
        val btnRegis = findViewById<TextView>(R.id.btnRegis)

        btnRegis.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        emailEditText = findViewById<EditText>(R.id.inputEmail)
        nameEditText = findViewById<EditText>(R.id.namaLengkap)
        passwordEditText = findViewById<EditText>(R.id.inputSandi)
        passwordConEditText = findViewById<EditText>(R.id.inputKonfirmasiSandi)
        regisButton = findViewById<Button>(R.id.button)
        passwordTextInputLayout = findViewById<FrameLayout>(R.id.layoutSandi)
        passwordConfirmTextInputLayout = findViewById<FrameLayout>(R.id.layoutKonfirmasiSandi)
        val showHideBtn: ImageButton = findViewById(R.id.imageButton)
        val showHideBtnS: ImageButton = findViewById(R.id.imageButton2)

        //Show hide pw
        var isPasswordVisible = false

        showHideBtn.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            val showPassword = isPasswordVisible
            if (showPassword) {
                passwordEditText.transformationMethod = null
                showHideBtn.setImageResource(R.drawable.show)
            } else {
                passwordEditText.transformationMethod = PasswordTransformationMethod()
                showHideBtn.setImageResource(R.drawable.hide)
            }
        }

        //Show hide konf pw
        var isKonPasswordVisible = false

        showHideBtnS.setOnClickListener {
            isKonPasswordVisible = !isKonPasswordVisible
            val showKonPassword = isKonPasswordVisible
            if (showKonPassword) {
                passwordConEditText.transformationMethod = null
                showHideBtnS.setImageResource(R.drawable.show)
            } else {
                passwordConEditText.transformationMethod = PasswordTransformationMethod()
                showHideBtnS.setImageResource(R.drawable.hide)
            }
        }

        // Add TextChangedListener to EditTexts
        emailEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)
        nameEditText.addTextChangedListener(textWatcher)
        passwordConEditText.addTextChangedListener(textWatcher)

        // Disable login button
        regisButton.isEnabled = false
        regisButton.setBackgroundResource(R.drawable.btn_disable)
        regisButton.alpha = 0.5f

        //Pindah dengan data
        regisButton.setOnClickListener {
            // Ambil nilai dari input email dan password
            val email = emailEditText?.text.toString()
            val password = passwordEditText?.text.toString()

            // Buat Intent untuk pindah ke activity Sign In
            val signInIntent = Intent(this@RegisterActivity, SignInActivity::class.java)

            // Sertakan data email dan password pada Intent
            signInIntent.putExtra("EMAIL", email)
            signInIntent.putExtra("PASSWORD", password)

            // Jalankan Intent untuk pindah ke activity Sign In
            startActivity(signInIntent)
        }

    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val nama = nameEditText.text.toString()
            val konfir = passwordConEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && nama.isNotEmpty() && konfir.isNotEmpty()) {
                // Enable login button and set alpha to 1.0
                regisButton.isEnabled = true
                regisButton.setBackgroundResource(R.drawable.btn_large)
                regisButton.alpha = 1.0f
            } else {
                // Disable login button and set alpha to 0.5
                regisButton.isEnabled = false
                regisButton.setBackgroundResource(R.drawable.btn_disable)
                regisButton.alpha = 0.5f
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }
}