package com.example.mealmate.fragmentnavbar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mealmate.JadwalMakan
import com.example.mealmate.R
import com.example.mealmate.Terpenuhi
import com.example.mealmate.WaterActivity

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



        //button minum
        val buttonMinum = view.findViewById<ImageButton>(R.id.button_minum)
        buttonMinum.setOnClickListener {
            val intent = Intent(activity, WaterActivity::class.java)
            startActivity(intent)
        }

        //card sarapan
        val cardSarapan = view.findViewById<ConstraintLayout>(R.id.card2)
        cardSarapan.setOnClickListener{
            if (checkbox1?.isChecked == true) {
                val intent = Intent(activity, Terpenuhi::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(activity, JadwalMakan::class.java)
                startActivityForResult(intent, REQUEST_CODE_JADWAL_MAKAN)

            }

        }

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_JADWAL_MAKAN && resultCode == Activity.RESULT_OK) {
            val checkboxStatus = data?.getBooleanExtra("checkbox_status", false) ?: false
            updateCheckboxStatus(checkboxStatus)
        }
    }

    fun updateCheckboxStatus(status: Boolean) {
        checkbox1?.isChecked = status

    }
    companion object {
        private const val REQUEST_CODE_JADWAL_MAKAN = 1
    }


}
