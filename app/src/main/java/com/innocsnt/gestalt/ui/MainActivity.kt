package com.innocsnt.gestalt.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.innocsnt.gestalt.R
import com.innocsnt.gestalt.ViewModelFactory
import com.innocsnt.gestalt.databinding.ActivityMainBinding
import com.innocsnt.gestalt.ui.others.ThemeViewModel
import com.innocsnt.gestalt.ui.others.SettingPreferences
import com.innocsnt.gestalt.ui.others.dataStore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)

        // Observasi perubahan tema
        val pref = SettingPreferences.getInstance(this.dataStore)
        val viewModel = ViewModelProvider(
            this,
            ViewModelFactory(pref)
        )[ThemeViewModel::class.java]
        viewModel.getThemeSettings().observe(this) { isDarkModeActive ->
            updateAppTheme(isDarkModeActive)
        }

    }

    private fun updateAppTheme(isDarkModeActive: Boolean) {
        val mode = if (isDarkModeActive) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}