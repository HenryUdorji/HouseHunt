package com.househuntng.app.features.onboarding.utils

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/23/2024
 */

sealed class AuthResult<out T> {
    data class Success<T>(val data: T) : AuthResult<T>()
    data class Error(val exception: Exception) : AuthResult<Nothing>()
    data object Loading : AuthResult<Nothing>()
}