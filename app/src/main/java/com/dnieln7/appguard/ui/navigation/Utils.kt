package com.dnieln7.appguard.ui.navigation

import androidx.navigation.NavBackStackEntry

object Utils {
    inline fun <reified T> NavBackStackEntry.findArg(key: String): T {
        val value = arguments?.get(key)

        requireNotNull(value)

        return value as T
    }
}