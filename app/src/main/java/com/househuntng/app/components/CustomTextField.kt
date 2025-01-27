package com.househuntng.app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.househuntng.app.ui.theme.DarkGray
import com.househuntng.app.ui.theme.DeepBlue
import com.househuntng.app.ui.theme.SoftGray
import com.househuntng.app.ui.theme.textColor

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/25/2025
 */

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false,
    isPasswordVisible: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: (() -> Unit)? = null
) {
    Column(modifier = modifier) {
        // TextField
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            label = label?.let { { Text(text = it) } },
            placeholder = placeholder?.let { { Text(text = it) } },
            isError = isError,
            visualTransformation = if (isPassword && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = singleLine,
            maxLines = maxLines,
            enabled = enabled,
            colors = TextFieldDefaults.colors(
                focusedTextColor = textColor,
                focusedContainerColor = if (isError) Color.Red else SoftGray,
                unfocusedContainerColor = if (isError) Color.Red else SoftGray,
                disabledContainerColor = if (isError) Color.Red else SoftGray,
                focusedIndicatorColor = DeepBlue,
                unfocusedIndicatorColor = if (isError) Color.Red else SoftGray,
                errorIndicatorColor = Color.Red
            ),
            shape = RoundedCornerShape(10),
            leadingIcon = {
                if (leadingIcon != null) {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = "",
                        tint = Color.Unspecified
                    )
                }
            },
            trailingIcon = {
                if (trailingIcon != null) {
                    IconButton(
                        onClick = {
                            if (onTrailingIconClick != null) {
                                onTrailingIconClick()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = "",
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        )

        // Error message
        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}