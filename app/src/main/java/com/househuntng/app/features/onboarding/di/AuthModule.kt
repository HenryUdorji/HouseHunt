package com.househuntng.app.features.onboarding.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.househuntng.app.features.onboarding.data.repository.AuthRepositoryImpl
import com.househuntng.app.features.onboarding.domain.repository.AuthRepository
import com.househuntng.app.features.onboarding.presentation.login.LoginViewModel
import com.househuntng.app.features.onboarding.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/23/2024
 */

val authModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        RegisterViewModel(get())
    }
}