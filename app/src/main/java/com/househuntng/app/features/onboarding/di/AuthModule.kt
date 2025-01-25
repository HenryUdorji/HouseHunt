package com.househuntng.app.features.onboarding.di

import com.househuntng.app.features.onboarding.data.repository.AuthRepositoryImpl
import com.househuntng.app.features.onboarding.domain.repository.AuthRepository
import org.koin.dsl.module

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/23/2024
 */

val authModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}