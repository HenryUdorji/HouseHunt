package com.househuntng.app.features.onboarding.presentation.login

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/27/2025
 */
data class LoginScreenState(
    val isLoading: Boolean = false,
    val isLoginSuccessful: Boolean = false,
    val errorMessage: String? = null
)
