package com.househuntng.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.househuntng.app.R
import com.househuntng.app.ui.theme.AppGray

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/27/2025
 */

@Composable
fun SocialButtonSection(
    modifier: Modifier = Modifier,
    onGmailClick: () -> Unit,
    onAppleClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SocialLoginButton(iconResource = R.drawable.ic_google, description = "Google Login") {
            onGmailClick()
        }
        Spacer(modifier = Modifier.width(10.dp))
        SocialLoginButton(iconResource = R.drawable.ic_apple, description = "Apple Login") {
            onAppleClick()
        }
    }
}

@Composable
fun RowScope.SocialLoginButton(iconResource: Int, description: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .height(70.dp)
            .weight(1f)
            .background(color = AppGray, shape = RoundedCornerShape(25.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = iconResource),
            contentDescription = description,
            tint = Color.Unspecified // Keep original icon color
        )
    }
}