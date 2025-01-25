package com.househuntng.app.features.onboarding.data.remote.api.dto

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/23/2024
 */
data class CreateUserRequest(
    val email: String,
    val password: String,
    val name: String,
    val phoneNo: String
)
