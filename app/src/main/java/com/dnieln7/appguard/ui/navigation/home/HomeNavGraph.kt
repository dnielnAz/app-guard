package com.dnieln7.appguard.ui.navigation.home

import androidx.navigation.NavHostController
import androidx.navigation.navArgument

sealed class HomeNavGraph(
    protected val rawRoute: String,
    private val rawArgs: List<HomeNavArg> = emptyList()
) {
    val fullRoute = run {
        listOf(rawRoute).plus(
            rawArgs.map { "{${it.key}}" }
        ).joinToString("/")
    }

    val args = rawArgs.map {
        navArgument(it.key) { type = it.navType }
    }

    object Welcome : HomeNavGraph("welcome") {
        val toApps: (NavHostController) -> Unit = { controller ->
            controller.navigate(Apps.rawRoute)
        }

        val toSecurity: (NavHostController) -> Unit = { controller ->
            controller.navigate(Security.rawRoute)
        }

        val toSettings: (NavHostController) -> Unit = { controller ->
            controller.navigate(Settings.rawRoute)
        }
    }

    object Apps : HomeNavGraph("apps")
    object Security : HomeNavGraph("security")
    object Settings : HomeNavGraph("settings")
}