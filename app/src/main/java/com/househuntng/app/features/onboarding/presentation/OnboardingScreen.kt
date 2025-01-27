package com.househuntng.app.features.onboarding.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.househuntng.app.R
import com.househuntng.app.components.CustomButton
import com.househuntng.app.features.core.domain.repository.SessionManager
import com.househuntng.app.ui.theme.AppGray
import com.househuntng.app.ui.theme.DeepBlue
import com.househuntng.app.ui.theme.Lato
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

/**
 * @Author: ifechukwu.udorji
 * @Date: 1/23/2025
 */

@Composable
fun OnBoardingScreen(sessionManager: SessionManager = koinInject(), onNavigate: () -> Unit) {
    val pagerState = rememberPagerState(pageCount = {
        onboardItems.size
    })
    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
        val onBoardingItem = onboardItems[page]
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            val coroutineScope = rememberCoroutineScope()
            val isLastPage = pagerState.currentPage == onboardItems.size - 1

            HeaderSection {
                sessionManager.setIsFirstLaunch()
                onNavigate()
            }
            Spacer(modifier = Modifier.height(20.dp))
            TextSection(onBoardingItem.title, onBoardingItem.description)
            Spacer(modifier = Modifier.height(30.dp))
            ImageSection(
                onBoardingItem.image,
                pagerState.currentPage == 0,
                onNextClick = {
                    if (isLastPage) {
                        sessionManager.setIsFirstLaunch()
                        onNavigate()
                    } else {
                        coroutineScope.launch {
                            pagerState.scrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
                onBackClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(pagerState.currentPage - 1)
                    }
                }
            )
        }
    }
}

@Composable
fun ImageSection(
    image: Int,
    isFirstPage: Boolean = false,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(510.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15)),
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.app_icon)
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
        ) {
            AnimatedVisibility(visible = !isFirstPage) {
                Box(modifier = Modifier
                    .background(Color.White, shape = CircleShape)
                    .size(54.dp)
                    .clickable { onBackClick() }
                ) {
                    Image(
                        modifier = Modifier.align(Alignment.Center),
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back button"
                    )
                }
            }

            Spacer(modifier = Modifier.width(10.dp))

            CustomButton(
                modifier = Modifier.width(190.dp),
                onClick = { onNextClick() },
                text = "Next"
            )
        }
    }
}

@Composable
fun TextSection(title: AnnotatedString, description: String) {
    Column {
        Text(
            text = title,
            fontSize = 25.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontFamily = Lato()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = description,
            fontSize = 12.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontFamily = Lato()
        )
    }
}

@Composable
fun HeaderSection(onSkipClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Image(
            modifier = Modifier
                .size(width = 52.dp, height = 55.dp),
            painter = painterResource(id = R.drawable.app_icon),
            contentDescription = stringResource(R.string.app_icon)
        )

        CustomButton(
            modifier = Modifier.size(width = 86.dp, height = 38.dp),
            onClick = { onSkipClick() },
            text = "Skip",
            textSize = 12,
            textColor = Color.Black,
            backgroundColor = AppGray,
            radius = 100
        )
    }
}

data class OnBoardingItem(
    val title: AnnotatedString,
    val description: String,
    val image: Int
)

val onboardItems = listOf(
    OnBoardingItem(
        title = buildAnnotatedString {
            append("Find best place\n\nto stay in ")

            withStyle(style = SpanStyle(color = DeepBlue, fontWeight = FontWeight.Bold)) {
                append("good price")
            }
        },
        description = "Explore a world of possibilities and find your dream home.",
        image = R.drawable.onboarding_1
    ),
    OnBoardingItem(
        title = buildAnnotatedString {
            append("Fast sell your property\n\n just to stay in ")

            withStyle(style = SpanStyle(color = DeepBlue, fontWeight = FontWeight.Bold)) {
                append("one click")
            }
        },
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed.",
        image = R.drawable.onboarding_2
    ),
    OnBoardingItem(
        title = buildAnnotatedString {
            append("Find ")

            withStyle(style = SpanStyle(color = DeepBlue, fontWeight = FontWeight.Bold)) {
                append("perfect choice ")
            }
            append("for\n\nyour future house")
        },
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed.",
        image = R.drawable.onboarding_3
    ),
)