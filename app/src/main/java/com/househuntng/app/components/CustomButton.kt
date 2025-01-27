package com.househuntng.app.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.househuntng.app.ui.theme.EmeraldGreen
import com.househuntng.app.ui.theme.Lato

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/20/2025
 */
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    textSize: Int = 16,
    textColor: Color = Color.White,
    backgroundColor: Color = EmeraldGreen,
    radius: Int = 10,
    startIcon: ImageVector? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(54.dp),
        shape = RoundedCornerShape(radius),
        colors = ButtonDefaults.buttonColors().copy(containerColor = backgroundColor)
    ) {
        Row {
            if (startIcon != null) {
                Icon(imageVector = startIcon, contentDescription = "Start icon", tint = textColor)
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                fontSize = textSize.sp,
                color = textColor,
                fontWeight = FontWeight.Bold,
                fontFamily = Lato()
            )
        }
    }
}