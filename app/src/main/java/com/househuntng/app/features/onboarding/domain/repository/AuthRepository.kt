package com.househuntng.app.features.onboarding.domain.repository

import com.househuntng.app.features.onboarding.data.remote.api.dto.CreateUserRequest
import com.househuntng.app.features.onboarding.utils.AuthResult
import io.github.jan.supabase.auth.user.UserInfo

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/21/2024
 */
interface AuthRepository {
    suspend fun createUser(createUserRequest: CreateUserRequest): AuthResult<UserInfo>
    suspend fun signInWithEmailAndPassword(email: String, password: String): AuthResult<Unit>
    suspend fun signOutUser(): AuthResult<Unit>
    suspend fun sendPasswordResetEmail(email: String): AuthResult<Unit>
}