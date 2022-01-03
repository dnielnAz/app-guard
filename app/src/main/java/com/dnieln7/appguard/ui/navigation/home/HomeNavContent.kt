package com.dnieln7.appguard.ui.navigation.home

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.dnieln7.appguard.ui.animation.enterFromLeft
import com.dnieln7.appguard.ui.animation.enterFromRight
import com.dnieln7.appguard.ui.animation.exitToLeft
import com.dnieln7.appguard.ui.animation.exitToRight
import com.dnieln7.appguard.ui.screen.apps.AppsScreen
import com.dnieln7.appguard.ui.screen.security.SecurityScreen
import com.dnieln7.appguard.ui.screen.settings.SettingsScreen
import com.dnieln7.appguard.ui.screen.welcome.WelcomeScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun HomeNavContent(controller: NavHostController) {
    AnimatedNavHost(navController = controller, startDestination = HomeNavGraph.Welcome.fullRoute) {
        composable(
            route = HomeNavGraph.Welcome.fullRoute,
            enterTransition = {
                when (initialState.destination.route) {
                    HomeNavGraph.Apps.fullRoute -> enterFromRight
                    HomeNavGraph.Security.fullRoute -> enterFromLeft
                    HomeNavGraph.Settings.fullRoute -> enterFromRight
                    else -> fadeIn()
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    HomeNavGraph.Apps.fullRoute -> exitToLeft
                    HomeNavGraph.Security.fullRoute -> exitToRight
                    HomeNavGraph.Settings.fullRoute -> exitToLeft
                    else -> fadeOut()
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    HomeNavGraph.Apps.fullRoute -> enterFromLeft
                    HomeNavGraph.Security.fullRoute -> enterFromRight
                    HomeNavGraph.Settings.fullRoute -> enterFromLeft
                    else -> fadeIn()
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    HomeNavGraph.Apps.fullRoute -> exitToRight
                    HomeNavGraph.Security.fullRoute -> exitToLeft
                    HomeNavGraph.Settings.fullRoute -> exitToRight
                    else -> fadeOut()
                }
            }) {
            WelcomeScreen(
                toApps = { HomeNavGraph.Welcome.toApps(controller) },
                toSecurity = { HomeNavGraph.Welcome.toSecurity(controller) },
                toSettings = { HomeNavGraph.Welcome.toSettings(controller) },
            )
        }
        rightToLeftComposable(route = HomeNavGraph.Apps.fullRoute) {
            AppsScreen()
        }
        leftToRightComposable(route = HomeNavGraph.Security.fullRoute) {
            SecurityScreen()
        }
        rightToLeftComposable(route = HomeNavGraph.Settings.fullRoute) {
            SettingsScreen()
        }
    }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.rightToLeftComposable(route: String, content: @Composable () -> Unit) {
    composable(
        route = route,
        enterTransition = { enterFromRight },
        exitTransition = { exitToLeft },
        popEnterTransition = { enterFromLeft },
        popExitTransition = { exitToRight }
    ) { content() }
}

@ExperimentalAnimationApi
fun NavGraphBuilder.leftToRightComposable(route: String, content: @Composable () -> Unit) {
    composable(
        route = route,
        enterTransition = { enterFromLeft },
        exitTransition = { exitToRight },
        popEnterTransition = { enterFromRight },
        popExitTransition = { exitToLeft }
    ) { content() }
}


