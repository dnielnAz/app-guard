package com.dnieln7.appguard.utils

import android.app.AppOpsManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings


object PermissionChecker {
    fun checkOverlayPermission(context: Context): Boolean {
        return Settings.canDrawOverlays(context)
    }

    fun requestOverlayPermission(context: Context) {
        val intent = Intent(
            Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            Uri.parse("package:${context.packageName}")
        )

        context.startActivity(intent)
    }

    fun checkUsageAccessPermission(context: Context): Boolean {
        return try {
            val packageManager = context.packageManager
            val applicationInfo = packageManager.getApplicationInfo(context.packageName, 0)
            val appOpsManager = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
            val mode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                appOpsManager.unsafeCheckOpNoThrow(
                    AppOpsManager.OPSTR_GET_USAGE_STATS,
                    applicationInfo.uid,
                    applicationInfo.packageName
                )
            } else {
                appOpsManager.checkOpNoThrow(
                    AppOpsManager.OPSTR_GET_USAGE_STATS,
                    applicationInfo.uid,
                    applicationInfo.packageName
                )
            }

            mode == AppOpsManager.MODE_ALLOWED

        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    fun requestUsageAccessPermission(context: Context) {
        val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)

        context.startActivity(intent)
    }
}