package com.example.mealmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.text.Editable
import android.text.TextWatcher

class SignInActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        emailEditText = findViewById<EditText>(R.id.inputEmail)
        passwordEditText = findViewById<EditText>(R.id.inputSandi)
        loginButton = findViewById<Button>(R.id.button)

        // Add TextChangedListener to EditTexts
        emailEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)



        // Disable login button
        loginButton.isEnabled = false
        // Set enabled state and reset background color
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Enable login button if email and password are not empty
            loginButton.isEnabled = email.isNotEmpty() && password.isNotEmpty()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }
}
