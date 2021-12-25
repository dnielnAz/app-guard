package com.dnieln7.appguard.ui.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@Composable
@ExperimentalAnimationApi
fun FallingWithOpacity(content: @Composable () -> Unit, after: () -> Unit) {
    var animate by rememberSaveable { mutableStateOf(false) }
    val opacity by animateFloatAsState(
        targetValue = if (animate) 1F else 0F,
        animationSpec = tween(durationMillis = 500, easing = FastOutLinearInEasing),
        finishedListener = { after() }
    )

    LaunchedEffect(key1 = true, block = { animate = true })

    AnimatedVisibility(
        visible = animate,
        enter = slideInVertically(
            initialOffsetY = { cardHeight -> (cardHeight * -0.80).roundToInt() },
            animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
        )
    ) {
        Box(modifier = Modifier.alpha(opacity)) {
            content()
        }
    }
}