package com.househuntng.app.features.core.domain.models


/**
 * @Author: ifechukwu.udorji
 * @Date: 12/21/2024
 */
data class User(
    val id: String,
    val phoneNumber: String,
    val email: String,
    val password: String,
    val fullName: String,
    val userType: UserType,
)

enum class UserType {
    HOUSE_SEEKER,
    AGENT
}
