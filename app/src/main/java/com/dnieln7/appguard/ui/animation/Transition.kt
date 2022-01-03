package com.dnieln7.appguard.ui.animation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.unit.IntOffset

val transitionSpec = tween<IntOffset>(durationMillis = 500, easing = LinearEasing)

val enterFromRight = slideInHorizontally(
    initialOffsetX = { fullWidth -> fullWidth },
    animationSpec = transitionSpec
)
val enterFromLeft = slideInHorizontally(
    initialOffsetX = { fullWidth -> -fullWidth },
    animationSpec = transitionSpec
)
val exitToRight = slideOutHorizontally(
    targetOffsetX = { fullWidth -> fullWidth },
    animationSpec = transitionSpec
)
val exitToLeft = slideOutHorizontally(
    targetOffsetX = { fullWidth -> -fullWidth },
    animationSpec = transitionSpec
)
val enterFromBottom = slideInVertically(
    initialOffsetY = { fullHeight -> fullHeight },
    animationSpec = transitionSpec
)
val enterFromTop = slideInVertically(
    initialOffsetY = { fullHeight -> -fullHeight },
    animationSpec = transitionSpec
)
val exitToTop = slideOutVertically(
    targetOffsetY = { fullHeight -> -fullHeight },
    animationSpec = transitionSpec
)
val exitToBottom = slideOutVertically(
    targetOffsetY = { fullHeight -> fullHeight },
    animationSpec = transitionSpec
)