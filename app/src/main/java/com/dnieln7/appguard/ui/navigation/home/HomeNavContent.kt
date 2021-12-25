package com.dnieln7.appguard.ui.navigation.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dnieln7.appguard.ui.screen.apps.AppsScreen
import com.dnieln7.appguard.ui.screen.security.SecurityScreen
import com.dnieln7.appguard.ui.screen.settings.SettingsScreen
import com.dnieln7.appguard.ui.screen.welcome.WelcomeScreen

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun HomeNavContent(controller: NavHostController) {
    NavHost(navController = controller, startDestination = HomeNavGraph.Welcome.fullRoute) {
        composable(route = HomeNavGraph.Welcome.fullRoute) {
            WelcomeScreen(
                toApps = { HomeNavGraph.Welcome.toApps(controller) },
                toSecurity = { HomeNavGraph.Welcome.toSecurity(controller) },
                toSettings = { HomeNavGraph.Welcome.toSettings(controller) },
            )
        }
        composable(route = HomeNavGraph.Apps.fullRoute) {
            AppsScreen()
        }
        composable(route = HomeNavGraph.Security.fullRoute) {
            SecurityScreen()
        }
        composable(route = HomeNavGraph.Settings.fullRoute) {
            SettingsScreen()
        }
    }
}