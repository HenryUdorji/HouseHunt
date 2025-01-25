package com.househuntng.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.househuntng.app.R

@Composable
fun Lato() = FontFamily(
    Font(resId = R.font.lato_regular),
    Font(resId = R.font.lato_bold, weight = FontWeight.Bold),
    Font(resId = R.font.lato_extrabold, weight = FontWeight.ExtraBold)
)

@Composable
fun Typography() = Typography().run {
    copy(
        displayLarge = displayLarge.copy(fontFamily = Lato(), fontSize = 34.sp),
        headlineMedium = headlineMedium.copy(fontFamily = Lato(), fontSize = 28.sp),
        titleLarge = titleLarge.copy(fontFamily = Lato(), fontSize = 22.sp),
        bodyLarge = bodyLarge.copy(fontFamily = Lato(), fontSize = 16.sp),
        bodyMedium = bodyMedium.copy(fontFamily = Lato(), fontSize = 14.sp),
        labelLarge = labelLarge.copy(fontFamily = Lato(), fontSize = 14.sp),
    )
}