package com.househuntng.app.features.onboarding.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.househuntng.app.R
import com.househuntng.app.components.CustomButton
import com.househuntng.app.components.CustomTextField
import com.househuntng.app.components.SocialButtonSection
import com.househuntng.app.features.onboarding.presentation.SeparatorSection
import com.househuntng.app.ui.theme.DarkGray
import com.househuntng.app.ui.theme.DeepBlue
import com.househuntng.app.ui.theme.Lato

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/12/2024
 */

@Composable
fun LoginScreen(
    onNavToHomeScreen: () -> Unit,
    onForgotPassword: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(bottom = 16.dp)) {
        HeaderSection()
        Spacer(modifier = Modifier.height(30.dp))
        FormSection(onForgotPassword, onRegisterClick)
    }
}

@Composable
fun ColumnScope.FormSection(onForgotPassword: () -> Unit, onRegisterClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    CustomTextField(
        value = email,
        onValueChange = { email = it },
        placeholder = stringResource(R.string.email),
        isError = isError,
        errorMessage = if (isError) stringResource(R.string.email_is_required) else null,
        leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_email),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    )

    Spacer(modifier = Modifier.height(15.dp))

    CustomTextField(
        value = password,
        onValueChange = { password = it },
        placeholder = stringResource(R.string.password),
        isError = isError,
        errorMessage = if (isError) stringResource(R.string.password_is_required) else null,
        isPassword = true,
        isPasswordVisible = passwordVisible,
        leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_lock),
        trailingIcon = if (passwordVisible) ImageVector.vectorResource(id = R.drawable.ic_visibility) else ImageVector.vectorResource(
            R.drawable.ic_visibility_off
        ),
        onTrailingIconClick = { passwordVisible = !passwordVisible },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )

    Spacer(modifier = Modifier.height(15.dp))

    Text(
        modifier = Modifier
            .align(Alignment.End)
            .padding(end = 16.dp)
            .clickable { onForgotPassword() },
        text = stringResource(R.string.forgot_password),
        color = DeepBlue,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = Lato()
    )

    Spacer(modifier = Modifier.height(20.dp))

    CustomButton(
        modifier = Modifier
            .width(278.dp)
            .align(Alignment.CenterHorizontally),
        onClick = { },
        text = stringResource(R.string.login)
    )

    Spacer(modifier = Modifier.height(15.dp))

    SeparatorSection()

    Spacer(modifier = Modifier.height(15.dp))

    SocialButtonSection(
        modifier = Modifier.padding(horizontal = 16.dp),
        onGmailClick = {

        },
        onAppleClick = {

        },
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = buildAnnotatedString {
            append(stringResource(R.string.don_t_have_an_account))

            withStyle(style = SpanStyle(color = DeepBlue, fontWeight = FontWeight.Bold)) {
                append(stringResource(R.string.register))
            }
        },
        color = DarkGray,
        fontFamily = Lato(),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .clickable { onRegisterClick() }
    )
}

@Composable
fun HeaderSection() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(175.dp),
        painter = painterResource(id = R.drawable.ic_login_header),
        contentDescription = ""
    )

    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = buildAnnotatedString {
            append("Let's ")

            withStyle(style = SpanStyle(color = DeepBlue, fontWeight = FontWeight.ExtraBold)) {
                append("Sign In")
            }
        },
        color = DeepBlue,
        fontSize = 25.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = Lato()
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = "quis nostrud exercitation ullamco laboris nisi ut",
        fontSize = 12.sp,
        color = DarkGray,
        fontWeight = FontWeight.Normal,
        fontFamily = Lato()
    )
}

