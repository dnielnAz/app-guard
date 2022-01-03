package com.dnieln7.appguard.ui.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

@Composable
@ExperimentalAnimationApi
fun EnterWithOpacity(enterFromRight: Boolean = true, content: @Composable () -> Unit) {
    var animate by rememberSaveable { mutableStateOf(false) }
    val opacity by animateFloatAsState(
        targetValue = if (animate) 1F else 0F,
        animationSpec = tween(durationMillis = 500, easing = FastOutLinearInEasing)
    )

    LaunchedEffect(key1 = true, block = { animate = true })

    AnimatedVisibility(
        visible = animate,
        enter = slideInHorizontally(
            initialOffsetX = { fullWidth -> if (enterFromRight) fullWidth else -fullWidth },
            animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
        )
    ) {
        Box(modifier = Modifier.alpha(opacity)) {
            content()
        }
    }
}