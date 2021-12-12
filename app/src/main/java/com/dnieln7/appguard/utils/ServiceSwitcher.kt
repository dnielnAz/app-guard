package com.dnieln7.appguard.utils

import android.content.Context
import android.content.Intent
import android.os.Build
import com.dnieln7.appguard.service.GuardService
import com.dnieln7.appguard.service.LockService

enum class Switcher {
    ON,
    OFF
}

fun Context.lockScreen(switcher: Switcher) {
    val intent = Intent(this, LockService::class.java)

    when (switcher) {
        Switcher.ON -> this.startService(intent)
        Switcher.OFF -> this.stopService(intent)
    }
}

fun Context.guard(switcher: Switcher) {
    val intent = Intent(this, GuardService::class.java)

    when (switcher) {
        Switcher.ON -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (!GuardService.IS_RUNNING) {
                    this.startForegroundService(intent)
                }
            } else {
                if (!GuardService.IS_RUNNING) {
                    this.startService(intent)
                }
            }
        }
        Switcher.OFF -> {
            this.stopService(intent)
        }
    }
}