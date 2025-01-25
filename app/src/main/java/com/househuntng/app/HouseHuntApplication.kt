package com.househuntng.app

import android.app.Application
import com.househuntng.app.features.core.di.appModule
import com.househuntng.app.features.onboarding.di.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/23/2024
 */
class HouseHuntApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@HouseHuntApplication)
            modules(appModule, authModule)
        }
    }
}