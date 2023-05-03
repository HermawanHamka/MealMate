package com.example.mealmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mealmate.databinding.ActivityHomeBinding
import com.example.mealmate.fragmentnavbar.HomeFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bottomNav = findViewById<ChipNavigationBar>(R.id.bottom_nav)
        bottomNav.setItemSelected(R.id.bottom_nav_beranda)
        // Inisialisasi NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView3) as NavHostFragment
        navController = navHostFragment.navController

        // Tambahkan listener untuk ChipNavigationBar
        bottomNav.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                // Navigasi ke fragment yang sesuai
                when (id) {
                    R.id.bottom_nav_beranda -> navController.navigate(R.id.homeFragment)
                    R.id.bottom_nav_akun -> navController.navigate(R.id.akunFragment)
                    R.id.bottom_nav_statistik -> navController.navigate(R.id.statistikFragment)
                }
            }

        })
    }
}
