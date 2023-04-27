package com.example.mealmate.onboarding.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.mealmate.PreferenceManager


import com.example.mealmate.R
import com.example.mealmate.SignInActivity
import com.example.mealmate.onboarding.ViewPagerAdapter
import com.example.mealmate.onboarding.ViewPagerFragment

class FirstScreen : Fragment() {
    private lateinit var preferenceManager: PreferenceManager
    private val viewPagerAdapter = ViewPagerAdapter(
        listOf(
            ViewPagerFragment(
                "Pola makan dan pola minum yang teratur membawamu ke kehidupan yang lebih sehat",
                R.drawable.onbor1
            ),
            ViewPagerFragment(
                "Atur jadwal makan dan minummu bersama kami",
                R.drawable.onbor2
            ),
            ViewPagerFragment(
                "Selamat menikmati fitur menarik dari kami bersama Meal Mate",
                R.drawable.onbor3
            )
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_first_screen, container, false)
        val buttonNext = rootView.findViewById<Button>(R.id.lanjut)
        val textSkip = rootView.findViewById<TextView>(R.id.lewati)
        val introSliderViewPager = rootView.findViewById<ViewPager2>(R.id.introSliderViewPager)
        preferenceManager = PreferenceManager(requireContext().applicationContext)
        introSliderViewPager.adapter = viewPagerAdapter // Menginisialisasi ViewPager2 dengan adapter
        introSliderViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)

                val buttonNext = view?.findViewById<Button>(R.id.lanjut)
                if (position == viewPagerAdapter.itemCount - 1) {
                    // Jika berada di halaman terakhir, ubah teks tombol menjadi "Selesai"
                    buttonNext?.text = "Selesai"
                } else {
                    // Jika tidak, kembalikan teks tombol menjadi "Lanjut"
                    buttonNext?.text = "Lanjut"
                }
            }
        })

        buttonNext.setOnClickListener {
            if (introSliderViewPager.currentItem + 1 < viewPagerAdapter.itemCount) {
                introSliderViewPager.currentItem += 1
            } else {
                preferenceManager.setFirstTimeLaunch(false) // Menyimpan status tampilan pertama kalinya
                Intent(requireContext().applicationContext, SignInActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(it)
                }
            }
        }
        textSkip.setOnClickListener{
            preferenceManager.setFirstTimeLaunch(false) // Menyimpan status tampilan pertama kalinya
            Intent(requireContext().applicationContext, SignInActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(it)
            }
        }

        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (!preferenceManager.isFirstTimeLaunch()) {
            // Jika sudah pernah ditampilkan sebelumnya, navigasi ke SignInActivity
            Intent(requireContext().applicationContext, SignInActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(it)
            }
        } else {
            // Jika belum pernah ditampilkan, tampilkan fragment ini
            setupIndicator()
            setCurrentIndicator(0)
        }
    }

    private fun setupIndicator() {
        val indicatorContainer = view?.findViewById<LinearLayout>(R.id.indicatorContainer)
        if (indicatorContainer != null) {

            val indicators = arrayOfNulls<ImageView>(viewPagerAdapter.itemCount)

            val layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(8, 0, 8, 0)


            for (i in indicators.indices) {
                indicators[i] = ImageView(requireContext())
                indicators[i]?.apply {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.indicator_inactive
                        )
                    )
                    this.layoutParams = layoutParams
                }
                indicatorContainer.addView(indicators[i])
            }
        }
    }

    private fun setCurrentIndicator(index: Int){
        val indicatorContainer = view?.findViewById<LinearLayout>(R.id.indicatorContainer)
        if (indicatorContainer != null) {

            val childCount = indicatorContainer.childCount
            for (i in 0 until childCount){
                val imageView = indicatorContainer[i] as ImageView
                if (i == index){
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext().applicationContext,
                            R.drawable.indicator_active
                        )
                    )
                }else{
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext().applicationContext,
                            R.drawable.indicator_inactive
                        )
                    )
                }
            }
        }
    }



}