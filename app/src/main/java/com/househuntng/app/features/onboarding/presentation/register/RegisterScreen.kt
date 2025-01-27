package com.househuntng.app.features.onboarding.presentation.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.househuntng.app.R
import com.househuntng.app.RegisterScreen
import com.househuntng.app.components.CustomButton
import com.househuntng.app.components.CustomTextField
import com.househuntng.app.components.LoaderOverlay
import com.househuntng.app.components.SocialButtonSection
import com.househuntng.app.features.onboarding.data.remote.api.dto.CreateUserRequest
import com.househuntng.app.features.onboarding.presentation.SeparatorSection
import com.househuntng.app.ui.theme.DarkGray
import com.househuntng.app.ui.theme.DeepBlue
import com.househuntng.app.ui.theme.Lato
import com.househuntng.app.ui.theme.SoftGray
import com.househuntng.app.ui.theme.textColor
import org.koin.androidx.compose.koinViewModel

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/27/2025
 */
@Composable
fun RegisterScreen(onBackClick: () -> Unit, viewModel: RegisterViewModel = koinViewModel()) {
    val uiState by viewModel.registerState.collectAsState()

    LoaderOverlay(isLoading = true) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ToolbarSection { onBackClick() }

            Spacer(modifier = Modifier.height(20.dp))

            TextHeaderSection()

            Spacer(modifier = Modifier.height(20.dp))

            FormSection(
                viewModel = viewModel,
                onForgotPassword = { },
                onRegisterClick = { }
            )
        }
    }
}

@Composable
fun ColumnScope.FormSection(
    viewModel: RegisterViewModel,
    onForgotPassword: () -> Unit,
    onRegisterClick: () -> Unit
) {
    var fullname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phoneNo by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }


    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = fullname,
        onValueChange = { fullname = it },
        placeholder = stringResource(R.string.fullname),
        isError = isError,
        errorMessage = if (isError) stringResource(R.string.fullname_is_required) else null,
        leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_profile),
    )

    Spacer(modifier = Modifier.height(15.dp))

    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        onValueChange = { email = it },
        placeholder = stringResource(R.string.email),
        isError = isError,
        errorMessage = if (isError) stringResource(R.string.email_is_required) else null,
        leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_email),
        keyboardType = KeyboardType.Email,
    )

    Spacer(modifier = Modifier.height(15.dp))

    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = { password = it },
        placeholder = stringResource(R.string.password),
        isError = isError,
        keyboardType = KeyboardType.Password,
        errorMessage = if (isError) stringResource(R.string.password_is_required) else null,
        isPassword = true,
        isPasswordVisible = passwordVisible,
        leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_lock),
        trailingIcon = if (passwordVisible) ImageVector.vectorResource(id = R.drawable.ic_visibility) else ImageVector.vectorResource(
            R.drawable.ic_visibility_off
        ),
        onTrailingIconClick = { passwordVisible = !passwordVisible },
    )

    Spacer(modifier = Modifier.height(15.dp))

    CustomTextField(
        modifier = Modifier.fillMaxWidth(),
        value = phoneNo,
        onValueChange = { phoneNo = it },
        placeholder = stringResource(R.string.phone_no),
        isError = isError,
        keyboardType = KeyboardType.Phone,
        errorMessage = if (isError) stringResource(R.string.phone_no_is_required) else null,
        leadingIcon = Icons.Outlined.Phone,
    )

    Spacer(modifier = Modifier.height(15.dp))

    Text(
        modifier = Modifier
            .align(Alignment.End)
            .padding(end = 16.dp)
            .clickable { onForgotPassword() },
        text = stringResource(R.string.terms_of_service),
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
        onClick = {
            val createUserRequest = CreateUserRequest(
                name = fullname,
                email = email,
                password = password,
                phoneNo = phoneNo
            )
            viewModel.validate(createUserRequest)
        },
        text = stringResource(R.string.register)
    )
}

@Composable
fun TextHeaderSection() {
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = buildAnnotatedString {
            append("Create your ")

            withStyle(style = SpanStyle(color = DeepBlue, fontWeight = FontWeight.ExtraBold)) {
                append("Account")
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

@Composable
fun ToolbarSection(onBackClick: () -> Unit) {
    Box(modifier = Modifier
        .background(SoftGray, shape = CircleShape)
        .size(54.dp)
        .clickable { onBackClick() }
    ) {
        Icon(
            modifier = Modifier.align(Alignment.Center),
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Back button",
            tint = textColor
        )
    }
}
