package com.househuntng.app.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.househuntng.app.R
import com.househuntng.app.components.CustomButton
import com.househuntng.app.components.SocialButtonSection
import com.househuntng.app.ui.theme.AppGray
import com.househuntng.app.ui.theme.DarkGray
import com.househuntng.app.ui.theme.DeepBlue
import com.househuntng.app.ui.theme.DividerColor
import com.househuntng.app.ui.theme.Lato

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/24/2025
 */
@Composable
fun LoginHome(
    onContinueWithEmail: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    Column(modifier = Modifier.padding(16.dp)) {
        GallerySection()
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = buildAnnotatedString {
                append("Ready to ")

                withStyle(style = SpanStyle(color = DeepBlue, fontWeight = FontWeight.ExtraBold)) {
                    append("explore?")
                }
            },
            color = DarkGray,
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = Lato()
        )
        Spacer(modifier = Modifier.height(50.dp))
        CustomButton(
            modifier = Modifier
                .width(278.dp)
                .align(Alignment.CenterHorizontally),
            onClick = { onContinueWithEmail() },
            text = stringResource(R.string.continue_with_email),
            startIcon = Icons.Outlined.Email
        )
        Spacer(modifier = Modifier.height(20.dp))
        SeparatorSection()
        Spacer(modifier = Modifier.height(15.dp))
        SocialButtonSection(
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
}

@Composable
fun SeparatorSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(modifier = Modifier.weight(1f), thickness = 1.dp, color = DividerColor)
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 8.dp),
            color = DividerColor,
            fontSize = 10.sp,
            fontFamily = Lato(),
            fontWeight = FontWeight.SemiBold
        )
        HorizontalDivider(modifier = Modifier.weight(1f), thickness = 1.dp, color = DividerColor)
    }
}

@Composable
fun GallerySection() {
    Column {
        Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            GalleryItem(R.drawable.gallery_1)
            GalleryItem(R.drawable.gallery_2)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            GalleryItem(R.drawable.gallery_3)
            GalleryItem(R.drawable.gallery_4)
        }
    }
}

@Composable
fun RowScope.GalleryItem(image: Int) {
    Box(
        modifier = Modifier
            .weight(1f)
            .height(174.dp)
            .clip(RoundedCornerShape(20))
    ) {
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
    }
}
