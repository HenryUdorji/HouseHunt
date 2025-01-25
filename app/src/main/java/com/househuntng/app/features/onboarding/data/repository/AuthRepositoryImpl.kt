package com.househuntng.app.features.onboarding.data.repository

import com.househuntng.app.features.onboarding.data.remote.api.dto.CreateUserRequest
import com.househuntng.app.features.onboarding.domain.repository.AuthRepository
import com.househuntng.app.features.onboarding.utils.AuthResult
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/21/2024
 */
class AuthRepositoryImpl(
    private val supabaseClient: SupabaseClient
): AuthRepository {
    override suspend fun createUser(createUserRequest: CreateUserRequest): AuthResult<UserInfo> {
        return try {
            AuthResult.Loading
            val user = supabaseClient.auth.signUpWith(Email) {
                email = createUserRequest.email
                password = createUserRequest.password
                data = buildJsonObject {
                    put("name", createUserRequest.name)
                    put("phoneNo", createUserRequest.phoneNo)
                }
            }

            if (user == null) {
                AuthResult.Error(Exception("User is null"))
            } else {
                AuthResult.Success(user)
            }
        } catch (e: Exception) {
            AuthResult.Error(e)
        }
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): AuthResult<Unit> {
        return try {
            AuthResult.Loading

            supabaseClient.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }

            AuthResult.Success(Unit)
        } catch (e: Exception) {
            AuthResult.Error(e)
        }
    }

    override suspend fun signOutUser(): AuthResult<Unit> {
        return try {
            AuthResult.Loading
            supabaseClient.auth.signOut()
            AuthResult.Success(Unit)
        } catch (e: Exception) {
            AuthResult.Error(e)
        }
    }

    override suspend fun sendPasswordResetEmail(email: String): AuthResult<Unit> {
        return try {
            AuthResult.Loading
            supabaseClient.auth.resetPasswordForEmail(email)
            AuthResult.Success(Unit)
        } catch (e: Exception) {
            AuthResult.Error(e)
        }
    }
}