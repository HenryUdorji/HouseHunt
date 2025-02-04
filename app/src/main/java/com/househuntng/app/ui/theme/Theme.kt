package com.househuntng.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = EmeraldGreen,
    onPrimary = Color.White, // Text on primary color
    secondary = DeepBlue,
    onSecondary = Color.White, // Text on secondary color
    background = lightBackground,
    surface = Color.White, // Card/Surface backgrounds
    onSurface = CharcoalGray,
    error = CrimsonRed,
    onError = Color.White,
    outline = LightGray, // For borders/dividers
)

private val DarkColorScheme = darkColorScheme(
    primary = DeepBlue,
    onPrimary = Color.White,
    secondary = EmeraldGreen,
    onSecondary = Color.White,
    background = CharcoalGray,
    surface = CharcoalGray,
    onSurface = LightGray,
    error = CrimsonRed,
    onError = Color.White,
    outline = SoftYellow, // For borders/dividers in dark mode
)

@Composable
fun HouseHuntTheme(
    darkTheme: Boolean = false,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = Typography(),
        content = content
    )
}