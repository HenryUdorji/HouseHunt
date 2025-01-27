package com.househuntng.app.features.onboarding.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.househuntng.app.features.core.domain.repository.SessionManager
import com.househuntng.app.features.onboarding.data.remote.api.dto.CreateUserRequest
import com.househuntng.app.features.onboarding.domain.repository.AuthRepository
import com.househuntng.app.features.onboarding.presentation.login.LoginScreenState
import com.househuntng.app.features.onboarding.utils.AuthResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/27/2025
 */
class RegisterViewModel(
    private val authRepository: AuthRepository
): ViewModel() {
    private val _registerState = MutableStateFlow(RegisterScreenState())
    val registerState = _registerState.asStateFlow()

    fun createAccount(email: String, password: String) = viewModelScope.launch {
        val createUserRequest = CreateUserRequest(
            email = email,
            password = password,
            name = "John Doe",
            phoneNo = "08012345678",
        )
        when (val result = authRepository.createUser(createUserRequest)) {
            is AuthResult.Error -> {
                _registerState.value = registerState.value.copy(
                    isLoading = false,
                    errorMessage = result.exception.message
                )
            }
            is AuthResult.Loading -> {
                _registerState.value = registerState.value.copy(
                    isLoading = true
                )
            }
            is AuthResult.Success -> {
                _registerState.value = registerState.value.copy(isLoading = false)
            }
        }
    }

    fun validate(createUserRequest: CreateUserRequest) {

    }
}