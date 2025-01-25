package com.househuntng.app.features.onboarding.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/12/2024
 */

@Composable
fun LoginScreen(onNavToHomeScreen: () -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp)) {
        GreetingSection()
    }
}

@Composable
fun GreetingSection() {
    Column {
        Text("Hey, Hello \uD83D\uDC4B", style = Typography().headlineMedium)
        Spacer(modifier = Modifier.height(5.dp))
        Text("Enter your credentials to access your account", style = Typography().bodyLarge)
    }
}

