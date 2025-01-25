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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.househuntng.app.features.onboarding.presentation.LoginHome
import com.househuntng.app.features.onboarding.presentation.LoginScreen
import com.househuntng.app.features.onboarding.presentation.OnBoardingScreen
import com.househuntng.app.features.onboarding.presentation.SplashScreen
import com.househuntng.app.ui.theme.HouseHuntTheme

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
fun HouseHuntApp(navController: NavHostController = rememberNavController()) {
    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = SplashScreen,
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
                LoginHome {
                    navController.navigate(LoginScreen)
                }
            }
            composable<LoginScreen> {
                LoginScreen {
                    navController.navigate(HomeScreen)
                }
            }
        }
    }
}