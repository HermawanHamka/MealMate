package com.example.mealmate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.OnFocusChangeListener
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class personalisasi1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalisasi1)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val item = listOf("Laki-Laki","Perempuan")

        val autoComplete : AutoCompleteTextView = findViewById(R.id.inputKelamin)
        val adapter = ArrayAdapter(this,R.layout.dropdown_item,item)
        autoComplete.setAdapter(adapter)
        autoComplete.setText("")
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            val itemSelected = adapterView.getItemAtPosition(i).toString()
            Log.d("Dropdown","$itemSelected")
        }

        val nextButton: Button = findViewById<Button>(com.example.mealmate.R.id.button_lanjut)
        nextButton.setOnClickListener {
            val intent = Intent(this, personalisasi2::class.java)
            startActivity(intent)
        }


    }


}