package com.househuntng.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.househuntng.app.R

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/27/2025
 */

@Composable
fun LoaderOverlay(
    isLoading: Boolean,
    lottieRes: Int = R.raw.loading_animation,
    backgroundColor: Color = Color.Black.copy(alpha = 0.5f),
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        // Main content
        content()

        // Loading overlay
        if (isLoading) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                val composition by rememberLottieComposition(
                    spec = LottieCompositionSpec.RawRes(lottieRes)
                )

                LottieAnimation(
                    composition = composition,
                    modifier = Modifier.size(100.dp),
                    iterations = LottieConstants.IterateForever,
                    speed = 1.5f
                )
            }
        }
    }
}