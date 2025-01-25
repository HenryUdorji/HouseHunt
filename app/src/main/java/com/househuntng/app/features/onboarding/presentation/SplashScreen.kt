package com.househuntng.app.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.househuntng.app.BuildConfig
import com.househuntng.app.R
import com.househuntng.app.components.CustomButton
import com.househuntng.app.ui.theme.Lato

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/20/2025
 */

@Composable
fun SplashScreen(onNavToOnBoardingScreen: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.splash_bg),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(
                R.string.splash_screen_background
            )
        )

        Image(
            modifier = Modifier
                .size(width = 170.dp, height = 150.dp)
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.app_icon),
            contentDescription = stringResource(R.string.app_icon)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(
                modifier = Modifier.width(190.dp),
                onButtonClick = { onNavToOnBoardingScreen() },
                text = stringResource(R.string.let_s_start)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.made_with_love),
                fontSize = 10.sp,
                color = Color.White,
            )
            Text(
                text = "v${BuildConfig.VERSION_NAME}",
                fontSize = 10.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = Lato()
            )

            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(onNavToOnBoardingScreen = {})
}