package com.example.mealmate

import android.R
import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider


class WaterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.mealmate.R.layout.activity_water)
        //Dropdown
        val timeset = listOf("15 Menit","30 Menit","45 Menit","60 Menit")
        val autoComplete : AutoCompleteTextView = findViewById(com.example.mealmate.R.id.auto_complete_txt)
        val adapter = ArrayAdapter(this,com.example.mealmate.R.layout.list_item,timeset)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i).toString()
            Log.d("Dropdown","$itemSelected")
        }

        //Slider
        val slider = findViewById<Slider>(com.example.mealmate.R.id.slider)
        slider.setLabelFormatter(MyLabelFormatter())
        val infoPorsi = findViewById<TextView>(com.example.mealmate.R.id.infoporsi)
        val jumlahPorsi = findViewById<TextView>(com.example.mealmate.R.id.jumlahporsi)


        slider.addOnChangeListener { slider, value, fromUser ->
            // Update info porsi
            when (value.toInt()) {
                0 -> infoPorsi.text = "Gelas Kecil"
                1 -> infoPorsi.text = "Gelas Sedang"
                2 -> infoPorsi.text = "Gelas Besar"
                3 -> infoPorsi.text = "Botol Kecil"
                4 -> infoPorsi.text = "Botol Besar"
            }

            // Update jumlah porsi
            val jumlah = when (value.toInt()) {
                0 -> "100 ml"
                1 -> "200 ml"
                2 -> "300 ml"
                3 -> "400 ml"
                4 -> "500 ml"
                else -> ""
            }
            jumlahPorsi.text = jumlah
        }



        val backButton: ImageView = findViewById<ImageView>(com.example.mealmate.R.id.backbutton)
        backButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("checkbox_status", true)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }

    }
}