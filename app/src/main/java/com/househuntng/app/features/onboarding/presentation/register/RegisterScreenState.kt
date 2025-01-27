package com.househuntng.app.features.onboarding.presentation.register

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/27/2025
 */
data class RegisterScreenState(
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val errorMessage: String? = null
)
