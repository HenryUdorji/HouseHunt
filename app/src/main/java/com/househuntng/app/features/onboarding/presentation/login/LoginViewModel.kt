package com.househuntng.app.features.onboarding.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.househuntng.app.features.core.domain.repository.SessionManager
import com.househuntng.app.features.onboarding.data.remote.api.dto.CreateUserRequest
import com.househuntng.app.features.onboarding.domain.repository.AuthRepository
import com.househuntng.app.features.onboarding.utils.AuthResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/27/2025
 */
class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _loginState = MutableStateFlow(LoginScreenState())
    val loginState = _loginState.asStateFlow()

    fun login(email: String, password: String) = viewModelScope.launch {
        when (val result = authRepository.signInWithEmailAndPassword(email, password)) {
            is AuthResult.Error -> {
                _loginState.value = loginState.value.copy(
                    isLoading = false,
                    errorMessage = result.exception.message
                )
            }

            is AuthResult.Loading -> {
                _loginState.value = loginState.value.copy(isLoading = true)
            }

            is AuthResult.Success -> {
                _loginState.value = loginState.value.copy(isLoading = false)
            }
        }
    }
}