package com.example.infoday.ui.info

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

import com.example.infoday.R

class InfoFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}