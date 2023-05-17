package com.example.androidprototype.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.androidprototype.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)
        bottomNavigationView.selectedItemId = R.id.navigation_workorders

        bottomNavigationView?.itemIconTintList = null
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navigationFragment)
        val navController = navHostFragment?.findNavController()
        navController?.let { bottomNavigationView?.setupWithNavController(navController) }
    }
}