package com.example.mealmate.fragmentnavbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.mealmate.R

class HomeFragment : Fragment() {
    private var checkbox1: CheckBox? = null
    private var checkbox2: CheckBox? = null
    private var checkbox3: CheckBox? = null
    private var textMakan: TextView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkbox1 = view.findViewById(R.id.checkSarapan)
        checkbox2 = view.findViewById(R.id.checkSiang)
        checkbox3 = view.findViewById(R.id.checkMalam)
        textMakan = view.findViewById(R.id.textView4)
        progressBar = view.findViewById(R.id.progressBar)

        var progress = 0f
        fun updateProgress() {
            if (checkbox1?.isChecked == true && checkbox2?.isChecked == true && checkbox3?.isChecked == true) {
                progress = 100f
                textMakan?.text = "3/3"
            } else if (checkbox1?.isChecked == true && checkbox2?.isChecked == true || checkbox1?.isChecked == true && checkbox3?.isChecked == true || checkbox2?.isChecked == true && checkbox3?.isChecked == true) {
                progress = 66.66f
                textMakan?.text = "2/3"
            } else if(checkbox1?.isChecked == true || checkbox2?.isChecked == true || checkbox3?.isChecked == true){
                progress = 33.33f
                textMakan?.text = "1/3"
            }else{
                progress = 0f
                textMakan?.text = "0/3"
            }

            progressBar?.progress = progress.toInt()
        }

        checkbox1?.setOnCheckedChangeListener { _, _ -> updateProgress() }
        checkbox2?.setOnCheckedChangeListener { _, _ -> updateProgress() }
        checkbox3?.setOnCheckedChangeListener { _, _ -> updateProgress() }
    }







}
