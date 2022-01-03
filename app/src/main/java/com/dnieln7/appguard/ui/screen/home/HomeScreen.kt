package com.dnieln7.appguard.ui.screen.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dnieln7.appguard.ui.navigation.home.HomeNavContent
import com.dnieln7.appguard.ui.theme.AppGuardTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen() {
    val navController = rememberAnimatedNavController()

    HomeNavContent(controller = navController)
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Preview
@Composable
fun HomePreview() {
    AppGuardTheme {
        HomeScreen()
    }
}