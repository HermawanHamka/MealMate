package com.example.mealmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.widget.*

class SignInActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var passwordTextInputLayout: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        //Pindah ke Register
        val btnRegis = findViewById<TextView>(R.id.btnRegis)

        btnRegis.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        emailEditText = findViewById<EditText>(R.id.inputEmail)
        passwordEditText = findViewById<EditText>(R.id.inputSandi)
        loginButton = findViewById<Button>(R.id.button)
        passwordTextInputLayout = findViewById<FrameLayout>(R.id.layoutSandi)
        val showHideBtn: ImageButton = findViewById(R.id.imageButton)

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


        // Add TextChangedListener to EditTexts
        emailEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)

        // Disable login button
        loginButton.isEnabled = false
        loginButton.setBackgroundResource(R.drawable.btn_disable)
        loginButton.alpha = 0.5f

        //Button masuk klik
        loginButton.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Enable login button and set alpha to 1.0
                loginButton.isEnabled = true
                loginButton.setBackgroundResource(R.drawable.btn_large)
                loginButton.alpha = 1.0f
            } else {
                // Disable login button and set alpha to 0.5
                loginButton.isEnabled = false
                loginButton.setBackgroundResource(R.drawable.btn_disable)
                loginButton.alpha = 0.5f
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }
}
