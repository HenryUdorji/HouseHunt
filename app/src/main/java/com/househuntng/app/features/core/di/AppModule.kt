package com.househuntng.app.features.core.di

import android.content.Context
import android.content.SharedPreferences
import com.househuntng.app.BuildConfig
import com.househuntng.app.features.core.data.repository.SessionManagerImpl
import com.househuntng.app.features.core.domain.repository.SessionManager
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/23/2024
 */
val appModule = module {
    single {
        createSupabaseClient(
            supabaseUrl = BuildConfig.SUPABASE_URL,
            supabaseKey = BuildConfig.SUPABASE_KEY
        ) {
            install(Auth)
            install(Postgrest)
        }
    }

    single {
        val context = androidContext().applicationContext
        context.getSharedPreferences("househuntpref", Context.MODE_PRIVATE)
    }

    single<SessionManager> { SessionManagerImpl(get()) }
}