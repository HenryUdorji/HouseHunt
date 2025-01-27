package com.househuntng.app.features.core.data.repository

import android.content.SharedPreferences
import com.househuntng.app.features.core.domain.repository.SessionManager

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/23/2024
 */
class SessionManagerImpl(private val sharedPreferences: SharedPreferences): SessionManager {
    override fun setIsFirstLaunch() {
        sharedPreferences.edit().putBoolean("isFirstLaunch", false).apply()
    }

    override fun getIsFirstLaunch(): Boolean {
        return sharedPreferences.getBoolean("isFirstLaunch", true)
    }
}