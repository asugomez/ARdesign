package com.ec.ardesign.ui.main

import android.os.Bundle
import android.preference.PreferenceActivity
import com.ec.ardesign.R

class SettingsActivity : PreferenceActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)


    }
}