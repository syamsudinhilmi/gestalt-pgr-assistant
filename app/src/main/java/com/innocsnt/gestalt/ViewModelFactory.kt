package com.innocsnt.gestalt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.innocsnt.gestalt.ui.others.ThemeViewModel
import com.innocsnt.gestalt.ui.others.SettingPreferences

class ViewModelFactory(private val pref: SettingPreferences) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ThemeViewModel::class.java)) {
            return ThemeViewModel(pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}