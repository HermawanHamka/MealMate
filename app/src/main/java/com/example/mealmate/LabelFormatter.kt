package com.example.mealmate

import com.google.android.material.slider.LabelFormatter

class MyLabelFormatter : LabelFormatter {
    override fun getFormattedValue(value: Float): String {
        return when (value.toInt()) {
            0 -> "100 ml"
            1 -> "200 ml"
            2 -> "300 ml"
            3 -> "400 ml"
            4 -> "500 ml"
            else -> ""
        }
    }
}

