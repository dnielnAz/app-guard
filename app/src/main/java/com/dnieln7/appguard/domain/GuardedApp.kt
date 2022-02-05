package com.dnieln7.appguard.domain

import android.graphics.Bitmap

data class GuardedApp(
    val packageName: String,
    val appName: String,
    val icon: Bitmap?,
    val installed: Boolean
)
