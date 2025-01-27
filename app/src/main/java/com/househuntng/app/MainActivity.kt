package com.househuntng.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.househuntng.app.features.core.domain.repository.SessionManager
import com.househuntng.app.features.onboarding.presentation.LoginHome
import com.househuntng.app.features.onboarding.presentation.login.LoginScreen
import com.househuntng.app.features.onboarding.presentation.OnBoardingScreen
import com.househuntng.app.features.onboarding.presentation.SplashScreen
import com.househuntng.app.features.onboarding.presentation.register.RegisterScreen
import com.househuntng.app.ui.theme.HouseHuntTheme
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HouseHuntTheme {
                HouseHuntApp()
            }
        }
    }
}

@Composable
fun HouseHuntApp(
    navController: NavHostController = rememberNavController(),
    sessionManager: SessionManager = koinInject()
) {
    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = if (sessionManager.getIsFirstLaunch()) SplashScreen else LoginHome,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable<SplashScreen> {
                SplashScreen {
                    navController.navigate(OnBoardingScreen)
                }
            }
            composable<OnBoardingScreen> {
                OnBoardingScreen {
                    navController.navigate(LoginHome)
                }
            }
            composable<LoginHome> {
                LoginHome(
                    onContinueWithEmail = {
                        navController.navigate(LoginScreen)
                    },
                    onRegisterClick = {
                        navController.navigate(RegisterScreen)
                    }
                )
            }
            composable<LoginScreen> {
                LoginScreen(
                    onNavToHomeScreen = {
                        navController.navigate(HomeScreen)
                    },
                    onForgotPassword = {},
                    onRegisterClick = {
                        navController.navigate(RegisterScreen)
                    }
                )
            }
            composable<RegisterScreen> {
                RegisterScreen(
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}