package com.dnieln7.appguard.domain

import android.graphics.Bitmap

data class InstalledApp(
    val packageName: String,
    val appName: String,
    val icon: Bitmap?,
    val isSystem: Boolean
)
