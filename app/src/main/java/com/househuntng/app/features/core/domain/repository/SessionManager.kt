package com.househuntng.app.features.core.domain.repository

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/23/2024
 */
interface SessionManager {
    fun setIsFirstLaunch()
    fun getIsFirstLaunch(): Boolean
}